package com.patrigan.elementary;

import com.patrigan.elementary.platform.ElementaryConstants;
import net.minecraftforge.fml.common.Mod;

@Mod(ElementaryConstants.MODID)
public class Elementary {
    
    public Elementary() {
        ElementaryConstants.LOGGER.info("Setting FC Forge up!");
        ElementaryConstants.PLATFORM.setupFC();
    }

}