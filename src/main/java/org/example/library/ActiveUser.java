package org.example.library;

import lombok.AllArgsConstructor;
import org.example.library.api.UserRole;

import java.util.Set;

@AllArgsConstructor
public class ActiveUser {

    private String login;
    private String name;
    private Set<UserRole> userRoles;

}
