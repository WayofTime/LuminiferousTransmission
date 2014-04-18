package WayofTime.luminescence.common.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

public class TEOutputMirror extends TEFluidicLens
{
	@Override
	public int recieveBeamFromSide(ForgeDirection side, FluidStack fluid)
	{
		if(side == this.getStandDirection())
		{
			return 0;
		}
		
		ForgeDirection stand = this.getStandDirection();
		
		TileEntity tile = worldObj.getBlockTileEntity(xCoord+stand.offsetX, yCoord+stand.offsetY, zCoord+stand.offsetZ);
		if(tile instanceof IFluidHandler)
		{
			IFluidHandler fluidTile = (IFluidHandler)tile;
			return fluidTile.fill(stand.getOpposite(), fluid, true);
		}
		
		return 0;
	}
}
