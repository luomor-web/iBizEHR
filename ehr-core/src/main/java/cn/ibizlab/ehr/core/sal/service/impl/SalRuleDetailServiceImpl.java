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
import cn.ibizlab.ehr.core.sal.domain.SalRuleDetail;
import cn.ibizlab.ehr.core.sal.filter.SalRuleDetailSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISalRuleDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SalRuleDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬规则明细] 服务对象接口实现
 */
@Slf4j
@Service("SalRuleDetailServiceImpl")
public class SalRuleDetailServiceImpl extends ServiceImpl<SalRuleDetailMapper, SalRuleDetail> implements ISalRuleDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalParamService salparamService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalRuleService salruleService;

    private int batchSize = 500;

    @Override
    @Transactional
    public SalRuleDetail get(String key) {
        SalRuleDetail et = getById(key);
        if(et==null){
            et=new SalRuleDetail();
            et.setSalruledetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(SalRuleDetail et) {
        return (!ObjectUtils.isEmpty(et.getSalruledetailid()))&&(!Objects.isNull(this.getById(et.getSalruledetailid())));
    }
    @Override
    @Transactional
    public boolean update(SalRuleDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salruledetailid",et.getSalruledetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalruledetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SalRuleDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SalRuleDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SalRuleDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SalRuleDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SalRuleDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SalRuleDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalruledetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SalRuleDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public SalRuleDetail getDraft(SalRuleDetail et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<SalRuleDetail> selectBySalparamid(String salparamid) {
        return baseMapper.selectBySalparamid(salparamid);
    }

    @Override
    public void removeBySalparamid(String salparamid) {
        this.remove(new QueryWrapper<SalRuleDetail>().eq("salparamid",salparamid));
    }

	@Override
    public List<SalRuleDetail> selectBySalparamid2(String salparamid) {
        return baseMapper.selectBySalparamid2(salparamid);
    }

    @Override
    public void removeBySalparamid2(String salparamid) {
        this.remove(new QueryWrapper<SalRuleDetail>().eq("salparamid2",salparamid));
    }

	@Override
    public List<SalRuleDetail> selectBySalruleid(String salruleid) {
        return baseMapper.selectBySalruleid(salruleid);
    }

    @Override
    public void removeBySalruleid(String salruleid) {
        this.remove(new QueryWrapper<SalRuleDetail>().eq("salruleid",salruleid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SalRuleDetail> searchDefault(SalRuleDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SalRuleDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SalRuleDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SalRuleDetail et){
        //实体关系[DER1N_SALRULEDETAIL_SALPARAM_SALPARAMID]
        if(!ObjectUtils.isEmpty(et.getSalparamid())){
            cn.ibizlab.ehr.core.sal.domain.SalParam salparam=et.getSalparam();
            if(ObjectUtils.isEmpty(salparam)){
                cn.ibizlab.ehr.core.sal.domain.SalParam majorEntity=salparamService.get(et.getSalparamid());
                et.setSalparam(majorEntity);
                salparam=majorEntity;
            }
            et.setSalparamname(salparam.getSalparamname());
        }
        //实体关系[DER1N_SALRULEDETAIL_SALPARAM_SALPARAMID2]
        if(!ObjectUtils.isEmpty(et.getSalparamid2())){
            cn.ibizlab.ehr.core.sal.domain.SalParam salparam2=et.getSalparam2();
            if(ObjectUtils.isEmpty(salparam2)){
                cn.ibizlab.ehr.core.sal.domain.SalParam majorEntity=salparamService.get(et.getSalparamid2());
                et.setSalparam2(majorEntity);
                salparam2=majorEntity;
            }
            et.setSalparamname2(salparam2.getSalparamname());
        }
        //实体关系[DER1N_SALRULEDETAIL_SALRULE_SALRULEID]
        if(!ObjectUtils.isEmpty(et.getSalruleid())){
            cn.ibizlab.ehr.core.sal.domain.SalRule salrule=et.getSalrule();
            if(ObjectUtils.isEmpty(salrule)){
                cn.ibizlab.ehr.core.sal.domain.SalRule majorEntity=salruleService.get(et.getSalruleid());
                et.setSalrule(majorEntity);
                salrule=majorEntity;
            }
            et.setSalrulename(salrule.getSalrulename());
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
    public List<SalRuleDetail> getSalruledetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SalRuleDetail> getSalruledetailByEntities(List<SalRuleDetail> entities) {
        List ids =new ArrayList();
        for(SalRuleDetail entity : entities){
            Serializable id=entity.getSalruledetailid();
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



