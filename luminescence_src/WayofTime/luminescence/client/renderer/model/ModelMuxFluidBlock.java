package WayofTime.luminescence.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.ForgeDirection;

public class ModelMuxFluidBlock extends ModelBase
{
  //fields
	ModelRenderer lens1;
    ModelRenderer lens2;
    ModelRenderer lens3;
    ModelRenderer lens4;
    ModelRenderer lens5;
    ModelRenderer lens6;
    ModelRenderer core;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
  
  public ModelMuxFluidBlock()
  {
	  textureWidth = 64;
	    textureHeight = 64;
	    
	      lens1 = new ModelRenderer(this, 0, 0);
	      lens1.addBox(-4F, -4F, -6F, 8, 8, 1);
	      lens1.setRotationPoint(0F, 16F, 0F);
	      lens1.setTextureSize(64, 64);
	      lens1.mirror = true;
	      setRotation(lens1, 0F, 0F, 0F);
	      lens2 = new ModelRenderer(this, 0, 0);
	      lens2.addBox(-4F, -4F, 5F, 8, 8, 1);
	      lens2.setRotationPoint(0F, 16F, 0F);
	      lens2.setTextureSize(64, 64);
	      lens2.mirror = true;
	      setRotation(lens2, 0F, 0F, 0F);
	      lens3 = new ModelRenderer(this, 0, 10);
	      lens3.addBox(-4F, -6F, -4F, 8, 1, 8);
	      lens3.setRotationPoint(0F, 16F, 0F);
	      lens3.setTextureSize(64, 64);
	      lens3.mirror = true;
	      setRotation(lens3, 0F, 0F, 0F);
	      lens4 = new ModelRenderer(this, 0, 10);
	      lens4.addBox(-4F, 5F, -4F, 8, 1, 8);
	      lens4.setRotationPoint(0F, 16F, 0F);
	      lens4.setTextureSize(64, 64);
	      lens4.mirror = true;
	      setRotation(lens4, 0F, 0F, 0F);
	      lens5 = new ModelRenderer(this, 0, 20);
	      lens5.addBox(5F, -4F, -4F, 1, 8, 8);
	      lens5.setRotationPoint(0F, 16F, 0F);
	      lens5.setTextureSize(64, 64);
	      lens5.mirror = true;
	      setRotation(lens5, 0F, 0F, 0F);
	      lens6 = new ModelRenderer(this, 0, 20);
	      lens6.addBox(-6F, -4F, -4F, 1, 8, 8);
	      lens6.setRotationPoint(0F, 16F, 0F);
	      lens6.setTextureSize(64, 64);
	      lens6.mirror = true;
	      setRotation(lens6, 0F, 0F, 0F);
	      core = new ModelRenderer(this, 0, 37);
	      core.addBox(-2F, -2F, -2F, 4, 4, 4);
	      core.setRotationPoint(0F, 16F, 0F);
	      core.setTextureSize(64, 64);
	      core.mirror = true;
	      setRotation(core, 0.7853982F, 0.7853982F, 0.7853982F);
	      Shape2 = new ModelRenderer(this, 20, 0);
	      Shape2.addBox(3F, -1F, -5F, 2, 2, 2);
	      Shape2.setRotationPoint(0F, 16F, 0F);
	      Shape2.setTextureSize(64, 64);
	      Shape2.mirror = true;
	      setRotation(Shape2, 0F, 0F, 0F);
	      Shape3 = new ModelRenderer(this, 20, 0);
	      Shape3.addBox(3F, -1F, 3F, 2, 2, 2);
	      Shape3.setRotationPoint(0F, 16F, 0F);
	      Shape3.setTextureSize(64, 64);
	      Shape3.mirror = true;
	      setRotation(Shape3, 0F, 0F, 0F);
	      Shape4 = new ModelRenderer(this, 20, 0);
	      Shape4.addBox(-5F, -1F, -5F, 2, 2, 2);
	      Shape4.setRotationPoint(0F, 16F, 0F);
	      Shape4.setTextureSize(64, 64);
	      Shape4.mirror = true;
	      setRotation(Shape4, 0F, 0F, 0F);
	      Shape5 = new ModelRenderer(this, 20, 0);
	      Shape5.addBox(-5F, -1F, 3F, 2, 2, 2);
	      Shape5.setRotationPoint(0F, 16F, 0F);
	      Shape5.setTextureSize(64, 64);
	      Shape5.mirror = true;
	      setRotation(Shape5, 0F, 0F, 0F);
	      Shape6 = new ModelRenderer(this, 20, 0);
	      Shape6.addBox(-1F, -5F, -5F, 2, 2, 2);
	      Shape6.setRotationPoint(0F, 16F, 0F);
	      Shape6.setTextureSize(64, 64);
	      Shape6.mirror = true;
	      setRotation(Shape6, 0F, 0F, 0F);
	      Shape7 = new ModelRenderer(this, 20, 0);
	      Shape7.addBox(-1F, -5F, 3F, 2, 2, 2);
	      Shape7.setRotationPoint(0F, 16F, 0F);
	      Shape7.setTextureSize(64, 64);
	      Shape7.mirror = true;
	      setRotation(Shape7, 0F, 0F, 0F);
	      Shape8 = new ModelRenderer(this, 20, 0);
	      Shape8.addBox(-5F, -5F, -1F, 2, 2, 2);
	      Shape8.setRotationPoint(0F, 16F, 0F);
	      Shape8.setTextureSize(64, 64);
	      Shape8.mirror = true;
	      setRotation(Shape8, 0F, 0F, 0F);
	      Shape9 = new ModelRenderer(this, 20, 0);
	      Shape9.addBox(3F, -5F, -1F, 2, 2, 2);
	      Shape9.setRotationPoint(0F, 16F, 0F);
	      Shape9.setTextureSize(64, 64);
	      Shape9.mirror = true;
	      setRotation(Shape9, 0F, 0F, 0F);
	      Shape10 = new ModelRenderer(this, 20, 0);
	      Shape10.addBox(-1F, 3F, 3F, 2, 2, 2);
	      Shape10.setRotationPoint(0F, 16F, 0F);
	      Shape10.setTextureSize(64, 64);
	      Shape10.mirror = true;
	      setRotation(Shape10, 0F, 0F, 0F);
	      Shape11 = new ModelRenderer(this, 20, 0);
	      Shape11.addBox(-1F, 3F, -5F, 2, 2, 2);
	      Shape11.setRotationPoint(0F, 16F, 0F);
	      Shape11.setTextureSize(64, 64);
	      Shape11.mirror = true;
	      setRotation(Shape11, 0F, 0F, 0F);
	      Shape12 = new ModelRenderer(this, 20, 0);
	      Shape12.addBox(3F, 3F, -1F, 2, 2, 2);
	      Shape12.setRotationPoint(0F, 16F, 0F);
	      Shape12.setTextureSize(64, 64);
	      Shape12.mirror = true;
	      setRotation(Shape12, 0F, 0F, 0F);
	      Shape13 = new ModelRenderer(this, 20, 0);
	      Shape13.addBox(-5F, 3F, -1F, 2, 2, 2);
	      Shape13.setRotationPoint(0F, 16F, 0F);
	      Shape13.setTextureSize(64, 64);
	      Shape13.mirror = true;
	      setRotation(Shape13, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, ForgeDirection input, ForgeDirection output)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    lens1.render(f5);
    lens2.render(f5);
    lens3.render(f5);
    lens4.render(f5);
    lens5.render(f5);
    lens6.render(f5);
    core.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
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
