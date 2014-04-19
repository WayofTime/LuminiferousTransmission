package WayofTime.luminescence;

import net.minecraft.block.Block;
import WayofTime.luminescence.common.block.BlockColouredDemuxFluid;
import WayofTime.luminescence.common.block.BlockColouredMuxFluid;
import WayofTime.luminescence.common.block.BlockInputMirror;

public class ModBlocks
{
	public static Block blockInputMirror;
	public static Block blockMultiplexerFluid;
	public static Block blockDemultiplexerFluid;
	
    public static void init()
    {
    	blockInputMirror = new BlockInputMirror(Luminescence.blockInputMirrorBlockID);
    	blockMultiplexerFluid = new BlockColouredMuxFluid(Luminescence.blockMultiplexerFluidBlockID);
    	blockDemultiplexerFluid = new BlockColouredDemuxFluid(Luminescence.blockDemultiplexerFluidBlockID);
    }
}
