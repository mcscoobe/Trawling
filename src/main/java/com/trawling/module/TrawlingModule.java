package com.trawling.module;

import com.trawling.TrawlingConfig;
import com.trawling.features.trawling.*;
import com.trawling.features.util.BoatTracker;
import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.util.Set;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;

@Slf4j
public class TrawlingModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		bind(ComponentManager.class);
	}

	@Provides
	Set<PluginLifecycleComponent> lifecycleComponents(
		@Named("developerMode") boolean developerMode,

		BoatTracker boatTracker,
		FishCaughtTracker fishCaughtTracker,
		NetDepthButtonHighlighter netDepthButtonHighlighter,
		NetDepthTimer netDepthTimer,
		NetDepthTracker netDepthTracker,
		ShoalOverlay shoalOverlay,
		ShoalPathOverlay shoalPathOverlay,
		ShoalPathTracker shoalPathTracker,
		ShoalPathTrackerCommand shoalPathTrackerCommand,
		ShoalPathTrackerOverlay shoalPathTrackerOverlay,
		ShoalTracker shoalTracker,
		TrawlingOverlay trawlingOverlay
	)
	{
		var builder = ImmutableSet.<PluginLifecycleComponent>builder()
			.add(boatTracker)
			.add(fishCaughtTracker)
			.add(netDepthButtonHighlighter)
			.add(netDepthTimer)
			.add(netDepthTracker)
			.add(shoalOverlay)
			.add(shoalPathOverlay)
			.add(shoalPathTracker)
			.add(shoalTracker)
			.add(trawlingOverlay);

		if (developerMode)
		{
			builder
				.add(shoalPathTrackerCommand)
				.add(shoalPathTrackerOverlay);
		}

		return builder.build();
	}

	@Provides
	@Singleton
	TrawlingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TrawlingConfig.class);
	}

}
