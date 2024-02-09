package nl.officialfox.foxwars.configs;

import nl.officialfox.foxwars.game.Arena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public class ArenaConfig {

    private static FileConfiguration config;

    private static File arenafile;
    private static FileConfiguration arenaconfigfile;

    public static void createArenaConfig(){
        arenafile = new File(Bukkit.getServer().getPluginManager().getPlugin("FoxWars").getDataFolder(),"Arenas.yml");
        if(!arenafile.exists()){
            try {
                arenafile.createNewFile();
            }catch (IOException e){
                Bukkit.getConsoleSender().sendMessage("Couldn't create arena config");
            }
        }
        arenaconfigfile = YamlConfiguration.loadConfiguration(arenafile);
    }

    public static FileConfiguration getArenaconfigfile(){
        return arenaconfigfile;
    }

    public static void save(){
        try{
            arenaconfigfile.save(arenafile);
        }catch(IOException e){
            Bukkit.getConsoleSender().sendMessage("Couldn't save arena config");
        }
    }

    public static void saveLobbyLocation(Location location){
        arenaconfigfile.set("lobby.world", location.getWorld().getName());
        arenaconfigfile.set("lobby.x", location.getX());
        arenaconfigfile.set("lobby.y", location.getY());
        arenaconfigfile.set("lobby.z", location.getZ());
        arenaconfigfile.set("lobby.yaw", location.getYaw());
        arenaconfigfile.set("lobby.pitch", location.getPitch());
        save();
    }

    @Nullable
    public static Location getLobbyLocation(){
        if(arenaconfigfile.contains("lobby")) {
            World world = Bukkit.getWorld(arenaconfigfile.getString("lobby.world"));
            double x = arenaconfigfile.getDouble("lobby.x");
            double y = arenaconfigfile.getDouble("lobby.y");
            double z = arenaconfigfile.getDouble("lobby.z");
            double yaw = arenaconfigfile.getDouble("lobby.yaw");
            double pitch = arenaconfigfile.getDouble("lobby.pitch");
            save();
            return new Location(world,x,y,z,(float) yaw,(float) pitch);
        } else {
            return null;
        }
    }

    public static void saveArenaLocation(Arena arena){

    }

}
