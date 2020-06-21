package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PimFilebatvhupload;
import cn.ibizlab.ehr.core.pim.filter.PimFilebatvhuploadSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimFilebatvhuploadService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimFilebatvhuploadMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[附件批量上传] 服务对象接口实现
 */
@Slf4j
@Service("PimFilebatvhuploadServiceImpl")
public class PimFilebatvhuploadServiceImpl extends ServiceImpl<PimFilebatvhuploadMapper, PimFilebatvhupload> implements IPimFilebatvhuploadService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PimFilebatvhupload et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimFilebatvhupload et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimFilebatvhupload> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimFilebatvhupload> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimFilebatvhupload get(String key) {
        PimFilebatvhupload et = getById(key);
        if(et==null){
            et=new PimFilebatvhupload();
            et.setPimfilebatvhuploadid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PimFilebatvhupload et) {
        return (!ObjectUtils.isEmpty(et.getPimfilebatvhuploadid()))&&(!Objects.isNull(this.getById(et.getPimfilebatvhuploadid())));
    }
    @Override
    @Transactional
    public boolean update(PimFilebatvhupload et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimfilebatvhuploadid",et.getPimfilebatvhuploadid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimfilebatvhuploadid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimFilebatvhupload> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimFilebatvhupload et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimfilebatvhuploadid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimFilebatvhupload> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public PimFilebatvhupload getDraft(PimFilebatvhupload et) {
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



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimFilebatvhupload> searchDefault(PimFilebatvhuploadSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFilebatvhupload> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFilebatvhupload>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PimFilebatvhupload> getPimfilebatvhuploadByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimFilebatvhupload> getPimfilebatvhuploadByEntities(List<PimFilebatvhupload> entities) {
        List ids =new ArrayList();
        for(PimFilebatvhupload entity : entities){
            Serializable id=entity.getPimfilebatvhuploadid();
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



