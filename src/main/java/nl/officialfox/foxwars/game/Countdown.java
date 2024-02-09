package nl.officialfox.foxwars.game;

import nl.officialfox.foxwars.FoxWars;
import nl.officialfox.foxwars.enums.GameState;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private FoxWars foxWars;
    private Arena arena;
    private int countdownSecond;

    public Countdown(FoxWars foxWars, Arena arena){
        this.foxWars = foxWars;
        this.arena = arena;
        this.countdownSecond = 20;
    }

    public void start(){
        arena.setState(GameState.LIVE);
        runTaskTimer(foxWars,0,20);
    }


    @Override
    public void run() {
        if(countdownSecond == 0){
            cancel();
            // arena start
            return;
        }

        if(countdownSecond <= 10 || countdownSecond % 10 == 0){
            arena.sendMessage("Game starts in: " + countdownSecond + "second" + (countdownSecond == 1 ? "" : "s"));
        }


        countdownSecond--;
    }
}
