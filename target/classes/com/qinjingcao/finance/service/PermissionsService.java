package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.Permissions;

import java.util.List;

public interface PermissionsService {

    List<Permissions> selectPermissionsByPermission(String permission);
}
