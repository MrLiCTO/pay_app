package com.lisl.pay.app.model.one;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "security_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
