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
import cn.ibizlab.ehr.core.pim.domain.PIMMAJORSETYPE;
import cn.ibizlab.ehr.core.pim.filter.PIMMAJORSETYPESearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMMAJORSETYPEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMMAJORSETYPEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[专业序列类型] 服务对象接口实现
 */
@Slf4j
@Service("PIMMAJORSETYPEServiceImpl")
public class PIMMAJORSETYPEServiceImpl extends ServiceImpl<PIMMAJORSETYPEMapper, PIMMAJORSETYPE> implements IPIMMAJORSETYPEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

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
    public boolean checkKey(PIMMAJORSETYPE et) {
        return (!ObjectUtils.isEmpty(et.getPimmajorsetypeid()))&&(!Objects.isNull(this.getById(et.getPimmajorsetypeid())));
    }

    @Override
    @Transactional
    public PIMMAJORSETYPE get(String key) {
        PIMMAJORSETYPE et = getById(key);
        if(et==null){
            et=new PIMMAJORSETYPE();
            et.setPimmajorsetypeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMMAJORSETYPE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMMAJORSETYPE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMMAJORSETYPE> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMMAJORSETYPE> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMMAJORSETYPE et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimmajorsetypeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMMAJORSETYPE> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public PIMMAJORSETYPE getDraft(PIMMAJORSETYPE et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PIMMAJORSETYPE et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimmajorsetypeid",et.getPimmajorsetypeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimmajorsetypeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMMAJORSETYPE> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMMAJORSETYPE> searchDefault(PIMMAJORSETYPESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMMAJORSETYPE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMMAJORSETYPE>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


