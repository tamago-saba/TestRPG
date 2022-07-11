package com.github.tsuoihito.testrpg.utils;

import com.github.tsuoihito.testrpg.TestRPG;
import org.bukkit.scheduler.BukkitRunnable;

public class ScoreboardScheduler extends BukkitRunnable {

    @Override
    public void run() {

        TestRPG.getPlugin().getServer().getOnlinePlayers().forEach(player -> {
            TestRPG.getPlugin().getUserData().getUser(player.getUniqueId()).ifPresent(user -> {
                player.setScoreboard(TestRPG.getPlugin().getTestRPGScoreboard().getScoreboard(user));
            });
        });

    }
}
