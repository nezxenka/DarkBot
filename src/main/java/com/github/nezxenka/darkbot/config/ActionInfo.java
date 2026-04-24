package com.github.nezxenka.darkbot.config;

import com.github.nezxenka.darkbot.config.types.Option;

@Option("Action")
public class ActionInfo {
    @Option("Active")
    public boolean active;
    @Option("Check every")
    public int checkEvery;
    @Option("Condition")
    public String condition;
    @Option("Cooldown")
    public int cooldown;
    @Option("Action")
    public String action;
    @Option("Limit")
    public int limit;
}
