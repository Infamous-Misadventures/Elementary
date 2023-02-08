package com.patrigan.elementary.damagetype;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

public class DamageTypeModifierList {

    public static final DamageTypeModifierList DEFAULT = new DamageTypeModifierList(List.of());

    public static final Codec<DamageTypeModifierList> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            DamageTypeModifier.CODEC.listOf().fieldOf("modifiers").forGetter(DamageTypeModifierList::getDamageTypeModifiers)
    ).apply(instance, DamageTypeModifierList::new));

    private List<DamageTypeModifier> damageTypeModifiers;

    public DamageTypeModifierList(List<DamageTypeModifier> damageTypeModifiers) {
        this.damageTypeModifiers = damageTypeModifiers;
    }

    public List<DamageTypeModifier> getDamageTypeModifiers() {
        return damageTypeModifiers;
    }
}
