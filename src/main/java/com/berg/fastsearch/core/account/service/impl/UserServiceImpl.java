package com.berg.fastsearch.core.account.service.impl;

import com.berg.fastsearch.core.account.web.dto.UserDto;
import com.berg.fastsearch.core.account.entity.User;
import com.berg.fastsearch.core.account.repository.UserRepository;
import com.berg.fastsearch.core.account.service.IRoleService;
import com.berg.fastsearch.core.account.service.IUserRoleService;
import com.berg.fastsearch.core.account.service.IUserService;
import com.berg.fastsearch.core.account.web.dto.UserQueryCondition;
import com.berg.fastsearch.core.enums.account.UserStatus;
import com.berg.fastsearch.core.system.base.service.impl.AbstractBaseServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>用户服务的实现类</p>
 *
 * @author bo.he02@hand-china.com
 * @version v1.0
 * @apiNote Created on 18-3-18
 */
@Service
public class UserServiceImpl
        extends AbstractBaseServiceImpl<Long, UserDto, User, UserQueryCondition>
        implements IUserService {

    /**
     * 用户的repository对象
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 角色的服务对象
     */
    @Autowired
    private IRoleService roleService;

    /**
     * 用户角色服务对象
     */
    @Autowired
    private IUserRoleService userRoleService;

    /**
     * 密码处理对象
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto findByName(String userName) {
        return transform2D(userRepository.findByName(userName));
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    protected UserDto createDto() {
        return new UserDto();
    }

    @Override
    protected User createEntity() {
        return new User();
    }

    @Override
    protected void transform2E(UserDto dto, User entity) {
        //如果dto有Id,就设置用于数据的更新
        Long id = dto.getId();
        if(id!=null && id>0){
            //更新
            entity.setId(id);
        }else{
            //新建
            //处理创建时间
            entity.setCreateTime(new Date());
            //处理最近登录时间
            entity.setLastLoginTime(new Date());
        }

        //处理用户的密码
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        //处理用户状态
        if(StringUtils.isBlank(entity.getStatus())){
            entity.setStatus(UserStatus.NORMAL.getValue());
        }
        //新增与更新共同的操作
        //处理最后更新时间
        entity.setLastUpdateTime(new Date());
    }
}
