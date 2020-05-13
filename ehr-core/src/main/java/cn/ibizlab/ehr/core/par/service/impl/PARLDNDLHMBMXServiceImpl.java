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
import cn.ibizlab.ehr.core.par.domain.PARLDNDLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARLDNDLHMBMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARLDNDLHMBMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARLDNDLHMBMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标明细（助理总经理级 ）] 服务对象接口实现
 */
@Slf4j
@Service("PARLDNDLHMBMXServiceImpl")
public class PARLDNDLHMBMXServiceImpl extends ServiceImpl<PARLDNDLHMBMXMapper, PARLDNDLHMBMX> implements IPARLDNDLHMBMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARLDNDLHMBService parldndlhmbService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PARLDNDLHMBMX get(String key) {
        PARLDNDLHMBMX et = getById(key);
        if(et==null){
            et=new PARLDNDLHMBMX();
            et.setParldndlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PARLDNDLHMBMX getDraft(PARLDNDLHMBMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARLDNDLHMBMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParldndlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARLDNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARLDNDLHMBMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARLDNDLHMBMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARLDNDLHMBMX> list) {
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
    public boolean checkKey(PARLDNDLHMBMX et) {
        return (!ObjectUtils.isEmpty(et.getParldndlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParldndlhmbmxid())));
    }

    @Override
    @Transactional
    public boolean update(PARLDNDLHMBMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parldndlhmbmxid",et.getParldndlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParldndlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARLDNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<PARLDNDLHMBMX> selectByParldndlhmbid(String parldndlhmbid) {
        return baseMapper.selectByParldndlhmbid(parldndlhmbid);
    }

    @Override
    public void removeByParldndlhmbid(String parldndlhmbid) {
        this.remove(new QueryWrapper<PARLDNDLHMBMX>().eq("parldndlhmbid",parldndlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARLDNDLHMBMX> searchDefault(PARLDNDLHMBMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARLDNDLHMBMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARLDNDLHMBMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARLDNDLHMBMX et){
        //实体关系[DER1N_PARLDNDLHMBMX_PARLDNDLHMB_PARLDNDLHMBID]
        if(!ObjectUtils.isEmpty(et.getParldndlhmbid())){
            cn.ibizlab.ehr.core.par.domain.PARLDNDLHMB parldndlhmb=et.getParldndlhmb();
            if(ObjectUtils.isEmpty(parldndlhmb)){
                cn.ibizlab.ehr.core.par.domain.PARLDNDLHMB majorEntity=parldndlhmbService.get(et.getParldndlhmbid());
                et.setParldndlhmb(majorEntity);
                parldndlhmb=majorEntity;
            }
            et.setParldndlhmbname(parldndlhmb.getParldndlhmbname());
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


