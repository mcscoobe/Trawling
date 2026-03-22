package com.trawling.features.trawling;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ShoalWaypoint {
    private final WorldPoint position;
    private final boolean stopPoint;

    public ShoalWaypoint(WorldPoint position) {
        this(position, false);
    }

    public static WorldPoint[] getPositions(ShoalWaypoint[] waypoints) {
        return Arrays.stream(waypoints)
            .map(ShoalWaypoint::getPosition)
            .toArray(WorldPoint[]::new);
    }

    public static int[] getStopIndices(ShoalWaypoint[] waypoints) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < waypoints.length; i++) {
            if (waypoints[i].isStopPoint()) {
                indices.add(i);
            }
        }
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }

    public static ShoalWaypoint[] getStopPoints(ShoalWaypoint[] waypoints) {
        return Arrays.stream(waypoints)
            .filter(ShoalWaypoint::isStopPoint)
            .toArray(ShoalWaypoint[]::new);
    }

    public static int getStopPointCount(ShoalWaypoint[] waypoints) {
        return (int) Arrays.stream(waypoints)
            .filter(ShoalWaypoint::isStopPoint)
            .count();
    }

    @Override
    public String toString() {
        return String.format("ShoalWaypoint{position=%s, stopPoint=%s}", position, stopPoint);
    }
}
