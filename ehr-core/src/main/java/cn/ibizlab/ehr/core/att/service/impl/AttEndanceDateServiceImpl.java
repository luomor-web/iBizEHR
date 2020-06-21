package cn.ibizlab.ehr.core.att.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.ehr.core.att.domain.AttEndanceDate;
import cn.ibizlab.ehr.core.att.filter.AttEndanceDateSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEndanceDateService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEndanceDateMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤日期] 服务对象接口实现
 */
@Slf4j
@Service("AttEndanceDateServiceImpl")
public class AttEndanceDateServiceImpl extends ServiceImpl<AttEndanceDateMapper, AttEndanceDate> implements IAttEndanceDateService {


    private int batchSize = 500;

    @Override
    @Transactional
    public AttEndanceDate get(String key) {
        AttEndanceDate et = getById(key);
        if(et==null){
            et=new AttEndanceDate();
            et.setAttendancedateid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public boolean create(AttEndanceDate et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancedateid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEndanceDate> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public AttEndanceDate getDraft(AttEndanceDate et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(AttEndanceDate et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEndanceDate et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEndanceDate> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEndanceDate> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(AttEndanceDate et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendancedateid",et.getAttendancedateid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancedateid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEndanceDate> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(AttEndanceDate et) {
        return (!ObjectUtils.isEmpty(et.getAttendancedateid()))&&(!Objects.isNull(this.getById(et.getAttendancedateid())));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEndanceDate> searchDefault(AttEndanceDateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndanceDate> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndanceDate>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }







    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

    @Override
    public List<AttEndanceDate> getAttendancedateByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEndanceDate> getAttendancedateByEntities(List<AttEndanceDate> entities) {
        List ids =new ArrayList();
        for(AttEndanceDate entity : entities){
            Serializable id=entity.getAttendancedateid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



