package com.JiovannyAlejos.capybaramod.entity;

import com.JiovannyAlejos.capybaramod.init.SoundInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class Capybara extends Animal {
    static final TargetingConditions BREED_TARGETING = TargetingConditions.forNonCombat().range(8.0D);

    public Capybara(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        //this.moveControl = new MoveControl(this);//CapyMoveControl(this);
    }

    @Override protected void registerGoals() {
        // goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(9, new TemptGoal(this, 1.0D, Ingredient.of(Items.MELON_SLICE), false));
        goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        goalSelector.addGoal(10, new RandomStrollGoal(this, 1));
        goalSelector.addGoal(12, new FollowParentGoal(this, 1.25));
        goalSelector.addGoal(13, new LookAtPlayerGoal(this, Player.class, 5));
    }
    public static AttributeSupplier.Builder createAttribute() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12)
                .add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return EntityInit.CAPYBARA.get().create(level);
    }
    public class CapyMoveControl extends SmoothSwimmingMoveControl {
        private final Capybara capy;
        public CapyMoveControl(Capybara capy) {
            super(capy, 40, 3, 1, 1, false);
            this.capy = capy;
        }
    }
    // Sounds
    @Override protected SoundEvent getAmbientSound() {
       return SoundInit.CAPY_AMBIENT.get();
    }
    @Override protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.CAPY_HURT.get();
    }
    @Override protected SoundEvent getDeathSound() {
        return SoundInit.CAPY_DEATH.get();
    }
    @Override public boolean canBreatheUnderwater() {return true;}
    @Override public boolean isFood(ItemStack itemStack) { return itemStack.getItem().equals(Items.MELON_SLICE); } // melon slice
    /*@Override protected void usePlayerItem(Player player, InteractionHand hand, ItemStack itemStack) {
        if (itemStack.is(Items.MELON_SLICE)) {
            super.usePlayerItem(player, hand, itemStack);
        }
    }
    protected PathNavigation createNavigation(Level p_149128_) {
        return new CapyNavigation(this, p_149128_);
    }
    static class CapyNavigation extends WaterBoundPathNavigation {
        CapyNavigation(Capybara p_149218_, Level p_149219_) {
            super(p_149218_, p_149219_);
        }

        /**
         * If on ground or swimming and can swim
         */
        /*protected boolean canUpdatePath() {
            return true;
        }

        protected PathFinder createPathFinder(int p_149222_) {
            this.nodeEvaluator = new AmphibiousNodeEvaluator(false);
            return new PathFinder(this.nodeEvaluator, p_149222_);
        }

        public boolean isStableDestination(BlockPos p_149224_) {
            return !this.level.getBlockState(p_149224_.below()).isAir();
        }
    }*/
    /*public void travel(Vec3 p_149181_) {
      if (this.isEffectiveAi() && this.isInWater()) {
         this.moveRelative(this.getSpeed(), p_149181_);
         this.move(MoverType.SELF, this.getDeltaMovement());
         this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
      } else {
         super.travel(p_149181_);
      }

   }*/
    static class CapyBreedGoal extends BreedGoal {
        private final Capybara capy;
        private int unhappyCooldown;

        public CapyBreedGoal(Capybara capy, double speedModifier) {
            super(capy, speedModifier);
            this.capy = capy;
        }

        public boolean canUse() {
            if (super.canUse()) {
                //if (this.capy.isEffectiveAi()) {
                    //Player player = this.level.getNearestPlayer(Capybara.BREED_TARGETING, this.capy);
                    //this.capy.lookAtPlayerGoal.setTarget(player);
                return true;
                //}
            } else return false;
        }
    }
}