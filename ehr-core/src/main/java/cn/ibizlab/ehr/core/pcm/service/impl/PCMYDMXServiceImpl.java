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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDMXServiceImpl")
public class PCMYDMXServiceImpl extends ServiceImpl<PCMYDMXMapper, PCMYDMX> implements IPCMYDMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMYDMXFillPersonInfoLogic fillpersoninfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PCMYDMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMYDMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMYDMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMYDMX fillPersonInfo(PCMYDMX et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    public boolean checkKey(PCMYDMX et) {
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
    public boolean update(PCMYDMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydmxid",et.getPcmydmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PCMYDMX getDraft(PCMYDMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PCMYDMX get(String key) {
        PCMYDMX et = getById(key);
        if(et==null){
            et=new PCMYDMX();
            et.setPcmydmxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PCMYDMX> selectByBmid(String orgsectorid) {
        return baseMapper.selectByBmid(orgsectorid);
    }

    @Override
    public void removeByBmid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMYDMX>().eq("bmid",orgsectorid));
    }

	@Override
    public List<PCMYDMX> selectByZzid(String orgid) {
        return baseMapper.selectByZzid(orgid);
    }

    @Override
    public void removeByZzid(String orgid) {
        this.remove(new QueryWrapper<PCMYDMX>().eq("zzid",orgid));
    }

	@Override
    public List<PCMYDMX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMYDMX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 IndexDER
     */
    @Override
    public Page<PCMYDMX> searchIndexDER(PCMYDMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDMX> pages=baseMapper.searchIndexDER(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDMX> searchDefault(PCMYDMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMYDMX et){
        //实体关系[DER1N_PCMYDMX_ORMORGSECTOR_BMID]
        if(!ObjectUtils.isEmpty(et.getBmid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ssbm=et.getSsbm();
            if(ObjectUtils.isEmpty(ssbm)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getBmid());
                et.setSsbm(majorEntity);
                ssbm=majorEntity;
            }
            et.setShortname(ssbm.getShortname());
            et.setBm(ssbm.getShortname());
        }
        //实体关系[DER1N_PCMYDMX_ORMORG_ZZID]
        if(!ObjectUtils.isEmpty(et.getZzid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG sszz=et.getSszz();
            if(ObjectUtils.isEmpty(sszz)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getZzid());
                et.setSszz(majorEntity);
                sszz=majorEntity;
            }
            et.setZzdzs(sszz.getZzdzs());
            et.setZz(sszz.getZzdzs());
        }
        //实体关系[DER1N_PCMYDMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


