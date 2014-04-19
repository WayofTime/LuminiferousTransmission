package WayofTime.luminescence.common.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemFluidDemultiplexerBlock extends ItemBlock

{
    public ItemFluidDemultiplexerBlock(int par1)
    {
        super(par1);
        setHasSubtypes(true);
        this.setUnlocalizedName("itemColouredDemuxFluid");
    }

    public String getUnlocalizedName(ItemStack itemstack)

    {
        String name = "";

        switch (itemstack.getItemDamage())
        {
            case 0:
            {
                name = "white";
                break;
            }

            case 1:
            {
                name = "orange";
                break;
            }

            case 2:
                name = "repeaterAssembly";
                break;

            default:
                name = "broken";
        }

        return getUnlocalizedName() + "." + name;
    }

    public int getMetadata(int par1)
    {
        return par1;
    }
}
