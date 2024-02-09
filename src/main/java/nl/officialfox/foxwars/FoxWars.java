package nl.officialfox.foxwars;

import me.mattstudios.mf.base.CommandManager;
import nl.officialfox.foxwars.commands.ArenaCommands;
import nl.officialfox.foxwars.commands.LobbyCommand;
import nl.officialfox.foxwars.configs.ArenaConfig;
import nl.officialfox.foxwars.manager.ArenaManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class FoxWars extends JavaPlugin {

    private HashMap<Integer, ArenaManager> games;

    @Override
    public void onEnable(){
        ArenaConfig.createArenaConfig();


        getCommand("lobby").setExecutor(new LobbyCommand());
//        games.put(10,new GameManager(new Island()))
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
