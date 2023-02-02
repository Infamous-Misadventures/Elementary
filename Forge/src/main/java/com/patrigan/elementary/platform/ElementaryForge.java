package com.patrigan.elementary.platform;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ElementaryForge implements ElementaryPlatform {

    @Override
    public void setupFC() {

    }

    @Override
    public String getPlatformName() { return "Forge"; }

    @Override
    public boolean isModLoaded(String modId) { return ModList.get().isLoaded(modId); }

    @Override
    public boolean isDevelopmentEnvironment() { return !FMLLoader.isProduction(); }

    @Override
    public void setupRegistries() {

    }

    @Override
    public void setupEvents() {

    }
}
