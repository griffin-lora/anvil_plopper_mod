package best.minecraft.pillow;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ploppermod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("ploppermod");

	public static final String MOD_ID = "ploppermod.best.minecraft.pillow";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.



		LOGGER.info("Hello Fabric world!");

		ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
			if (world.isClient()) {
				return;
			}

			PlopperPersistentState st = PlopperPersistentState.getServerState(world.getServer());

			st.totalDirtBlocksBroken++;

//			LOGGER.info(String.format("Loaded chunk: %d, %d", chunk.getPos().x, chunk.getPos().z));
			LOGGER.info(String.format("Test Counter: %d", st.totalDirtBlocksBroken));

			chunk.setBlockState(new BlockPos(0, 10, 0), Blocks.OAK_PLANKS.getDefaultState(), false);
		});
	}
}