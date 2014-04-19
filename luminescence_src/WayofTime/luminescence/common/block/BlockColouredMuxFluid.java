package WayofTime.luminescence.common.block;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import WayofTime.luminescence.Luminescence;
import WayofTime.luminescence.ModBlocks;
import WayofTime.luminescence.common.tileEntity.TEColouredMultiplexerFluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockColouredMuxFluid extends BlockOrientable 
{
	public BlockColouredMuxFluid(int id) 
	{
		super(id);
		setUnlocalizedName("blockColouredMuxFluid");
		this.setCreativeTab(Luminescence.tabLuminescence);
	}
	
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (this.blockID == ModBlocks.blockMultiplexerFluid.blockID)
        {
        	for(int i=0; i<1; i++)
        	{
        		par3List.add(new ItemStack(par1, 1, i));
        	}
        } else
        {
            super.getSubBlocks(par1, par2CreativeTabs, par3List);
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World world)
    { 
		return new TEColouredMultiplexerFluid();
	}
}
