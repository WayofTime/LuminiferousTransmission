package WayofTime.luminescence.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.ForgeDirection;

public class ModelRepeaterLensBlock extends ModelBase
{
  //fields
	ModelRenderer Shape1;
    ModelRenderer lens1;
    ModelRenderer lens2;
    ModelRenderer lens3;
    ModelRenderer lens4;
    ModelRenderer lens5;
    ModelRenderer lens6;
    ModelRenderer cube;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
  
  public ModelRepeaterLensBlock()
  {
	  textureWidth = 64;
	    textureHeight = 64;
	    
	      Shape1 = new ModelRenderer(this, 0, 10);
	      Shape1.addBox(6F, -2F, -2F, 1, 4, 4);
	      Shape1.setRotationPoint(0F, 16F, 0F);
	      Shape1.setTextureSize(64, 64);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);
	      lens1 = new ModelRenderer(this, 0, 47);
	      lens1.addBox(5F, -4F, -4F, 1, 8, 8);
	      lens1.setRotationPoint(0F, 16F, 0F);
	      lens1.setTextureSize(64, 64);
	      lens1.mirror = true;
	      setRotation(lens1, 0F, 0F, 0F);
	      lens2 = new ModelRenderer(this, 0, 32);
	      lens2.addBox(-4F, -4F, -6F, 8, 8, 1);
	      lens2.setRotationPoint(0F, 16F, 0F);
	      lens2.setTextureSize(64, 64);
	      lens2.mirror = true;
	      setRotation(lens2, 0F, 0F, 0F);
	      lens3 = new ModelRenderer(this, 0, 32);
	      lens3.addBox(-4F, -4F, 5F, 8, 8, 1);
	      lens3.setRotationPoint(0F, 16F, 0F);
	      lens3.setTextureSize(64, 64);
	      lens3.mirror = true;
	      setRotation(lens3, 0F, 0F, 0F);
	      lens4 = new ModelRenderer(this, 0, 22);
	      lens4.addBox(-4F, -6F, -4F, 8, 1, 8);
	      lens4.setRotationPoint(0F, 16F, 0F);
	      lens4.setTextureSize(64, 64);
	      lens4.mirror = true;
	      setRotation(lens4, 0F, 0F, 0F);
	      lens5 = new ModelRenderer(this, 0, 22);
	      lens5.addBox(-4F, 5F, -4F, 8, 1, 8);
	      lens5.setRotationPoint(0F, 16F, 0F);
	      lens5.setTextureSize(64, 64);
	      lens5.mirror = true;
	      setRotation(lens5, 0F, 0F, 0F);
	      lens6 = new ModelRenderer(this, 19, 32);
	      lens6.addBox(-6F, -4F, -4F, 1, 8, 8);
	      lens6.setRotationPoint(0F, 16F, 0F);
	      lens6.setTextureSize(64, 64);
	      lens6.mirror = true;
	      setRotation(lens6, 0F, 0F, 0F);
	      cube = new ModelRenderer(this, 33, 0);
	      cube.addBox(-2F, -2F, -2F, 4, 4, 4);
	      cube.setRotationPoint(0F, 16F, 0F);
	      cube.setTextureSize(64, 64);
	      cube.mirror = true;
	      setRotation(cube, 0.7853982F, 0.7853982F, 0.7853982F);
	      Shape9 = new ModelRenderer(this, 11, 10);
	      Shape9.addBox(-1.5F, -6F, -6F, 3, 2, 2);
	      Shape9.setRotationPoint(0F, 16F, 0F);
	      Shape9.setTextureSize(64, 64);
	      Shape9.mirror = true;
	      setRotation(Shape9, 0F, 0F, 0F);
	      Shape10 = new ModelRenderer(this, 11, 10);
	      Shape10.addBox(-1.5F, -6F, 4F, 3, 2, 2);
	      Shape10.setRotationPoint(0F, 16F, 0F);
	      Shape10.setTextureSize(64, 64);
	      Shape10.mirror = true;
	      setRotation(Shape10, 0F, 0F, 0F);
	      Shape11 = new ModelRenderer(this, 11, 10);
	      Shape11.addBox(-1.5F, 4F, -6F, 3, 2, 2);
	      Shape11.setRotationPoint(0F, 16F, 0F);
	      Shape11.setTextureSize(64, 64);
	      Shape11.mirror = true;
	      setRotation(Shape11, 0F, 0F, 0F);
	      Shape2 = new ModelRenderer(this, 11, 10);
	      Shape2.addBox(-1.5F, 4F, 4F, 3, 2, 2);
	      Shape2.setRotationPoint(0F, 16F, 0F);
	      Shape2.setTextureSize(64, 64);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0F, 0F, 0F);
	      Shape3 = new ModelRenderer(this, 22, 10);
	      Shape3.addBox(-6F, -1.5F, -6F, 2, 3, 2);
	      Shape3.setRotationPoint(0F, 16F, 0F);
	      Shape3.setTextureSize(64, 64);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 22, 10);
	      Shape4.addBox(-6F, -1.5F, 4F, 2, 3, 2);
	      Shape4.setRotationPoint(0F, 16F, 0F);
	      Shape4.setTextureSize(64, 64);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
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

    this.setRotation(lens1, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(lens2, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(lens3, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(lens4, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(lens5, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(lens6, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(Shape1, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(Shape9, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(Shape10, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(Shape11, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(Shape2, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(Shape3, xOutputRot, yOutputRot, zOutputRot);
    this.setRotation(Shape4, xOutputRot, yOutputRot, zOutputRot);
    
    Shape1.render(f5);
    lens1.render(f5);
    lens2.render(f5);
    lens3.render(f5);
    lens4.render(f5);
    lens5.render(f5);
    lens6.render(f5);
    cube.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
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
