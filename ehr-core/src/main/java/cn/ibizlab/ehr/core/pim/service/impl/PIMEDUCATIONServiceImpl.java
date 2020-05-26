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
import cn.ibizlab.ehr.core.pim.domain.PIMEDUCATION;
import cn.ibizlab.ehr.core.pim.filter.PIMEDUCATIONSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMEDUCATIONService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMEDUCATIONMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[教育信息] 服务对象接口实现
 */
@Slf4j
@Service("PIMEDUCATIONServiceImpl")
public class PIMEDUCATIONServiceImpl extends ServiceImpl<PIMEDUCATIONMapper, PIMEDUCATION> implements IPIMEDUCATIONService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PIMEDUCATION checkHighestEdu(PIMEDUCATION et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMEDUCATION get(String key) {
        PIMEDUCATION et = getById(key);
        if(et==null){
            et=new PIMEDUCATION();
            et.setPimeducationid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMEDUCATION et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMEDUCATION et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMEDUCATION> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMEDUCATION> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMEDUCATION et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimeducationid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMEDUCATION> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PIMEDUCATION getDraft(PIMEDUCATION et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PIMEDUCATION et) {
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
    public boolean update(PIMEDUCATION et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimeducationid",et.getPimeducationid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimeducationid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMEDUCATION> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<PIMEDUCATION> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMEDUCATION>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 教育信息（非A转正专用）
     */
    @Override
    public Page<PIMEDUCATION> searchFAZZSY(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEDUCATION> pages=baseMapper.searchFAZZSY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEDUCATION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PIMEDUCATION> searchJLSS(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEDUCATION> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEDUCATION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(教育信息)
     */
    @Override
    public Page<PIMEDUCATION> searchZIZHU(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEDUCATION> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEDUCATION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 第一学历和最高学历（管理员）
     */
    @Override
    public Page<PIMEDUCATION> searchADMDYZG(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEDUCATION> pages=baseMapper.searchADMDYZG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEDUCATION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PIMEDUCATION> searchPERSONAL(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEDUCATION> pages=baseMapper.searchPERSONAL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEDUCATION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PIMEDUCATION> searchADMSYSTEM(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEDUCATION> pages=baseMapper.searchADMSYSTEM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEDUCATION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMEDUCATION> searchDefault(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEDUCATION> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEDUCATION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 图表_学历分布统计
     */
    @Override
    public Page<HashMap> searchREP_EDU(PIMEDUCATIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_EDU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMEDUCATION et){
        //实体关系[DER1N_PIMEDUCATION_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


