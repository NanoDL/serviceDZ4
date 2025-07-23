package ru.ruslan.spring.dz4.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.ruslan.spring.dz4.model.MyUser;

import java.net.UnknownServiceException;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final MyUser user;

    public CustomUserDetails(MyUser user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String authority = user.getRole().name();
        return List.<GrantedAuthority>of(new SimpleGrantedAuthority(authority));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public MyUser getUser() {
        return user;
    }
}
