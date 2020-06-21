package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.ParPtryndlhmbmx;
import cn.ibizlab.ehr.core.par.filter.ParPtryndlhmbmxSearchContext;
import cn.ibizlab.ehr.core.par.service.IParPtryndlhmbmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParPtryndlhmbmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标明细（部门副职及以下人员）] 服务对象接口实现
 */
@Slf4j
@Service("ParPtryndlhmbmxServiceImpl")
public class ParPtryndlhmbmxServiceImpl extends ServiceImpl<ParPtryndlhmbmxMapper, ParPtryndlhmbmx> implements IParPtryndlhmbmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParPtryndlhmbService parptryndlhmbService;

    private int batchSize = 500;

    @Override
    public ParPtryndlhmbmx getDraft(ParPtryndlhmbmx et) {
        fillParentData(et);
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
    public boolean checkKey(ParPtryndlhmbmx et) {
        return (!ObjectUtils.isEmpty(et.getParptryndlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParptryndlhmbmxid())));
    }
    @Override
    @Transactional
    public ParPtryndlhmbmx get(String key) {
        ParPtryndlhmbmx et = getById(key);
        if(et==null){
            et=new ParPtryndlhmbmx();
            et.setParptryndlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(ParPtryndlhmbmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParPtryndlhmbmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParPtryndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParPtryndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ParPtryndlhmbmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parptryndlhmbmxid",et.getParptryndlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParptryndlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParPtryndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ParPtryndlhmbmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParptryndlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParPtryndlhmbmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<ParPtryndlhmbmx> selectByParptryndlhmbid(String parptryndlhmbid) {
        return baseMapper.selectByParptryndlhmbid(parptryndlhmbid);
    }

    @Override
    public void removeByParptryndlhmbid(String parptryndlhmbid) {
        this.remove(new QueryWrapper<ParPtryndlhmbmx>().eq("parptryndlhmbid",parptryndlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParPtryndlhmbmx> searchDefault(ParPtryndlhmbmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParPtryndlhmbmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParPtryndlhmbmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParPtryndlhmbmx et){
        //实体关系[DER1N_PARPTRYNDLHMBMX_PARPTRYNDLHMB_PARPTRYNDLHMBID]
        if(!ObjectUtils.isEmpty(et.getParptryndlhmbid())){
            cn.ibizlab.ehr.core.par.domain.ParPtryndlhmb parptryndlhmb=et.getParptryndlhmb();
            if(ObjectUtils.isEmpty(parptryndlhmb)){
                cn.ibizlab.ehr.core.par.domain.ParPtryndlhmb majorEntity=parptryndlhmbService.get(et.getParptryndlhmbid());
                et.setParptryndlhmb(majorEntity);
                parptryndlhmb=majorEntity;
            }
            et.setParptryndlhmbname(parptryndlhmb.getParptryndlhmbname());
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
    public List<ParPtryndlhmbmx> getParptryndlhmbmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParPtryndlhmbmx> getParptryndlhmbmxByEntities(List<ParPtryndlhmbmx> entities) {
        List ids =new ArrayList();
        for(ParPtryndlhmbmx entity : entities){
            Serializable id=entity.getParptryndlhmbmxid();
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



