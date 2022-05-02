package tech.thatgravyboat.duckling.common.registry;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import tech.thatgravyboat.duckling.platform.CommonServices;
import tech.thatgravyboat.duckling.platform.SpawnData;

public class ModSpawns {

    public static void addSpawns() {
        CommonServices.REGISTRY.addEntityToBiome(Biome.Category.RIVER,
                new SpawnData(ModEntities.DUCK.get(), SpawnGroup.WATER_CREATURE, 100, 3, 4, precipitation -> !precipitation.equals(Biome.Precipitation.SNOW)));
        CommonServices.REGISTRY.addEntityToBiome(Biome.Category.SWAMP,
                new SpawnData(ModEntities.QUACKLING.get(), SpawnGroup.WATER_CREATURE, 1, 0, 1));
    }

    public static void addSpawnRules() {
        CommonServices.REGISTRY.setSpawnRules(ModEntities.DUCK.get(),
                SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (a, b, c, d, e) -> true);
        CommonServices.REGISTRY.setSpawnRules(ModEntities.QUACKLING.get(),
                SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (a, world, c, d, e) -> world.getRandom().nextInt(250) == 0 && MobEntity.canMobSpawn(a, world, c, d, e));
    }
}
