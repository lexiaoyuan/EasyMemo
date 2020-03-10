package com.easymemo.controller;

import com.easymemo.pojo.Memo;
import com.easymemo.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String lookMemo(HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("userAccount") == null) {
            redirectAttributes.addFlashAttribute("msg", "账号未登录，请先登录!");
            return "redirect:/entry/login";
        } else {
            String userAccount = session.getAttribute("userAccount").toString();
            List<Memo> memoList = memoService.lookMemo(userAccount);
            if (memoList.size() != 0 ) {
                session.setAttribute("memoList", memoList);
                System.out.println(session.getAttribute("msg"));
                redirectAttributes.addFlashAttribute("msg", session.getAttribute("msg"));
                session.removeAttribute("msg");
                return "redirect:/entry/lookMemo";
            } else {
                redirectAttributes.addFlashAttribute("msg", "结果为空，无法查看！");
                return "redirect:/entry/addMemo";
            }
        }
    }

    @PostMapping("/addMemo")
    public String addMemo(Memo memo, HttpSession session, RedirectAttributes redirectAttributes){

        if (session.getAttribute("userAccount") == null) {
            redirectAttributes.addFlashAttribute("msg", "账号未登录，请先登录!");
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

        session.setAttribute("memoId", memoId);
        Memo memo = memoService.queryMemoById(memoId);
        session.setAttribute("memo", memo);
        return "redirect:/entry/updateMemo";
    }


    @PostMapping("/updateMemo")
    public String updateMemo(Memo memo, HttpSession session, RedirectAttributes redirectAttributes) {

        if (session.getAttribute("userAccount") == null) {
            redirectAttributes.addFlashAttribute("msg", "账号未登录，请先登录!");
            return "redirect:/entry/login";
        } else {
            if (session.getAttribute("memoId") == null) {
                redirectAttributes.addFlashAttribute("msg", "出现错误，请重试!");
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
    public String deleteMemo(@PathVariable int memoId, HttpSession session, RedirectAttributes redirectAttributes) {

        if (session.getAttribute("userAccount") == null) {
            redirectAttributes.addFlashAttribute("msg", "账号未登录，请先登录!");
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
