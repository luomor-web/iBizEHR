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
import cn.ibizlab.ehr.core.par.domain.PARJXZGPCMX;
import cn.ibizlab.ehr.core.par.filter.PARJXZGPCMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARJXZGPCMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARJXZGPCMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效主观评测明细] 服务对象接口实现
 */
@Slf4j
@Service("PARJXZGPCMXServiceImpl")
public class PARJXZGPCMXServiceImpl extends ServiceImpl<PARJXZGPCMXMapper, PARJXZGPCMX> implements IPARJXZGPCMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXZGPCService parjxzgpcService;

    private int batchSize = 500;

    @Override
    public PARJXZGPCMX getDraft(PARJXZGPCMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PARJXZGPCMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxzgpcmxid",et.getParjxzgpcmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxzgpcmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARJXZGPCMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARJXZGPCMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARJXZGPCMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARJXZGPCMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARJXZGPCMX> list) {
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
    public boolean create(PARJXZGPCMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxzgpcmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARJXZGPCMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PARJXZGPCMX get(String key) {
        PARJXZGPCMX et = getById(key);
        if(et==null){
            et=new PARJXZGPCMX();
            et.setParjxzgpcmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PARJXZGPCMX et) {
        return (!ObjectUtils.isEmpty(et.getParjxzgpcmxid()))&&(!Objects.isNull(this.getById(et.getParjxzgpcmxid())));
    }


	@Override
    public List<PARJXZGPCMX> selectByParjxzgpcid(String parjxzgpcid) {
        return baseMapper.selectByParjxzgpcid(parjxzgpcid);
    }

    @Override
    public void removeByParjxzgpcid(String parjxzgpcid) {
        this.remove(new QueryWrapper<PARJXZGPCMX>().eq("parjxzgpcid",parjxzgpcid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARJXZGPCMX> searchDefault(PARJXZGPCMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJXZGPCMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJXZGPCMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARJXZGPCMX et){
        //实体关系[DER1N_PARJXZGPCMX_PARJXZGPC_PARJXZGPCID]
        if(!ObjectUtils.isEmpty(et.getParjxzgpcid())){
            cn.ibizlab.ehr.core.par.domain.PARJXZGPC parjxzgpc=et.getParjxzgpc();
            if(ObjectUtils.isEmpty(parjxzgpc)){
                cn.ibizlab.ehr.core.par.domain.PARJXZGPC majorEntity=parjxzgpcService.get(et.getParjxzgpcid());
                et.setParjxzgpc(majorEntity);
                parjxzgpc=majorEntity;
            }
            et.setParjxzgpcname(parjxzgpc.getParjxzgpcname());
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


