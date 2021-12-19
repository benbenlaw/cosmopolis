package com.benbenlaw.cosmopolis.item;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {

    spacesuit("space_suit", 7, new int[]{13, 15, 16, 11},12,
            SoundEvents.ARMOR_EQUIP_IRON, 1.0f, 0.0f, () -> {
        return Ingredient.of(ModItems.ASTEROID_ROCK.get());
    }) ;

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;}

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {return this.damageReductionAmountArray[slotIn.getIndex()];}

    @Override
    public int getEnchantmentValue() {return this.enchantability;}

    @Override
    public SoundEvent getEquipSound() {return this.soundEvent;}

    @Override
    public Ingredient getRepairIngredient() {return this.repairMaterial.get();}

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {return Cosmopolis.MOD_ID + ":" + this.name;}

    @Override
    public float getToughness() {return this.toughness;}

    @Override
    public float getKnockbackResistance() {return this.knockbackResistance;}
}