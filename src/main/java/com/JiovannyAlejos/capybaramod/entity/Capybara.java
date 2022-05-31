package com.JiovannyAlejos.capybaramod.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Capybara extends Animal {
    public Capybara(EntityType<? extends Animal> entityType, Level level) {super(entityType, level)};

    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        goalSelector.addGoal(10, new RandomStrollGoal(this, 1));
        goalSelector.addGoal(11, new RandomSwimmingGoal(this, 3, 3));
        goalSelector.addGoal(12, new FollowParentGoal(this, 1.25));
        goalSelector.addGoal(13, new LookAtPlayerGoal(this, Player.class, 5));
    }
    public static AttributeSupplier.Builder createAttribute() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12)
                .add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    @Override public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return EntityInit.CAPYBARA.get().create(level);
    }
}