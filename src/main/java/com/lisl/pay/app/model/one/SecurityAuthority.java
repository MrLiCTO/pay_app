package com.lisl.pay.app.model.one;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "security_authority")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @Override
    public String getAuthority() {
        return operation;
    }
}
