package com.patrigan.elementary.datapack;

import com.patrigan.elementary.registry.DamageTypeRegistry;
import net.minecraftforge.event.AddReloadListenerEvent;

public class DatapackReloadListener{

    public static void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(DamageTypeRegistry.DAMAGE_TYPES);
    }
}
