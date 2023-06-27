package com.baroque.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.baroque.scenes.GameScene;
import com.baroque.scenes.MainMenu;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private Map<GameController.GAME_STATE, Scene> scenes;
    private Scene currentScene;

    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    private Table table;
    private Stage stage;
    private FitViewport viewport;
    Skin skin;

    SceneManager(OrthographicCamera camera, SpriteBatch batch, Input input) {
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        stage = new Stage(viewport, batch);
        input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        scenes = new HashMap<>();
        scenes.put(GameController.GAME_STATE.menu, new MainMenu(table, skin));
        scenes.put(GameController.GAME_STATE.game, new GameScene(table, skin));
    }

    public void setScene(GameController gc) {
        if (currentScene != null) {
            currentScene.dispose(); // Dispose the previous scene if exists
        }
        currentScene = scenes.get(gc.currentState);
        currentScene.create(gc); // Create the new scene
    }

    public void update() {
        float delta = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }
}
