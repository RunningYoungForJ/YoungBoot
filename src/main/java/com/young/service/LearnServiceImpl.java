package com.young.service;

import com.young.dao.LearnDao;
import com.young.entity.LearnResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.young.tools.Page;

import java.util.Map;

/**
 * Created by yangkun on 2017/12/21.
 */
@Service
public class LearnServiceImpl implements LearnService {
    @Autowired
    private LearnDao learnDao;

    @Override
    public int add(LearnResource learnResource) {
        return this.learnDao.add(learnResource);
    }

    @Override
    public int update(LearnResource learnResource) {
        return this.learnDao.update(learnResource);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.learnDao.deleteByIds(ids);
    }

    @Override
    public LearnResource queryLearnResourceById(Long learnResource) {
        return this.learnDao.queryLearnResourceById(learnResource);
    }

    @Override
    public Page queryLearnResourceList(Map<String, Object> params) {
        return this.learnDao.queryLearnResourceList(params);
    }
}
