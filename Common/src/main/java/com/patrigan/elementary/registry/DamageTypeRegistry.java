package com.patrigan.elementary.registry;

import com.patrigan.elementary.type.DamageType;
import com.patrigan.elementary.util.CodecJsonDataManager;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

import static com.patrigan.elementary.platform.ElementaryConstants.MODID;

public class DamageTypeRegistry {
    public static final ResourceLocation DAMAGE_TYPE_RESOURCELOCATION = new ResourceLocation(MODID, "type_config");

    public static final CodecJsonDataManager<DamageType> DAMAGE_TYPES = new CodecJsonDataManager<>("damage_type", DamageType.CODEC);



    public static DamageType getDamageType(ResourceLocation resourceLocation) {
        return DAMAGE_TYPES.getData().getOrDefault(resourceLocation, DamageType.DEFAULT);
    }

    public static boolean damageTypeExists(ResourceLocation resourceLocation) {
        return DAMAGE_TYPES.getData().containsKey(resourceLocation);
    }

    public static void setData(Map<ResourceLocation, DamageType> data) {
        DAMAGE_TYPES.setData(data);
    }
}