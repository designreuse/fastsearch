package com.berg.fastsearch.system.code.service.impl;

import com.berg.fastsearch.system.base.service.impl.AbstractBaseServiceImpl;
import com.berg.fastsearch.system.code.web.dto.CodeValueDto;
import com.berg.fastsearch.system.code.entity.CodeValue;
import com.berg.fastsearch.system.code.repository.CodeValueRepository;
import com.berg.fastsearch.system.code.service.ICodeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author bo.he02@hand-china.com
 * @version v1.0
 * @apiNote Created on 18-3-18
 */
@Service
public class CodeValueServiceImpl extends AbstractBaseServiceImpl<CodeValueDto, CodeValue, Long> implements ICodeValueService {
    @Autowired
    private CodeValueRepository codeValueRepository;

    @Override
    protected JpaRepository<CodeValue, Long> getRepository() {
        return codeValueRepository;
    }

    @Override
    protected CodeValueDto createDto() {
        return new CodeValueDto();
    }

    @Override
    protected CodeValue createEntity() {
        return new CodeValue();
    }
}