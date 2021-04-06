package com.spring.security.example.user.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Component
public class User implements UserDetails {
   
    private static final long serialVersionUID = 1L;
    private String uid;
    private String name;
    private String password;
    private List<String> roles = new ArrayList<>();
    
    public void setRoles(String roles) {
	this.roles = Arrays.asList(roles.split(","));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
	return this.uid;
    }

    @Override
    public boolean isAccountNonExpired() {
	return false;
    }

    @Override
    public boolean isAccountNonLocked() {
	return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return false;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
	return false;
    }

}
