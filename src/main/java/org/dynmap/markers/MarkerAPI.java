package org.dynmap.markers;

import java.util.Set;

public interface MarkerAPI {
	
	/**
     * Find marker set by ID
     * @param id - ID of marker set
     * @return marker set, or null if not found
     */
    public MarkerSet getMarkerSet(String id);
    
    /**
     * Create marker set
     * @param id - ID for marker set (must be unique among marker set - limit to alphanumerics, periods, underscores)
     * @param lbl - Label for marker set
     * @param iconlimit - set of allowed marker icons (if null, any marker icon can be used in set)
     * @param persistent - if true, set is persistent (and can contain persistent markers)
     * @return marker set, or null if failed to be created
     */
    public MarkerSet createMarkerSet(String id, String lbl, Set<MarkerIcon> iconlimit, boolean persistent);
    
    /**
     * Find marker icon by ID
     * @param id - ID of marker icon
     * @return marker icon, or null if not found
     */
    public MarkerIcon getMarkerIcon(String id);
	
}
