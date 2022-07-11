package com.github.tsuoihito.testrpg.utils;

import com.github.tsuoihito.testrpg.TestRPG;
import com.github.tsuoihito.testrpg.model.User;
import com.github.tsuoihito.testrpg.model.role.Role;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.stream.Collectors;

@Getter
public class TestRPGScoreboard {

    private ScoreboardManager scoreboardManager;

    public TestRPGScoreboard() {
        scoreboardManager = TestRPG.getPlugin().getServer().getScoreboardManager();
    }

    public Scoreboard getScoreboard(User user) {

        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("TestRPG", "dummy", ChatColor.AQUA + "TestRPG");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        RoleManager.getMainRole(user).ifPresent(role -> objective.getScore(ChatColor.YELLOW + "本職 : %mainRole%".replace("%mainRole%", role.getDisplayName())).setScore(15));
        objective.getScore(ChatColor.GREEN + "サブ職 : %subRoles%".replace("%subRoles%", RoleManager.getSubRole(user).stream().map(Role::getDisplayName).collect(Collectors.joining(" ")))).setScore(14);
        objective.getScore(ChatColor.BLUE + "MP : %MP%".replace("%MP%", user.getMagicPoint().toString())).setScore(13);

        return scoreboard;
    }

}
