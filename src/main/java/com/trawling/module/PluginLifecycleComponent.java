package com.trawling.module;

import com.trawling.TrawlingConfig;

public interface PluginLifecycleComponent
{

	default boolean isEnabled(TrawlingConfig config)
	{
		return true;
	}

	default void startUp()
	{
	}

	default void shutDown()
	{
	}

}
