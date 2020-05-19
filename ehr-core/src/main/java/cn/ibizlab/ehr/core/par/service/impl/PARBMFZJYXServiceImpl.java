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
import cn.ibizlab.ehr.core.par.domain.PARBMFZJYX;
import cn.ibizlab.ehr.core.par.filter.PARBMFZJYXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARBMFZJYXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARBMFZJYXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[通知选择部门副职及以下] 服务对象接口实现
 */
@Slf4j
@Service("PARBMFZJYXServiceImpl")
public class PARBMFZJYXServiceImpl extends ServiceImpl<PARBMFZJYXMapper, PARBMFZJYX> implements IPARBMFZJYXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARTZGGService partzggService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PARBMFZJYX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARBMFZJYX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARBMFZJYX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PARBMFZJYX getDraft(PARBMFZJYX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARBMFZJYX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParbmfzjyxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARBMFZJYX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PARBMFZJYX et) {
        return (!ObjectUtils.isEmpty(et.getParbmfzjyxid()))&&(!Objects.isNull(this.getById(et.getParbmfzjyxid())));
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
    public boolean update(PARBMFZJYX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parbmfzjyxid",et.getParbmfzjyxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParbmfzjyxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARBMFZJYX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PARBMFZJYX get(String key) {
        PARBMFZJYX et = getById(key);
        if(et==null){
            et=new PARBMFZJYX();
            et.setParbmfzjyxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PARBMFZJYX> selectByPartzggid(String partzggid) {
        return baseMapper.selectByPartzggid(partzggid);
    }

    @Override
    public void removeByPartzggid(String partzggid) {
        this.remove(new QueryWrapper<PARBMFZJYX>().eq("partzggid",partzggid));
    }

	@Override
    public List<PARBMFZJYX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PARBMFZJYX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARBMFZJYX> searchDefault(PARBMFZJYXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARBMFZJYX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARBMFZJYX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARBMFZJYX et){
        //实体关系[DER1N_PARBMFZJYX_PARTZGG_PARTZGGID]
        if(!ObjectUtils.isEmpty(et.getPartzggid())){
            cn.ibizlab.ehr.core.par.domain.PARTZGG partzgg=et.getPartzgg();
            if(ObjectUtils.isEmpty(partzgg)){
                cn.ibizlab.ehr.core.par.domain.PARTZGG majorEntity=partzggService.get(et.getPartzggid());
                et.setPartzgg(majorEntity);
                partzgg=majorEntity;
            }
            et.setPartzggname(partzgg.getPartzggname());
        }
        //实体关系[DER1N_PARBMFZJYX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setSsbm(pimperson.getOrmorgsectorname());
            et.setSszz(pimperson.getOrmorgname());
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


