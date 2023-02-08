package com.patrigan.elementary.damagetype;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class DamageType {

    public static final DamageType DEFAULT = new DamageType(null, null);

    public static final Codec<DamageType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Registry.ATTRIBUTE.byNameCodec().fieldOf("focus").forGetter(DamageType::getFocus),
            Registry.ATTRIBUTE.byNameCodec().fieldOf("resistance").forGetter(DamageType::getResistance)
    ).apply(instance, DamageType::new));

    private Attribute focus;
    private Attribute resistance;

    public DamageType(Attribute focus, Attribute resistance) {
        this.focus = focus;
        this.resistance = resistance;
    }

    public Attribute getResistance() {
        return resistance;
    }

    public Attribute getFocus() {
        return focus;
    }
}
