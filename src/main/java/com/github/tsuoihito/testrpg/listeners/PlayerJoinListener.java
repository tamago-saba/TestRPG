package com.github.tsuoihito.testrpg.listeners;

import com.github.tsuoihito.testrpg.TestRPG;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (TestRPG.getPlugin().getUserData().getUser(event.getPlayer().getUniqueId()).isPresent()) {
            return;
        }

        TestRPG.getPlugin().getUserData().addUser(event.getPlayer().getName(), event.getPlayer().getUniqueId());

    }
}
