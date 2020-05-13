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
import cn.ibizlab.ehr.core.pcm.domain.PCMZSGL;
import cn.ibizlab.ehr.core.pcm.filter.PCMZSGLSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMZSGLService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMZSGLMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职数管理] 服务对象接口实现
 */
@Slf4j
@Service("PCMZSGLServiceImpl")
public class PCMZSGLServiceImpl extends ServiceImpl<PCMZSGLMapper, PCMZSGL> implements IPCMZSGLService {


    private int batchSize = 500;

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
    public PCMZSGL get(String key) {
        PCMZSGL et = getById(key);
        if(et==null){
            et=new PCMZSGL();
            et.setPcmzsglid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PCMZSGL getDraft(PCMZSGL et) {
        return et;
    }

    @Override
    public boolean checkKey(PCMZSGL et) {
        return (!ObjectUtils.isEmpty(et.getPcmzsglid()))&&(!Objects.isNull(this.getById(et.getPcmzsglid())));
    }

    @Override
    @Transactional
    public boolean update(PCMZSGL et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmzsglid",et.getPcmzsglid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmzsglid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMZSGL> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMZSGL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMZSGL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMZSGL> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMZSGL et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmzsglid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMZSGL> list) {
        saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMZSGL> searchDefault(PCMZSGLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMZSGL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMZSGL>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


