package net.eitan.mccourse.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.impl.entity.TerraformBoatEntity;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import net.eitan.mccourse.McCourse;
import net.eitan.mccourse.block.ModBlocks;
import net.eitan.mccourse.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier DRIFTWOOD_BOAT_ID = new Identifier(McCourse.MOD_ID, "driftwood_boat");
    public static final Identifier DRIFTWOOD_CHEST_BOAT_ID = new Identifier(McCourse.MOD_ID, "driftwood_chest_boat");

    public static final RegistryKey<TerraformBoatType> DRIFTWOOD_BOAT_KEY = TerraformBoatTypeRegistry.createKey(DRIFTWOOD_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType driftwoodBoat = new TerraformBoatType.Builder()
                .item(ModItems.DRIFTWOOD_BOAT)
                .chestItem(ModItems.DRIFTWOOD_CHEST_BOAT)
                .planks(ModBlocks.DRIFTWOOD_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, DRIFTWOOD_BOAT_KEY, driftwoodBoat);
    }
}
