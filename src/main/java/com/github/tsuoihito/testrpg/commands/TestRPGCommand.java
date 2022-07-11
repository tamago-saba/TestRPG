package com.github.tsuoihito.testrpg.commands;

import com.github.tsuoihito.testrpg.TestRPG;
import com.github.tsuoihito.testrpg.model.User;
import com.github.tsuoihito.testrpg.model.role.MainRole;
import com.github.tsuoihito.testrpg.model.role.SubRole;
import com.github.tsuoihito.testrpg.utils.RoleManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.HumanEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRPGCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            invalidSyntax(sender);
            return true;
        }

        // /testrpg givemp <player> <mp>
        if (args[0].equals("givemp")) {
            if (args.length != 3) {
                invalidSyntax(sender);
                return true;
            }
            Optional<User> user = TestRPG.getPlugin().getUserData().getUser(args[1]);
            if (!user.isPresent()) {
                sender.sendMessage(ChatColor.RED + "ユーザーデータが見つかりませんでした");
                return true;
            }
            try {
                user.get().setMagicPoint(Integer.parseInt(args[2]));
            } catch (NumberFormatException e) {
                sender.sendMessage(ChatColor.RED + "MPが有効な値ではありません");
                return true;
            }
            sender.sendMessage(ChatColor.GREEN + "MPが正常に設定されました");
            return true;
        }

        // /testrpg mainrole <player> <role>
        if (args[0].equals("mainrole")) {
            if (args.length != 3) {
                invalidSyntax(sender);
                return true;
            }
            for (MainRole mainRole : MainRole.values()) {
                if (mainRole.toString().equalsIgnoreCase(args[2])) {
                    Optional<User> user = TestRPG.getPlugin().getUserData().getUser(args[1]);
                    if (!user.isPresent()) {
                        sender.sendMessage(ChatColor.RED + "ユーザーデータが見つかりませんでした");
                        return true;
                    }
                    if (!RoleManager.setMainRole(user.get(), mainRole)) {
                        sender.sendMessage(ChatColor.RED + "既に本職に就いています");
                    }
                    sender.sendMessage(ChatColor.GREEN + "役職は正常に設定されました");
                    return true;
                }
            }
            sender.sendMessage(ChatColor.RED + "役職名が無効です");
        }

        // /testrpg subrole <player> <role>
        if (args[0].equals("subrole")) {
            if (args.length != 3) {
                invalidSyntax(sender);
                return true;
            }
            for (SubRole subRole : SubRole.values()) {
                if (subRole.toString().equalsIgnoreCase(args[2])) {
                    Optional<User> user = TestRPG.getPlugin().getUserData().getUser(args[1]);
                    if (!user.isPresent()) {
                        sender.sendMessage(ChatColor.RED + "ユーザーデータが見つかりませんでした");
                        return true;
                    }
                    if (!RoleManager.setSubRole(user.get(), subRole)) {
                        sender.sendMessage(ChatColor.RED + "これ以上複職できません");
                    }
                    sender.sendMessage(ChatColor.GREEN + "役職は正常に設定されました");
                    return true;
                }
            }
            sender.sendMessage(ChatColor.RED + "役職名が無効です");
        }

        return true;

    }

    private void invalidSyntax(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "構文が間違っています");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Stream.of("givemp", "mainrole", "subrole").filter(name -> name.startsWith(args[0])).collect(Collectors.toList());
        }
        return TestRPG.getPlugin().getServer().getOnlinePlayers().stream().map(HumanEntity::getName).collect(Collectors.toList());
    }
}
