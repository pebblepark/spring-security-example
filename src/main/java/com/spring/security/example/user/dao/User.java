package com.spring.security.example.user.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String uid;
    private String name;
    private String password;
    
    /*
     * private List<String> roles = new ArrayList<>();
     * 
     * @JsonProperty(access = Access.WRITE_ONLY)
     * 
     * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
     * return
     * this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.
     * toList()); }
     * 
     * @JsonProperty(access = Access.WRITE_ONLY)
     * 
     * @Override public String getUsername() { return this.uid; }
     * 
     * @JsonProperty(access = Access.WRITE_ONLY)
     * 
     * @Override public boolean isAccountNonExpired() { return true; }
     * 
     * @JsonProperty(access = Access.WRITE_ONLY)
     * 
     * @Override public boolean isAccountNonLocked() { return true; }
     * 
     * @JsonProperty(access = Access.WRITE_ONLY)
     * 
     * @Override public boolean isCredentialsNonExpired() { return true; }
     * 
     * @JsonProperty(access = Access.WRITE_ONLY)
     * 
     * @Override public boolean isEnabled() { return true; }
     */
}
