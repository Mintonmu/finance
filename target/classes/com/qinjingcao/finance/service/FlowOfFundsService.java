package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.FlowOfFunds;

import java.util.List;

public interface FlowOfFundsService {

    Integer insertFlowOfFunds(FlowOfFunds flowOfFunds);

    List<FlowOfFunds> selectFlowOfFundsByUserId(Integer userId);
}
