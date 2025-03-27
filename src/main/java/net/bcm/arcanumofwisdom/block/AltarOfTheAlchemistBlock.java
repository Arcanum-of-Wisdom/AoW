
package net.bcm.arcanumofwisdom.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.bcm.arcanumofwisdom.world.inventory.AltarOfTheAlchemistGUIMenu;
import net.bcm.arcanumofwisdom.block.entity.AltarOfTheAlchemistBlockEntity;

import io.netty.buffer.Unpooled;

public class AltarOfTheAlchemistBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public AltarOfTheAlchemistBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1f, 8f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(2, 0, 2, 14, 1, 14), box(6, 9.75, 6, 10, 10.75, 10), box(1, 9.75, 2, 15, 10.75, 15), box(2, 10.75, 14, 14, 11.75, 15), box(10.75, 15.25, 4.25, 12.25, 15.75, 5.75), box(7, 11.5, 8, 13, 12.5, 15),
					box(7.75, 12.5, 9.25, 12.25, 12.75, 15), box(2, 14.25, 6, 14, 15.25, 7), box(6, 1, 6, 10, 3, 10), box(7, 3, 7, 9, 10, 9));
			case NORTH -> Shapes.or(box(2, 0, 2, 14, 1, 14), box(6, 9.75, 6, 10, 10.75, 10), box(1, 9.75, 1, 15, 10.75, 14), box(2, 10.75, 1, 14, 11.75, 2), box(3.75, 15.25, 10.25, 5.25, 15.75, 11.75), box(3, 11.5, 1, 9, 12.5, 8),
					box(3.75, 12.5, 1, 8.25, 12.75, 6.75), box(2, 14.25, 9, 14, 15.25, 10), box(6, 1, 6, 10, 3, 10), box(7, 3, 7, 9, 10, 9));
			case EAST -> Shapes.or(box(2, 0, 2, 14, 1, 14), box(6, 9.75, 6, 10, 10.75, 10), box(2, 9.75, 1, 15, 10.75, 15), box(14, 10.75, 2, 15, 11.75, 14), box(4.25, 15.25, 3.75, 5.75, 15.75, 5.25), box(8, 11.5, 3, 15, 12.5, 9),
					box(9.25, 12.5, 3.75, 15, 12.75, 8.25), box(6, 14.25, 2, 7, 15.25, 14), box(6, 1, 6, 10, 3, 10), box(7, 3, 7, 9, 10, 9));
			case WEST -> Shapes.or(box(2, 0, 2, 14, 1, 14), box(6, 9.75, 6, 10, 10.75, 10), box(1, 9.75, 1, 14, 10.75, 15), box(1, 10.75, 2, 2, 11.75, 14), box(10.25, 15.25, 10.75, 11.75, 15.75, 12.25), box(1, 11.5, 7, 8, 12.5, 13),
					box(1, 12.5, 7.75, 6.75, 12.75, 12.25), box(9, 14.25, 2, 10, 15.25, 14), box(6, 1, 6, 10, 3, 10), box(7, 3, 7, 9, 10, 9));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
		return 0.5f;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 1;
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Altar of the Alchemist");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new AltarOfTheAlchemistGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new AltarOfTheAlchemistBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof AltarOfTheAlchemistBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof AltarOfTheAlchemistBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
