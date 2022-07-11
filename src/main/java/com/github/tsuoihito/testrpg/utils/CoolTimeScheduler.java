package com.github.tsuoihito.testrpg.utils;

import com.github.tsuoihito.testrpg.TestRPG;
import org.bukkit.scheduler.BukkitRunnable;

public class CoolTimeScheduler extends BukkitRunnable {

    @Override
    public void run() {

        TestRPG.getPlugin().getUserData().getUsers().forEach(user ->
                user.getUserRoles().forEach(userRole -> {
                    if (userRole.getCoolTime() > 0) {
                        userRole.setCoolTime(userRole.getCoolTime() - 1);
                    }
                    if (userRole.getCoolTime() < 0) {
                        userRole.setCoolTime(0);
                    }
                })
        );

    }
}
