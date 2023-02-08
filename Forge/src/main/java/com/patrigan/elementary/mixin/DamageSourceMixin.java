package com.patrigan.elementary.mixin;

import com.patrigan.elementary.damagesource.TypedDamageSource;
import com.patrigan.elementary.damagetype.DamageType;
import com.patrigan.elementary.damagetype.DamageTypeModifier;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;

import java.util.ArrayList;
import java.util.List;

@Mixin(DamageSource.class)
public class DamageSourceMixin implements TypedDamageSource {

    private final List<DamageTypeModifier> damageTypeModifiers = new ArrayList<>();

    @Override
    public List<DamageTypeModifier> getDamageTypeModifiers() {
        return damageTypeModifiers;
    }

    @Override
    public void addDamageType(DamageType damageType, float percentage) {
        for(DamageTypeModifier damageTypeModifier : damageTypeModifiers){
            if(damageTypeModifier.getDamageType() == damageType){
                damageTypeModifier.setPercentage(Math.min(damageTypeModifier.getPercentage() + percentage, 100));
                return;
            }
        }
        damageTypeModifiers.add(new DamageTypeModifier(damageType, percentage));

    }

    @Override
    public void removeDamageType(DamageType damageType) {
        damageTypeModifiers.removeIf(damageTypeModifier -> damageTypeModifier.getDamageType() == damageType);
    }

}
