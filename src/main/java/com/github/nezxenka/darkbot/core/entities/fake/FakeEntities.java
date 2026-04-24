package com.github.nezxenka.darkbot.core.entities.fake;

public class FakeEntities {
  private static int CURR_ID = Integer.MIN_VALUE;

  public static int allocateFakeId() {
    return CURR_ID++;
  }
}
