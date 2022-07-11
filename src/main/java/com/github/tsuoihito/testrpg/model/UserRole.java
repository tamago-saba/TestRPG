package com.github.tsuoihito.testrpg.model;

import com.github.tsuoihito.testrpg.model.role.Role;
import lombok.Data;

@Data
public class UserRole {
    private final Role role;
    private int level;
    private int coolTime;
}
