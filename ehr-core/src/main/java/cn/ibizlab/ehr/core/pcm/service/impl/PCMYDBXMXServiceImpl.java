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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDBXMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDBXMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDBXMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDBXMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动病休明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDBXMXServiceImpl")
public class PCMYDBXMXServiceImpl extends ServiceImpl<PCMYDBXMXMapper, PCMYDBXMX> implements IPCMYDBXMXService {


    private int batchSize = 500;

    @Override
    @Transactional
    public PCMYDBXMX get(String key) {
        PCMYDBXMX et = getById(key);
        if(et==null){
            et=new PCMYDBXMX();
            et.setPcmydbxmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMYDBXMX fillPersonInfo(PCMYDBXMX et) {
        //自定义代码
        return et;
    }

    @Override
    public PCMYDBXMX getDraft(PCMYDBXMX et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMYDBXMX et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydbxmxid",et.getPcmydbxmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydbxmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDBXMX> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMYDBXMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmydbxmxid()))&&(!Objects.isNull(this.getById(et.getPcmydbxmxid())));
    }

    @Override
    @Transactional
    public boolean save(PCMYDBXMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDBXMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMYDBXMX> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMYDBXMX> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMYDBXMX finishBX(PCMYDBXMX et) {
        //自定义代码
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
    public boolean create(PCMYDBXMX et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydbxmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDBXMX> list) {
        this.saveBatch(list,batchSize);
    }



    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PCMYDBXMX> searchGLDS(PCMYDBXMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDBXMX> pages=baseMapper.searchGLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDBXMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDBXMX> searchDefault(PCMYDBXMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDBXMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDBXMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录查询
     */
    @Override
    public Page<PCMYDBXMX> searchJLDS(PCMYDBXMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDBXMX> pages=baseMapper.searchJLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDBXMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
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

    @Override
    public List<PCMYDBXMX> getPcmydbxmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMYDBXMX> getPcmydbxmxByEntities(List<PCMYDBXMX> entities) {
        List ids =new ArrayList();
        for(PCMYDBXMX entity : entities){
            Serializable id=entity.getPcmydbxmxid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}


