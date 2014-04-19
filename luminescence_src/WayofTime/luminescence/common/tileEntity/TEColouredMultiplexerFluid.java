package WayofTime.luminescence.common.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEColouredMultiplexerFluid extends TEFluidicLensMulti
{
	@Override
	public int recieveChannelFromSide(int channel, ForgeDirection side, FluidStack fluid) 
	{
		return 0;
	}
	
	@Override
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid)
	{
		Vec3 nextBlock = this.getProjectedBlock(side.getOpposite());
		if(nextBlock != null)
		{
			int meta = this.getBlockMetadata();
			
			TileEntity nextTile = worldObj.getBlockTileEntity((int)nextBlock.xCoord, (int)nextBlock.yCoord, (int)nextBlock.zCoord);
			if(nextTile instanceof IMultiLens)
			{
				return ((IMultiLens) nextTile).recieveChannelFromSide(this.getChannelForMeta(meta), side, fluid);
			}
		}
		
		return 0;
	}
	
	public int getChannelForMeta(int meta)
	{
		return 0;
	}
}
