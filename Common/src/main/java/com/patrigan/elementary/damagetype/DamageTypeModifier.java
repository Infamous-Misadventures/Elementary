package com.patrigan.elementary.damagetype;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.patrigan.elementary.registry.damagetype.DamageTypeRegistry;

public class DamageTypeModifier {
    public static final Codec<DamageTypeModifier> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            DamageTypeRegistry.REGISTRY.byNameCodec().fieldOf("damage_type").forGetter(DamageTypeModifier::getDamageType),
            Codec.FLOAT.fieldOf("percentage").forGetter(DamageTypeModifier::getPercentage)
    ).apply(instance, DamageTypeModifier::new));

    private DamageType damageType;
    private float percentage;

    public DamageTypeModifier(DamageType damageType, float percentage) {
        this.damageType = damageType;
        this.percentage = percentage;
    }

    public float getApplicableAmount(float amount) {
        return amount * getPercentage();
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
