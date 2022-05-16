package com.benbenlaw.cosmopolis.item.custom;

import com.benbenlaw.cosmopolis.item.ModArmorMaterial;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, MobEffect> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffect>())
                    .put(ModArmorMaterial.spacesuit, MobEffects.ABSORPTION).build();

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if(!world.isClientSide()) {
            if(entity instanceof Player player) {

                ArmorMaterial material = ModArmorItem.getArmorSetType(player);
                if (material != null) {
                    ModArmorItem.addStatusEffectForMaterial(player, material);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private static void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial) {
        MobEffect effect = MATERIAL_TO_EFFECT_MAP.get(mapArmorMaterial);

        if(!player.hasEffect(effect)) {
            player.addEffect(new MobEffectInstance(effect, 20, 0));

            //if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
            //    player.getInventory().hurtArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            //}
        }
    }

    @Nullable
    public static ArmorMaterial getArmorSetType(LivingEntity entity) {
        Item helmet = entity.getItemBySlot(EquipmentSlot.HEAD).getItem();
        if (helmet instanceof ArmorItem armor) {
            ArmorMaterial material = armor.getMaterial();
            for (ItemStack armorPieceStack : entity.getArmorSlots()) {
                Item armorPiece = armorPieceStack.getItem();
                if (armorPiece instanceof ArmorItem comparable) {
                    if (comparable.getMaterial() == material) {
                        continue;
                    }
                }

                return null;
            }

            return material;
        }

        return null;
    }
}
