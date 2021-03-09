package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.ChangeMoney;

import java.util.List;

public interface ChangeMoneyService {

    List<ChangeMoney> selectAllChangeMoney();

    ChangeMoney selectChangeMoneyById(Integer id);

    Integer insertChangeMoney(ChangeMoney changeMoney);

    Integer updateChangeMoney(ChangeMoney changeMoney);

    Integer deleteChangeMoneyById(Integer id);
}
