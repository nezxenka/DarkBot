package com.github.nezxenka.darkbot.extensions;

import com.github.nezxenka.darkbot.Main;
import com.github.nezxenka.darkbot.backpage.BackpageManager;
import com.github.nezxenka.darkbot.backpage.FlashResManager;
import com.github.nezxenka.darkbot.backpage.NativeBrowserImpl;
import com.github.nezxenka.darkbot.config.ConfigHandler;
import com.github.nezxenka.darkbot.core.manager.HeroManager;
import com.github.nezxenka.darkbot.core.manager.MapManager;
import com.github.nezxenka.darkbot.core.manager.PetManager;
import com.github.nezxenka.darkbot.core.manager.RepairManager;
import com.github.nezxenka.darkbot.core.manager.StarManager;
import com.github.nezxenka.darkbot.core.manager.StatsManager;
import com.github.nezxenka.darkbot.core.objects.facades.SlotBarsProxy;
import com.github.nezxenka.darkbot.core.utils.Drive;
import com.github.nezxenka.darkbot.core.utils.EntityList;
import com.github.nezxenka.darkbot.extensions.features.FeatureRegistry;
import com.github.nezxenka.darkbot.modules.utils.AttackAPIImpl;
import com.github.nezxenka.darkbot.utils.LegacyModules;
import eu.darkbot.impl.PluginApiImpl;
import eu.darkbot.impl.decorators.ListenerDecorator;
import eu.darkbot.impl.managers.EventBroker;
import eu.darkbot.impl.managers.I18n;

public class DarkBotPluginApiImpl extends PluginApiImpl {

    public DarkBotPluginApiImpl(Main main) {
        addInstance(main, main.params, StarManager.getInstance(), main.configManager);
        addImplementations(
                BackpageManager.class,
                EntityList.class,
                EventBroker.class,
                FeatureRegistry.class,
                FlashResManager.class,
                HeroManager.class,
                SlotBarsProxy.class,
                Drive.class,
                PetManager.class,
                RepairManager.class,
                MapManager.class,
                StatsManager.class,
                AttackAPIImpl.class,
                LegacyModules.class,
                I18n.class,
                ConfigHandler.class,
                NativeBrowserImpl.class);
        addDecorator(requireInstance(ListenerDecorator.class));
    }

}
