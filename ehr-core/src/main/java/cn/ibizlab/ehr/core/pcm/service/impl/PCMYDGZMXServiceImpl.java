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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDGZMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDGZMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDGZMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDGZMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动挂职明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDGZMXServiceImpl")
public class PCMYDGZMXServiceImpl extends ServiceImpl<PCMYDGZMXMapper, PCMYDGZMX> implements IPCMYDGZMXService {


    private int batchSize = 500;

    @Override
    @Transactional
    public PCMYDGZMX rYHG(PCMYDGZMX et) {
        //自定义代码
        return et;
    }

    @Override
    public PCMYDGZMX getDraft(PCMYDGZMX et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMYDGZMX et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydgzmxid",et.getPcmydgzmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydgzmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDGZMX> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMYDGZMX get(String key) {
        PCMYDGZMX et = getById(key);
        if(et==null){
            et=new PCMYDGZMX();
            et.setPcmydgzmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMYDGZMX fillPersonInfo(PCMYDGZMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMYDGZMX et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydgzmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDGZMX> list) {
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMYDGZMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDGZMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMYDGZMX> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMYDGZMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmydgzmxid()))&&(!Objects.isNull(this.getById(et.getPcmydgzmxid())));
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
     * 查询集合 挂职出人员查询
     */
    @Override
    public Page<PCMYDGZMX> searchGZCRYDQ(PCMYDGZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDGZMX> pages=baseMapper.searchGZCRYDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDGZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职进历史记录查询
     */
    @Override
    public Page<PCMYDGZMX> searchGZJLSJLDQ(PCMYDGZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDGZMX> pages=baseMapper.searchGZJLSJLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDGZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职进人员
     */
    @Override
    public Page<PCMYDGZMX> searchGZJRY(PCMYDGZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDGZMX> pages=baseMapper.searchGZJRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDGZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDGZMX> searchDefault(PCMYDGZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDGZMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDGZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职出历史记录查询
     */
    @Override
    public Page<PCMYDGZMX> searchGZCLSJLDQ(PCMYDGZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDGZMX> pages=baseMapper.searchGZCLSJLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDGZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


