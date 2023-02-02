package com.patrigan.elementary.platform;

import net.fabricmc.loader.api.FabricLoader;

public class ElementaryFabric implements ElementaryPlatform {

    @Override
    public void setupFC() {

    }

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) { return FabricLoader.getInstance().isModLoaded(modId); }

    @Override
    public boolean isDevelopmentEnvironment() { return FabricLoader.getInstance().isDevelopmentEnvironment(); }

    @Override
    public void setupRegistries() {

    }

    @Override
    public void setupEvents() {

    }
}
