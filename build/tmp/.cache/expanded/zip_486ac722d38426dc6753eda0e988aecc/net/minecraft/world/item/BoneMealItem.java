package net.minecraft.world.item;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class BoneMealItem extends Item {
    public static final int GRASS_SPREAD_WIDTH = 3;
    public static final int GRASS_SPREAD_HEIGHT = 1;
    public static final int GRASS_COUNT_MULTIPLIER = 3;

    public BoneMealItem(Item.Properties p_40626_) {
        super(p_40626_);
    }

    @Override
    public InteractionResult useOn(UseOnContext p_40637_) {
        Level level = p_40637_.getLevel();
        BlockPos blockpos = p_40637_.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(p_40637_.getClickedFace());
        if (applyBonemeal(p_40637_.getItemInHand(), level, blockpos, p_40637_.getPlayer())) {
            if (!level.isClientSide) {
                p_40637_.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                level.levelEvent(1505, blockpos, 0);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            BlockState blockstate = level.getBlockState(blockpos);
            boolean flag = blockstate.isFaceSturdy(level, blockpos, p_40637_.getClickedFace());
            if (flag && growWaterPlant(p_40637_.getItemInHand(), level, blockpos1, p_40637_.getClickedFace())) {
                if (!level.isClientSide) {
                    p_40637_.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                    level.levelEvent(1505, blockpos1, 0);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @Deprecated //Forge: Use Player/Hand version
    public static boolean growCrop(ItemStack p_40628_, Level p_40629_, BlockPos p_40630_) {
        if (p_40629_ instanceof net.minecraft.server.level.ServerLevel)
            return applyBonemeal(p_40628_, p_40629_, p_40630_, net.neoforged.neoforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.server.level.ServerLevel)p_40629_));
        return false;
    }

    public static boolean applyBonemeal(ItemStack p_40628_, Level p_40629_, BlockPos p_40630_, net.minecraft.world.entity.player.Player player) {
        BlockState blockstate = p_40629_.getBlockState(p_40630_);
        int hook = net.neoforged.neoforge.event.EventHooks.onApplyBonemeal(player, p_40629_, p_40630_, blockstate, p_40628_);
        if (hook != 0) return hook > 0;
        Block block = blockstate.getBlock();
        if (block instanceof BonemealableBlock bonemealableblock && bonemealableblock.isValidBonemealTarget(p_40629_, p_40630_, blockstate)) {
            if (p_40629_ instanceof ServerLevel) {
                if (bonemealableblock.isBonemealSuccess(p_40629_, p_40629_.random, p_40630_, blockstate)) {
                    bonemealableblock.performBonemeal((ServerLevel)p_40629_, p_40629_.random, p_40630_, blockstate);
                }

                p_40628_.shrink(1);
            }

            return true;
        }

        return false;
    }

    public static boolean growWaterPlant(ItemStack p_40632_, Level p_40633_, BlockPos p_40634_, @Nullable Direction p_40635_) {
        if (p_40633_.getBlockState(p_40634_).is(Blocks.WATER) && p_40633_.getFluidState(p_40634_).getAmount() == 8) {
            if (!(p_40633_ instanceof ServerLevel)) {
                return true;
            } else {
                RandomSource randomsource = p_40633_.getRandom();

                label78:
                for(int i = 0; i < 128; ++i) {
                    BlockPos blockpos = p_40634_;
                    BlockState blockstate = Blocks.SEAGRASS.defaultBlockState();

                    for(int j = 0; j < i / 16; ++j) {
                        blockpos = blockpos.offset(
                            randomsource.nextInt(3) - 1, (randomsource.nextInt(3) - 1) * randomsource.nextInt(3) / 2, randomsource.nextInt(3) - 1
                        );
                        if (p_40633_.getBlockState(blockpos).isCollisionShapeFullBlock(p_40633_, blockpos)) {
                            continue label78;
                        }
                    }

                    Holder<Biome> holder = p_40633_.getBiome(blockpos);
                    if (holder.is(BiomeTags.PRODUCES_CORALS_FROM_BONEMEAL)) {
                        if (i == 0 && p_40635_ != null && p_40635_.getAxis().isHorizontal()) {
                            blockstate = BuiltInRegistries.BLOCK
                                .getTag(BlockTags.WALL_CORALS)
                                .flatMap(p_204098_ -> p_204098_.getRandomElement(p_40633_.random))
                                .map(p_204100_ -> p_204100_.value().defaultBlockState())
                                .orElse(blockstate);
                            if (blockstate.hasProperty(BaseCoralWallFanBlock.FACING)) {
                                blockstate = blockstate.setValue(BaseCoralWallFanBlock.FACING, p_40635_);
                            }
                        } else if (randomsource.nextInt(4) == 0) {
                            blockstate = BuiltInRegistries.BLOCK
                                .getTag(BlockTags.UNDERWATER_BONEMEALS)
                                .flatMap(p_204091_ -> p_204091_.getRandomElement(p_40633_.random))
                                .map(p_204095_ -> p_204095_.value().defaultBlockState())
                                .orElse(blockstate);
                        }
                    }

                    if (blockstate.is(BlockTags.WALL_CORALS, p_204093_ -> p_204093_.hasProperty(BaseCoralWallFanBlock.FACING))) {
                        for(int k = 0; !blockstate.canSurvive(p_40633_, blockpos) && k < 4; ++k) {
                            blockstate = blockstate.setValue(BaseCoralWallFanBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(randomsource));
                        }
                    }

                    if (blockstate.canSurvive(p_40633_, blockpos)) {
                        BlockState blockstate1 = p_40633_.getBlockState(blockpos);
                        if (blockstate1.is(Blocks.WATER) && p_40633_.getFluidState(blockpos).getAmount() == 8) {
                            p_40633_.setBlock(blockpos, blockstate, 3);
                        } else if (blockstate1.is(Blocks.SEAGRASS) && randomsource.nextInt(10) == 0) {
                            ((BonemealableBlock)Blocks.SEAGRASS).performBonemeal((ServerLevel)p_40633_, randomsource, blockpos, blockstate1);
                        }
                    }
                }

                p_40632_.shrink(1);
                return true;
            }
        } else {
            return false;
        }
    }

    public static void addGrowthParticles(LevelAccessor p_40639_, BlockPos p_40640_, int p_40641_) {
        if (p_40641_ == 0) {
            p_40641_ = 15;
        }

        BlockState blockstate = p_40639_.getBlockState(p_40640_);
        if (!blockstate.isAir()) {
            double d0 = 0.5;
            double d1;
            if (blockstate.is(Blocks.WATER)) {
                p_40641_ *= 3;
                d1 = 1.0;
                d0 = 3.0;
            } else if (blockstate.isSolidRender(p_40639_, p_40640_)) {
                p_40640_ = p_40640_.above();
                p_40641_ *= 3;
                d0 = 3.0;
                d1 = 1.0;
            } else {
                d1 = blockstate.getShape(p_40639_, p_40640_).max(Direction.Axis.Y);
            }

            p_40639_.addParticle(
                ParticleTypes.HAPPY_VILLAGER, (double)p_40640_.getX() + 0.5, (double)p_40640_.getY() + 0.5, (double)p_40640_.getZ() + 0.5, 0.0, 0.0, 0.0
            );
            RandomSource randomsource = p_40639_.getRandom();

            for(int i = 0; i < p_40641_; ++i) {
                double d2 = randomsource.nextGaussian() * 0.02;
                double d3 = randomsource.nextGaussian() * 0.02;
                double d4 = randomsource.nextGaussian() * 0.02;
                double d5 = 0.5 - d0;
                double d6 = (double)p_40640_.getX() + d5 + randomsource.nextDouble() * d0 * 2.0;
                double d7 = (double)p_40640_.getY() + randomsource.nextDouble() * d1;
                double d8 = (double)p_40640_.getZ() + d5 + randomsource.nextDouble() * d0 * 2.0;
                if (!p_40639_.getBlockState(BlockPos.containing(d6, d7, d8).below()).isAir()) {
                    p_40639_.addParticle(ParticleTypes.HAPPY_VILLAGER, d6, d7, d8, d2, d3, d4);
                }
            }
        }
    }
}
