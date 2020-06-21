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
import cn.ibizlab.ehr.core.pim.domain.PimSocialSecurity;
import cn.ibizlab.ehr.core.pim.filter.PimSocialSecuritySearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimSocialSecurityService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimSocialSecurityMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[社保信息] 服务对象接口实现
 */
@Slf4j
@Service("PimSocialSecurityServiceImpl")
public class PimSocialSecurityServiceImpl extends ServiceImpl<PimSocialSecurityMapper, PimSocialSecurity> implements IPimSocialSecurityService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

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
    public boolean checkKey(PimSocialSecurity et) {
        return (!ObjectUtils.isEmpty(et.getPimsocialsecurityid()))&&(!Objects.isNull(this.getById(et.getPimsocialsecurityid())));
    }
    @Override
    @Transactional
    public PimSocialSecurity get(String key) {
        PimSocialSecurity et = getById(key);
        if(et==null){
            et=new PimSocialSecurity();
            et.setPimsocialsecurityid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PimSocialSecurity getDraft(PimSocialSecurity et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimSocialSecurity et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimsocialsecurityid",et.getPimsocialsecurityid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimsocialsecurityid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimSocialSecurity> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimSocialSecurity et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimsocialsecurityid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimSocialSecurity> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimSocialSecurity et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimSocialSecurity et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimSocialSecurity> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimSocialSecurity> list) {
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PimSocialSecurity> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimSocialSecurity>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 自助(社保信息)
     */
    @Override
    public Page<PimSocialSecurity> searchZIZHU(PimSocialSecuritySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimSocialSecurity> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimSocialSecurity>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimSocialSecurity> searchDefault(PimSocialSecuritySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimSocialSecurity> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimSocialSecurity>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PimSocialSecurity> searchJLSS(PimSocialSecuritySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimSocialSecurity> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimSocialSecurity>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimSocialSecurity> getPimsocialsecurityByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimSocialSecurity> getPimsocialsecurityByEntities(List<PimSocialSecurity> entities) {
        List ids =new ArrayList();
        for(PimSocialSecurity entity : entities){
            Serializable id=entity.getPimsocialsecurityid();
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



