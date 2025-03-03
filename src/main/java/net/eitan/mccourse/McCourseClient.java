package net.eitan.mccourse;


import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.block.entity.ModBlockEntities;
import net.eitan.mccourse.block.entity.renderer.GemEmpoweringBlockEntityRenderer;
import net.eitan.mccourse.entity.ModEntities;
import net.eitan.mccourse.entity.client.MagicProjectileModel;
import net.eitan.mccourse.entity.client.MagicProjectileRenderer;
import net.eitan.mccourse.entity.client.PorcupineModel;
import net.eitan.mccourse.entity.client.PorcupineRenderer;
import net.eitan.mccourse.entity.layer.ModModelLayers;
import net.eitan.mccourse.fluid.ModFluids;
import net.eitan.mccourse.networking.ModMessages;
import net.eitan.mccourse.particle.ModParticles;
import net.eitan.mccourse.particle.PinkGarnetParticle;
import net.eitan.mccourse.screen.GemEmpoweringScreen;
import net.eitan.mccourse.screen.ModScreenHandlers;
import net.eitan.mccourse.util.ModModelPredicateProvider;
import net.eitan.mccourse.util.ModWoodTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.ModelIdentifier;

public class McCourseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_PETUNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETUNIA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_GARNET_PARTICLE, PinkGarnetParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
                SimpleFluidRenderHandler.coloredWater(0xA1E038D0));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER);

        ModelLoadingRegistry.INSTANCE.registerModelProvider(((manager, out) -> new ModelIdentifier(McCourse.MOD_ID, "radiation_staff_3d", "inventory")));

        HandledScreens.register(ModScreenHandlers.GEM_EMPOWERING_SCREEN_HANDLER_SCREEN_HANDLER, GemEmpoweringScreen::new);

        ModMessages.registerS2CPackets();

        BlockEntityRendererFactories.register(ModBlockEntities.GEM_EMPOWERING_STATION_BE, GemEmpoweringBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.DRIFTWOOD, TexturedRenderLayers.getSignTextureId(ModWoodTypes.DRIFTWOOD));

        // models
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MAGIC_PROJECTILE, MagicProjectileModel::getTexturedModelData);

        // renderers
        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
        EntityRendererRegistry.register(ModEntities.THROWN_DICE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MAGIC_PROJECTILE, MagicProjectileRenderer::new);
    }
}
