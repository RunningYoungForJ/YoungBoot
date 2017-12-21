package com.young.dao;

import com.young.entity.LearnResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.young.tools.Page;
import com.young.tools.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by yangkun on 2017/12/21.
 */
@Repository
public class LearnDaoImpl implements LearnDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnResource learnResource) {
        return jdbcTemplate.update("INSERT INTO learn_resource (author,title,url) " +
                "values (?,?,?)",
                learnResource.getAuthor(),learnResource.getTitle(),learnResource.getUrl());
    }

    @Override
    public int update(LearnResource learnResource) {
        return jdbcTemplate.update("UPDATE learn_resource  SET author=?,title=?,url=? " +
                "WHERE id=?",
                new Object[]{learnResource.getAuthor(),learnResource.getTitle(),learnResource.getUrl(),learnResource.getId()});
    }

    @Override
    public int deleteByIds(String ids) {
        return jdbcTemplate.update("DELETE FROM learn_resource where id IN ("+ids+")");
    }

    @Override
    public LearnResource queryLearnResourceById(Long id) {
        List<LearnResource> list=jdbcTemplate.query("select * from learn_resource where id =?",
                new Object[]{id},new BeanPropertyRowMapper<>(LearnResource.class));
        if (list!=null&&list.size()>0){
            LearnResource learnResource=list.get(0);
            return learnResource;
        }
        else {
            return null;
        }
    }

    @Override
    public Page queryLearnResourceList(Map<String, Object> params) {
        StringBuffer sql=new StringBuffer();
        sql.append("select * from learn_resource where 1=1");
        if (!StringUtil.isNull((String)params.get("author"))){
            sql.append(" and author like '%").append((String)params.get("author")).append("%'");
        }
        if (!StringUtil.isNull((String)params.get("title"))){
            sql.append(" and title like '%").append((String)params.get("title")).append("%'");
        }
        Page page=new Page(sql.toString(),Integer.parseInt(params.get("page").toString()),Integer.parseInt(params.get("rows").toString()),jdbcTemplate);
        return page;
    }
}
