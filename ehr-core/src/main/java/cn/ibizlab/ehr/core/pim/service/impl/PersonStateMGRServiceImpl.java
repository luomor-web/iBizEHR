package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PersonStateMGR;
import cn.ibizlab.ehr.core.pim.filter.PersonStateMGRSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPersonStateMGRService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PersonStateMGRMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工状态管理] 服务对象接口实现
 */
@Slf4j
@Service("PersonStateMGRServiceImpl")
public class PersonStateMGRServiceImpl extends ServiceImpl<PersonStateMGRMapper, PersonStateMGR> implements IPersonStateMGRService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PersonStateMGR et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PersonStateMGR et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PersonStateMGR> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PersonStateMGR et) {
        return (!ObjectUtils.isEmpty(et.getPersonstatemgrid()))&&(!Objects.isNull(this.getById(et.getPersonstatemgrid())));
    }

    @Override
    public PersonStateMGR getDraft(PersonStateMGR et) {
        return et;
    }

    @Override
    @Transactional
    public PersonStateMGR get(String key) {
        PersonStateMGR et = getById(key);
        if(et==null){
            et=new PersonStateMGR();
            et.setPersonstatemgrid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PersonStateMGR et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPersonstatemgrid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PersonStateMGR> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PersonStateMGR et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("personstatemgrid",et.getPersonstatemgrid())))
            return false;
        CachedBeanCopier.copy(get(et.getPersonstatemgrid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PersonStateMGR> list) {
        updateBatchById(list,batchSize);
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



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PersonStateMGR> searchDefault(PersonStateMGRSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PersonStateMGR> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PersonStateMGR>(pages.getRecords(), context.getPageable(), pages.getTotal());
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

}


