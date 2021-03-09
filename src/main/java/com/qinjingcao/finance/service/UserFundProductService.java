package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.UserFundProduct;
import com.qinjingcao.finance.entity.UserTermFinancial;

import java.util.List;

public interface UserFundProductService {

    Integer insertUserFundProduct(UserFundProduct userFundProduct);

    List<UserFundProduct> selectUserFundProductByUserId(Integer userId);

    Integer updateUserFundProduct(UserFundProduct userFundProduct);

    UserFundProduct selectUserFundProductById(Integer id);
}
