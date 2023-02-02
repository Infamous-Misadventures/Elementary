package com.patrigan.elementary;

import com.patrigan.elementary.platform.ElementaryConstants;
import net.fabricmc.api.ModInitializer;

public class Elementary implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ElementaryConstants.LOGGER.info("Setting Elementary Fabric up!");
        ElementaryConstants.PLATFORM.setupElementary();
    }
}
