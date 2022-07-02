package com.zhao.controller;

import com.zhao.pojo.Comment;
import com.zhao.service.impl.CommentServiceImpl;
import com.zhao.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;

    @RequestMapping("/insertComment")
    public String insertComment(Comment comment, HttpSession session,HttpServletRequest request){
        String username =(String) session.getAttribute("username");
        comment.setAuthor(username);

        String ipAddress = null;
        try {
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            // "***.***.***.***".length()
            // = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
    } catch (Exception e) {
        ipAddress="";
    }
        comment.setIp(ipAddress);

        int i = commentService.insertComment(comment);
        return "redirect:/index/queryById?id="+comment.getArticle_id();
    }
    @GetMapping("/deleteComment")
    public String deleteComment(int id ,int article_id){
        commentService.deleteComment(id);
        return "redirect:/index/queryByIds?id="+article_id;
    }
}
