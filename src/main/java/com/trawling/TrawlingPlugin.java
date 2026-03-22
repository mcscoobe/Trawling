package com.trawling;

import com.trawling.module.ComponentManager;
import com.trawling.module.TrawlingModule;
import com.google.inject.Binder;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Trawling",
	description = "Trawling quality-of-life for fishing net management, shoal tracking, and more.",
	tags = {"trawling", "sailing", "fishing", "shoal", "net"},
	enabledByDefault = false
)
public class TrawlingPlugin extends Plugin
{

	@Inject
	private ComponentManager componentManager;

	@Override
	public void configure(Binder binder)
	{
		binder.install(new TrawlingModule());
	}

	@Override
	protected void startUp() throws Exception
	{
		componentManager.onPluginStart();
	}

	@Override
	protected void shutDown() throws Exception
	{
		componentManager.onPluginStop();
	}

}
