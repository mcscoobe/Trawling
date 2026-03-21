package com.trawling;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Trawling",
	description = "A trawling plugin",
	tags = {"trawling"},
	enabledByDefault = false
)
public class TrawlingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private TrawlingConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Trawling started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Trawling stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Trawling says " + config.greeting(), null);
		}
	}

	@Provides
	TrawlingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TrawlingConfig.class);
	}
}
