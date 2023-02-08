package com.patrigan.elementary.damagesource;

import com.patrigan.elementary.damagetype.DamageType;
import com.patrigan.elementary.damagetype.DamageTypeModifier;

import java.util.List;

public interface TypedDamageSource {
    List<DamageTypeModifier> getDamageTypeModifiers();
    void addDamageType(DamageType damageType, float percentage);
    void removeDamageType(DamageType damageType);
}
