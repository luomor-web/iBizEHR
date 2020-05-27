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
import cn.ibizlab.ehr.core.pim.domain.PIMACHIEVEMENTS;
import cn.ibizlab.ehr.core.pim.filter.PIMACHIEVEMENTSSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMACHIEVEMENTSService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMACHIEVEMENTSMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效信息] 服务对象接口实现
 */
@Slf4j
@Service("PIMACHIEVEMENTSServiceImpl")
public class PIMACHIEVEMENTSServiceImpl extends ServiceImpl<PIMACHIEVEMENTSMapper, PIMACHIEVEMENTS> implements IPIMACHIEVEMENTSService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PIMACHIEVEMENTS et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimachievementsid",et.getPimachievementsid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimachievementsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMACHIEVEMENTS> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PIMACHIEVEMENTS et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMACHIEVEMENTS et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMACHIEVEMENTS> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMACHIEVEMENTS> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PIMACHIEVEMENTS getDraft(PIMACHIEVEMENTS et) {
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
    @Transactional
    public PIMACHIEVEMENTS get(String key) {
        PIMACHIEVEMENTS et = getById(key);
        if(et==null){
            et=new PIMACHIEVEMENTS();
            et.setPimachievementsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PIMACHIEVEMENTS et) {
        return (!ObjectUtils.isEmpty(et.getPimachievementsid()))&&(!Objects.isNull(this.getById(et.getPimachievementsid())));
    }

    @Override
    @Transactional
    public boolean create(PIMACHIEVEMENTS et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimachievementsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMACHIEVEMENTS> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PIMACHIEVEMENTS> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMACHIEVEMENTS>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 记录所属和人员ID不符的
     */
    @Override
    public Page<PIMACHIEVEMENTS> searchJLSS(PIMACHIEVEMENTSSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMACHIEVEMENTS> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMACHIEVEMENTS>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMACHIEVEMENTS> searchDefault(PIMACHIEVEMENTSSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMACHIEVEMENTS> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMACHIEVEMENTS>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(绩效信息)
     */
    @Override
    public Page<PIMACHIEVEMENTS> searchZIZHU(PIMACHIEVEMENTSSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMACHIEVEMENTS> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMACHIEVEMENTS>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMACHIEVEMENTS et){
        //实体关系[DER1N_PIMACHIEVEMENTS_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
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
    public List<PIMACHIEVEMENTS> getPimachievementsByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PIMACHIEVEMENTS> getPimachievementsByEntities(List<PIMACHIEVEMENTS> entities) {
        List ids =new ArrayList();
        for(PIMACHIEVEMENTS entity : entities){
            Serializable id=entity.getPimachievementsid();
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


