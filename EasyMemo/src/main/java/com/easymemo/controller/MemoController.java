package com.easymemo.controller;

import com.easymemo.pojo.Memo;
import com.easymemo.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 负责memo的增删改查操作
 */
@Controller
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/lookMemo")
    public String lookMemo(HttpSession session) {

        if (session.getAttribute("userAccount") == null) {
            return "redirect:/entry/login";
        } else {
            String userAccount = session.getAttribute("userAccount").toString();
            List<Memo> memoList = memoService.lookMemo(userAccount);
            session.setAttribute("memoList", memoList);
            session.setAttribute("msg", "查询成功！");
            return "redirect:/entry/lookMemo";
        }
    }

    @PostMapping("/addMemo")
    public String addMemo(Memo memo, HttpSession session){

        if (session.getAttribute("userAccount") == null) {
            return "redirect:/entry/login";
        } else {
            String userAccount = session.getAttribute("userAccount").toString();
            memo.setUserAccount(userAccount);
            memoService.addMemo(memo);
            session.setAttribute("msg", "保存成功！");
            return "redirect:/memo/lookMemo";
        }
    }


    @GetMapping("/updateMemo/{memoId}")
    public String toUpdateMemo(@PathVariable int memoId, HttpSession session) {
        System.out.println("toUpdateMemo===>memoId:"+memoId);
        session.setAttribute("memoId", memoId);
        Memo memo = memoService.queryMemoById(memoId);
        session.setAttribute("memo", memo);
        return "redirect:/entry/updateMemo";
    }


    @PostMapping("/updateMemo")
    public String updateMemo(Memo memo, HttpSession session) {
        if (session.getAttribute("userAccount") == null) {
            return "redirect:/entry/login";
        } else {
            if (session.getAttribute("memoId") == null) {
                session.setAttribute("msg", "出现错误，请重试!");
                return "redirect:/entry/lookMemo";
            } else {
                String userAccount = session.getAttribute("userAccount").toString();
                memo.setUserAccount(userAccount);
                memo.setMemoId((Integer) session.getAttribute("memoId"));
                memoService.updateMemo(memo);
                session.setAttribute("msg", "修改成功！");
                return "redirect:/memo/lookMemo";
            }
        }
    }

    @GetMapping("/deleteMemo/{memoId}")
    public String deleteMemo(@PathVariable int memoId, HttpSession session) {

        if (session.getAttribute("userAccount") == null) {
            return "redirect:/entry/login";
        } else {
            if (memoService.queryMemoById(memoId) != null) {
                memoService.deleteMemoById(memoId);
                session.setAttribute("msg", "删除成功！");
            } else {
                session.setAttribute("msg", "删除失败！");
            }
            return "redirect:/memo/lookMemo";
        }
    }
}
