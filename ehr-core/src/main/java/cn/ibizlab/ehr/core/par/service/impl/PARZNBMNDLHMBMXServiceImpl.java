package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARZNBMNDLHMBMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARZNBMNDLHMBMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标明细（职能部门级 ）] 服务对象接口实现
 */
@Slf4j
@Service("PARZNBMNDLHMBMXServiceImpl")
public class PARZNBMNDLHMBMXServiceImpl extends ServiceImpl<PARZNBMNDLHMBMXMapper, PARZNBMNDLHMBMX> implements IPARZNBMNDLHMBMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBService parznbmndlhmbService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PARZNBMNDLHMBMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARZNBMNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PARZNBMNDLHMBMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parznbmndlhmbmxid",et.getParznbmndlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARZNBMNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PARZNBMNDLHMBMX getDraft(PARZNBMNDLHMBMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PARZNBMNDLHMBMX get(String key) {
        PARZNBMNDLHMBMX et = getById(key);
        if(et==null){
            et=new PARZNBMNDLHMBMX();
            et.setParznbmndlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PARZNBMNDLHMBMX et) {
        return (!ObjectUtils.isEmpty(et.getParznbmndlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParznbmndlhmbmxid())));
    }

    @Override
    @Transactional
    public boolean save(PARZNBMNDLHMBMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARZNBMNDLHMBMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARZNBMNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARZNBMNDLHMBMX> list) {
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
    public List<PARZNBMNDLHMBMX> selectByParznbmndlhmbid(String parznbmndlhmbid) {
        return baseMapper.selectByParznbmndlhmbid(parznbmndlhmbid);
    }

    @Override
    public void removeByParznbmndlhmbid(String parznbmndlhmbid) {
        this.remove(new QueryWrapper<PARZNBMNDLHMBMX>().eq("parznbmndlhmbid",parznbmndlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARZNBMNDLHMBMX> searchDefault(PARZNBMNDLHMBMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARZNBMNDLHMBMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARZNBMNDLHMBMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARZNBMNDLHMBMX et){
        //实体关系[DER1N_PARZNBMNDLHMBMX_PARZNBMNDLHMB_PARZNBMNDLHMBID]
        if(!ObjectUtils.isEmpty(et.getParznbmndlhmbid())){
            cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMB parznbmndlhmb=et.getParznbmndlhmb();
            if(ObjectUtils.isEmpty(parznbmndlhmb)){
                cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMB majorEntity=parznbmndlhmbService.get(et.getParznbmndlhmbid());
                et.setParznbmndlhmb(majorEntity);
                parznbmndlhmb=majorEntity;
            }
            et.setParznbmndlhmbname(parznbmndlhmb.getParznbmndlhmbname());
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


