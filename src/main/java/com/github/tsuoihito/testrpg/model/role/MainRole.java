package com.github.tsuoihito.testrpg.model.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;

@Getter
@RequiredArgsConstructor
public enum MainRole implements Role {

    SABER(ChatColor.RED, "セイバー"),
    ARCHER(ChatColor.DARK_RED, ""),
    LANCER(ChatColor.BLUE, ""),
    WIZARD(ChatColor.DARK_PURPLE, ""),
    BERSERKER(ChatColor.DARK_GREEN, ""),
    ASSASSIN(ChatColor.LIGHT_PURPLE, "");

    private final ChatColor color;
    private final String name;

    @Override
    public String getDisplayName() {
        return color + name;
    }

}
