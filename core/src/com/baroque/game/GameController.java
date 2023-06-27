package com.baroque.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.baroque.objects.BuildingManager;

public class GameController {

    SceneManager sceneManager;
    PlayerManager playerManager;
    BuildingManager buildingManager;
    GAME_STATE currentState;


    public enum GAME_STATE {
        lobby, paused, menu, game
    }

    GameController(OrthographicCamera camera, SpriteBatch batch, InputManager input) {
        playerManager = new PlayerManager();
        buildingManager = new BuildingManager(playerManager);
        sceneManager = new SceneManager(camera, batch, input.input);
        currentState = GAME_STATE.menu;
        sceneManager.setScene(this);
    }

    public void update() {
        sceneManager.update();
        buildingManager.update();
    }

    public Runnable startGame = new Runnable() {
        @Override
        public void run() {
            playerManager.addPlayer("Player 1");
            playerManager.addPlayer("Player 2");
            GameController.this.currentState = GAME_STATE.game;
            sceneManager.setScene(GameController.this);
            buildingManager.startGame();
            buildingManager.placeStarterBuildings();
        }
    };

}
