package org.dynmap;

public abstract class DynmapCommonAPIListener {
	
	/**
     * Called when API becomes enabled, or during call to register listener if API is already enabled
     * 
     * @param api - API interface (note: may be platform specific subclass, such as bukkit-specific API)
     */
    public abstract void apiEnabled(DynmapCommonAPI api);
    /**
     * Called when API becomes disabled/obsolete
     * 
     * @param api - API interface being disabled (not usable immediately after call completes)
     */
    public void apiDisabled(DynmapCommonAPI api) {
    }
    /**
     * Called when API listener added before API ready (internal use)
     */
    public void apiListenerAdded() {
    }
    /**
     * Callback when web chat event is being processed:
     * @param source
     * @param name
     * @param message
     * @return true if not cancelled and not processed
     */
    public boolean webChatEvent(String source, String name, String message) {
        return true;
    }
    
    public static void register(DynmapCommonAPIListener listener) {
    	
    }
	
}
