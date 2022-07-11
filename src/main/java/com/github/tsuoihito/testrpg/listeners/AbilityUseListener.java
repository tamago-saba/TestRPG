package com.github.tsuoihito.testrpg.listeners;

import com.github.tsuoihito.testrpg.TestRPG;
import com.github.tsuoihito.testrpg.utils.Ability;
import com.github.tsuoihito.testrpg.utils.Message;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.github.tsuoihito.testrpg.model.role.MainRole.SABER;

@RequiredArgsConstructor
public class AbilityUseListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (!(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK))) {
            return;
        }

        if (event.getItem() == null) {
            return;
        }

        TestRPG.getPlugin().getUserData().getUser(event.getPlayer().getName()).ifPresent(user -> {

            if (user.getAbilityCoolTime() != 0) {
                Message.sendActionBar(event.getPlayer(), ChatColor.RED + "クールタイム中...");
                return;
            }

            switch (event.getItem().getType()) {

                case BLAZE_ROD:
                    if (user.getRoles().containsKey(SABER)) {
                        Ability.Saber(event.getPlayer(), user);
                    }
                    break;
            }

        });
    }
}
