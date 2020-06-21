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
import cn.ibizlab.ehr.core.pim.domain.PimEducation;
import cn.ibizlab.ehr.core.pim.filter.PimEducationSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimEducationService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimEducationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[教育信息] 服务对象接口实现
 */
@Slf4j
@Service("PimEducationServiceImpl")
public class PimEducationServiceImpl extends ServiceImpl<PimEducationMapper, PimEducation> implements IPimEducationService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PimEducation checkHighestEdu(PimEducation et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimEducation get(String key) {
        PimEducation et = getById(key);
        if(et==null){
            et=new PimEducation();
            et.setPimeducationid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimEducation et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimEducation et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimEducation> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimEducation> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimEducation et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimeducationid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimEducation> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PimEducation getDraft(PimEducation et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PimEducation et) {
        return (!ObjectUtils.isEmpty(et.getPimeducationid()))&&(!Objects.isNull(this.getById(et.getPimeducationid())));
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
    public boolean update(PimEducation et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimeducationid",et.getPimeducationid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimeducationid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimEducation> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<PimEducation> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimEducation>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 教育信息（非A转正专用）
     */
    @Override
    public Page<PimEducation> searchFAZZSY(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimEducation> pages=baseMapper.searchFAZZSY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimEducation>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PimEducation> searchJLSS(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimEducation> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimEducation>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(教育信息)
     */
    @Override
    public Page<PimEducation> searchZIZHU(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimEducation> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimEducation>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 第一学历和最高学历（管理员）
     */
    @Override
    public Page<PimEducation> searchADMDYZG(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimEducation> pages=baseMapper.searchADMDYZG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimEducation>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PimEducation> searchPERSONAL(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimEducation> pages=baseMapper.searchPERSONAL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimEducation>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PimEducation> searchADMSYSTEM(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimEducation> pages=baseMapper.searchADMSYSTEM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimEducation>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimEducation> searchDefault(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimEducation> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimEducation>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 图表_学历分布统计
     */
    @Override
    public Page<HashMap> searchREP_EDU(PimEducationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_EDU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimEducation et){
        //实体关系[DER1N_PIMEDUCATION_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
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
    public List<PimEducation> getPimeducationByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimEducation> getPimeducationByEntities(List<PimEducation> entities) {
        List ids =new ArrayList();
        for(PimEducation entity : entities){
            Serializable id=entity.getPimeducationid();
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



