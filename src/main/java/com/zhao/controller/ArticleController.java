package com.zhao.controller;


import com.github.pagehelper.PageInfo;
import com.zhao.pojo.Article;
import com.zhao.pojo.Categoriy;
import com.zhao.pojo.Comment;
import com.zhao.service.CommentService;
import com.zhao.service.impl.ArticleServiceImpl;
import com.zhao.service.impl.CategoriyServiceImpl;
import com.zhao.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    CategoriyServiceImpl categoriyService;
    @Autowired
    CommentServiceImpl commentService;

    @GetMapping("/")
    public String index(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "4")Integer pageSize,
                        Model model) {
        PageInfo<Article> article = articleService.queryArticle(pageNum,pageSize);
//        List<Article> articles = articleService.queryArticle();
        System.out.println(article);
//        model.addAttribute("article", articles);
        model.addAttribute("articles",article);
        return "index";
    }

    @GetMapping("/index/queryById")
    public String queryById(int id, Model model) {
        Article art = articleService.queryById(id);
        List<Comment> comments = commentService.queryCategoriy(id);
        int i = commentService.selectCount(id);
        model.addAttribute("i",i);
        int hits = art.getHits();
        hits+=1;
        articleService.updateHist(hits,id);
        Article article = articleService.queryById(id);
        model.addAttribute("comments",comments);
        model.addAttribute("details", article);
        return "details";
    }
    @GetMapping("/index/queryByIds")
    public String queryByIds(int id, Model model) {
        Article art = articleService.queryById(id);
        List<Comment> comments = commentService.queryCategoriy(id);
        int i = commentService.selectCount(id);
        model.addAttribute("i",i);
        Article article = articleService.queryById(id);
        model.addAttribute("comments",comments);
        model.addAttribute("detail", article);
        return "detail";
    }

    @GetMapping("/index/toInsert")
    public String toInsert(Model model) {
        List<Categoriy> categoriys = categoriyService.queryCategoriy();
        for (Categoriy c : categoriys) {
            System.out.println(c);
        }
        model.addAttribute("categories", categoriys);
        return "insert";
    }

    @RequestMapping("/index/insert")
    public String insert(Model model, Article article, HttpSession session, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("images/blog");
            String name = (String) session.getAttribute("username");
            article.setAuthor(name);
        articleService.insertArticle(article);
            System.out.println("上传成功！");
        return "redirect:/";
    }
    @RequestMapping("/index/toUpdate")
    public String toUpdate(int id,Model model){
        Article article = articleService.queryById(id);
        List<Categoriy> categoriys = categoriyService.queryCategoriy();
        model.addAttribute("categoriys",categoriys);
        model.addAttribute("article",article);

        return "update";

    }
    @RequestMapping("/index/update")
    public String update(Article article){
            articleService.update(article);
        return "redirect:/index/selectMy";
    }

    @GetMapping("/index/delete")
    public String delete(int id){
        articleService.delete(id);
        return "redirect:/index/selectMy";
    }
    @GetMapping("/index/selectMy")
    public String selectMy(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "4")Integer pageSize,
                           Model model,HttpSession session){
            String author = (String) session.getAttribute("username");
        PageInfo<Article> articles = articleService.queryByName(pageNum,pageSize,author);

        model.addAttribute("articles",articles);
        return "guanli";
    }
    @GetMapping("/index/queryByAuthor")
    public String queryByAuthor(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "pageSize",required = false,defaultValue = "4")Integer pageSize,
                                String author,Model model,HttpSession session){
        PageInfo<Article> articles = articleService.queryByName(pageNum,pageSize,author);
        model.addAttribute("author",author);
        model.addAttribute("articles",articles);

        return "queryAuthor";
    }

    @GetMapping("/queryCategories")
    public String queryCategories(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "4")Integer pageSize,
                                  String categories,Model model){
        PageInfo<Article> articles = articleService.queryCategories(pageNum,pageSize,categories);
        model.addAttribute("categories",categories);
        model.addAttribute("articles",articles);
        return "index";
    }
    @GetMapping("/queryTitleAndAuthor")
    public String queryTitleAndAuthor(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "4")Integer pageSize,
                                      String TitleAuthor,Model model){
        PageInfo<Article> articles = articleService.queryTitleAndAuthor(pageNum,pageSize,TitleAuthor);
        model.addAttribute("TitleAuthor",TitleAuthor);
        model.addAttribute("articles",articles);
        return "queryTitleAndAuthor";
    }

}
