package com.trawling.features.trawling;

import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

public interface ShoalAreaData {
    
    WorldArea getArea();
    
    ShoalWaypoint[] getWaypoints();
    
    Shoal getShoalType();
    
    default int getStopDuration() { return getShoalType().getStopDuration(); }
    
    default boolean contains(WorldPoint point) {
        return getArea().contains(point);
    }
    
    default WorldPoint[] getPositions() {
        return ShoalWaypoint.getPositions(getWaypoints());
    }
    
    default int[] getStopIndices() {
        return ShoalWaypoint.getStopIndices(getWaypoints());
    }
    
    default int getStopPointCount() {
        return ShoalWaypoint.getStopPointCount(getWaypoints());
    }
    
    default ShoalWaypoint[] getStopPoints() {
        return ShoalWaypoint.getStopPoints(getWaypoints());
    }
    
    default boolean isValidArea() {
        return getArea() != null && getWaypoints() != null && getWaypoints().length > 0;
    }
}
