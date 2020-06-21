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
import cn.ibizlab.ehr.core.sal.domain.SalRule;
import cn.ibizlab.ehr.core.sal.filter.SalRuleSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISalRuleService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SalRuleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬规则] 服务对象接口实现
 */
@Slf4j
@Service("SalRuleServiceImpl")
public class SalRuleServiceImpl extends ServiceImpl<SalRuleMapper, SalRule> implements ISalRuleService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalRuleDetailService salruledetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService salschemeitemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalParamService salparamService;

    private int batchSize = 500;

    @Override
    public SalRule getDraft(SalRule et) {
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
    public SalRule get(String key) {
        SalRule et = getById(key);
        if(et==null){
            et=new SalRule();
            et.setSalruleid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(SalRule et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalruleid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SalRule> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SalRule et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salruleid",et.getSalruleid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalruleid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SalRule> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SalRule et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SalRule et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SalRule> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SalRule> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SalRule et) {
        return (!ObjectUtils.isEmpty(et.getSalruleid()))&&(!Objects.isNull(this.getById(et.getSalruleid())));
    }

	@Override
    public List<SalRule> selectBySalparamid(String salparamid) {
        return baseMapper.selectBySalparamid(salparamid);
    }

    @Override
    public void removeBySalparamid(String salparamid) {
        this.remove(new QueryWrapper<SalRule>().eq("salparamid",salparamid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SalRule> searchDefault(SalRuleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SalRule> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SalRule>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SalRule et){
        //实体关系[DER1N_SALRULE_SALPARAM_SALPARAMID]
        if(!ObjectUtils.isEmpty(et.getSalparamid())){
            cn.ibizlab.ehr.core.sal.domain.SalParam salparam=et.getSalparam();
            if(ObjectUtils.isEmpty(salparam)){
                cn.ibizlab.ehr.core.sal.domain.SalParam majorEntity=salparamService.get(et.getSalparamid());
                et.setSalparam(majorEntity);
                salparam=majorEntity;
            }
            et.setSalparamname(salparam.getSalparamname());
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
    public List<SalRule> getSalruleByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SalRule> getSalruleByEntities(List<SalRule> entities) {
        List ids =new ArrayList();
        for(SalRule entity : entities){
            Serializable id=entity.getSalruleid();
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



