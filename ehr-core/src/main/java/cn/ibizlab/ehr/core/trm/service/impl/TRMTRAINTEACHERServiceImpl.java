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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINTEACHERSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINTEACHERMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训讲师] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINTEACHERServiceImpl")
public class TRMTRAINTEACHERServiceImpl extends ServiceImpl<TRMTRAINTEACHERMapper, TRMTRAINTEACHER> implements ITRMTRAINTEACHERService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTEACHERCHARGEService trmteacherchargeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTEACHERTRAINService trmteachertrainService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService trmtrainplantermService;
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
    public boolean update(TRMTRAINTEACHER et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainteacherid",et.getTrmtrainteacherid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainteacherid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINTEACHER> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public TRMTRAINTEACHER getDraft(TRMTRAINTEACHER et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TRMTRAINTEACHER get(String key) {
        TRMTRAINTEACHER et = getById(key);
        if(et==null){
            et=new TRMTRAINTEACHER();
            et.setTrmtrainteacherid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(TRMTRAINTEACHER et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainteacherid()))&&(!Objects.isNull(this.getById(et.getTrmtrainteacherid())));
    }

    @Override
    @Transactional
    public boolean save(TRMTRAINTEACHER et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINTEACHER et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMTRAINTEACHER> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMTRAINTEACHER> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINTEACHER et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainteacherid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINTEACHER> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<TRMTRAINTEACHER> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMTRAINTEACHER>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMTRAINTEACHER> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMTRAINTEACHER>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TRMTRAINTEACHER> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMTRAINTEACHER>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 内部讲师
     */
    @Override
    public Page<TRMTRAINTEACHER> searchNBJS(TRMTRAINTEACHERSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINTEACHER> pages=baseMapper.searchNBJS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINTEACHER>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 外部讲师
     */
    @Override
    public Page<TRMTRAINTEACHER> searchWBJS(TRMTRAINTEACHERSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINTEACHER> pages=baseMapper.searchWBJS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINTEACHER>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINTEACHER> searchDefault(TRMTRAINTEACHERSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINTEACHER> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINTEACHER>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINTEACHER et){
        //实体关系[DER1N_TRMTRAINTEACHER_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_TRMTRAINTEACHER_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setNl(pimperson.getNl());
            et.setXb(pimperson.getXb());
            et.setZjhm(pimperson.getZjhm());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setLxdh(pimperson.getLxdh());
            et.setZw(pimperson.getZw());
            et.setAhtc(pimperson.getAhtc());
            et.setDzyx(pimperson.getDzyx());
        }
        //实体关系[DER1N_TRMTRAINTEACHER_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
            et.setJglb(trmtrainagency.getJglb());
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


