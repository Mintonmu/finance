package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.FundProduct;
import com.qinjingcao.finance.entity.TermFinancial;

import java.util.List;

public interface FundProductService {

    List<FundProduct> selectAllFundProduct();

    FundProduct selectFundProductById(Integer id);

    Integer insertFundProduct(FundProduct fundProduct);

    Integer updateFundProduct(FundProduct fundProduct);

    Integer deleteFundProductById(Integer id);
}
