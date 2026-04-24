package com.github.nezxenka.darkbot.config.actions;

public interface Parser {
    String parse(String str) throws SyntaxException;
}
