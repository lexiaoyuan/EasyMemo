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

    public int updateMemo(Memo memo) {
        return memoMapper.updateMemo(memo);
    }

    public Memo queryMemoById(int memoId) {
        return memoMapper.queryMemoById(memoId);
    }

    public int deleteMemoById(int memoId) {
        return memoMapper.deleteMemoById(memoId);
    }
}
