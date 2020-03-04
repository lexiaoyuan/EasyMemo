package com.easymemo.controller;

import com.easymemo.pojo.Memo;
import com.easymemo.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/memo")
public class MemoController {

    private MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/lookMemo/{userAccount}")
    public String lookMemo(@PathVariable String userAccount, Model model) {
        List<Memo> memoList = memoService.lookMemo(userAccount);
        for (Memo memo : memoList) {
            System.out.println(memo);
        }

        model.addAttribute("memoList", memoList);
        return "look-memo";
    }
}
