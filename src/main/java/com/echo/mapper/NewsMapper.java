package com.echo.mapper;

import com.echo.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper {
    public List<News> findNewsWithoutContent();

    public News findNewsById(@Param("id") String id);

    public void updateNewsById(News news);
}
