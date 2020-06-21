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
import cn.ibizlab.ehr.core.pcm.domain.PcmNoRecyclingLibrary;
import cn.ibizlab.ehr.core.pcm.filter.PcmNoRecyclingLibrarySearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmNoRecyclingLibraryService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmNoRecyclingLibraryMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工编号回收库] 服务对象接口实现
 */
@Slf4j
@Service("PcmNoRecyclingLibraryServiceImpl")
public class PcmNoRecyclingLibraryServiceImpl extends ServiceImpl<PcmNoRecyclingLibraryMapper, PcmNoRecyclingLibrary> implements IPcmNoRecyclingLibraryService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PcmNoRecyclingLibrary et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmnorecyclinglibraryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmNoRecyclingLibrary> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public PcmNoRecyclingLibrary getDraft(PcmNoRecyclingLibrary et) {
        return et;
    }

    @Override
    @Transactional
    public PcmNoRecyclingLibrary get(String key) {
        PcmNoRecyclingLibrary et = getById(key);
        if(et==null){
            et=new PcmNoRecyclingLibrary();
            et.setPcmnorecyclinglibraryid(key);
        }
        else{
        }
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
    public boolean update(PcmNoRecyclingLibrary et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmnorecyclinglibraryid",et.getPcmnorecyclinglibraryid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmnorecyclinglibraryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmNoRecyclingLibrary> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmNoRecyclingLibrary et) {
        return (!ObjectUtils.isEmpty(et.getPcmnorecyclinglibraryid()))&&(!Objects.isNull(this.getById(et.getPcmnorecyclinglibraryid())));
    }
    @Override
    @Transactional
    public boolean save(PcmNoRecyclingLibrary et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmNoRecyclingLibrary et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmNoRecyclingLibrary> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmNoRecyclingLibrary> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmNoRecyclingLibrary> searchDefault(PcmNoRecyclingLibrarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmNoRecyclingLibrary> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmNoRecyclingLibrary>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmNoRecyclingLibrary> getPcmnorecyclinglibraryByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmNoRecyclingLibrary> getPcmnorecyclinglibraryByEntities(List<PcmNoRecyclingLibrary> entities) {
        List ids =new ArrayList();
        for(PcmNoRecyclingLibrary entity : entities){
            Serializable id=entity.getPcmnorecyclinglibraryid();
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



