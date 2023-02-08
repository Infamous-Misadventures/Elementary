package com.patrigan.elementary.datapack;

import com.patrigan.elementary.registry.damagetype.DamageTypeRegistry;
import com.patrigan.elementary.registry.damagetype.modifier.EnchantmentModifierRegistry;
import net.minecraftforge.event.AddReloadListenerEvent;

public class DatapackReloadListener{

    public static void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(DamageTypeRegistry.REGISTRY);
        event.addListener(EnchantmentModifierRegistry.REGISTRY);
    }
}
