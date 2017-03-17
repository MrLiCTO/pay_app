package com.lisl.pay.app.model.one;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "sys_moudle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
