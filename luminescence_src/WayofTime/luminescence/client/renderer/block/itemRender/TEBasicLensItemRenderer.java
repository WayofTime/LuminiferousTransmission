package WayofTime.luminescence.client.renderer.block.itemRender;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import WayofTime.luminescence.ModBlocks;
import WayofTime.luminescence.client.renderer.model.ModelInputMirrorBlock;
import WayofTime.luminescence.client.renderer.model.ModelRepeaterLensBlock;
import cpw.mods.fml.client.FMLClientHandler;

public class TEBasicLensItemRenderer implements IItemRenderer 
{
	private ModelInputMirrorBlock modelInputBlock = new ModelInputMirrorBlock();
	private ModelInputMirrorBlock modelOutputBlock = new ModelInputMirrorBlock();
	private ModelRepeaterLensBlock modelRepeaterLensBlock = new ModelRepeaterLensBlock();

	private void renderConduitItem(RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ) 
	{
		Tessellator tessellator = Tessellator.instance;

		Block block = ModBlocks.blockInputMirror;
		//Icon icon = item.getItem().getIconFromDamage(0);
		
		GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        /**
         * Render the ghost item inside of the Altar, slowly spinning
         */
        GL11.glPushMatrix();
        GL11.glTranslatef((float) translateX + 0.5F, (float) translateY + 1.5F, (float) translateZ + 0.5F);
        ResourceLocation test = new ResourceLocation(this.getResourceLocationForMeta(item.getItemDamage()));
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
        //A reference to your Model file. Again, very important.
        switch(item.getItemDamage())
        {
        case 0:
            this.modelInputBlock.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, ForgeDirection.DOWN, ForgeDirection.UP);
            break;
        case 1:
            this.modelOutputBlock.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, ForgeDirection.DOWN, ForgeDirection.UP);
            break;
        case 2:
        	this.modelRepeaterLensBlock.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, ForgeDirection.DOWN, ForgeDirection.UP);
            break;
        case 3:
        	this.modelRepeaterLensBlock.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, ForgeDirection.DOWN, ForgeDirection.UP);
            break;
        }
        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
	}


	/**
	 * IItemRenderer implementation *
	 */
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
			case ENTITY:
				return true;
			case EQUIPPED:
				return true;
			case EQUIPPED_FIRST_PERSON:
				return true;
			case INVENTORY:
				return true;
			default:
				return false;
		}
	}


	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}


	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case ENTITY:
				renderConduitItem((RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
				break;
			case EQUIPPED:
				renderConduitItem((RenderBlocks) data[0], item, -0.4f, 0.50f, 0.35f);
				break;
			case EQUIPPED_FIRST_PERSON:
				renderConduitItem((RenderBlocks) data[0], item, -0.4f, 0.50f, 0.35f);
				break;
			case INVENTORY:
				renderConduitItem((RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
				break;
			default:
		}
	}
	
	public String getResourceLocationForMeta(int meta)
    {
		switch(meta)
		{
		case 0: return "luminescence:textures/models/InputMirror.png";
		case 1: return "luminescence:textures/models/OutputMirror.png";
		case 2: return "luminescence:textures/models/RepeaterLens.png";
		case 3: return "luminescence:textures/models/RepeaterLens.png";
		}
    	return "";
    }
}
