package fr.catsuri33.fratospia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.stream.Stream;

public class OakStool extends Block {

    public static final DirectionProperty facing = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape oak_stool_shape_n = Stream.of(
            Block.makeCuboidShape(5, -2, 9, 6, 3, 10),
            Block.makeCuboidShape(10, -2, 9, 11, 3, 10),
            Block.makeCuboidShape(10, -2, 6, 11, 3, 7),
            Block.makeCuboidShape(5, -2, 6, 6, 3, 7),
            Block.makeCuboidShape(4, 3, 4, 12, 4, 12),
            Block.makeCuboidShape(5, 4, 5, 11, 4.5, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape oak_stool_shape_s = Stream.of(
            Block.makeCuboidShape(5, -2, 9, 6, 3, 10),
            Block.makeCuboidShape(10, -2, 9, 11, 3, 10),
            Block.makeCuboidShape(10, -2, 6, 11, 3, 7),
            Block.makeCuboidShape(5, -2, 6, 6, 3, 7),
            Block.makeCuboidShape(4, 3, 4, 12, 4, 12),
            Block.makeCuboidShape(5, 4, 5, 11, 4.5, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape oak_stool_shape_e = Stream.of(
            Block.makeCuboidShape(5, -2, 9, 6, 3, 10),
            Block.makeCuboidShape(10, -2, 9, 11, 3, 10),
            Block.makeCuboidShape(10, -2, 6, 11, 3, 7),
            Block.makeCuboidShape(5, -2, 6, 6, 3, 7),
            Block.makeCuboidShape(4, 3, 4, 12, 4, 12),
            Block.makeCuboidShape(5, 4, 5, 11, 4.5, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape oak_stool_shape_w = Stream.of(
            Block.makeCuboidShape(5, -2, 9, 6, 3, 10),
            Block.makeCuboidShape(10, -2, 9, 11, 3, 10),
            Block.makeCuboidShape(10, -2, 6, 11, 3, 7),
            Block.makeCuboidShape(5, -2, 6, 6, 3, 7),
            Block.makeCuboidShape(4, 3, 4, 12, 4, 12),
            Block.makeCuboidShape(5, 4, 5, 11, 4.5, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public OakStool(Properties properties){

        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(facing, Direction.NORTH));

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch(state.get(facing)){

            case NORTH:
                return oak_stool_shape_n;
            case SOUTH:
                return oak_stool_shape_s;
            case EAST:
                return oak_stool_shape_e;
            case WEST:
                return oak_stool_shape_w;
            default:
                return oak_stool_shape_n;

        }

    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {

        return this.getDefaultState().with(facing, context.getPlacementHorizontalFacing().getOpposite());

    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {

        return state.with(facing, rotation.rotate(state.get(facing)));

    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {

        return state.rotate(mirrorIn.toRotation(state.get(facing)));

    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {

        builder.add(facing);

    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        //if(!worldIn.isRemote){

            //ServerWorld sw = (ServerWorld) worldIn;
            //LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
            //sw.addLightningBolt(entity);

        //}

        return ActionResultType.SUCCESS;

    }

}
