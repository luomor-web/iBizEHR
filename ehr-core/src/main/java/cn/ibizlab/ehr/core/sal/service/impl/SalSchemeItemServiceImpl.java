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
import cn.ibizlab.ehr.core.sal.domain.SalSchemeItem;
import cn.ibizlab.ehr.core.sal.filter.SalSchemeItemSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SalSchemeItemMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工资单要素项] 服务对象接口实现
 */
@Slf4j
@Service("SalSchemeItemServiceImpl")
public class SalSchemeItemServiceImpl extends ServiceImpl<SalSchemeItemMapper, SalSchemeItem> implements ISalSchemeItemService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDDETAILService salpersonstddetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryDetailService salsalarydetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalItemService salitemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalRuleService salruleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSchemeService salschemeService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(SalSchemeItem et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salschemeitemid",et.getSalschemeitemid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalschemeitemid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SalSchemeItem> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SalSchemeItem et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SalSchemeItem et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SalSchemeItem> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SalSchemeItem> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public SalSchemeItem get(String key) {
        SalSchemeItem et = getById(key);
        if(et==null){
            et=new SalSchemeItem();
            et.setSalschemeitemid(key);
        }
        else{
        }
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
    public boolean checkKey(SalSchemeItem et) {
        return (!ObjectUtils.isEmpty(et.getSalschemeitemid()))&&(!Objects.isNull(this.getById(et.getSalschemeitemid())));
    }
    @Override
    @Transactional
    public boolean create(SalSchemeItem et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalschemeitemid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SalSchemeItem> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public SalSchemeItem getDraft(SalSchemeItem et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<SalSchemeItem> selectBySalitemid(String salitemid) {
        return baseMapper.selectBySalitemid(salitemid);
    }

    @Override
    public void removeBySalitemid(String salitemid) {
        this.remove(new QueryWrapper<SalSchemeItem>().eq("salitemid",salitemid));
    }

	@Override
    public List<SalSchemeItem> selectBySalruleid(String salruleid) {
        return baseMapper.selectBySalruleid(salruleid);
    }

    @Override
    public void removeBySalruleid(String salruleid) {
        this.remove(new QueryWrapper<SalSchemeItem>().eq("salruleid",salruleid));
    }

	@Override
    public List<SalSchemeItem> selectBySalschemeid(String salschemeid) {
        return baseMapper.selectBySalschemeid(salschemeid);
    }

    @Override
    public void removeBySalschemeid(String salschemeid) {
        this.remove(new QueryWrapper<SalSchemeItem>().eq("salschemeid",salschemeid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SalSchemeItem> searchDefault(SalSchemeItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SalSchemeItem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SalSchemeItem>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SalSchemeItem et){
        //实体关系[DER1N_SALSCHEMEITEM_SALITEM_SALITEMID]
        if(!ObjectUtils.isEmpty(et.getSalitemid())){
            cn.ibizlab.ehr.core.sal.domain.SalItem salitem=et.getSalitem();
            if(ObjectUtils.isEmpty(salitem)){
                cn.ibizlab.ehr.core.sal.domain.SalItem majorEntity=salitemService.get(et.getSalitemid());
                et.setSalitem(majorEntity);
                salitem=majorEntity;
            }
            et.setSalitemname(salitem.getSalitemname());
            et.setXh2(salitem.getXh());
        }
        //实体关系[DER1N_SALSCHEMEITEM_SALRULE_SALRULEID]
        if(!ObjectUtils.isEmpty(et.getSalruleid())){
            cn.ibizlab.ehr.core.sal.domain.SalRule salrule=et.getSalrule();
            if(ObjectUtils.isEmpty(salrule)){
                cn.ibizlab.ehr.core.sal.domain.SalRule majorEntity=salruleService.get(et.getSalruleid());
                et.setSalrule(majorEntity);
                salrule=majorEntity;
            }
            et.setSalrulename(salrule.getSalrulename());
        }
        //实体关系[DER1N_SALSCHEMEITEM_SALSCHEME_SALSCHEMEID]
        if(!ObjectUtils.isEmpty(et.getSalschemeid())){
            cn.ibizlab.ehr.core.sal.domain.SalScheme salscheme=et.getSalscheme();
            if(ObjectUtils.isEmpty(salscheme)){
                cn.ibizlab.ehr.core.sal.domain.SalScheme majorEntity=salschemeService.get(et.getSalschemeid());
                et.setSalscheme(majorEntity);
                salscheme=majorEntity;
            }
            et.setSalschemename(salscheme.getSalschemename());
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
    public List<SalSchemeItem> getSalschemeitemByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SalSchemeItem> getSalschemeitemByEntities(List<SalSchemeItem> entities) {
        List ids =new ArrayList();
        for(SalSchemeItem entity : entities){
            Serializable id=entity.getSalschemeitemid();
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



