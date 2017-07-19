package org.dynmap.markers;

public interface MarkerSet {
	
	/**
     * Create a new marker in the marker set
     * 
     * @param id - ID of the marker - must be unique within the set: if null, unique ID is generated
     * @param label - Label for the marker (plain text)
     * @param world - world ID
     * @param x - x coord
     * @param y - y coord
     * @param z - z coord
     * @param icon - Icon for the marker
     * @param is_persistent - if true, marker is persistent (saved and reloaded on restart).  If set is not persistent, this must be false.
     * @return created marker, or null if cannot be created.
     */
    public Marker createMarker(String id, String label, String world, double x, double y, double z, MarkerIcon icon, boolean is_persistent);
    /**
     * Create a new marker in the marker set
     * 
     * @param id - ID of the marker - must be unique within the set: if null, unique ID is generated
     * @param label - Label for the marker
     * @param markup - if true, label is processed as HTML.  if false, label is processed as plain text.
     * @param world - world ID
     * @param x - x coord
     * @param y - y coord
     * @param z - z coord
     * @param icon - Icon for the marker
     * @param is_persistent - if true, marker is persistent (saved and reloaded on restart).  If set is not persistent, this must be false.
     * @return created marker, or null if cannot be created.
     */
    public Marker createMarker(String id, String label, boolean markup, String world, double x, double y, double z, MarkerIcon icon, boolean is_persistent);
    
}
