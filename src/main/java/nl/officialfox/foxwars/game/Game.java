package nl.officialfox.foxwars.game;

import nl.officialfox.foxwars.enums.GameState;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public class Game {

    private List<Player> players;
    private World world;
    private GameState state;
    private final Integer id;

    public Game(World world, Integer id){
        this.world = world;
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }

    public Integer getId() {
        return id;
    }
}
