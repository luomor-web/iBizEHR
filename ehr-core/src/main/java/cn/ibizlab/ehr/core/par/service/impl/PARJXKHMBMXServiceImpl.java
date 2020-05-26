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
import cn.ibizlab.ehr.core.par.domain.PARJXKHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARJXKHMBMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARJXKHMBMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARJXKHMBMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效模板明细] 服务对象接口实现
 */
@Slf4j
@Service("PARJXKHMBMXServiceImpl")
public class PARJXKHMBMXServiceImpl extends ServiceImpl<PARJXKHMBMXMapper, PARJXKHMBMX> implements IPARJXKHMBMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXKHMBService parjxkhmbService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PARJXKHMBMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxkhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARJXKHMBMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PARJXKHMBMX et) {
        return (!ObjectUtils.isEmpty(et.getParjxkhmbmxid()))&&(!Objects.isNull(this.getById(et.getParjxkhmbmxid())));
    }

    @Override
    public PARJXKHMBMX getDraft(PARJXKHMBMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PARJXKHMBMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxkhmbmxid",et.getParjxkhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxkhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARJXKHMBMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PARJXKHMBMX get(String key) {
        PARJXKHMBMX et = getById(key);
        if(et==null){
            et=new PARJXKHMBMX();
            et.setParjxkhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PARJXKHMBMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARJXKHMBMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARJXKHMBMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARJXKHMBMX> list) {
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
    public List<PARJXKHMBMX> selectByParjxkhmbid(String parjxkhmbid) {
        return baseMapper.selectByParjxkhmbid(parjxkhmbid);
    }

    @Override
    public void removeByParjxkhmbid(String parjxkhmbid) {
        this.remove(new QueryWrapper<PARJXKHMBMX>().eq("parjxkhmbid",parjxkhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARJXKHMBMX> searchDefault(PARJXKHMBMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJXKHMBMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJXKHMBMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARJXKHMBMX et){
        //实体关系[DER1N_PARJXKHMBMX_PARJXKHMB_PARJXKHMBID]
        if(!ObjectUtils.isEmpty(et.getParjxkhmbid())){
            cn.ibizlab.ehr.core.par.domain.PARJXKHMB parjxkhmb=et.getParjxkhmb();
            if(ObjectUtils.isEmpty(parjxkhmb)){
                cn.ibizlab.ehr.core.par.domain.PARJXKHMB majorEntity=parjxkhmbService.get(et.getParjxkhmbid());
                et.setParjxkhmb(majorEntity);
                parjxkhmb=majorEntity;
            }
            et.setParjxkhmbname(parjxkhmb.getParjxkhmbname());
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


