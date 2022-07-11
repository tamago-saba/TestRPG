package com.github.tsuoihito.testrpg.model;

import com.github.tsuoihito.testrpg.model.role.Role;
import lombok.Data;

import java.util.*;

@Data
public class User {
    private final String name;
    private final UUID uuid;
    private final List<UserRole> userRoles = new ArrayList<>();
    private int magicPoint;
}
