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
import cn.ibizlab.ehr.core.sal.domain.SALSCHEMEITEM;
import cn.ibizlab.ehr.core.sal.filter.SALSCHEMEITEMSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALSCHEMEITEMService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALSCHEMEITEMMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工资单要素项] 服务对象接口实现
 */
@Slf4j
@Service("SALSCHEMEITEMServiceImpl")
public class SALSCHEMEITEMServiceImpl extends ServiceImpl<SALSCHEMEITEMMapper, SALSCHEMEITEM> implements ISALSCHEMEITEMService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDDETAILService salpersonstddetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYDETAILService salsalarydetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALITEMService salitemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALRULEService salruleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSCHEMEService salschemeService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(SALSCHEMEITEM et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salschemeitemid",et.getSalschemeitemid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalschemeitemid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALSCHEMEITEM> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SALSCHEMEITEM et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALSCHEMEITEM et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<SALSCHEMEITEM> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public SALSCHEMEITEM get(String key) {
        SALSCHEMEITEM et = getById(key);
        if(et==null){
            et=new SALSCHEMEITEM();
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
    public boolean checkKey(SALSCHEMEITEM et) {
        return (!ObjectUtils.isEmpty(et.getSalschemeitemid()))&&(!Objects.isNull(this.getById(et.getSalschemeitemid())));
    }

    @Override
    @Transactional
    public boolean create(SALSCHEMEITEM et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalschemeitemid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALSCHEMEITEM> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public SALSCHEMEITEM getDraft(SALSCHEMEITEM et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<SALSCHEMEITEM> selectBySalitemid(String salitemid) {
        return baseMapper.selectBySalitemid(salitemid);
    }

    @Override
    public void removeBySalitemid(String salitemid) {
        this.remove(new QueryWrapper<SALSCHEMEITEM>().eq("salitemid",salitemid));
    }

	@Override
    public List<SALSCHEMEITEM> selectBySalruleid(String salruleid) {
        return baseMapper.selectBySalruleid(salruleid);
    }

    @Override
    public void removeBySalruleid(String salruleid) {
        this.remove(new QueryWrapper<SALSCHEMEITEM>().eq("salruleid",salruleid));
    }

	@Override
    public List<SALSCHEMEITEM> selectBySalschemeid(String salschemeid) {
        return baseMapper.selectBySalschemeid(salschemeid);
    }

    @Override
    public void removeBySalschemeid(String salschemeid) {
        this.remove(new QueryWrapper<SALSCHEMEITEM>().eq("salschemeid",salschemeid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALSCHEMEITEM> searchDefault(SALSCHEMEITEMSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALSCHEMEITEM> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALSCHEMEITEM>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALSCHEMEITEM et){
        //实体关系[DER1N_SALSCHEMEITEM_SALITEM_SALITEMID]
        if(!ObjectUtils.isEmpty(et.getSalitemid())){
            cn.ibizlab.ehr.core.sal.domain.SALITEM salitem=et.getSalitem();
            if(ObjectUtils.isEmpty(salitem)){
                cn.ibizlab.ehr.core.sal.domain.SALITEM majorEntity=salitemService.get(et.getSalitemid());
                et.setSalitem(majorEntity);
                salitem=majorEntity;
            }
            et.setSalitemname(salitem.getSalitemname());
        }
        //实体关系[DER1N_SALSCHEMEITEM_SALRULE_SALRULEID]
        if(!ObjectUtils.isEmpty(et.getSalruleid())){
            cn.ibizlab.ehr.core.sal.domain.SALRULE salrule=et.getSalrule();
            if(ObjectUtils.isEmpty(salrule)){
                cn.ibizlab.ehr.core.sal.domain.SALRULE majorEntity=salruleService.get(et.getSalruleid());
                et.setSalrule(majorEntity);
                salrule=majorEntity;
            }
            et.setSalrulename(salrule.getSalrulename());
        }
        //实体关系[DER1N_SALSCHEMEITEM_SALSCHEME_SALSCHEMEID]
        if(!ObjectUtils.isEmpty(et.getSalschemeid())){
            cn.ibizlab.ehr.core.sal.domain.SALSCHEME salscheme=et.getSalscheme();
            if(ObjectUtils.isEmpty(salscheme)){
                cn.ibizlab.ehr.core.sal.domain.SALSCHEME majorEntity=salschemeService.get(et.getSalschemeid());
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

}


