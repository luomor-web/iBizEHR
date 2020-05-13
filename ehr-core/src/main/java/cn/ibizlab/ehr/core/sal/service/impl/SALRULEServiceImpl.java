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
import cn.ibizlab.ehr.core.sal.domain.SALRULE;
import cn.ibizlab.ehr.core.sal.filter.SALRULESearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALRULEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALRULEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬规则] 服务对象接口实现
 */
@Slf4j
@Service("SALRULEServiceImpl")
public class SALRULEServiceImpl extends ServiceImpl<SALRULEMapper, SALRULE> implements ISALRULEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALRULEDETAILService salruledetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSCHEMEITEMService salschemeitemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALPARAMService salparamService;

    private int batchSize = 500;

    @Override
    public SALRULE getDraft(SALRULE et) {
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
    public SALRULE get(String key) {
        SALRULE et = getById(key);
        if(et==null){
            et=new SALRULE();
            et.setSalruleid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(SALRULE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalruleid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALRULE> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SALRULE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salruleid",et.getSalruleid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalruleid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALRULE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SALRULE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALRULE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<SALRULE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SALRULE et) {
        return (!ObjectUtils.isEmpty(et.getSalruleid()))&&(!Objects.isNull(this.getById(et.getSalruleid())));
    }


	@Override
    public List<SALRULE> selectBySalparamid(String salparamid) {
        return baseMapper.selectBySalparamid(salparamid);
    }

    @Override
    public void removeBySalparamid(String salparamid) {
        this.remove(new QueryWrapper<SALRULE>().eq("salparamid",salparamid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALRULE> searchDefault(SALRULESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALRULE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALRULE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALRULE et){
        //实体关系[DER1N_SALRULE_SALPARAM_SALPARAMID]
        if(!ObjectUtils.isEmpty(et.getSalparamid())){
            cn.ibizlab.ehr.core.sal.domain.SALPARAM salparam=et.getSalparam();
            if(ObjectUtils.isEmpty(salparam)){
                cn.ibizlab.ehr.core.sal.domain.SALPARAM majorEntity=salparamService.get(et.getSalparamid());
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

}

