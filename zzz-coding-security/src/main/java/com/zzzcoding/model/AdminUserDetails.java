package com.zzzcoding.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wenjie Zhang
 * @date 2/10/2022 11:17 pm
 */
public class AdminUserDetails implements UserDetails {
    private final Users users;
    private final List<Resource> resourceList;
    public AdminUserDetails(Users users, List<Resource> resourceList) {
        this.users = users;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getResourceId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() { return users.getUserPass(); }

    @Override
    public String getUsername() { return users.getUserLogin(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() {return users.getUserStatus().equals(1); }

    public Users getUsers() { return this.users; }

}

