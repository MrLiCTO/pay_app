package com.lisl.pay.app.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "security_authority")
public class SecurityAuthority implements GrantedAuthority {
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    private String name;
    private String operation;
    @ManyToOne(cascade = { CascadeType.REFRESH}, optional=false)
    @JoinColumn(name = "module_id")
    private SysModule module;
    @ManyToMany(mappedBy = "authorities")
    private List<SecurityRole> roles;
    private boolean enabled;

    public List<SecurityRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SecurityRole> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getOperation() {
        return operation;
    }

    public SysModule getModule() {
        return module;
    }

    public void setModule(SysModule module) {
        this.module = module;
    }

    @Override
    public String getAuthority() {
        return operation;
    }
}
