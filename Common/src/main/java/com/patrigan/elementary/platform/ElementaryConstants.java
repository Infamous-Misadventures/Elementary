package com.patrigan.elementary.platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

public class ElementaryConstants {

	public static final String MODID = "data/elementary";
	public static final String MOD_NAME = "Elementary";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static final ElementaryPlatform PLATFORM = load(ElementaryPlatform.class);

	public static <T> T load(Class<T> clazz) {
		final T loadedService = ServiceLoader.load(clazz)
				.findFirst()
				.orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
		ElementaryConstants.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
		return loadedService;
	}

}