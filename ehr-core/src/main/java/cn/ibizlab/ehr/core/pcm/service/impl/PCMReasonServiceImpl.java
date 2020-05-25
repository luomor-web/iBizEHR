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
import cn.ibizlab.ehr.core.pcm.domain.PCMReason;
import cn.ibizlab.ehr.core.pcm.filter.PCMReasonSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMReasonService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMReasonMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[配置原因代码表] 服务对象接口实现
 */
@Slf4j
@Service("PCMReasonServiceImpl")
public class PCMReasonServiceImpl extends ServiceImpl<PCMReasonMapper, PCMReason> implements IPCMReasonService {


    private int batchSize = 500;

    @Override
    public PCMReason getDraft(PCMReason et) {
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
    public boolean update(PCMReason et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmreasonid",et.getPcmreasonid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmreasonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMReason> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMReason get(String key) {
        PCMReason et = getById(key);
        if(et==null){
            et=new PCMReason();
            et.setPcmreasonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMReason et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmreasonid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMReason> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMReason et) {
        return (!ObjectUtils.isEmpty(et.getPcmreasonid()))&&(!Objects.isNull(this.getById(et.getPcmreasonid())));
    }

    @Override
    @Transactional
    public boolean save(PCMReason et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMReason et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMReason> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMReason> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMReason> searchDefault(PCMReasonSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMReason> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMReason>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


