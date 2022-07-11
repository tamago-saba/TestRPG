package com.github.tsuoihito.testrpg.model;

import com.github.tsuoihito.testrpg.model.role.Role;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class User {
    private final String name;
    private final UUID uuid;
    private final Map<Role, Integer> roles = new HashMap<>();
    private Integer abilityCoolTime;
    private Integer magicPoint;
}
