package com.lisl.pay.app.model.one;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "security_role")
public class SecurityRole implements Serializable {
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    private String name;
    private String code;
    @ManyToMany(mappedBy = "roles")
    private List<SecurityUser> users;
    private boolean enabled;
    /**
     * 多对多关系中不要使用级联删除
     */
    @ManyToMany(cascade={CascadeType.REFRESH}, fetch= FetchType.EAGER)
    @JoinTable(name="t_role_authority",
            inverseJoinColumns=@JoinColumn(name="authority_id"),
            joinColumns=@JoinColumn(name="role_id"))
    private List<SecurityAuthority> authorities;

    public List<SecurityUser> getUsers() {
        return users;
    }

    public void setUsers(List<SecurityUser> users) {
        this.users = users;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
