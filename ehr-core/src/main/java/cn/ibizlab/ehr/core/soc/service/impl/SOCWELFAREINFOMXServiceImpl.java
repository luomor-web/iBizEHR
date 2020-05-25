package cn.ibizlab.ehr.core.soc.service.impl;

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
import cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFOMX;
import cn.ibizlab.ehr.core.soc.filter.SOCWELFAREINFOMXSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISOCWELFAREINFOMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SOCWELFAREINFOMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[个人社保福利明细] 服务对象接口实现
 */
@Slf4j
@Service("SOCWELFAREINFOMXServiceImpl")
public class SOCWELFAREINFOMXServiceImpl extends ServiceImpl<SOCWELFAREINFOMXMapper, SOCWELFAREINFOMX> implements ISOCWELFAREINFOMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISOCSELFAREBASEMXService socselfarebasemxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISOCWELFAREINFOService socwelfareinfoService;

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
    public boolean save(SOCWELFAREINFOMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SOCWELFAREINFOMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SOCWELFAREINFOMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SOCWELFAREINFOMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SOCWELFAREINFOMX et) {
        return (!ObjectUtils.isEmpty(et.getSocwelfareinfomxid()))&&(!Objects.isNull(this.getById(et.getSocwelfareinfomxid())));
    }

    @Override
    public SOCWELFAREINFOMX getDraft(SOCWELFAREINFOMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(SOCWELFAREINFOMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSocwelfareinfomxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SOCWELFAREINFOMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public SOCWELFAREINFOMX get(String key) {
        SOCWELFAREINFOMX et = getById(key);
        if(et==null){
            et=new SOCWELFAREINFOMX();
            et.setSocwelfareinfomxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(SOCWELFAREINFOMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("socwelfareinfomxid",et.getSocwelfareinfomxid())))
            return false;
        CachedBeanCopier.copy(get(et.getSocwelfareinfomxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SOCWELFAREINFOMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<SOCWELFAREINFOMX> selectBySocselfarebasemxid(String socselfarebasemxid) {
        return baseMapper.selectBySocselfarebasemxid(socselfarebasemxid);
    }

    @Override
    public void removeBySocselfarebasemxid(String socselfarebasemxid) {
        this.remove(new QueryWrapper<SOCWELFAREINFOMX>().eq("socselfarebasemxid",socselfarebasemxid));
    }

	@Override
    public List<SOCWELFAREINFOMX> selectBySocwelfareinfoid(String socwelfareinfoid) {
        return baseMapper.selectBySocwelfareinfoid(socwelfareinfoid);
    }

    @Override
    public void removeBySocwelfareinfoid(String socwelfareinfoid) {
        this.remove(new QueryWrapper<SOCWELFAREINFOMX>().eq("socwelfareinfoid",socwelfareinfoid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SOCWELFAREINFOMX> searchDefault(SOCWELFAREINFOMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SOCWELFAREINFOMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SOCWELFAREINFOMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SOCWELFAREINFOMX et){
        //实体关系[DER1N_SOCWELFAREINFOMX_SOCSELFAREBASEMX_SOCSELFAREBASEMXID]
        if(!ObjectUtils.isEmpty(et.getSocselfarebasemxid())){
            cn.ibizlab.ehr.core.soc.domain.SOCSELFAREBASEMX socselfarebasemx=et.getSocselfarebasemx();
            if(ObjectUtils.isEmpty(socselfarebasemx)){
                cn.ibizlab.ehr.core.soc.domain.SOCSELFAREBASEMX majorEntity=socselfarebasemxService.get(et.getSocselfarebasemxid());
                et.setSocselfarebasemx(majorEntity);
                socselfarebasemx=majorEntity;
            }
            et.setSm(socselfarebasemx.getSm());
            et.setDwbl(socselfarebasemx.getDwbl());
            et.setDe(socselfarebasemx.getDe());
            et.setGrbl(socselfarebasemx.getGrbl());
            et.setSbfllx(socselfarebasemx.getSbfllx());
        }
        //实体关系[DER1N_SOCWELFAREINFOMX_SOCWELFAREINFO_SOCWELFAREINFOID]
        if(!ObjectUtils.isEmpty(et.getSocwelfareinfoid())){
            cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFO socwelfareinfo=et.getSocwelfareinfo();
            if(ObjectUtils.isEmpty(socwelfareinfo)){
                cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFO majorEntity=socwelfareinfoService.get(et.getSocwelfareinfoid());
                et.setSocwelfareinfo(majorEntity);
                socwelfareinfo=majorEntity;
            }
            et.setSocwelfareinfoname(socwelfareinfo.getSocwelfareinfoname());
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


