package com.github.tsuoihito.testrpg.model.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;

@Getter
@RequiredArgsConstructor
public enum SubRole implements Role {

    ANGLER(ChatColor.YELLOW, ""),
    FARMER(ChatColor.GREEN, ""),
    ARCHITECT(ChatColor.AQUA, ""),
    HEALER(ChatColor.LIGHT_PURPLE, "");

    private final ChatColor color;
    private final String name;

    @Override
    public String getDisplayName() {
        return color + name;
    }

}
