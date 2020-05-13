package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.PARLHMBKHMX;
import cn.ibizlab.ehr.core.par.filter.PARLHMBKHMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARLHMBKHMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARLHMBKHMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[量化目标考核明细] 服务对象接口实现
 */
@Slf4j
@Service("PARLHMBKHMXServiceImpl")
public class PARLHMBKHMXServiceImpl extends ServiceImpl<PARLHMBKHMXMapper, PARLHMBKHMX> implements IPARLHMBKHMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARNDLHMBKHService parndlhmbkhService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PARLHMBKHMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parlhmbkhmxid",et.getParlhmbkhmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbkhmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARLHMBKHMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PARLHMBKHMX getDraft(PARLHMBKHMX et) {
        fillParentData(et);
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
    public boolean save(PARLHMBKHMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARLHMBKHMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARLHMBKHMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PARLHMBKHMX et) {
        return (!ObjectUtils.isEmpty(et.getParlhmbkhmxid()))&&(!Objects.isNull(this.getById(et.getParlhmbkhmxid())));
    }

    @Override
    @Transactional
    public PARLHMBKHMX get(String key) {
        PARLHMBKHMX et = getById(key);
        if(et==null){
            et=new PARLHMBKHMX();
            et.setParlhmbkhmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARLHMBKHMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParlhmbkhmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARLHMBKHMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }


	@Override
    public List<PARLHMBKHMX> selectByParndlhmbkhid(String parndlhmbkhid) {
        return baseMapper.selectByParndlhmbkhid(parndlhmbkhid);
    }

    @Override
    public void removeByParndlhmbkhid(String parndlhmbkhid) {
        this.remove(new QueryWrapper<PARLHMBKHMX>().eq("parndlhmbkhid",parndlhmbkhid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARLHMBKHMX> searchDefault(PARLHMBKHMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARLHMBKHMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARLHMBKHMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARLHMBKHMX et){
        //实体关系[DER1N_PARLHMBKHMX_PARNDLHMBKH_PARNDLHMBKHID]
        if(!ObjectUtils.isEmpty(et.getParndlhmbkhid())){
            cn.ibizlab.ehr.core.par.domain.PARNDLHMBKH parndlhmbkh=et.getParndlhmbkh();
            if(ObjectUtils.isEmpty(parndlhmbkh)){
                cn.ibizlab.ehr.core.par.domain.PARNDLHMBKH majorEntity=parndlhmbkhService.get(et.getParndlhmbkhid());
                et.setParndlhmbkh(majorEntity);
                parndlhmbkh=majorEntity;
            }
            et.setParndlhmbkhname(parndlhmbkh.getParndlhmbkhname());
        }
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


