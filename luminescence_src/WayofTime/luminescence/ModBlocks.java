package WayofTime.luminescence;

import net.minecraft.block.Block;
import WayofTime.luminescence.common.block.BlockInputMirror;

public class ModBlocks
{
	public static Block blockInputMirror;
	
    public static void init()
    {
    	blockInputMirror = new BlockInputMirror(Luminescence.blockInputMirrorBlockID);
    }
}
