package com.github.nezxenka.darkbot.utils.itf;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Throwable> {

    void accept(T t) throws E;

}
