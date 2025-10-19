package com.george.more.unique.weapons.loottable;

import com.george.more.unique.weapons.item.UniqueWeaponsItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class UniqueWeaponsLootTableModifiers {

    public static void modifyLootTable(){

        LootTableEvents.MODIFY.register((registryKey,
                                         builder,
                                         lootTableSource,
                                         wrapperLookup) -> {
            if(LootTables.END_CITY_TREASURE_CHEST.equals(registryKey)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(UniqueWeaponsItems.GRAVITY_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                builder.pool(poolBuilder);
            }


            if (registryKey.getValue().equals(Identifier.of("minecraft", "entities/enderman"))) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .conditionally(LocationCheckLootCondition.builder(
                                LocationPredicate.Builder.create()
                                        .dimension(RegistryKey.of(RegistryKeys.WORLD,(Identifier.of("minecraft:the_end")))
                        )))
                        .with(ItemEntry.builder(UniqueWeaponsItems.GRAVITY_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder);
            }



                });


    }
}
