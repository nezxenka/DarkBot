package com.github.nezxenka.darkbot.config.types;

import com.github.nezxenka.darkbot.config.types.suppliers.OptionList;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface Options {
    Class<? extends OptionList<?>> value();
}
