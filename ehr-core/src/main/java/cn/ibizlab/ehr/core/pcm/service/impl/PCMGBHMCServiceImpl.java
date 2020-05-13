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
import cn.ibizlab.ehr.core.pcm.domain.PCMGBHMC;
import cn.ibizlab.ehr.core.pcm.filter.PCMGBHMCSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMGBHMCService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMGBHMCMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[干部花名册] 服务对象接口实现
 */
@Slf4j
@Service("PCMGBHMCServiceImpl")
public class PCMGBHMCServiceImpl extends ServiceImpl<PCMGBHMCMapper, PCMGBHMC> implements IPCMGBHMCService {


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
    public PCMGBHMC get(String key) {
        PCMGBHMC et = getById(key);
        if(et==null){
            et=new PCMGBHMC();
            et.setPimpersonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMGBHMC toggleLeader(PCMGBHMC et) {
        //自定义代码
        return et;
    }

    @Override
    public PCMGBHMC getDraft(PCMGBHMC et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMGBHMC et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMGBHMC> list) {
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PCMGBHMC et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpersonid",et.getPimpersonid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMGBHMC> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMGBHMC et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMGBHMC et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMGBHMC> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMGBHMC sGTG(PCMGBHMC et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMGBHMC et) {
        return (!ObjectUtils.isEmpty(et.getPimpersonid()))&&(!Objects.isNull(this.getById(et.getPimpersonid())));
    }

    @Override
    @Transactional
    public PCMGBHMC sGBTG(PCMGBHMC et) {
        //自定义代码
        return et;
    }



    /**
     * 查询集合 树视图的干部花名册（新）
     */
    @Override
    public Page<PCMGBHMC> searchGBHMCNewTree(PCMGBHMCSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMGBHMC> pages=baseMapper.searchGBHMCNewTree(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMGBHMC>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 树视图的干部花名册
     */
    @Override
    public Page<PCMGBHMC> searchGBHMCTree(PCMGBHMCSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMGBHMC> pages=baseMapper.searchGBHMCTree(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMGBHMC>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMGBHMC> searchDefault(PCMGBHMCSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMGBHMC> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMGBHMC>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 ZJPD
     */
    @Override
    public Page<PCMGBHMC> searchZJPD(PCMGBHMCSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMGBHMC> pages=baseMapper.searchZJPD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMGBHMC>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


