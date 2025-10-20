package net.undercoverenderman.enderblocksmp.entity.custom;


import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GreenBeanEntity extends Monster {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public GreenBeanEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 1, 10));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.5));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 12D)
                .add(Attributes.ARMOR, 2D)
                .add(Attributes.MOVEMENT_SPEED, .5D)
                .add(Attributes.ATTACK_DAMAGE, 4D)
                .add(Attributes.FOLLOW_RANGE, 10D);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide) {
            this.setupAnimationStates();
        }
    }
}

