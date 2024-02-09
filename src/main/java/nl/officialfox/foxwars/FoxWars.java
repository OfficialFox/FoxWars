package nl.officialfox.foxwars;

import nl.officialfox.foxwars.manager.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class FoxWars extends JavaPlugin {

    private HashMap<Integer,GameManager> games;

    @Override
    public void onEnable() {

//        games.put(10,new GameManager(new Island()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
