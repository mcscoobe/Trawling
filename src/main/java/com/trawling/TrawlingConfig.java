package com.trawling;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Notification;

@ConfigGroup(TrawlingConfig.CONFIG_GROUP)
public interface TrawlingConfig extends Config
{

	String CONFIG_GROUP = "trawling";

	@ConfigItem(
		keyName = "trawlingHighlightShoals",
		name = "Highlight Shoals",
		description = "Highlight fish shoals with a 10x10 tile area.",
		position = 1
	)
	default boolean trawlingHighlightShoals()
	{
		return false;
	}

	@ConfigItem(
		keyName = "trawlingShoalHighlightColour",
		name = "Shoal Highlight Colour",
		description = "Colour to highlight fish shoals.",
		position = 2
	)
	@Alpha
	default Color trawlingShoalHighlightColour()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "trawlingShowNetCapacity",
		name = "Show Net Capacity",
		description = "Display the current fish count in your nets.",
		position = 3
	)
	default boolean trawlingShowNetCapacity()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trawlingShowFishCaught",
		name = "Show Fish Caught",
		description = "Display the number of each fish caught in the session.",
		position = 4
	)
	default boolean trawlingShowFishCaught()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trawlingShowNetDepthTimer",
		name = "Show Net Depth Timer",
		description = "Display an overlay showing ticks until net depth change.",
		position = 5
	)
	default boolean trawlingShowNetDepthTimer()
	{
		return false;
	}

	@ConfigItem(
		keyName = "trawlingShowShoalPaths",
		name = "Show Shoal Routes",
		description = "Display the known routes for shoals.",
		position = 6
	)
	default boolean trawlingShowShoalPaths()
	{
		return true;
	}

	@ConfigItem(
		keyName = "trawlingShoalPathColour",
		name = "Route Colour",
		description = "Colour for displaying shoal routes.",
		position = 7
	)
	@Alpha
	default Color trawlingShoalPathColour()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "trawlingShowShoalDirectionArrows",
		name = "Show Direction Arrows",
		description = "Display directional arrows along shoal routes to indicate movement direction.",
		position = 8
	)
	default boolean trawlingShowShoalDirectionArrows()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightNetButtons",
		name = "Highlight Net Buttons",
		description = "Highlight the net button to move to the correct shoal depth.",
		position = 9
	)
	default boolean highlightNetButtons()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notifyDepthChange",
		name = "Notify Shoal Depth Changed",
		description = "Notify you when the shoal changes depth.",
		position = 10
	)
	default Notification notifyDepthChange()
	{
		return Notification.OFF;
	}

	@ConfigItem(
		keyName = "notifyShoalMove",
		name = "Notify Shoal Move",
		description = "Notify you when the shoal moves.",
		position = 11
	)
	default Notification notifyShoalMove()
	{
		return Notification.OFF;
	}
}
