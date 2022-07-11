package com.github.tsuoihito.testrpg.utils;

import com.github.tsuoihito.testrpg.model.User;
import com.github.tsuoihito.testrpg.model.role.MainRole;
import com.github.tsuoihito.testrpg.model.role.Role;
import com.github.tsuoihito.testrpg.model.role.SubRole;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoleManager {

    public static boolean setMainRole(User user, MainRole mainRole) {
        if (user.getRoles().keySet().stream().anyMatch(role -> role instanceof MainRole)) {
            return false;
        }
        user.getRoles().put(mainRole, 0);
        return true;
    }

    public static boolean setSubRole(User user, SubRole subRole) {
        if (user.getRoles().size() > 3) {
            return false;
        }
        user.getRoles().put(subRole, 0);
        return true;
    }

    public static Optional<Role> getMainRole(User user) {
        return user.getRoles().keySet().stream().filter(role -> role instanceof MainRole).findAny();
    }

    public static List<Role> getSubRole(User user) {
        return user.getRoles().keySet().stream().filter(role -> role instanceof SubRole).collect(Collectors.toList());
    }

}
