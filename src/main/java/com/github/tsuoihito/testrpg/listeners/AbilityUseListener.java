package com.github.tsuoihito.testrpg.listeners;

import com.github.tsuoihito.testrpg.TestRPG;
import com.github.tsuoihito.testrpg.model.role.MainRole;
import com.github.tsuoihito.testrpg.utils.Ability;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

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

            switch (event.getItem().getType()) {

                case BLAZE_ROD:
                    Ability.useAbility(MainRole.SABER, event.getPlayer(), user);
                    break;

            }

        });
    }
}
