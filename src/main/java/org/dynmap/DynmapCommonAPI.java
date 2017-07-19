package org.dynmap;

import org.dynmap.markers.MarkerAPI;

public interface DynmapCommonAPI {
	
	/**
     * This method can return null if the 'markers' component has not been configured - 
     * a warning message will be issued to the server.log in this event.
     * 
     * @return MarkerAPI, or null if not configured
     */
    public MarkerAPI getMarkerAPI();
    
}
