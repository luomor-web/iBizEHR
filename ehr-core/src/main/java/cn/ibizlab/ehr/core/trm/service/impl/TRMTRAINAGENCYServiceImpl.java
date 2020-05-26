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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINAGENCYSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINAGENCYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训机构] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINAGENCYServiceImpl")
public class TRMTRAINAGENCYServiceImpl extends ServiceImpl<TRMTRAINAGENCYMapper, TRMTRAINAGENCY> implements ITRMTRAINAGENCYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMAGENCYRECORDService trmagencyrecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOURSESYSTEMService trmcoursesystemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEPARTNEEDSService trmdepartneedsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMEMPLOYRETIONService trmemployretionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMHMATSERService trmhmatserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMINVOICEService trminvoiceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMSTAFFNODESService trmstaffnodesService;

    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINDATAService trmtraindataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TRMTRAINAGENCY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINAGENCY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMTRAINAGENCY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMTRAINAGENCY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMTRAINAGENCY et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainagencyid()))&&(!Objects.isNull(this.getById(et.getTrmtrainagencyid())));
    }

    @Override
    public TRMTRAINAGENCY getDraft(TRMTRAINAGENCY et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TRMTRAINAGENCY get(String key) {
        TRMTRAINAGENCY et = getById(key);
        if(et==null){
            et=new TRMTRAINAGENCY();
            et.setTrmtrainagencyid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TRMTRAINAGENCY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainagencyid",et.getTrmtrainagencyid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainagencyid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINAGENCY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINAGENCY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainagencyid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINAGENCY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public List<TRMTRAINAGENCY> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMTRAINAGENCY>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMTRAINAGENCY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMTRAINAGENCY>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TRMTRAINAGENCY> selectByTrmtrainagencyid2(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid2(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid2(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMTRAINAGENCY>().eq("trmtrainagencyid2",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINAGENCY> searchDefault(TRMTRAINAGENCYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINAGENCY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINAGENCY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINAGENCY et){
        //实体关系[DER1N_TRMTRAINAGENCY_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMTRAINAGENCY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setLxdh(pimperson.getLxdh());
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_TRMTRAINAGENCY_TRMTRAINAGENCY_TRMTRAINAGENCYID2]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid2())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY trmtrainagency2=et.getTrmtrainagency2();
            if(ObjectUtils.isEmpty(trmtrainagency2)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid2());
                et.setTrmtrainagency2(majorEntity);
                trmtrainagency2=majorEntity;
            }
            et.setTrmtrainagencyname2(trmtrainagency2.getTrmtrainagencyname());
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


