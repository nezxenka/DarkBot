package com.github.nezxenka.darkbot.modules;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.config.Config;
import com.github.nezxenka.darkbot.config.NpcExtra;
import com.github.nezxenka.darkbot.core.entities.Box;
import com.github.nezxenka.darkbot.core.entities.Npc;
import com.github.nezxenka.darkbot.core.itf.Module;
import com.github.nezxenka.darkbot.core.manager.HeroManager;
import com.github.nezxenka.darkbot.core.manager.PetManager;
import com.github.nezxenka.darkbot.core.utils.Drive;
import com.github.nezxenka.darkbot.extensions.features.Feature;
import com.github.nezxenka.darkbot.utils.I18n;

/**
 * @deprecated Use {@link eu.darkbot.shared.modules.LootCollectorModule}
 */
@Deprecated(forRemoval = true)
@SuppressWarnings("removal")
@Feature(name = "Kill & Collect (Legacy)", description = "Kills npcs and collects resources at the same time.")
public class LootNCollectorModule implements Module {

    protected LootModule lootModule = new LootModule();
    protected CollectorModule collectorModule = new CollectorModule();

    protected PetManager pet;
    protected HeroManager hero;
    protected Drive drive;
    protected Config config;

    @Override
    public void install(Main main) {
        lootModule.install(main);
        collectorModule.install(main);

        this.pet = main.guiManager.pet;
        this.hero = main.hero;
        this.drive = main.hero.drive;
        this.config = main.config;
    }

    @Override
    public String status() {
        return I18n.get("module.kill_n_collect.status", lootModule.status(), collectorModule.status());
    }

    @Override
    public boolean canRefresh() {

        if(collectorModule.isNotWaiting()) {
            return lootModule.canRefresh();
        }

        return false;
    }

    @Override
    public void tick() {
        if (collectorModule.isNotWaiting() && lootModule.checkDangerousAndCurrentMap()) {
            pet.setEnabled(true);

            if (lootModule.findTarget()) {

                collectorModule.findBox();

                Box box = collectorModule.current;
                Npc npc = lootModule.attack.target;

                if (box == null || box.removed
                        || box.locationInfo.distance(hero) > config.COLLECT.RADIUS
                        || (npc.npcInfo.extra.has(NpcExtra.IGNORE_BOXES)
                                && npc.locationInfo.distance(box) > Math.min(800, npc.npcInfo.radius * 2))
                        || lootModule.attack.target.health.hpPercent() < 0.25) {
                    lootModule.moveToAnSafePosition();
                } else {
                    lootModule.setConfig(collectorModule.current.locationInfo.now);
                    collectorModule.tryCollectNearestBox();
                }

                lootModule.ignoreInvalidTarget();
                lootModule.attack.doKillTargetTick();

            } else {
                hero.roamMode();
                collectorModule.findBox();

                if (!collectorModule.tryCollectNearestBox() && (!drive.isMoving() || drive.isOutOfMap())) {
                    drive.moveRandom();
                }

            }

        }

    }
}
