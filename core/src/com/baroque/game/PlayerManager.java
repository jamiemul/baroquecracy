package com.baroque.game;

import com.baroque.objects.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerManager {

    public enum PLAYER_COLOR {RED, ORANGE, BLUE, BLACK, GREEN}

    List<Player> players;

    public PlayerManager() {
        players = new ArrayList<>();
    }

    public void addPlayer(String name) {
        if (players.size() < 5) {
            players.add(new Player(name, players.size()));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

}
