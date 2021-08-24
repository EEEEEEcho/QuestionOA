package com.echo.service;

import com.echo.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsService {
    public List<News> findNewsWithoutContent();

    public News findNewsById(String id);

    public void updateNewsById(News news);
}
