package com.github.nezxenka.darkbot.backpage.dispatch;

@FunctionalInterface
public interface BiIntConsumer<T> {
    void accept(T a, int b);
}
