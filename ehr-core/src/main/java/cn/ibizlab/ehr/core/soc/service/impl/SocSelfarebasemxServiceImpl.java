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
import cn.ibizlab.ehr.core.soc.domain.SocSelfarebasemx;
import cn.ibizlab.ehr.core.soc.filter.SocSelfarebasemxSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISocSelfarebasemxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SocSelfarebasemxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[社保明细] 服务对象接口实现
 */
@Slf4j
@Service("SocSelfarebasemxServiceImpl")
public class SocSelfarebasemxServiceImpl extends ServiceImpl<SocSelfarebasemxMapper, SocSelfarebasemx> implements ISocSelfarebasemxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocWelfareinfomxService socwelfareinfomxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocCompanyWelService soccompanywelService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocSelfareBaseService socselfarebaseService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(SocSelfarebasemx et) {
        return (!ObjectUtils.isEmpty(et.getSocselfarebasemxid()))&&(!Objects.isNull(this.getById(et.getSocselfarebasemxid())));
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
    public SocSelfarebasemx get(String key) {
        SocSelfarebasemx et = getById(key);
        if(et==null){
            et=new SocSelfarebasemx();
            et.setSocselfarebasemxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SocSelfarebasemx getDraft(SocSelfarebasemx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(SocSelfarebasemx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSocselfarebasemxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SocSelfarebasemx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SocSelfarebasemx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SocSelfarebasemx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SocSelfarebasemx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SocSelfarebasemx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SocSelfarebasemx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("socselfarebasemxid",et.getSocselfarebasemxid())))
            return false;
        CachedBeanCopier.copy(get(et.getSocselfarebasemxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SocSelfarebasemx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<SocSelfarebasemx> selectBySoccompanywelid(String soccompanywelid) {
        return baseMapper.selectBySoccompanywelid(soccompanywelid);
    }

    @Override
    public void removeBySoccompanywelid(String soccompanywelid) {
        this.remove(new QueryWrapper<SocSelfarebasemx>().eq("soccompanywelid",soccompanywelid));
    }

	@Override
    public List<SocSelfarebasemx> selectBySocselfarebaseid(String socselfarebaseid) {
        return baseMapper.selectBySocselfarebaseid(socselfarebaseid);
    }

    @Override
    public void removeBySocselfarebaseid(String socselfarebaseid) {
        this.remove(new QueryWrapper<SocSelfarebasemx>().eq("socselfarebaseid",socselfarebaseid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SocSelfarebasemx> searchDefault(SocSelfarebasemxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SocSelfarebasemx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SocSelfarebasemx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SocSelfarebasemx et){
        //实体关系[DER1N_SOCSELFAREBASEMX_SOCCOMPANYWEL_SOCCOMPANYWELID]
        if(!ObjectUtils.isEmpty(et.getSoccompanywelid())){
            cn.ibizlab.ehr.core.soc.domain.SocCompanyWel soccompanywel=et.getSoccompanywel();
            if(ObjectUtils.isEmpty(soccompanywel)){
                cn.ibizlab.ehr.core.soc.domain.SocCompanyWel majorEntity=soccompanywelService.get(et.getSoccompanywelid());
                et.setSoccompanywel(majorEntity);
                soccompanywel=majorEntity;
            }
            et.setSoccompanywelname(soccompanywel.getSoccompanywelname());
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

    @Override
    public List<SocSelfarebasemx> getSocselfarebasemxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SocSelfarebasemx> getSocselfarebasemxByEntities(List<SocSelfarebasemx> entities) {
        List ids =new ArrayList();
        for(SocSelfarebasemx entity : entities){
            Serializable id=entity.getSocselfarebasemxid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



