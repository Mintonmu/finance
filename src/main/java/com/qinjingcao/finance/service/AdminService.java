package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.Admin;

public interface AdminService {

    Admin selectAdminByTerms(String username,String password);

    Integer updateAdmin(Admin admin);

    Admin selectAdminById(Integer id);
}
