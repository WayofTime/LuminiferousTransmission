package WayofTime.luminescence.client.renderer.block;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import WayofTime.luminescence.client.helper.ShaderHelper;
import WayofTime.luminescence.client.renderer.model.ModelInputMirrorBlock;
import WayofTime.luminescence.common.tileEntity.TEInputMirror;
import cpw.mods.fml.client.FMLClientHandler;

public class RenderInputMirrorBlock extends TileEntitySpecialRenderer
{
	private ModelInputMirrorBlock modelInputMirror = new ModelInputMirrorBlock();
	private static final ResourceLocation field_110629_a = new ResourceLocation("textures/entity/beacon_beam.png");
	private static final ResourceLocation test = new ResourceLocation("luminescence:textures/models/InputMirror.png");

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f)
	{
		if (tileEntity instanceof TEInputMirror)
		{
			TEInputMirror tileSpellBlock = (TEInputMirror) tileEntity;
			
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			this.modelInputMirror.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, tileSpellBlock.getInputDirection(), tileSpellBlock.getOutputDirection());
			GL11.glPopMatrix();
			
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();

			ForgeDirection dir = tileSpellBlock.getLensDirection();
			float distance = tileSpellBlock.getDistanceAndSetBeamRender(dir,2);

			GL11.glPushMatrix();
			float f1 = 1.0f;
			Tessellator tessellator = Tessellator.instance;
			this.bindTexture(field_110629_a);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			float f2 = 0;
			float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			

			GL11.glDepthMask(false);

			tessellator.startDrawingQuads();
			tessellator.setColorRGBA(255, 255, 255, 100);
			
			double d18 = 0.3D;
			double d19 = 0.3D;
			double d20 = 0.7D;
			double d21 = 0.3D;
			double d22 = 0.3D;
			double d23 = 0.7D;
			double d24 = 0.7D;
			double d25 = 0.7D;
			double d26 = (double)(distance * f1) + 0.2;
			double d27 = 0.0D;
			double d28 = 1.0D;
			double d29 = (double)(-1.0F + f3);
			double d30 = (double)(distance * f1) + d29;
			
			GL11.glTranslated(d0, d1, d2);
			
			switch(dir) {
				case UP : {
					GL11.glRotatef(90F, 0F, 0F, 1F);
					GL11.glTranslatef(0F, -1F, 0F);
					break;
				}
				case DOWN : {
					GL11.glRotatef(-90F, 0F, 0F, 1F);
					GL11.glTranslatef(-1F, 0F, 0F);
					break;
				}
				case NORTH : {
					GL11.glRotatef(90F, 0F, 1F, 0F);
					GL11.glTranslatef(-1F, 0F, 0F);
					break;
				}
				case SOUTH : {
					GL11.glRotatef(-90F, 0F, 1F, 0F);
					GL11.glTranslatef(0F, 0F, -1F);
					break;
				}
				case WEST : {
					GL11.glRotatef(180F, 0F, 1F, 0F);
					GL11.glTranslatef(-1F, 0F, -1F);
					break;
				}
				default : {
					break;
				}
			}
			
			
			tessellator.setBrightness(240);
			float s = 1F / 16F;
			GL11.glTranslatef(0F, s, s);
			GL11.glScalef(1F, s * 14F, s * 14F);
			tessellator.addVertexWithUV(d26, d18, d19, d28, d30);
			tessellator.addVertexWithUV(13d/16d, d18, d19, d28, d29);
			tessellator.addVertexWithUV(13d/16d, d20, d21, d27, d29);
			tessellator.addVertexWithUV(d26, d20, d21, d27, d30);
			tessellator.addVertexWithUV(d26, d24, d25, d28, d30);
			tessellator.addVertexWithUV(13d/16d, d24, d25, d28, d29);
			tessellator.addVertexWithUV(13d/16d, d22, d23, d27, d29);
			tessellator.addVertexWithUV(d26, d22, d23, d27, d30);
			tessellator.addVertexWithUV(d26, d20, d21, d28, d30);
			tessellator.addVertexWithUV(13d/16d, d20, d21, d28, d29);
			tessellator.addVertexWithUV(13d/16d, d24, d25, d27, d29);
			tessellator.addVertexWithUV(d26, d24, d25, d27, d30);
			tessellator.addVertexWithUV(d26, d22, d23, d28, d30);
			tessellator.addVertexWithUV(13d/16d, d22, d23, d28, d29);
			tessellator.addVertexWithUV(13d/16d, d18, d19, d27, d29);
			tessellator.addVertexWithUV(d26, d18, d19, d27, d30);

			ShaderHelper.useShaderWithProps(ShaderHelper.beam, "time", (int) tileSpellBlock.worldObj.getTotalWorldTime());
			tessellator.draw();
			ShaderHelper.releaseShader();

			GL11.glDepthMask(true);


			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glPopMatrix();
		}
	}
}