package best.minecraft.pillow;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

public class PlopperPersistentState extends PersistentState {

    public Integer totalDirtBlocksBroken = 0;

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putInt("totalDirtBlocksBroken", totalDirtBlocksBroken);
        return nbt;
    }

    public static PlopperPersistentState createFromNbt(NbtCompound tag) {
        PlopperPersistentState state = new PlopperPersistentState();
        state.totalDirtBlocksBroken = tag.getInt("totalDirtBlocksBroken");
        return state;
    }

    public static PlopperPersistentState getServerState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();

        PlopperPersistentState state = persistentStateManager.getOrCreate(PlopperPersistentState::createFromNbt, PlopperPersistentState::new, Ploppermod.MOD_ID);

        state.markDirty();

        return state;
    }
}