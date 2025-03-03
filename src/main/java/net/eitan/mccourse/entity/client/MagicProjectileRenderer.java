package net.eitan.mccourse.entity.client;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.entity.custom.MagicProjectileEntity;
import net.eitan.mccourse.entity.layer.ModModelLayers;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class MagicProjectileRenderer extends EntityRenderer<MagicProjectileEntity> {

    public static final Identifier TEXTURE = new Identifier(McCourse.MOD_ID, "textures/entity/magic_projectile.png");
    protected MagicProjectileModel model;

    public MagicProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new MagicProjectileModel(ctx.getPart(ModModelLayers.MAGIC_PROJECTILE));
    }

    @Override
    public void render(MagicProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch() + 90.0F)));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(TEXTURE), false, false);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 0.0F, 0.0F, 1.0F);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(MagicProjectileEntity entity) {
        return null;
    }
    
}
