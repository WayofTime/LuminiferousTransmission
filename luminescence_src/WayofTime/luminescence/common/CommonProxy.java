package WayofTime.luminescence.common;

import net.minecraft.world.World;
import WayofTime.luminescence.common.tileEntity.TEColouredMultiplexerFluid;
import WayofTime.luminescence.common.tileEntity.TEInputMirror;
import WayofTime.luminescence.common.tileEntity.TEOutputMirror;
import WayofTime.luminescence.common.tileEntity.TESingleRepeater;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public static int manualGuiID = -1;

    // Client stuff
    public void registerRenderers()
    {
        // Nothing here as the server doesn't render graphics!
    }

    public void registerEntities()
    {
    }

    public World getClientWorld()
    {
        return null;
    }

    public void registerActions()
    {
    }

    public void registerEvents()
    {
    }

    public void registerSoundHandler()
    {
        // Nothing here as this is a server side proxy
    }

    public void registerTileEntities()
    {
    	GameRegistry.registerTileEntity(TEInputMirror.class, "containerInputMirror");
    	GameRegistry.registerTileEntity(TEOutputMirror.class, "containerOutputMirror");
    	GameRegistry.registerTileEntity(TESingleRepeater.class, "containerSingleRepeater");
    	GameRegistry.registerTileEntity(TEColouredMultiplexerFluid.class, "containerMultiFluid");
    }

    public void registerEntityTrackers()
    {

    }

    public void registerTickHandlers()
    {
    }

    public void InitRendering()
    {
        // TODO Auto-generated method stub
    }
}
