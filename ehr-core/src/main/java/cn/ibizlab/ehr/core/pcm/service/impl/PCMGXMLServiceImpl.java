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
import cn.ibizlab.ehr.core.pcm.domain.PCMGXML;
import cn.ibizlab.ehr.core.pcm.filter.PCMGXMLSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMGXMLService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMGXMLMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[高校名录] 服务对象接口实现
 */
@Slf4j
@Service("PCMGXMLServiceImpl")
public class PCMGXMLServiceImpl extends ServiceImpl<PCMGXMLMapper, PCMGXML> implements IPCMGXMLService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMGXXKTEMPService pcmgxxktempService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PCMGXML et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmgxmlid",et.getPcmgxmlid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmgxmlid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMGXML> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMGXML et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMGXML et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMGXML> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PCMGXML getDraft(PCMGXML et) {
        return et;
    }

    @Override
    public boolean checkKey(PCMGXML et) {
        return (!ObjectUtils.isEmpty(et.getPcmgxmlid()))&&(!Objects.isNull(this.getById(et.getPcmgxmlid())));
    }

    @Override
    @Transactional
    public PCMGXML get(String key) {
        PCMGXML et = getById(key);
        if(et==null){
            et=new PCMGXML();
            et.setPcmgxmlid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMGXML et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmgxmlid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMGXML> list) {
        saveBatch(list,batchSize);
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
    public Page<PCMGXML> searchDefault(PCMGXMLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMGXML> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMGXML>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前年度高校名录
     */
    @Override
    public Page<PCMGXML> searchCurND(PCMGXMLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMGXML> pages=baseMapper.searchCurND(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMGXML>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


