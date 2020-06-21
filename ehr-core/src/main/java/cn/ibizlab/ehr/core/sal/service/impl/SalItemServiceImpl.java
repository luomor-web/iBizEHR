package cn.ibizlab.ehr.core.sal.service.impl;

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
import cn.ibizlab.ehr.core.sal.domain.SalItem;
import cn.ibizlab.ehr.core.sal.filter.SalItemSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISalItemService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SalItemMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬要素项] 服务对象接口实现
 */
@Slf4j
@Service("SalItemServiceImpl")
public class SalItemServiceImpl extends ServiceImpl<SalItemMapper, SalItem> implements ISalItemService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalItemSubService salitemsubService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService salschemeitemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSubjectService salsubjectService;

    private int batchSize = 500;

    @Override
    @Transactional
    public SalItem get(String key) {
        SalItem et = getById(key);
        if(et==null){
            et=new SalItem();
            et.setSalitemid(key);
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
    public boolean save(SalItem et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SalItem et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SalItem> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SalItem> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public SalItem getDraft(SalItem et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SalItem et) {
        return (!ObjectUtils.isEmpty(et.getSalitemid()))&&(!Objects.isNull(this.getById(et.getSalitemid())));
    }
    @Override
    @Transactional
    public boolean update(SalItem et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salitemid",et.getSalitemid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalitemid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SalItem> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SalItem et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalitemid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SalItem> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<SalItem> selectBySalsubjectid(String salsubjectid) {
        return baseMapper.selectBySalsubjectid(salsubjectid);
    }

    @Override
    public void removeBySalsubjectid(String salsubjectid) {
        this.remove(new QueryWrapper<SalItem>().eq("salsubjectid",salsubjectid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SalItem> searchDefault(SalItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SalItem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SalItem>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SalItem et){
        //实体关系[DER1N_SALITEM_SALSUBJECT_SALSUBJECTID]
        if(!ObjectUtils.isEmpty(et.getSalsubjectid())){
            cn.ibizlab.ehr.core.sal.domain.SalSubject salsubject=et.getSalsubject();
            if(ObjectUtils.isEmpty(salsubject)){
                cn.ibizlab.ehr.core.sal.domain.SalSubject majorEntity=salsubjectService.get(et.getSalsubjectid());
                et.setSalsubject(majorEntity);
                salsubject=majorEntity;
            }
            et.setSalsubjectname(salsubject.getSalsubjectname());
        }
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
    public List<SalItem> getSalitemByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SalItem> getSalitemByEntities(List<SalItem> entities) {
        List ids =new ArrayList();
        for(SalItem entity : entities){
            Serializable id=entity.getSalitemid();
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



