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
import cn.ibizlab.ehr.core.trm.domain.TrmStaff;
import cn.ibizlab.ehr.core.trm.filter.TrmStaffSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmStaffService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmStaffMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[员工需求填报] 服务对象接口实现
 */
@Slf4j
@Service("TrmStaffServiceImpl")
public class TrmStaffServiceImpl extends ServiceImpl<TrmStaffMapper, TrmStaff> implements ITrmStaffService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmStaffnodesService trmstaffnodesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

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
    public boolean checkKey(TrmStaff et) {
        return (!ObjectUtils.isEmpty(et.getTrmstaffid()))&&(!Objects.isNull(this.getById(et.getTrmstaffid())));
    }
    @Override
    @Transactional
    public boolean update(TrmStaff et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmstaffid",et.getTrmstaffid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstaffid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmStaff> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TrmStaff et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstaffid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmStaff> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public TrmStaff getDraft(TrmStaff et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TrmStaff get(String key) {
        TrmStaff et = getById(key);
        if(et==null){
            et=new TrmStaff();
            et.setTrmstaffid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(TrmStaff et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmStaff et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmStaff> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmStaff> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<TrmStaff> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TrmStaff>().eq("ormorgid",orgid));
    }

	@Override
    public List<TrmStaff> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TrmStaff>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TrmStaff> selectByPimpersonid2(String pimpersonid) {
        return baseMapper.selectByPimpersonid2(pimpersonid);
    }

    @Override
    public void removeByPimpersonid2(String pimpersonid) {
        this.remove(new QueryWrapper<TrmStaff>().eq("pimpersonid2",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmStaff> searchDefault(TrmStaffSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmStaff> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmStaff>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmStaff et){
        //实体关系[DER1N_TRMSTAFF_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMSTAFF_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setZz(pimperson.getOrmorgname());
        }
        //实体关系[DER1N_TRMSTAFF_PIMPERSON_PIMPERSONID2]
        if(!ObjectUtils.isEmpty(et.getPimpersonid2())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson2=et.getPimperson2();
            if(ObjectUtils.isEmpty(pimperson2)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid2());
                et.setPimperson2(majorEntity);
                pimperson2=majorEntity;
            }
            et.setPimpersonname2(pimperson2.getPimpersonname());
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
    public List<TrmStaff> getTrmstaffByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmStaff> getTrmstaffByEntities(List<TrmStaff> entities) {
        List ids =new ArrayList();
        for(TrmStaff entity : entities){
            Serializable id=entity.getTrmstaffid();
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



