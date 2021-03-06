package net.eragon_skill.world.gen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case -1:
			break;
		case 0:
			generateOverworld(chunkX, chunkZ, random, world);
			break;
		case 1:
			break;
		}
	}
	
	private void generateOverworld(int chunkX, int chunkZ, Random random, World world) {
		int X = chunkX * 16 + random.nextInt(16);
		int Z = chunkZ * 16 + random.nextInt(16);
		int Y = 255;
		BlockPos pos = new BlockPos(X, Y, Z);
		String randDungeon = DungeonGen.dungeonNames.get(random.nextInt(DungeonGen.dungeonNames.size()));
		createDungeon(randDungeon, pos, world, random);
	}
	
	private void createDungeon(String name, BlockPos pos, World world, Random random){
		switch(name){
		case DungeonGen.CASTLE:
			(new WorldGenCastle()).generate(world, random, pos);
			break;
		case DungeonGen.PILLAR:
			(new WorldGenPillar()).generate(world, random, pos);
			break;
		case DungeonGen.SEAHUT:
			(new WorldGenSeahut()).generate(world, random, pos);
			break;
		default:
			break;	
		}
	}
}
