package com.creativemd.deathtracker;

import java.util.Map;

import org.dynmap.DynmapCommonAPI;
import org.dynmap.DynmapCommonAPIListener;
import org.dynmap.forge.ForgeWorld;
import org.dynmap.markers.MarkerAPI;
import org.dynmap.markers.MarkerSet;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DeathTracker.modid, version = DeathTracker.version, name = "Death Tracker", acceptedMinecraftVersions = "")
public class DeathTracker {

	public static final String modid = "deathtracker";
	public static final String version = "1.0";
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public Object api;
	
	@EventHandler
    public void serverStarted(FMLServerStartedEvent event)
    {
        DynmapCommonAPIListener.register(new DynmapCommonAPIListener() {
			
			@Override
			public void apiEnabled(DynmapCommonAPI api) {
				DeathTracker.this.api = api;
			}
		});
    }
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void playerDied(LivingDeathEvent event)
	{
		if(event.getEntityLiving() instanceof EntityPlayer && !event.getEntity().world.isRemote)
		{
			EntityPlayerMP player = (EntityPlayerMP) event.getEntityLiving();
			ICommand command = player.getServer().commandManager.getCommands().get("dmarker");
			if(command != null)
			{
				String name = "" + player.getDisplayNameString() + " (" + Integer.toString(player.getStatFile().readStat(StatList.DEATHS)) + ")";
				MarkerAPI marker = ((DynmapCommonAPI) api).getMarkerAPI();
				MarkerSet set = marker.getMarkerSet("deaths");
				if(set == null)
					set = marker.createMarkerSet("deaths", "deaths", null, true);
				
				set.createMarker(null, name, ForgeWorld.getWorldName(player.world), player.posX, player.posY, player.posZ, marker.getMarkerIcon("skull"), true);
				//command.execute(player.getServer(), player, new String[]{"add", name, "icon:skull"});
				
			}
		}
	}
	
	@NetworkCheckHandler
    public boolean netCheckHandler(Map<String, String> mods, Side side) {
        return true;
    }
}
