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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQ;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZSQSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMXYGZZSQMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试用期员工转正申请] 服务对象接口实现
 */
@Slf4j
@Service("PCMXYGZZSQServiceImpl")
public class PCMXYGZZSQServiceImpl extends ServiceImpl<PCMXYGZZSQMapper, PCMXYGZZSQ> implements IPCMXYGZZSQService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZJLMXService pcmxygzzjlmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQMXService pcmxygzzsqmxService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PCMXYGZZSQ et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzsqid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMXYGZZSQ> list) {
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMXYGZZSQ get(String key) {
        PCMXYGZZSQ et = getById(key);
        if(et==null){
            et=new PCMXYGZZSQ();
            et.setPcmxygzzsqid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMXYGZZSQ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMXYGZZSQ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMXYGZZSQ> list) {
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
    public boolean checkKey(PCMXYGZZSQ et) {
        return (!ObjectUtils.isEmpty(et.getPcmxygzzsqid()))&&(!Objects.isNull(this.getById(et.getPcmxygzzsqid())));
    }

    @Override
    public PCMXYGZZSQ getDraft(PCMXYGZZSQ et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMXYGZZSQ et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmxygzzsqid",et.getPcmxygzzsqid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzsqid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMXYGZZSQ> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMXYGZZSQ> searchDefault(PCMXYGZZSQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMXYGZZSQ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMXYGZZSQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


