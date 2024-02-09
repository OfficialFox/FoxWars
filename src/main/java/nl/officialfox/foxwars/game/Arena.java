package nl.officialfox.foxwars.game;

import nl.officialfox.foxwars.FoxWars;
import nl.officialfox.foxwars.enums.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Arena {

    private int id;
    private Location spawn;

    private GameState state;
    private List<UUID> players;
    private Countdown countdown;

    private List<Arena> arenas = new ArrayList<>();

    public Arena(FoxWars foxWars, int id, Location loc){
        this.id = id;
        this.spawn = loc;

        this.state = GameState.QUEUE;
        this.players = new ArrayList<>();
        this.countdown = new Countdown(foxWars, this);
        arenas.add(this);
    }

    public void sendMessage(String string){
        for(UUID uuid : players){
            Bukkit.getPlayer(uuid).sendMessage(string);
        }
    }

    public void addPlayer(Player player){
        players.add(player.getUniqueId());
        player.teleport(spawn);
    }

    public void removePlayer(Player player){
        players.remove(player.getUniqueId());
        //player.teleport();
    }
    public int getId(){return id;}

    public GameState getState() {return state;}
    public List<UUID> getPlayers(){return players;}

    public List<Arena> getArenas() {
        return arenas;
    }

    public void setState(GameState gameState){
        this.state = gameState;
    }

    @Nullable
    public Arena getArena(Integer id){
        for(Arena arena : arenas){
            if(arena.getId() == id){
                return arena;
            }
        }
        return null;
    }
}
