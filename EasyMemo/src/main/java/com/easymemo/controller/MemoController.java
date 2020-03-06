package com.easymemo.controller;

import com.easymemo.pojo.Memo;
import com.easymemo.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/memo")
public class MemoController {

    private MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/lookMemo")
    public String lookMemo(HttpSession session) {
        String userAccount = session.getAttribute("userAccount").toString();
        List<Memo> memoList = memoService.lookMemo(userAccount);
        session.setAttribute("memoList", memoList);
        session.setAttribute("msg", "查询成功！");
        return "redirect:/entry/lookMemo";
    }

    @PostMapping("/addMemo")
    public String addMemo(Memo memo, HttpSession session){
        String userAccount = session.getAttribute("userAccount").toString();
        memo.setUserAccount(userAccount);
        memoService.addMemo(memo);
        session.setAttribute("msg", "保存成功！");
        return "redirect:/entry/memo";
    }

}
