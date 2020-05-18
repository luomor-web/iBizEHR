package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZJGWH;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZJGWHSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZJGWHService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMXYGZZJGWHMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试用期员工转正考核结果维护] 服务对象接口实现
 */
@Slf4j
@Service("PCMXYGZZJGWHServiceImpl")
public class PCMXYGZZJGWHServiceImpl extends ServiceImpl<PCMXYGZZJGWHMapper, PCMXYGZZJGWH> implements IPCMXYGZZJGWHService {


    private int batchSize = 500;

    @Override
    public PCMXYGZZJGWH getDraft(PCMXYGZZJGWH et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMXYGZZJGWH et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMXYGZZJGWH et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMXYGZZJGWH> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PCMXYGZZJGWH et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmxygzzjgwhid",et.getPcmxygzzjgwhid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzjgwhid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMXYGZZJGWH> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMXYGZZJGWH et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzjgwhid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMXYGZZJGWH> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMXYGZZJGWH et) {
        return (!ObjectUtils.isEmpty(et.getPcmxygzzjgwhid()))&&(!Objects.isNull(this.getById(et.getPcmxygzzjgwhid())));
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
    public PCMXYGZZJGWH get(String key) {
        PCMXYGZZJGWH et = getById(key);
        if(et==null){
            et=new PCMXYGZZJGWH();
            et.setPcmxygzzjgwhid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMXYGZZJGWH> searchDefault(PCMXYGZZJGWHSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMXYGZZJGWH> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMXYGZZJGWH>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


