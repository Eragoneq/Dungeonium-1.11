package net.eragon_skill.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSeahut extends WorldGenerator{

	private Block[] allowedBlocks = {Blocks.GRASS, Blocks.SAND, Blocks.GRAVEL};
	private String name = DungeonGen.SEAHUT;
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		while(worldIn.isAirBlock(pos) && pos.getY() > 2){
			pos = pos.down();
		}
		if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.east()).getBlock())){
			EnumFacing facing = null;
			for(EnumFacing face : EnumFacing.HORIZONTALS){
				int water_counter = 0;
				for(int i=0; i<5; i++){
					if(worldIn.getBlockState(pos.offset(face, i)).getBlock().getDefaultState() == Blocks.WATER.getDefaultState()){
						water_counter++;
					}
				}
				if(water_counter>3){
					facing = face;
				}
			}
			if(facing != null){
				switch(facing){
					case NORTH:
						if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.west(3)).getBlock())){
							if(checkTerrain(worldIn, pos.west(3).north(12), pos.west(3).add(-4, -1, -21), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.west(3).up(1), pos.west(3).add(-4, -1, -12), Rotation.COUNTERCLOCKWISE_90);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.east(3)).getBlock())){
							if(checkTerrain(worldIn, pos.north(12), pos.add(-4, -1, -21), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.up(), pos.add(-4, -1, -12), Rotation.COUNTERCLOCKWISE_90);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else{
							return false;
						}
						break;
					case SOUTH:
						if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.west(3)).getBlock())){
							if(checkTerrain(worldIn, pos.west(3), pos.add(-7, -1, 12), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.up(), pos.add(4, -1, 12), Rotation.CLOCKWISE_90);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.east(3)).getBlock())){
							if(checkTerrain(worldIn, pos, pos.add(-4, -1, 12), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.east(3).up(), pos.add(7, -1, 12), Rotation.CLOCKWISE_90);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else{
							return false;
						}
						break;
					case EAST:
						if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.south(3)).getBlock())){
							if(checkTerrain(worldIn, pos, pos.add(12, -1, -4), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.up(), pos.add(12, -1, -4), Rotation.NONE);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.north(3)).getBlock())){
							if(checkTerrain(worldIn, pos.north(3), pos.add(12, -1, -7), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.north(3).up(), pos.add(12, -1, -7), Rotation.NONE);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else{
							return false;
						}
						break;
					case WEST:
						if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.north(3)).getBlock())){
							if(checkTerrain(worldIn, pos.west(12).north(3), pos.add(-21, -1, -7), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.up(), pos.add(-12, -1, 4), Rotation.CLOCKWISE_180);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else if(Arrays.asList(allowedBlocks).contains(worldIn.getBlockState(pos.south(3)).getBlock())){
							if(checkTerrain(worldIn, pos.west(12), pos.add(-21, -1, -3), new int[]{4, 1, 12}, new int[]{12, 2, 9})){
								loadStructure(worldIn, pos.south(3).up(), pos.	add(-12, -1, 7), Rotation.CLOCKWISE_180);
								System.out.println(facing + " " + pos);
								return true;
							}
						}else{
							return false;
						}
						break;
				default:
					return false;
				}
			}
		}
	return false;
	}
	
	private boolean checkTerrain(World worldIn, BlockPos posBridge, BlockPos posHut, int[] bridgeSize, int[] hutSize){
		if(DungeonGen.checkTerrain(worldIn, posBridge, bridgeSize, new Block[]{(Block)Blocks.WATER}, 0.75D) &&
		DungeonGen.checkTerrain(worldIn, posHut, hutSize, new Block[]{(Block)Blocks.WATER}, 1.0D)){
			return true;
		}
		return false;
	}
	private void loadStructure(World worldIn, BlockPos pos1, BlockPos pos2, Rotation rot){
		DungeonGen.loadStructure(pos1, worldIn, "dungeoniumbridgeseahut", Mirror.NONE, rot);
		DungeonGen.loadStructure(pos2, worldIn, "dungeoniumseahut", Mirror.NONE, rot);
	}
}
