package cn.ibizlab.ehr.core.vac.service.impl;

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
import cn.ibizlab.ehr.core.vac.domain.VacSystemApplication;
import cn.ibizlab.ehr.core.vac.filter.VacSystemApplicationSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacSystemApplicationService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacSystemApplicationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[制度适用] 服务对象接口实现
 */
@Slf4j
@Service("VacSystemApplicationServiceImpl")
public class VacSystemApplicationServiceImpl extends ServiceImpl<VacSystemApplicationMapper, VacSystemApplication> implements IVacSystemApplicationService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveSystemService vacleavesystemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(VacSystemApplication et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacsystemapplicationid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacSystemApplication> list) {
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
    @Transactional
    public boolean update(VacSystemApplication et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacsystemapplicationid",et.getVacsystemapplicationid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacsystemapplicationid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacSystemApplication> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public VacSystemApplication get(String key) {
        VacSystemApplication et = getById(key);
        if(et==null){
            et=new VacSystemApplication();
            et.setVacsystemapplicationid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(VacSystemApplication et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacSystemApplication et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacSystemApplication> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacSystemApplication> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public VacSystemApplication getDraft(VacSystemApplication et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(VacSystemApplication et) {
        return (!ObjectUtils.isEmpty(et.getVacsystemapplicationid()))&&(!Objects.isNull(this.getById(et.getVacsystemapplicationid())));
    }

	@Override
    public List<VacSystemApplication> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<VacSystemApplication>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<VacSystemApplication> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VacSystemApplication>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<VacSystemApplication> selectByVacleavesystemid(String vacleavesystemid) {
        return baseMapper.selectByVacleavesystemid(vacleavesystemid);
    }

    @Override
    public void removeByVacleavesystemid(String vacleavesystemid) {
        this.remove(new QueryWrapper<VacSystemApplication>().eq("vacleavesystemid",vacleavesystemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacSystemApplication> searchDefault(VacSystemApplicationSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacSystemApplication> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacSystemApplication>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacSystemApplication et){
        //实体关系[DER1N_VACSYSTEMAPPLICATION_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_VACSYSTEMAPPLICATION_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_VACSYSTEMAPPLICATION_VACLEAVESYSTEM_VACLEAVESYSTEMID]
        if(!ObjectUtils.isEmpty(et.getVacleavesystemid())){
            cn.ibizlab.ehr.core.vac.domain.VacLeaveSystem vacleavesystem=et.getVacleavesystem();
            if(ObjectUtils.isEmpty(vacleavesystem)){
                cn.ibizlab.ehr.core.vac.domain.VacLeaveSystem majorEntity=vacleavesystemService.get(et.getVacleavesystemid());
                et.setVacleavesystem(majorEntity);
                vacleavesystem=majorEntity;
            }
            et.setVacleavesystemname(vacleavesystem.getVacleavesystemname());
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
    public List<VacSystemApplication> getVacsystemapplicationByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacSystemApplication> getVacsystemapplicationByEntities(List<VacSystemApplication> entities) {
        List ids =new ArrayList();
        for(VacSystemApplication entity : entities){
            Serializable id=entity.getVacsystemapplicationid();
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



