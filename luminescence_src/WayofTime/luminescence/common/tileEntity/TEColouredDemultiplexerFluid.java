package WayofTime.luminescence.common.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TEColouredDemultiplexerFluid extends TEFluidicLensMulti
{
	@Override
	public int recieveChannelFromSide(int channel, ForgeDirection side, FluidStack fluid) 
	{
		//Lens is the multi-channel, stand is the single channel
		if(side == this.getLensDirection() || side == this.getStandDirection())
		{
			return 0;
		}
		if(channel == this.getChannelForMeta(this.getBlockMetadata()))
		{
			Vec3 nextBlock = this.getProjectedBlock(this.getStandDirection());
			if(nextBlock != null)
			{
				TileEntity nextTile = worldObj.getBlockTileEntity((int)nextBlock.xCoord, (int)nextBlock.yCoord, (int)nextBlock.zCoord);
				if(nextTile instanceof ISingleLens)
				{
					return ((ISingleLens) nextTile).recieveBeamFromSide(this.getStandDirection().getOpposite(), fluid);
				}
			}
		}else
		{
			Vec3 nextBlock = this.getProjectedBlock(this.getLensDirection());
			if(nextBlock != null)
			{
				TileEntity nextTile = worldObj.getBlockTileEntity((int)nextBlock.xCoord, (int)nextBlock.yCoord, (int)nextBlock.zCoord);
				if(nextTile instanceof IMultiLens)
				{
					return ((IMultiLens) nextTile).recieveChannelFromSide(channel, this.getLensDirection().getOpposite(), fluid);
				}
			}
		}
		
		return 0;
	}
	
	@Override
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid)
	{
		return 0;
	}
	
	public int getChannelForMeta(int meta)
	{
		return 0;
	}
}
