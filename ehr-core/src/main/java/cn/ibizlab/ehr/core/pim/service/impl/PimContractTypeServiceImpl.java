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
import cn.ibizlab.ehr.core.pim.domain.PimContractType;
import cn.ibizlab.ehr.core.pim.filter.PimContractTypeSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimContractTypeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimContractTypeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[合同类别] 服务对象接口实现
 */
@Slf4j
@Service("PimContractTypeServiceImpl")
public class PimContractTypeServiceImpl extends ServiceImpl<PimContractTypeMapper, PimContractType> implements IPimContractTypeService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PimContractType et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimcontracttypeid",et.getPimcontracttypeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimcontracttypeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimContractType> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimContractType et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimContractType et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimContractType> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimContractType> list) {
        saveOrUpdateBatch(list,batchSize);
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
    public boolean create(PimContractType et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimcontracttypeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimContractType> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimContractType get(String key) {
        PimContractType et = getById(key);
        if(et==null){
            et=new PimContractType();
            et.setPimcontracttypeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PimContractType getDraft(PimContractType et) {
        return et;
    }

    @Override
    public boolean checkKey(PimContractType et) {
        return (!ObjectUtils.isEmpty(et.getPimcontracttypeid()))&&(!Objects.isNull(this.getById(et.getPimcontracttypeid())));
    }

	@Override
    public List<PimContractType> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimContractType>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimContractType> searchDefault(PimContractTypeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContractType> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContractType>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimContractType> getPimcontracttypeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimContractType> getPimcontracttypeByEntities(List<PimContractType> entities) {
        List ids =new ArrayList();
        for(PimContractType entity : entities){
            Serializable id=entity.getPimcontracttypeid();
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



