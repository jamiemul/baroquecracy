package com.baroque.game;


public interface Scene {
    void create(GameController gc);

    void update();

    void dispose();
}
