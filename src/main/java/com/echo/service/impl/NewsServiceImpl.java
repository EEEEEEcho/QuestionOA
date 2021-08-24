package com.echo.service.impl;

import com.echo.mapper.NewsMapper;
import com.echo.pojo.News;
import com.echo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> findNewsWithoutContent() {
        return newsMapper.findNewsWithoutContent();
    }

    @Override
    public News findNewsById(String id) {
        return newsMapper.findNewsById(id);
    }

    @Override
    public void updateNewsById(News news) {
        newsMapper.updateNewsById(news);
    }
}
