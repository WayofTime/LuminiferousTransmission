package WayofTime.luminescence.common.block;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import WayofTime.luminescence.Luminescence;
import WayofTime.luminescence.ModBlocks;
import WayofTime.luminescence.common.tileEntity.TEInputMirror;
import WayofTime.luminescence.common.tileEntity.TEMultiRepeater;
import WayofTime.luminescence.common.tileEntity.TEOutputMirror;
import WayofTime.luminescence.common.tileEntity.TESingleRepeater;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockInputMirror extends BlockOrientable 
{
	public BlockInputMirror(int id) 
	{
		super(id);
		setUnlocalizedName("blockInputMirror");
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
        if (this.blockID == ModBlocks.blockInputMirror.blockID)
        {
        	for(int i=0; i<4; i++)
        	{
        		par3List.add(new ItemStack(par1, 1, i));
        	}
        } else
        {
            super.getSubBlocks(par1, par2CreativeTabs, par3List);
        }
    }
	
	public TileEntity createTileEntity(World world, int metadata)
    { 
		switch(metadata)
		{
		case 0:
			return new TEInputMirror();
		case 1:
			return new TEOutputMirror();
		case 2:
			return new TESingleRepeater();
		case 3:
			return new TEMultiRepeater();
		}

		return null;
	}
}
