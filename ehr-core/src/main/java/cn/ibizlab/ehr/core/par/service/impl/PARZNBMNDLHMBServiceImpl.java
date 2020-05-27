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
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMB;
import cn.ibizlab.ehr.core.par.filter.PARZNBMNDLHMBSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARZNBMNDLHMBMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标（职能部门级）] 服务对象接口实现
 */
@Slf4j
@Service("PARZNBMNDLHMBServiceImpl")
public class PARZNBMNDLHMBServiceImpl extends ServiceImpl<PARZNBMNDLHMBMapper, PARZNBMNDLHMB> implements IPARZNBMNDLHMBService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBMXService parznbmndlhmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PARZNBMNDLHMB et) {
        return (!ObjectUtils.isEmpty(et.getParznbmndlhmbid()))&&(!Objects.isNull(this.getById(et.getParznbmndlhmbid())));
    }

    @Override
    @Transactional
    public boolean save(PARZNBMNDLHMB et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARZNBMNDLHMB et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARZNBMNDLHMB> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARZNBMNDLHMB> list) {
        list.forEach(item->fillParentData(item));
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
    public boolean update(PARZNBMNDLHMB et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parznbmndlhmbid",et.getParznbmndlhmbid())))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARZNBMNDLHMB> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PARZNBMNDLHMB getDraft(PARZNBMNDLHMB et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PARZNBMNDLHMB get(String key) {
        PARZNBMNDLHMB et = getById(key);
        if(et==null){
            et=new PARZNBMNDLHMB();
            et.setParznbmndlhmbid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARZNBMNDLHMB et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARZNBMNDLHMB> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PARZNBMNDLHMB> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PARZNBMNDLHMB>().eq("ormorgsectorid",orgsectorid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARZNBMNDLHMB> searchDefault(PARZNBMNDLHMBSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARZNBMNDLHMB> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARZNBMNDLHMB>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARZNBMNDLHMB et){
        //实体关系[DER1N_PARZNBMNDLHMB_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
            et.setSsorg(ormorgsector.getOrgname());
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
    public List<PARZNBMNDLHMB> getParznbmndlhmbByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PARZNBMNDLHMB> getParznbmndlhmbByEntities(List<PARZNBMNDLHMB> entities) {
        List ids =new ArrayList();
        for(PARZNBMNDLHMB entity : entities){
            Serializable id=entity.getParznbmndlhmbid();
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


