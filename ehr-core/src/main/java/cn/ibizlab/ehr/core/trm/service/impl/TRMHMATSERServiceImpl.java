package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TRMHMATSER;
import cn.ibizlab.ehr.core.trm.filter.TRMHMATSERSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMHMATSERService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMHMATSERMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[班主任] 服务对象接口实现
 */
@Slf4j
@Service("TRMHMATSERServiceImpl")
public class TRMHMATSERServiceImpl extends ServiceImpl<TRMHMATSERMapper, TRMHMATSER> implements ITRMHMATSERService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService;

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
    public boolean save(TRMHMATSER et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMHMATSER et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMHMATSER> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TRMHMATSER et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmhmatserid",et.getTrmhmatserid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmhmatserid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMHMATSER> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TRMHMATSER et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmhmatserid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMHMATSER> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMHMATSER et) {
        return (!ObjectUtils.isEmpty(et.getTrmhmatserid()))&&(!Objects.isNull(this.getById(et.getTrmhmatserid())));
    }

    @Override
    public TRMHMATSER getDraft(TRMHMATSER et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TRMHMATSER get(String key) {
        TRMHMATSER et = getById(key);
        if(et==null){
            et=new TRMHMATSER();
            et.setTrmhmatserid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<TRMHMATSER> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMHMATSER>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMHMATSER> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMHMATSER>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TRMHMATSER> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMHMATSER>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMHMATSER> searchDefault(TRMHMATSERSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMHMATSER> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMHMATSER>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMHMATSER et){
        //实体关系[DER1N_TRMHMATSER_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMHMATSER_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setLxdh(pimperson.getLxdh());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setZjhm(pimperson.getZjhm());
            et.setXb(pimperson.getXb());
            et.setNj(pimperson.getNj());
        }
        //实体关系[DER1N_TRMHMATSER_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
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

