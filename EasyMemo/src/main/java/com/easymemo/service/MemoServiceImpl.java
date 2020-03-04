package com.easymemo.service;

import com.easymemo.dao.MemoMapper;
import com.easymemo.pojo.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {
    private MemoMapper memoMapper;

    @Autowired
    public void setMemoMapper(MemoMapper memoMapper) {
        this.memoMapper = memoMapper;
    }

    public int addMemo(Memo memo) {
        return memoMapper.addMemo(memo);
    }

    public List<Memo> lookMemo(String userAccount) {
        return memoMapper.lookMemo(userAccount);
    }
}
