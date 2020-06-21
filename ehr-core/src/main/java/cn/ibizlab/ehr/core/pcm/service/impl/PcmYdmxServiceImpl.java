package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmYdmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmYdmxServiceImpl")
public class PcmYdmxServiceImpl extends ServiceImpl<PcmYdmxMapper, PcmYdmx> implements IPcmYdmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdmxFillPersonInfoLogic fillpersoninfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PcmYdmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmYdmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmYdmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmYdmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmYdmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmYdmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmYdmx fillPersonInfo(PcmYdmx et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    public boolean checkKey(PcmYdmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmydmxid()))&&(!Objects.isNull(this.getById(et.getPcmydmxid())));
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
    public boolean update(PcmYdmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydmxid",et.getPcmydmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmYdmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PcmYdmx getDraft(PcmYdmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmYdmx get(String key) {
        PcmYdmx et = getById(key);
        if(et==null){
            et=new PcmYdmx();
            et.setPcmydmxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PcmYdmx> selectByBmid(String orgsectorid) {
        return baseMapper.selectByBmid(orgsectorid);
    }

    @Override
    public void removeByBmid(String orgsectorid) {
        this.remove(new QueryWrapper<PcmYdmx>().eq("bmid",orgsectorid));
    }

	@Override
    public List<PcmYdmx> selectByZzid(String orgid) {
        return baseMapper.selectByZzid(orgid);
    }

    @Override
    public void removeByZzid(String orgid) {
        this.remove(new QueryWrapper<PcmYdmx>().eq("zzid",orgid));
    }

	@Override
    public List<PcmYdmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmYdmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 IndexDER
     */
    @Override
    public Page<PcmYdmx> searchIndexDER(PcmYdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdmx> pages=baseMapper.searchIndexDER(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmYdmx> searchDefault(PcmYdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmYdmx et){
        //实体关系[DER1N_PCMYDMX_ORMORGSECTOR_BMID]
        if(!ObjectUtils.isEmpty(et.getBmid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ssbm=et.getSsbm();
            if(ObjectUtils.isEmpty(ssbm)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getBmid());
                et.setSsbm(majorEntity);
                ssbm=majorEntity;
            }
            et.setShortname(ssbm.getShortname());
            et.setBm(ssbm.getShortname());
        }
        //实体关系[DER1N_PCMYDMX_ORMORG_ZZID]
        if(!ObjectUtils.isEmpty(et.getZzid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg sszz=et.getSszz();
            if(ObjectUtils.isEmpty(sszz)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getZzid());
                et.setSszz(majorEntity);
                sszz=majorEntity;
            }
            et.setZzdzs(sszz.getZzdzs());
            et.setZz(sszz.getZzdzs());
        }
        //实体关系[DER1N_PCMYDMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
            et.setZjhm(pimperson.getZjhm());
            et.setCsrq(pimperson.getCsrq());
            et.setLxdh(pimperson.getLxdh());
            et.setNl(pimperson.getNl());
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
    public List<PcmYdmx> getPcmydmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmYdmx> getPcmydmxByEntities(List<PcmYdmx> entities) {
        List ids =new ArrayList();
        for(PcmYdmx entity : entities){
            Serializable id=entity.getPcmydmxid();
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



