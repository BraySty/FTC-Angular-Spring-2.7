package com.ftc.spring.api.entitys;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ftc.spring.api.security.role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario", catalog = "games")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nombre", length = 255, unique = true)
    String nombre;
    @Column(name = "Correo", length = 255, unique = true)
    String correo;
    @Column(name = "Password", length = 255)
    String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String toString() {
        return "Usuario [nombre = " + nombre + ", correo = " + correo + ", contraseña = " + password + "]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((role.name())));
    }
    @Override
    public String getUsername() {
        return this.nombre;
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

}
