package cn.ibizlab.ehr.core.wf.service.impl;

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
import cn.ibizlab.ehr.core.wf.domain.WFUIWizard;
import cn.ibizlab.ehr.core.wf.filter.WFUIWizardSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFUIWizardService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFUIWizardMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流操作界面] 服务对象接口实现
 */
@Slf4j
@Service("WFUIWizardServiceImpl")
public class WFUIWizardServiceImpl extends ServiceImpl<WFUIWizardMapper, WFUIWizard> implements IWFUIWizardService {


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
    @Transactional
    public boolean update(WFUIWizard et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfuiwizardid",et.getWfuiwizardid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfuiwizardid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFUIWizard> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(WFUIWizard et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFUIWizard et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFUIWizard> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public WFUIWizard getDraft(WFUIWizard et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(WFUIWizard et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfuiwizardid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFUIWizard> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(WFUIWizard et) {
        return (!ObjectUtils.isEmpty(et.getWfuiwizardid()))&&(!Objects.isNull(this.getById(et.getWfuiwizardid())));
    }

    @Override
    @Transactional
    public WFUIWizard get(String key) {
        WFUIWizard et = getById(key);
        if(et==null){
            et=new WFUIWizard();
            et.setWfuiwizardid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUIWizard> searchDefault(WFUIWizardSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFUIWizard> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFUIWizard>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


