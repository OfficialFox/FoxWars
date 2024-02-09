package nl.officialfox.foxwars.manager;

import org.bukkit.entity.Fox;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public boolean gameStarted = false;
    private List<Fox> foxes = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Island island;

    public GameManager(Island island) {
        this.island = island;
    }

    public void startGame() {
        gameStarted = true;
    }

    public void addFox(Fox fox) {
        foxes.add(fox);
    }

    public void addPlayer(Player player) {
        if (gameStarted) {
            players.add(player);
        }
    }

//    public void handleFoxAttacked(Team team, Player attacker) {
//        if (gameStarted) {
//            nl.officialfox.foxwars.game.Fox fox = team.getFox();
//            fox.runAway(attacker);
//            fox.constrainToIsland(island);
//        }
//    }
}
