// Date: 3/02/2013 5:28:04 p.m.
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package pixelmon.client.models.pokemon;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import pixelmon.client.models.PixelmonModelBase;
import pixelmon.client.models.animations.ModuleHead;
import pixelmon.client.models.animations.Bird.SkeletonBird;

public class ModelFearow extends PixelmonModelBase {
	// fields
	ModelRenderer Body;

	public ModelFearow() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new ModelRenderer(this, "Body");
		Body.setRotationPoint(0, 5, 0);
		ModelRenderer body_1 = new ModelRenderer(this, 96, 14);
		body_1.addBox(-4F, 0F, -2F, 8, 7, 8);
		body_1.setTextureSize(128, 64);
		body_1.mirror = true;
		setRotation(body_1, 0.3665191F, 0F, 0F);
		Body.addChild(body_1);
		ModelRenderer body_2 = new ModelRenderer(this, 69, 24);
		body_2.addBox(-3F, -0.5F, -3F, 6, 6, 6);
		body_2.setRotationPoint(0F, 4F, 5F);
		body_2.setTextureSize(128, 64);
		body_2.mirror = true;
		setRotation(body_2, -0.2792527F, 0F, 0F);
		Body.addChild(body_2);
		ModelRenderer neck_base = new ModelRenderer(this, 63, 38);
		neck_base.addBox(-3F, -2.4F, -0.1333333F, 6, 4, 6);
		neck_base.setTextureSize(128, 64);
		neck_base.mirror = true;
		setRotation(neck_base, 0.5410521F, 0F, 0F);
		Body.addChild(neck_base);
		ModelRenderer neck_1 = new ModelRenderer(this, 44, 31);
		neck_1.addBox(-2.5F, -5F, 1.333333F, 5, 4, 4);
		neck_1.setTextureSize(128, 64);
		neck_1.mirror = true;
		setRotation(neck_1, 0.6632251F, 0F, 0F);
		Body.addChild(neck_1);
		ModelRenderer neck_2 = new ModelRenderer(this, 31, 27);
		neck_2.addBox(-1.5F, -11.13333F, 2.866667F, 3, 8, 3);
		neck_2.setTextureSize(128, 64);
		neck_2.mirror = true;
		setRotation(neck_2, 0.8726646F, 0F, 0F);
		Body.addChild(neck_2);
		ModelRenderer neck_feathers = new ModelRenderer(this, 0, 52);
		neck_feathers.addBox(-3F, 0F, -0.5333334F, 6, 5, 0);
		neck_feathers.setRotationPoint(3F, -1F, 2F);
		neck_feathers.setTextureSize(128, 64);
		neck_feathers.mirror = true;
		setRotation(neck_feathers, -0.9599311F, -1.291544F, -0.2792527F);
		Body.addChild(neck_feathers);
		ModelRenderer neck_feathers_2 = new ModelRenderer(this, 0, 59);
		neck_feathers_2.addBox(-5F, -0.4F, -0.6F, 10, 5, 0);
		neck_feathers_2.setRotationPoint(0F, 0F, 0F);
		neck_feathers_2.setTextureSize(128, 64);
		neck_feathers_2.mirror = true;
		setRotation(neck_feathers_2, -0.9075712F, 0F, 0F);
		Body.addChild(neck_feathers_2);
		ModelRenderer neck_feathers_3 = new ModelRenderer(this, 0, 52);
		neck_feathers_3.addBox(-3F, 0F, -0.5333334F, 6, 5, 0);
		neck_feathers_3.setRotationPoint(-3F, -1F, 2F);
		neck_feathers_3.setTextureSize(128, 64);
		neck_feathers_3.mirror = true;
		setRotation(neck_feathers_3, -0.9599311F, 1.291544F, 0.2792527F);
		Body.addChild(neck_feathers_3);
		ModelRenderer back_feathers_1 = new ModelRenderer(this, 18, 48);
		back_feathers_1.addBox(-4F, 0F, 0.06666667F, 8, 10, 0);
		back_feathers_1.setRotationPoint(0F, -3F, 5F);
		back_feathers_1.setTextureSize(128, 64);
		back_feathers_1.mirror = true;
		setRotation(back_feathers_1, 0.6806784F, 0F, 0F);
		Body.addChild(back_feathers_1);
		ModelRenderer back_feathers_2 = new ModelRenderer(this, 16, 42);
		back_feathers_2.addBox(-6.5F, 0F, 0.06666667F, 13, 4, 0);
		back_feathers_2.setRotationPoint(0F, -3F, 5F);
		back_feathers_2.setTextureSize(128, 64);
		back_feathers_2.mirror = true;
		setRotation(back_feathers_2, 0.5759587F, 0F, 0F);
		Body.addChild(back_feathers_2);
		ModelRenderer back_feathers_3 = new ModelRenderer(this, 21, 60);
		back_feathers_3.addBox(-3.5F, 0F, 0.06666667F, 7, 4, 0);
		back_feathers_3.setRotationPoint(0F, -3F, 5F);
		back_feathers_3.setTextureSize(128, 64);
		back_feathers_3.mirror = true;
		setRotation(back_feathers_3, 1.291544F, 0F, 0F);
		Body.addChild(back_feathers_3);

		ModelRenderer Head = new ModelRenderer(this, "Head");
		Head.setRotationPoint(0, -11, -7);
		ModelRenderer head = new ModelRenderer(this, 0, 32);
		head.addBox(-2F, -0.8F, -1.4F, 4, 5, 4);
		// head.setRotationPoint(0F, -6F, -7F);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.3316126F, 0F, 0F);
		Head.addChild(head);
		ModelRenderer head_2 = new ModelRenderer(this, 0, 24);
		head_2.addBox(-1.5F, -1.2F, -4F, 3, 4, 3);
		head_2.setRotationPoint(0F, 0F, 0F);
		head_2.setTextureSize(128, 64);
		head_2.mirror = true;
		setRotation(head_2, 0.8901179F, 0F, 0F);
		Head.addChild(head_2);
		ModelRenderer upper_beak = new ModelRenderer(this, 17, 32);
		upper_beak.addBox(-1F, -0.6666667F, -9F, 2, 1, 8);
		upper_beak.setRotationPoint(0F, 2F, -1F);
		upper_beak.setTextureSize(128, 64);
		upper_beak.mirror = true;
		setRotation(upper_beak, 0.6981317F, 0F, 0F);
		Head.addChild(upper_beak);
		ModelRenderer lower_beak = new ModelRenderer(this, 17, 25);
		lower_beak.addBox(-0.5F, 0.3333333F, -6F, 1, 1, 5);
		lower_beak.setRotationPoint(0F, 2F, -1F);
		lower_beak.setTextureSize(128, 64);
		lower_beak.mirror = true;
		setRotation(lower_beak, 0.6108652F, 0F, 0F);
		Head.addChild(lower_beak);
		ModelRenderer crest = new ModelRenderer(this, 36, 44);
		crest.addBox(0F, -6.733333F, -3F, 0, 7, 13);
		crest.setRotationPoint(0F, 1F, -1F);
		crest.setTextureSize(128, 64);
		crest.mirror = true;
		setRotation(crest, 0.7330383F, 0F, 0F);
		Head.addChild(crest);
		ModelRenderer crest_base = new ModelRenderer(this, 40, 49);
		crest_base.addBox(-1F, -2.666667F, -1.666667F, 2, 2, 5);
		crest_base.setRotationPoint(0F, 2F, -1F);
		crest_base.setTextureSize(128, 64);
		crest_base.mirror = true;
		setRotation(crest_base, 0.715585F, 0F, 0F);
		Head.addChild(crest_base);
		Body.addChild(Head);

		ModelRenderer Tail = new ModelRenderer(this, "Tail");
		Tail.setRotationPoint(0, 9, 5);
		ModelRenderer tail_base = new ModelRenderer(this, 45, 23);
		tail_base.addBox(-2F, 0.5F, 0F, 4, 3, 3);
		// tail_base.setRotationPoint(0F, 14F, 5F);
		tail_base.setTextureSize(128, 64);
		tail_base.mirror = true;
		setRotation(tail_base, 1.012291F, 0F, 0F);
		Tail.addChild(tail_base);
		ModelRenderer tail_base_2 = new ModelRenderer(this, 60, 26);
		tail_base_2.addBox(-1F, 2.5F, 1F, 2, 2, 2);
		tail_base_2.setRotationPoint(0F, 0, 0F);
		tail_base_2.setTextureSize(128, 64);
		tail_base_2.mirror = true;
		setRotation(tail_base_2, 0.6457718F, 0F, 0F);
		Tail.addChild(tail_base_2);
		ModelRenderer tail = new ModelRenderer(this, 96, 31);
		tail.addBox(-8F, 3.5F, 1F, 16, 13, 0);
		tail.setRotationPoint(0F, 0F, 0F);
		tail.setTextureSize(128, 64);
		tail.mirror = true;
		setRotation(tail, 1.012291F, 0F, 0F);
		Tail.addChild(tail);
		Body.addChild(Tail);

		ModelRenderer LeftLeg = new ModelRenderer(this, "Left Leg");
		LeftLeg.setRotationPoint(2, 8, 0);
		ModelRenderer leg_base_L = new ModelRenderer(this, 0, 14);
		leg_base_L.addBox(0F, 0F, -1F, 3, 4, 4);
		// leg_base_L.setRotationPoint(2F, 13F, 0F);
		leg_base_L.setTextureSize(128, 64);
		leg_base_L.mirror = true;
		setRotation(leg_base_L, 0.6283185F, -0.296706F, 0F);
		LeftLeg.addChild(leg_base_L);
		ModelRenderer leg_L = new ModelRenderer(this, 14, 0);
		leg_L.addBox(1F, 1.2F, -4F, 1, 2, 5);
		leg_L.setRotationPoint(0F, 0F, 0F);
		leg_L.setTextureSize(128, 64);
		leg_L.mirror = true;
		setRotation(leg_L, 0.1047198F, -0.296706F, 0F);
		LeftLeg.addChild(leg_L);
		ModelRenderer toe_1_L = new ModelRenderer(this, 5, 0);
		toe_1_L.addBox(0F, 1.066667F, 0F, 1, 3, 1);
		toe_1_L.setRotationPoint(2F, 2F, -3F);
		toe_1_L.setTextureSize(128, 64);
		toe_1_L.mirror = true;
		setRotation(toe_1_L, -0.2617994F, -0.296706F, 0F);
		LeftLeg.addChild(toe_1_L);
		ModelRenderer toe_2_L = new ModelRenderer(this, 0, 0);
		toe_2_L.addBox(0F, -3.933333F, 0F, 1, 4, 1);
		toe_2_L.setRotationPoint(2F, 2F, -3F);
		toe_2_L.setTextureSize(128, 64);
		toe_2_L.mirror = true;
		setRotation(toe_2_L, 0.6457718F, -0.296706F, 0F);
		LeftLeg.addChild(toe_2_L);
		ModelRenderer toe_3_L = new ModelRenderer(this, 0, 0);
		toe_3_L.addBox(0F, -3.933333F, 0F, 1, 4, 1);
		toe_3_L.setRotationPoint(2F, 2F, -3F);
		toe_3_L.setTextureSize(128, 64);
		toe_3_L.mirror = true;
		setRotation(toe_3_L, 0.6457718F, -0.296706F, 0.6283185F);
		LeftLeg.addChild(toe_3_L);
		ModelRenderer toe_4_L = new ModelRenderer(this, 0, 0);
		toe_4_L.addBox(0F, -3.933333F, -0.4666667F, 1, 4, 1);
		toe_4_L.setRotationPoint(2F, 2F, -3F);
		toe_4_L.setTextureSize(128, 64);
		toe_4_L.mirror = true;
		setRotation(toe_4_L, 0.6457718F, -0.3490659F, -0.8203047F);
		LeftLeg.addChild(toe_4_L);
		Body.addChild(LeftLeg);

		ModelRenderer RightLeg = new ModelRenderer(this, "Right Leg");
		RightLeg.setRotationPoint(-4, 8, 0);
		ModelRenderer leg_base_R = new ModelRenderer(this, 0, 14);
		leg_base_R.addBox(-3F, 0F, -1F, 3, 4, 4);
		// leg_base_R.setRotationPoint(-4F, 13F, 0F);
		leg_base_R.setTextureSize(128, 64);
		leg_base_R.mirror = true;
		setRotation(leg_base_R, 0.6283185F, 0.296706F, 0F);
		RightLeg.addChild(leg_base_R);
		ModelRenderer leg_R = new ModelRenderer(this, 14, 0);
		leg_R.addBox(-2F, 1.2F, -4F, 1, 2, 5);
		leg_R.setRotationPoint(2F, 0F, 0F);
		leg_R.setTextureSize(128, 64);
		leg_R.mirror = true;
		setRotation(leg_R, 0.1047198F, 0.296706F, 0F);
		RightLeg.addChild(leg_R);
		ModelRenderer toe_1_R = new ModelRenderer(this, 5, 0);
		toe_1_R.addBox(-1F, 1.066667F, 0F, 1, 3, 1);
		toe_1_R.setRotationPoint(0F, 2F, -3F);
		toe_1_R.setTextureSize(128, 64);
		toe_1_R.mirror = true;
		setRotation(toe_1_R, -0.2617994F, 0.296706F, 0F);
		RightLeg.addChild(toe_1_R);
		ModelRenderer toe_2_R = new ModelRenderer(this, 0, 0);
		toe_2_R.addBox(-1F, -3.933333F, 0F, 1, 4, 1);
		toe_2_R.setRotationPoint(0F, 2F, -3F);
		toe_2_R.setTextureSize(128, 64);
		toe_2_R.mirror = true;
		setRotation(toe_2_R, 0.6457718F, 0.296706F, 0F);
		RightLeg.addChild(toe_2_R);
		ModelRenderer toe_3_R = new ModelRenderer(this, 0, 0);
		toe_3_R.addBox(-1F, -3.933333F, 0F, 1, 4, 1);
		toe_3_R.setRotationPoint(0F, 2F, -3F);
		toe_3_R.setTextureSize(128, 64);
		toe_3_R.mirror = true;
		setRotation(toe_3_R, 0.6457718F, 0.296706F, -0.6283185F);
		RightLeg.addChild(toe_3_R);
		ModelRenderer toe_4_R = new ModelRenderer(this, 0, 0);
		toe_4_R.addBox(-1F, -3.933333F, -0.4666667F, 1, 4, 1);
		toe_4_R.setRotationPoint(0F, 2F, -3F);
		toe_4_R.setTextureSize(128, 64);
		toe_4_R.mirror = true;
		setRotation(toe_4_R, 0.6457718F, 0.3490659F, 0.8203047F);
		RightLeg.addChild(toe_1_R);
		Body.addChild(RightLeg);

		ModelRenderer LeftWing = new ModelRenderer(this, "Left Wing");
		LeftWing.setRotationPoint(4, -1, 3);
		ModelRenderer wing_base_1_L = new ModelRenderer(this, 98, 45);
		wing_base_1_L.addBox(-1F, -1F, 0F, 14, 2, 1);
		// wing_base_1_L.setRotationPoint(4F, 4F, 3F);
		wing_base_1_L.setTextureSize(128, 64);
		wing_base_1_L.mirror = false;
		setRotation(wing_base_1_L, 0F, 0.2617994F, -0.715585F);
		LeftWing.addChild(wing_base_1_L);
		ModelRenderer wing_L = new ModelRenderer(this, 64, 49);
		wing_L.addBox(-27F, -1.8F, 0.5F, 32, 15, 0);
		wing_L.setRotationPoint(-8F, 2F, 0F);
		wing_L.setTextureSize(128, 64);
		wing_L.mirror = false;
		setRotation(wing_L, 0F, -0.2617994F, 0.715585F);
		LeftWing.addChild(wing_L);
		Body.addChild(LeftWing);

		ModelRenderer RightWing = new ModelRenderer(this, "Right Wing");
		RightWing.setRotationPoint(-4, -1, 3);
		ModelRenderer wing_base_1_R = new ModelRenderer(this, 98, 45);
		wing_base_1_R.addBox(-13F, -1F, 0F, 14, 2, 1);
		// wing_base_1_R.setRotationPoint(-4F, 4F, 3F);
		wing_base_1_R.setTextureSize(128, 64);
		wing_base_1_R.mirror = false;
		setRotation(wing_base_1_R, 0F, -0.2617994F, 0.715585F);
		RightWing.addChild(wing_base_1_R);
		ModelRenderer wing_R = new ModelRenderer(this, 31, 0);
		wing_R.addBox(-4F, -1.8F, 0.5F, 32, 15, 0);
		wing_R.setRotationPoint(8F, 2F, 0F);
		wing_R.setTextureSize(128, 64);
		wing_R.mirror = false;
		setRotation(wing_R, 0F, 0.2617994F, -0.715585F);
		RightWing.addChild(wing_R);
		Body.addChild(RightWing);

		ModuleHead headModule = new ModuleHead(Head);
		skeleton = new SkeletonBird(Body, headModule, LeftWing, RightWing, LeftLeg, RightLeg);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		Body.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}