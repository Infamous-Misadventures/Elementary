package com.patrigan.elementary.damagetype;

import com.patrigan.elementary.damagesource.TypedDamageSource;
import com.patrigan.elementary.registry.damagetype.modifier.EnchantmentModifierRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class DamageTypeHandlers {

    public static void applyDamageTypeModifiers(DamageSource source, LivingEntity target, float amount){
        if(source.getEntity() instanceof LivingEntity livingEntity && source instanceof TypedDamageSource typedDamageSource) {
            EnchantmentHelper.getEnchantments(livingEntity.getMainHandItem()).keySet().forEach(enchantment -> {
                EnchantmentModifierRegistry.getDamageTypeModifiers(Registry.ENCHANTMENT.getKey(enchantment)).forEach(damageTypeModifier -> {
                    if(damageTypeModifier != null){
                        typedDamageSource.addDamageType(damageTypeModifier.getDamageType(), damageTypeModifier.getPercentage());
                    }
                });
            });
        }
    }

    public static float applyFocus(DamageSource source, float amount){
        if(source.getEntity() instanceof LivingEntity livingEntity && source instanceof TypedDamageSource typedDamageSource) {
            float total = amount;
            for (DamageTypeModifier damageTypeModifier : typedDamageSource.getDamageTypeModifiers()) {
                AttributeInstance attribute = livingEntity.getAttribute(damageTypeModifier.getDamageType().getFocus());
                if (attribute != null) {
                    total += damageTypeModifier.getApplicableAmount(amount) * (float) attribute.getValue();
                }
            }
            return total;
        }else{
            return amount;
        }
    }

    public static float applyResistance(LivingEntity target, DamageSource source, float amount){
        if(source instanceof TypedDamageSource typedDamageSource) {
            float total = amount;
            for (DamageTypeModifier damageTypeModifier : typedDamageSource.getDamageTypeModifiers()) {
                AttributeInstance attribute = target.getAttribute(damageTypeModifier.getDamageType().getResistance());
                if (attribute != null) {
                    total -= damageTypeModifier.getApplicableAmount(amount) * (float) attribute.getValue();
                }
            }
            return total;
        }else{
            return amount;
        }
    }

}
