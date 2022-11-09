package com.benbenlaw.cosmopolis.effect;

import com.benbenlaw.cosmopolis.Cosmopolis;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.xml.parsers.SAXParser;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Cosmopolis.MOD_ID);

    public static final RegistryObject<MobEffect> NO_OXYGEN = MOB_EFFECTS.register("no_oxygen",
            () -> new NoOxygenEffect(MobEffectCategory.HARMFUL, 3124687));

    public static final RegistryObject<MobEffect> AFTER_DEATH_PROTECTION = MOB_EFFECTS.register("after_death_protection",
            () -> new AfterDeathProtectionEffect(MobEffectCategory.BENEFICIAL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}