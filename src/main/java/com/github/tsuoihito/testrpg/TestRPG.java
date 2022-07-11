package com.github.tsuoihito.testrpg;

import com.github.tsuoihito.testrpg.commands.TestRPGCommand;
import com.github.tsuoihito.testrpg.data.UserData;
import com.github.tsuoihito.testrpg.listeners.AbilityUseListener;
import com.github.tsuoihito.testrpg.listeners.PlayerJoinListener;
import com.github.tsuoihito.testrpg.utils.ScoreboardScheduler;
import com.github.tsuoihito.testrpg.utils.TestRPGScoreboard;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class TestRPG extends JavaPlugin {

    private static TestRPG plugin;

    private final UserData userData = new UserData();
    private TestRPGScoreboard testRPGScoreboard;

    @Override
    public void onEnable() {
        plugin = this;
        register();
        testRPGScoreboard = new TestRPGScoreboard();
        new ScoreboardScheduler().runTaskTimer(this, 0, 20);
    }

    @Override
    public void onDisable() {
    }

    private void register() {
        getServer().getPluginManager().registerEvents(new AbilityUseListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getCommand("testrpg").setExecutor(new TestRPGCommand());
    }

    public static TestRPG getPlugin() {
        return plugin;
    }
}
