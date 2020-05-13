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
import cn.ibizlab.ehr.core.par.domain.PARYDGZJHMX;
import cn.ibizlab.ehr.core.par.filter.PARYDGZJHMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARYDGZJHMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARYDGZJHMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[月度工作计划明细] 服务对象接口实现
 */
@Slf4j
@Service("PARYDGZJHMXServiceImpl")
public class PARYDGZJHMXServiceImpl extends ServiceImpl<PARYDGZJHMXMapper, PARYDGZJHMX> implements IPARYDGZJHMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARYDGZJHService parydgzjhService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PARYDGZJHMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parydgzjhmxid",et.getParydgzjhmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParydgzjhmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARYDGZJHMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARYDGZJHMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARYDGZJHMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARYDGZJHMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
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
    public PARYDGZJHMX get(String key) {
        PARYDGZJHMX et = getById(key);
        if(et==null){
            et=new PARYDGZJHMX();
            et.setParydgzjhmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PARYDGZJHMX et) {
        return (!ObjectUtils.isEmpty(et.getParydgzjhmxid()))&&(!Objects.isNull(this.getById(et.getParydgzjhmxid())));
    }

    @Override
    public PARYDGZJHMX getDraft(PARYDGZJHMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARYDGZJHMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParydgzjhmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARYDGZJHMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }


	@Override
    public List<PARYDGZJHMX> selectByParydgzjhid(String parydgzjhid) {
        return baseMapper.selectByParydgzjhid(parydgzjhid);
    }

    @Override
    public void removeByParydgzjhid(String parydgzjhid) {
        this.remove(new QueryWrapper<PARYDGZJHMX>().eq("parydgzjhid",parydgzjhid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARYDGZJHMX> searchDefault(PARYDGZJHMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARYDGZJHMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARYDGZJHMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARYDGZJHMX et){
        //实体关系[DER1N_PARYDGZJHMX_PARYDGZJH_PARYDGZJHID]
        if(!ObjectUtils.isEmpty(et.getParydgzjhid())){
            cn.ibizlab.ehr.core.par.domain.PARYDGZJH parydgzjh=et.getParydgzjh();
            if(ObjectUtils.isEmpty(parydgzjh)){
                cn.ibizlab.ehr.core.par.domain.PARYDGZJH majorEntity=parydgzjhService.get(et.getParydgzjhid());
                et.setParydgzjh(majorEntity);
                parydgzjh=majorEntity;
            }
            et.setParydgzjhname(parydgzjh.getParydgzjhname());
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


