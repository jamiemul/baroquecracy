package com.baroque.scenes;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.baroque.game.GameController;
import com.baroque.game.Scene;

public class GameScene implements Scene {
    private Table table;
    private Skin skin;
    TextButton button;

    public GameScene(Table table, Skin skin) {
        this.table = table;
        this.skin = skin;
    }

    public void create(GameController gc) {
        addButton(10f, "GameScene", gc.startGame);
    }

    public void addButton(float padding, String text, Runnable action) {
        button = new TextButton(text, skin);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                action.run();
            }
        });

        table.add(button).pad(padding);
    }

    public void update() {
        // Update the menu scene logic, if required
    }

    public void dispose() {
        this.button.remove();
        // Dispose any resources used by the menu scene, if needed
    }
}