package WayofTime.luminescence.common.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class TESingleRepeater extends TEFluidicLens
{
	@Override
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid)
	{
		if(side == this.getStandDirection() || side == this.getLensDirection())
		{
			return 0;
		}
		
		Vec3 nextBlock = this.getProjectedBlock(getLensDirection());
		if(nextBlock != null)
		{
			TileEntity nextTile = worldObj.getBlockTileEntity((int)nextBlock.xCoord, (int)nextBlock.yCoord, (int)nextBlock.zCoord);
			if(nextTile instanceof TEFluidicLens)
			{
				return ((TEFluidicLens) nextTile).recieveBeamFromSide(getLensDirection().getOpposite(), fluid);
			}
		}
		
		return 0;
	}
	
	@Override
	public ForgeDirection getStandDirection()
	{
		return ForgeDirection.UNKNOWN;
	}
	
	@Override
	public void setInputDirection(ForgeDirection input)
	{
		return;
	}
}
