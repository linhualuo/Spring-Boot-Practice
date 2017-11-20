package com.hualuo.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 控制器
 *
 * @author Joseph
 * @create 2017/11/20 16:33
 */
@Controller
public class TwitterController {

    @Autowired
    private Twitter twitter;

    /**
     * 跳转到搜索页面
     * @return
     */
    @RequestMapping("/")
    public String home() {
        return "searchPage";
    }

    /**
     * 跳转到结果页面
     * @param search
     * @param model
     * @return
     */
    @RequestMapping("/result")
    public String hello(@RequestParam(defaultValue = "masterSpringMVC4") String search,Model model) {
        SearchResults searchResults = twitter.searchOperations().search(search);
        List<Tweet> tweets = searchResults.getTweets();
        model.addAttribute("tweets", tweets);
        model.addAttribute("search", search);
        return "resultPage";
    }

    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String search = request.getParameter("search");
        //搜索结果不能包含"struts"
        if (search.toLowerCase().contains("struts")) {
            redirectAttributes.addFlashAttribute("error", "Try using spring instead.");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("search", search);
        return "redirect:result";
    }
}
