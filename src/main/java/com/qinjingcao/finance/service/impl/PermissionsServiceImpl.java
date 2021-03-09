package com.qinjingcao.finance.service.impl;

import com.qinjingcao.finance.entity.Permissions;
import com.qinjingcao.finance.entity.PermissionsExample;
import com.qinjingcao.finance.mapper.PermissionsMapper;
import com.qinjingcao.finance.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsServiceImpl implements PermissionsService {
    @Autowired
    PermissionsMapper permissionsMapper;
    @Override
    public List<Permissions> selectPermissionsByPermission(String permission) {
        PermissionsExample permissionsExample = new PermissionsExample();
        permissionsExample.createCriteria().andPermissionEqualTo(permission);
        return permissionsMapper.selectByExample(permissionsExample);
    }
}
