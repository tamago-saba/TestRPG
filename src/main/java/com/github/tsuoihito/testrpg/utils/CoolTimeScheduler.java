package com.github.tsuoihito.testrpg.utils;

import com.github.tsuoihito.testrpg.model.User;
import lombok.RequiredArgsConstructor;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class CoolTimeScheduler extends BukkitRunnable {

    private final User user;

    @Override
    public void run() {

        if (user.getAbilityCoolTime() == 0) {
            cancel();
            return;
        }

        user.setAbilityCoolTime(user.getAbilityCoolTime() - 1);

    }
}
