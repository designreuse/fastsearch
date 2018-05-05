package com.berg.fastsearch.account.entity;

import com.berg.fastsearch.system.base.entity.BaseEntity;

import javax.persistence.*;

/**
 * <p>用户角色实体</p>
 *
 * @author bo.he02@hand-china.com
 * @version v1.0
 * @apiNote Created on 18-3-18
 */
@Table(
        name = "sys_roles"
)
@Entity
public class Role extends BaseEntity{
    /**
     * 角色的主键
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    /**
     * 角色名
     */
    @Column
    private String name;

    /**
     * 描述
     */
    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
