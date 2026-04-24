package com.github.nezxenka.darkbot.extensions.features.handlers;

import com.github.nezxenka.darkbot.core.manager.HeroManager;
import eu.darkbot.api.config.types.ShipMode;
import eu.darkbot.api.extensions.selectors.PrioritizedSupplier;
import eu.darkbot.api.extensions.selectors.ShipModeSelector;

public class ShipModeSelectorHandler extends AbstractSelectorHandler<ShipModeSelector,
        ShipMode, PrioritizedSupplier<ShipMode>> {

    private static final Class<?>[] NATIVE = new Class[]{HeroManager.DefaultShipModeSupplier.class};

    public ShipModeSelectorHandler() {
        super(ShipModeSelector::getShipModeSupplier);
    }

    @Override
    public Class<?>[] getNativeFeatures() {
        return NATIVE;
    }
}
