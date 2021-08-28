package com.echo.controller;

import com.echo.pojo.News;
import com.echo.service.NewsService;
import com.echo.util.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/news")
@Slf4j
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private IDUtil idUtil;
    //    本地路径
    @Value("${application.profile}")
    private String profile ;
    //    对外虚拟路径
    @Value("${application.staticAccessPath}")
    private String staticAccessPath ;
    @Value("${server.port}")
    private String port;

    @GetMapping("/getAllNews")
    public String getAllNews(Model model){
        List<News> newsList = newsService.findNewsWithoutContent();
        model.addAttribute("newsList",newsList);

        return "news/news-list";
    }

    @GetMapping("/updateNews/{newsId}")
    public String updateNews(@PathVariable("newsId")String newsId,Model model){
        News news = newsService.findNewsById(newsId);
        model.addAttribute("news",news);
        return "news/news-update";
    }

    @PostMapping("/doUpdate")
    public String doUpdate(@RequestParam("id")String id,
                           @RequestParam("title")String title,
                           @RequestParam("publish")String publish,
                           @RequestParam("imageFile")MultipartFile imageFile,
                           @RequestParam("content")String content){
        log.debug("传入的图片名字为：" + imageFile.getOriginalFilename());
        if(imageFile.isEmpty()){
            return "redirect:/imageFail";
        }
        else{
            try {
                byte[] fileBytes = imageFile.getBytes();
//                InputStream inputStream = imageFile.getInputStream();
                String newFileName = String.valueOf(idUtil.getId());
                String[] type = imageFile.getContentType().split("/");
                Path path = Paths.get(profile, newFileName + "." + type[1]);
                Files.write(path,fileBytes);
                //http://127.0.0.1:9007/temp/1430063107358588928.jpeg
                String imageUrl  = "http://127.0.0.1:" +  port + "/temp/" +  newFileName + "." + type[1];
                //System.out.println(imageUrl);
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setPublish(publish);
                news.setImgUrl(imageUrl);
                news.setContent(content);
                newsService.updateNewsById(news);
            }
            catch (Exception e){
                e.printStackTrace();
                return "redirect:/imageFail";
            }
        }
        return "redirect:/news/getAllNews";
    }
}
