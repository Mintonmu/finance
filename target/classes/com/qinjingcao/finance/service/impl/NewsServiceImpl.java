package com.qinjingcao.finance.service.impl;

import com.qinjingcao.finance.entity.News;
import com.qinjingcao.finance.mapper.NewsMapper;
import com.qinjingcao.finance.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired(required = false)
    NewsMapper newsMapper;

    @Override
    public List<News> selectAllNews() {
        List<News> list = newsMapper.selectByExample(null);
        return list;
    }
}
