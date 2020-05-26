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
import cn.ibizlab.ehr.core.pcm.domain.PCMRZGL;
import cn.ibizlab.ehr.core.pcm.filter.PCMRZGLSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMRZGLService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMRZGLMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[任职管理] 服务对象接口实现
 */
@Slf4j
@Service("PCMRZGLServiceImpl")
public class PCMRZGLServiceImpl extends ServiceImpl<PCMRZGLMapper, PCMRZGL> implements IPCMRZGLService {


    private int batchSize = 500;

    @Override
    @Transactional
    public PCMRZGL get(String key) {
        PCMRZGL et = getById(key);
        if(et==null){
            et=new PCMRZGL();
            et.setPcmrzglid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMRZGL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMRZGL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMRZGL> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMRZGL> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMRZGL et) {
        return (!ObjectUtils.isEmpty(et.getPcmrzglid()))&&(!Objects.isNull(this.getById(et.getPcmrzglid())));
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
    public boolean create(PCMRZGL et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmrzglid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMRZGL> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public PCMRZGL getDraft(PCMRZGL et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMRZGL et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmrzglid",et.getPcmrzglid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmrzglid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMRZGL> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMRZGL> searchDefault(PCMRZGLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRZGL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRZGL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 干部任职期限查询
     */
    @Override
    public Page<PCMRZGL> searchGBRZQXDQ(PCMRZGLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRZGL> pages=baseMapper.searchGBRZQXDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRZGL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 RQCX
     */
    @Override
    public Page<PCMRZGL> searchRQCX(PCMRZGLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRZGL> pages=baseMapper.searchRQCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRZGL>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


