package WayofTime.luminescence.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.ForgeDirection;

public class ModelInputMirrorBlock extends ModelBase
{
  //fields
	ModelRenderer base;
    ModelRenderer stand;
    ModelRenderer lens1;
    ModelRenderer lens2;
    ModelRenderer lens3;
  
  public ModelInputMirrorBlock()
  {
	  textureWidth = 64;
	    textureHeight = 64;
	    
	      base = new ModelRenderer(this, 0, 0);
	      base.addBox(-5F, -5F, -8F, 10, 10, 2);
	      base.setRotationPoint(0F, 16F, 0F);
	      base.setTextureSize(64, 64);
	      base.mirror = true;
	      setRotation(base, 0F, 0F, 0F);
	      stand = new ModelRenderer(this, 0, 13);
	      stand.addBox(-1F, -1F, -6F, 2, 2, 8);
	      stand.setRotationPoint(0F, 16F, 0F);
	      stand.setTextureSize(64, 64);
	      stand.mirror = true;
	      setRotation(stand, 0F, 0F, 0F);
	      lens1 = new ModelRenderer(this, 21, 13);
	      lens1.addBox(3F, -4F, -4F, 1, 8, 8);
	      lens1.setRotationPoint(0F, 16F, 0F);
	      lens1.setTextureSize(64, 64);
	      lens1.mirror = true;
	      setRotation(lens1, 0F, 0F, 0F);
	      lens2 = new ModelRenderer(this, 21, 30);
	      lens2.addBox(4F, -5F, -5F, 1, 10, 10);
	      lens2.setRotationPoint(0F, 16F, 0F);
	      lens2.setTextureSize(64, 64);
	      lens2.mirror = true;
	      setRotation(lens2, 0F, 0F, 0F);
	      lens3 = new ModelRenderer(this, 0, 25);
	      lens3.addBox(1F, -2F, -2F, 2, 4, 4);
	      lens3.setRotationPoint(0F, 16F, 0F);
	      lens3.setTextureSize(64, 64);
	      lens3.mirror = true;
	      setRotation(lens3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, ForgeDirection input, ForgeDirection output)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    float xInputRot = 0.0f;
    float yInputRot = 0.0f;
    float zInputRot = 0.0f;
    float xOutputRot = 0.0f;
    float yOutputRot = 0.0f;
    float zOutputRot = 0.0f;

    switch (input)
    {
        case NORTH:
            xInputRot = 0.0f;
            yInputRot = 0.0f;
            zInputRot = 0.0f;
            break;

        case EAST:
            xInputRot = 0.0f;
            yInputRot = (float) (0.5f * Math.PI);
            zInputRot = 0.0f;
            break;

        case SOUTH:
            xInputRot = 0.0f;
            yInputRot = (float) (1.0f * Math.PI);
            zInputRot = 0.0f;
            break;

        case WEST:
            xInputRot = 0.0f;
            yInputRot = (float) (-0.5f * Math.PI);
            zInputRot = 0.0f;
            break;

        case UP:
            xInputRot = (float) (-0.5f * Math.PI);
            yInputRot = 0.0f;
            zInputRot = 0.0f;
            break;

        case DOWN:
            xInputRot = (float) (0.5f * Math.PI);
            yInputRot = 0.0f;
            zInputRot = 0.0f;
            break;

        default:
            break;
    }

    switch (output)
    {
        case NORTH:
            xOutputRot = 0.0f;
            yOutputRot = (float) (0.5f * Math.PI);
            zOutputRot = 0.0f;
            break;

        case EAST:
            xOutputRot = 0.0f;
            yOutputRot = (float) (1.0f * Math.PI);
            zOutputRot = 0.0f;
            break;

        case SOUTH:
            xOutputRot = 0.0f;
            yOutputRot = (float) (-0.5f * Math.PI);
            zOutputRot = 0.0f;
            break;

        case WEST:
            xOutputRot = 0.0f;
            yOutputRot = 0.0f;
            zOutputRot = 0.0f;
            break;

        case UP:
            xOutputRot = 0.0f;
            yOutputRot = 0.0f;
            zOutputRot = (float) (-0.5f * Math.PI);
            break;

        case DOWN:
            xOutputRot = 0.0f;
            yOutputRot = 0.0f;
            zOutputRot = (float) (0.5f * Math.PI);
            break;

        default:
            break;
    }

    this.setRotation(base, xInputRot, yInputRot, zInputRot);
    this.setRotation(stand, xInputRot, yInputRot, zInputRot);
    this.setRotation(lens1, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(lens2, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(lens3, xOutputRot, yOutputRot, zOutputRot);
    
    base.render(f5);
    stand.render(f5);
    lens1.render(f5);
    lens2.render(f5);
    lens3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
