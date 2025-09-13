package com.reservation.reservation_server.config.Security;

import com.reservation.reservation_server.entity.Store;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class CustomStoreDetails implements UserDetails {

    private final Store store;

    public CustomStoreDetails(Store store) {
        this.store = store;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + store.getRole().name()));
    }

    @Override
    public String getPassword() {
        return store.getPassword();
    }

    @Override
    public String getUsername() {
        return store.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE.equals(store.getIsActive());
    }

    @Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE.equals(store.getIsActive());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Boolean.TRUE.equals(store.getIsActive());
    }

    public Long getId() {
        return store.getStoreId();
    }
}
