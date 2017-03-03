package com.lisl.pay.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "sys_moudle")
public class SysModule implements Serializable{
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    private String name;
    private boolean enabled;
    // 父级模块
    @ManyToOne(cascade = { CascadeType.REFRESH}, optional=true)
    @JoinColumn(name="parent_id")
    private SysModule parentModule;
    // 子级模块
    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.REMOVE }, fetch= FetchType.LAZY, mappedBy="parentModule")
    private Set<SysModule> childModules;
    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.REMOVE }, fetch= FetchType.LAZY, mappedBy="module")
    private List<SecurityAuthority> authorities;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<SecurityAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SecurityAuthority> authorities) {
        this.authorities = authorities;
    }
}
