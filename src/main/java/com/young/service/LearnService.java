package com.young.service;

import com.young.entity.LearnResource;
import com.young.tools.Page;

import java.util.Map;

/**
 * Created by yangkun on 2017/12/21.
 */
public interface LearnService {
    int add(LearnResource learnResource);
    int update(LearnResource learnResource);
    int deleteByIds(String ids);
    LearnResource queryLearnResourceById(Long learnResource);
    Page queryLearnResourceList(Map<String,Object> params);
}
