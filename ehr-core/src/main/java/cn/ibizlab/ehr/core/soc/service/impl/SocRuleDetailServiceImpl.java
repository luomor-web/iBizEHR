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
import cn.ibizlab.ehr.core.soc.domain.SocRuleDetail;
import cn.ibizlab.ehr.core.soc.filter.SocRuleDetailSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISocRuleDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SocRuleDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[社保规则明细] 服务对象接口实现
 */
@Slf4j
@Service("SocRuleDetailServiceImpl")
public class SocRuleDetailServiceImpl extends ServiceImpl<SocRuleDetailMapper, SocRuleDetail> implements ISocRuleDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocArchivesDetailService socarchivesdetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocRuleService socruleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocTypeService soctypeService;

    private int batchSize = 500;

    @Override
    public SocRuleDetail getDraft(SocRuleDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(SocRuleDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("socruledetailid",et.getSocruledetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getSocruledetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SocRuleDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public SocRuleDetail get(String key) {
        SocRuleDetail et = getById(key);
        if(et==null){
            et=new SocRuleDetail();
            et.setSocruledetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(SocRuleDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSocruledetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SocRuleDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SocRuleDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SocRuleDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SocRuleDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SocRuleDetail> list) {
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
    public boolean checkKey(SocRuleDetail et) {
        return (!ObjectUtils.isEmpty(et.getSocruledetailid()))&&(!Objects.isNull(this.getById(et.getSocruledetailid())));
    }

	@Override
    public List<SocRuleDetail> selectBySocruleid(String socruleid) {
        return baseMapper.selectBySocruleid(socruleid);
    }

    @Override
    public void removeBySocruleid(String socruleid) {
        this.remove(new QueryWrapper<SocRuleDetail>().eq("socruleid",socruleid));
    }

	@Override
    public List<SocRuleDetail> selectBySoctypeid(String soctypeid) {
        return baseMapper.selectBySoctypeid(soctypeid);
    }

    @Override
    public void removeBySoctypeid(String soctypeid) {
        this.remove(new QueryWrapper<SocRuleDetail>().eq("soctypeid",soctypeid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SocRuleDetail> searchDefault(SocRuleDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SocRuleDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SocRuleDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SocRuleDetail et){
        //实体关系[DER1N_SOCRULEDETAIL_SOCRULE_SOCRULEID]
        if(!ObjectUtils.isEmpty(et.getSocruleid())){
            cn.ibizlab.ehr.core.soc.domain.SocRule socrule=et.getSocrule();
            if(ObjectUtils.isEmpty(socrule)){
                cn.ibizlab.ehr.core.soc.domain.SocRule majorEntity=socruleService.get(et.getSocruleid());
                et.setSocrule(majorEntity);
                socrule=majorEntity;
            }
            et.setSocrulename(socrule.getSocrulename());
        }
        //实体关系[DER1N_SOCRULEDETAIL_SOCTYPE_SOCTYPEID]
        if(!ObjectUtils.isEmpty(et.getSoctypeid())){
            cn.ibizlab.ehr.core.soc.domain.SocType soctype=et.getSoctype();
            if(ObjectUtils.isEmpty(soctype)){
                cn.ibizlab.ehr.core.soc.domain.SocType majorEntity=soctypeService.get(et.getSoctypeid());
                et.setSoctype(majorEntity);
                soctype=majorEntity;
            }
            et.setSoctypename(soctype.getSoctypename());
            et.setOrdervalue(soctype.getOrdervalue());
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
    public List<SocRuleDetail> getSocruledetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SocRuleDetail> getSocruledetailByEntities(List<SocRuleDetail> entities) {
        List ids =new ArrayList();
        for(SocRuleDetail entity : entities){
            Serializable id=entity.getSocruledetailid();
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



