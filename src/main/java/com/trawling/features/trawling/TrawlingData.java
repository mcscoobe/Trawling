package com.trawling.features.trawling;

import com.trawling.model.FishingAreaType;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ObjectID;

class TrawlingData {

    static class ShoalObjectID {
        static final int GIANT_KRILL = ObjectID.SAILING_SHOAL_CLICKBOX_GIANT_KRILL;
        static final int HADDOCK = ObjectID.SAILING_SHOAL_CLICKBOX_HADDOCK;
        static final int YELLOWFIN = ObjectID.SAILING_SHOAL_CLICKBOX_YELLOWFIN;
        static final int HALIBUT = ObjectID.SAILING_SHOAL_CLICKBOX_HALIBUT;
        static final int BLUEFIN = ObjectID.SAILING_SHOAL_CLICKBOX_BLUEFIN;
        static final int MARLIN = ObjectID.SAILING_SHOAL_CLICKBOX_MARLIN;
        static final int SHIMMERING = ObjectID.SAILING_SHOAL_CLICKBOX_SHIMMERING;
        static final int GLISTENING = ObjectID.SAILING_SHOAL_CLICKBOX_GLISTENING;
        static final int VIBRANT = ObjectID.SAILING_SHOAL_CLICKBOX_VIBRANT;
    }

    static class FishingAreas {

		static FishingAreaType getFishingAreaType(final WorldPoint location) {
			if (location == null) {
				return null;
			}

			for (final var area : ShoalFishingArea.AREAS) {
				if (area.contains(location)) {
					return area.getShoal().getDepth();
				}
			}

			return null;
		}

        static int getStopDurationForLocation(final WorldPoint location) {
            if (location == null) {
                return -1;
            }

            for (final var area : ShoalFishingArea.AREAS) {
                if (area.contains(location)) {
                    return area.getShoal().getStopDuration();
                }
            }

            return -1;
        }
    }
}
