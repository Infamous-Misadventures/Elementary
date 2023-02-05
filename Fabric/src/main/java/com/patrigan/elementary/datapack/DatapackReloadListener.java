package com.patrigan.elementary.datapack;

import com.patrigan.elementary.registry.DamageTypeRegistry;
import net.minecraft.server.packs.resources.PreparableReloadListener;

import java.util.List;

public class DatapackReloadListener {

    public static List<PreparableReloadListener> reloadListeners() {
        return List.of(DamageTypeRegistry.DAMAGE_TYPES);
    }
}
