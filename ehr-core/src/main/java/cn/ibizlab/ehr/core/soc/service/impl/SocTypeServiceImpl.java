package cn.ibizlab.ehr.core.soc.service.impl;

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
import cn.ibizlab.ehr.core.soc.domain.SocType;
import cn.ibizlab.ehr.core.soc.filter.SocTypeSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISocTypeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SocTypeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[保险类型] 服务对象接口实现
 */
@Slf4j
@Service("SocTypeServiceImpl")
public class SocTypeServiceImpl extends ServiceImpl<SocTypeMapper, SocType> implements ISocTypeService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocRuleDetailService socruledetailService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SocType et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSoctypeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SocType> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SocType et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("soctypeid",et.getSoctypeid())))
            return false;
        CachedBeanCopier.copy(get(et.getSoctypeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SocType> list) {
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

    @Override
    @Transactional
    public boolean save(SocType et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SocType et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SocType> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SocType> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public SocType getDraft(SocType et) {
        return et;
    }

    @Override
    @Transactional
    public SocType get(String key) {
        SocType et = getById(key);
        if(et==null){
            et=new SocType();
            et.setSoctypeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(SocType et) {
        return (!ObjectUtils.isEmpty(et.getSoctypeid()))&&(!Objects.isNull(this.getById(et.getSoctypeid())));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SocType> searchDefault(SocTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SocType> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SocType>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<SocType> getSoctypeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SocType> getSoctypeByEntities(List<SocType> entities) {
        List ids =new ArrayList();
        for(SocType entity : entities){
            Serializable id=entity.getSoctypeid();
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



