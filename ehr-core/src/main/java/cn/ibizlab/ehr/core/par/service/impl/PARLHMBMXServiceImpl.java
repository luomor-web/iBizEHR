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
import cn.ibizlab.ehr.core.par.domain.PARLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARLHMBMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARLHMBMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARLHMBMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效量化目标明细] 服务对象接口实现
 */
@Slf4j
@Service("PARLHMBMXServiceImpl")
public class PARLHMBMXServiceImpl extends ServiceImpl<PARLHMBMXMapper, PARLHMBMX> implements IPARLHMBMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXLHMBService parjxlhmbService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PARLHMBMX et) {
        return (!ObjectUtils.isEmpty(et.getParlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParlhmbmxid())));
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
    public boolean save(PARLHMBMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARLHMBMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PARLHMBMX getDraft(PARLHMBMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PARLHMBMX get(String key) {
        PARLHMBMX et = getById(key);
        if(et==null){
            et=new PARLHMBMX();
            et.setParlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PARLHMBMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parlhmbmxid",et.getParlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PARLHMBMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PARLHMBMX> selectByParjxlhmbid(String parjxlhmbid) {
        return baseMapper.selectByParjxlhmbid(parjxlhmbid);
    }

    @Override
    public void removeByParjxlhmbid(String parjxlhmbid) {
        this.remove(new QueryWrapper<PARLHMBMX>().eq("parjxlhmbid",parjxlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARLHMBMX> searchDefault(PARLHMBMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARLHMBMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARLHMBMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARLHMBMX et){
        //实体关系[DER1N_PARLHMBMX_PARJXLHMB_PARJXLHMBID]
        if(!ObjectUtils.isEmpty(et.getParjxlhmbid())){
            cn.ibizlab.ehr.core.par.domain.PARJXLHMB parjxlhmb=et.getParjxlhmb();
            if(ObjectUtils.isEmpty(parjxlhmb)){
                cn.ibizlab.ehr.core.par.domain.PARJXLHMB majorEntity=parjxlhmbService.get(et.getParjxlhmbid());
                et.setParjxlhmb(majorEntity);
                parjxlhmb=majorEntity;
            }
            et.setParjxlhmbname(parjxlhmb.getParjxlhmbname());
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


