package net.eitan.mccourse.datagen;

import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.UsingItemCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.PINK_GARNET),
                        Text.literal("Mc Course"), Text.literal("The Power lies in the Pink Garnet"),
                        new Identifier(McCourse.MOD_ID, "block/pink_garnet_ore"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_pink_garnet", InventoryChangedCriterion.Conditions.items(ModItems.PINK_GARNET)) // checks when your inventory changes and finds a pink garnet
                .build(consumer, McCourse.MOD_ID + ":mc-course");

        Advancement metalDetector = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.PINK_GARNET),
                        Text.literal("Metal Detector"), Text.literal("Batteries not included!"),
                        new Identifier(McCourse.MOD_ID, "block/pink_garnet_ore"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_pink_garnet", UsingItemCriterion.Conditions.create(EntityPredicate.Builder.create(), // checks when the metal detector is used
                                ItemPredicate.Builder.create().items(ModItems.METAL_DETECTOR)))
                .parent(rootAdvancement)
                .build(consumer, McCourse.MOD_ID + ":mc-course");
    }
}
