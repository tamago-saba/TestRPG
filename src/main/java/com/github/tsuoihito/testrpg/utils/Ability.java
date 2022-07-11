package com.github.tsuoihito.testrpg.utils;

import com.github.tsuoihito.testrpg.TestRPG;
import com.github.tsuoihito.testrpg.model.User;
import com.github.tsuoihito.testrpg.model.role.MainRole;
import com.github.tsuoihito.testrpg.model.role.Role;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ability {

    public static void Saber(Player player, User user) {
        if (user.getMagicPoint() < 20) {
            Message.sendActionBar(player, ChatColor.RED + "MPが足りません！");
            return;
        }
        user.setMagicPoint(user.getMagicPoint() - 20);
        player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 1000);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 3));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 3));

        useMessage(player, MainRole.SABER);
        user.setAbilityCoolTime(300);
        new CoolTimeScheduler(user).runTaskTimer(TestRPG.getPlugin(), 0, 20);
    }

    private static void useMessage(Player player, Role role) {
        Message.sendActionBar(player, role.getDisplayName() + ChatColor.AQUA + "の" + ChatColor.GREEN + "アビリティ" + ChatColor.AQUA + "を使用した！");
    }

}
