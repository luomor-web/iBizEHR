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
import cn.ibizlab.ehr.core.trm.domain.TRMTRIANPERSON;
import cn.ibizlab.ehr.core.trm.filter.TRMTRIANPERSONSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRIANPERSONService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRIANPERSONMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训记录] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRIANPERSONServiceImpl")
public class TRMTRIANPERSONServiceImpl extends ServiceImpl<TRMTRIANPERSONMapper, TRMTRIANPERSON> implements ITRMTRIANPERSONService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService trmtrainplantermService;

    private int batchSize = 500;

    @Override
    public TRMTRIANPERSON getDraft(TRMTRIANPERSON et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(TRMTRIANPERSON et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRIANPERSON et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMTRIANPERSON> list) {
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
    public boolean checkKey(TRMTRIANPERSON et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrianpersonid()))&&(!Objects.isNull(this.getById(et.getTrmtrianpersonid())));
    }

    @Override
    @Transactional
    public boolean create(TRMTRIANPERSON et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrianpersonid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRIANPERSON> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMTRIANPERSON get(String key) {
        TRMTRIANPERSON et = getById(key);
        if(et==null){
            et=new TRMTRIANPERSON();
            et.setTrmtrianpersonid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TRMTRIANPERSON et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrianpersonid",et.getTrmtrianpersonid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrianpersonid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRIANPERSON> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<TRMTRIANPERSON> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMTRIANPERSON>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TRMTRIANPERSON> selectByTrmtrainplantermid(String trmtrainplantermid) {
        return baseMapper.selectByTrmtrainplantermid(trmtrainplantermid);
    }

    @Override
    public void removeByTrmtrainplantermid(String trmtrainplantermid) {
        this.remove(new QueryWrapper<TRMTRIANPERSON>().eq("trmtrainplantermid",trmtrainplantermid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRIANPERSON> searchDefault(TRMTRIANPERSONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRIANPERSON> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRIANPERSON>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRIANPERSON et){
        //实体关系[DER1N_TRMTRIANPERSON_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setZw(pimperson.getZw());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setLxdh(pimperson.getLxdh());
            et.setZz(pimperson.getOrmorgname());
            et.setXb(pimperson.getXb());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
            et.setNj(pimperson.getNj());
        }
        //实体关系[DER1N_TRMTRIANPERSON_TRMTRAINPLANTERM_TRMTRAINPLANTERMID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplantermid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM trmtrainplanterm=et.getTrmtrainplanterm();
            if(ObjectUtils.isEmpty(trmtrainplanterm)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM majorEntity=trmtrainplantermService.get(et.getTrmtrainplantermid());
                et.setTrmtrainplanterm(majorEntity);
                trmtrainplanterm=majorEntity;
            }
            et.setJhxbm(trmtrainplanterm.getJhxbm());
            et.setPxjssj(trmtrainplanterm.getPxjssj());
            et.setTrmtrainteachername(trmtrainplanterm.getTrmtrainteachername());
            et.setTrmtrainagencyname(trmtrainplanterm.getTrmtrainagencyname());
            et.setTrmtraincoursename(trmtrainplanterm.getTrmtraincoursename());
            et.setBzr(trmtrainplanterm.getBzr());
            et.setTrmtrainplantermname(trmtrainplanterm.getTrmtrainplantermname());
            et.setPxkssj(trmtrainplanterm.getPxkssj());
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


