package WayofTime.luminescence.common.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemInputMirrorBlock extends ItemBlock

{
    public ItemInputMirrorBlock(int par1)
    {
        super(par1);
        setHasSubtypes(true);
        this.setUnlocalizedName("itemInputMirror");
    }

    public String getUnlocalizedName(ItemStack itemstack)

    {
        String name = "";

        switch (itemstack.getItemDamage())
        {
            case 0:
            {
                name = "inputMirror";
                break;
            }

            case 1:
            {
                name = "outputMirror";
                break;
            }

            case 2:
                name = "repeaterAssembly";
                break;

            case 3:
            	name = "multiRepeater";
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
