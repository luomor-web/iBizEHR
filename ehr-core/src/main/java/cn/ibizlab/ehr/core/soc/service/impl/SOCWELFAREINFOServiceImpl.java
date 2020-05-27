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
import cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFO;
import cn.ibizlab.ehr.core.soc.filter.SOCWELFAREINFOSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISOCWELFAREINFOService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SOCWELFAREINFOMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[个人社保福利] 服务对象接口实现
 */
@Slf4j
@Service("SOCWELFAREINFOServiceImpl")
public class SOCWELFAREINFOServiceImpl extends ServiceImpl<SOCWELFAREINFOMapper, SOCWELFAREINFO> implements ISOCWELFAREINFOService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISOCWELFAREINFOMXService socwelfareinfomxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISOCCOMPANYWELService soccompanywelService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(SOCWELFAREINFO et) {
        return (!ObjectUtils.isEmpty(et.getSocwelfareinfoid()))&&(!Objects.isNull(this.getById(et.getSocwelfareinfoid())));
    }

    @Override
    @Transactional
    public SOCWELFAREINFO getFJSJofPerson(SOCWELFAREINFO et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(SOCWELFAREINFO et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SOCWELFAREINFO et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SOCWELFAREINFO> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SOCWELFAREINFO> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public SOCWELFAREINFO getDraft(SOCWELFAREINFO et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public SOCWELFAREINFO get(String key) {
        SOCWELFAREINFO et = getById(key);
        if(et==null){
            et=new SOCWELFAREINFO();
            et.setSocwelfareinfoid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public SOCWELFAREINFO getCBDofSOCCOMPANYWEL(SOCWELFAREINFO et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(SOCWELFAREINFO et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("socwelfareinfoid",et.getSocwelfareinfoid())))
            return false;
        CachedBeanCopier.copy(get(et.getSocwelfareinfoid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SOCWELFAREINFO> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    public boolean create(SOCWELFAREINFO et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSocwelfareinfoid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SOCWELFAREINFO> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<SOCWELFAREINFO> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<SOCWELFAREINFO>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<SOCWELFAREINFO> selectBySoccompanywelid(String soccompanywelid) {
        return baseMapper.selectBySoccompanywelid(soccompanywelid);
    }

    @Override
    public void removeBySoccompanywelid(String soccompanywelid) {
        this.remove(new QueryWrapper<SOCWELFAREINFO>().eq("soccompanywelid",soccompanywelid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SOCWELFAREINFO> searchDefault(SOCWELFAREINFOSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SOCWELFAREINFO> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SOCWELFAREINFO>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SOCWELFAREINFO et){
        //实体关系[DER1N_SOCWELFAREINFO_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgname(pimperson.getOrmorgname());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setZjhm(pimperson.getZjhm());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setYgbh(pimperson.getYgbh());
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_SOCWELFAREINFO_SOCCOMPANYWEL_SOCCOMPANYWELID]
        if(!ObjectUtils.isEmpty(et.getSoccompanywelid())){
            cn.ibizlab.ehr.core.soc.domain.SOCCOMPANYWEL soccompanywel=et.getSoccompanywel();
            if(ObjectUtils.isEmpty(soccompanywel)){
                cn.ibizlab.ehr.core.soc.domain.SOCCOMPANYWEL majorEntity=soccompanywelService.get(et.getSoccompanywelid());
                et.setSoccompanywel(majorEntity);
                soccompanywel=majorEntity;
            }
            et.setSocselfarebasename(soccompanywel.getSocselfarebasename());
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
    public List<SOCWELFAREINFO> getSocwelfareinfoByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SOCWELFAREINFO> getSocwelfareinfoByEntities(List<SOCWELFAREINFO> entities) {
        List ids =new ArrayList();
        for(SOCWELFAREINFO entity : entities){
            Serializable id=entity.getSocwelfareinfoid();
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


