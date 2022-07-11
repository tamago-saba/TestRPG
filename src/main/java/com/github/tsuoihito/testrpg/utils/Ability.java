package com.github.tsuoihito.testrpg.utils;

import com.github.tsuoihito.testrpg.model.User;
import com.github.tsuoihito.testrpg.model.UserRole;
import com.github.tsuoihito.testrpg.model.role.MainRole;
import com.github.tsuoihito.testrpg.model.role.Role;
import com.github.tsuoihito.testrpg.model.role.SubRole;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Optional;

public class Ability {

    public static void useAbility(Role role, Player player, User user) {

        Optional<UserRole> userRoleOptional = user.getUserRoles().stream().filter(userRole -> userRole.getRole().equals(role)).findAny();

        if (!userRoleOptional.isPresent()) {
            return;
        }

        if (userRoleOptional.get().getCoolTime() != 0) {
            Message.sendActionBar(player, ChatColor.RED + "クールタイム中... 残り%coolTime%秒".replace("%coolTime%", ((Integer)userRoleOptional.get().getCoolTime()).toString()));
            return;
        }

        if (user.getMagicPoint() < 20) {
            Message.sendActionBar(player, ChatColor.RED + "MPが足りません！");
            return;
        }

        user.setMagicPoint(user.getMagicPoint() - 20);

        if (role instanceof MainRole) {
            switch ((MainRole) role) {
                case SABER:
                    useSaber(player, user);
                    break;
            }
        }

        if (role instanceof SubRole) {
        }

        usedMessage(player, role);

        userRoleOptional.get().setCoolTime(300);

    }
    private static void useSaber(Player player, User user) {
        player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 1000);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 3));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 3));
    }

    private static void usedMessage(Player player, Role role) {
        Message.sendActionBar(player, role.getDisplayName() + ChatColor.AQUA + "の" + ChatColor.GREEN + "アビリティ" + ChatColor.AQUA + "を使用した！");
    }

}
