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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsgz;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsgzSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsgzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmJxsgzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[见习生规则] 服务对象接口实现
 */
@Slf4j
@Service("PcmJxsgzServiceImpl")
public class PcmJxsgzServiceImpl extends ServiceImpl<PcmJxsgzMapper, PcmJxsgz> implements IPcmJxsgzService {


    private int batchSize = 500;

    @Override
    public boolean checkKey(PcmJxsgz et) {
        return (!ObjectUtils.isEmpty(et.getPcmjxsgzid()))&&(!Objects.isNull(this.getById(et.getPcmjxsgzid())));
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
    public boolean update(PcmJxsgz et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmjxsgzid",et.getPcmjxsgzid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsgzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmJxsgz> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmJxsgz get(String key) {
        PcmJxsgz et = getById(key);
        if(et==null){
            et=new PcmJxsgz();
            et.setPcmjxsgzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PcmJxsgz getDraft(PcmJxsgz et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmJxsgz et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsgzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmJxsgz> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmJxsgz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmJxsgz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmJxsgz> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmJxsgz> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmJxsgz> searchDefault(PcmJxsgzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmJxsgz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmJxsgz>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmJxsgz> getPcmjxsgzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmJxsgz> getPcmjxsgzByEntities(List<PcmJxsgz> entities) {
        List ids =new ArrayList();
        for(PcmJxsgz entity : entities){
            Serializable id=entity.getPcmjxsgzid();
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



