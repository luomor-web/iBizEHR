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
import cn.ibizlab.ehr.core.vac.domain.VacSystemHistory;
import cn.ibizlab.ehr.core.vac.filter.VacSystemHistorySearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacSystemHistoryService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacSystemHistoryMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[制度历史] 服务对象接口实现
 */
@Slf4j
@Service("VacSystemHistoryServiceImpl")
public class VacSystemHistoryServiceImpl extends ServiceImpl<VacSystemHistoryMapper, VacSystemHistory> implements IVacSystemHistoryService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveSystemService vacleavesystemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(VacSystemHistory et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacsystemhistoryid",et.getVacsystemhistoryid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacsystemhistoryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacSystemHistory> list) {
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
    public boolean save(VacSystemHistory et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacSystemHistory et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacSystemHistory> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacSystemHistory> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VacSystemHistory get(String key) {
        VacSystemHistory et = getById(key);
        if(et==null){
            et=new VacSystemHistory();
            et.setVacsystemhistoryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(VacSystemHistory et) {
        return (!ObjectUtils.isEmpty(et.getVacsystemhistoryid()))&&(!Objects.isNull(this.getById(et.getVacsystemhistoryid())));
    }
    @Override
    @Transactional
    public boolean create(VacSystemHistory et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacsystemhistoryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacSystemHistory> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public VacSystemHistory getDraft(VacSystemHistory et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<VacSystemHistory> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VacSystemHistory>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<VacSystemHistory> selectByVacleavesystemid(String vacleavesystemid) {
        return baseMapper.selectByVacleavesystemid(vacleavesystemid);
    }

    @Override
    public void removeByVacleavesystemid(String vacleavesystemid) {
        this.remove(new QueryWrapper<VacSystemHistory>().eq("vacleavesystemid",vacleavesystemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacSystemHistory> searchDefault(VacSystemHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacSystemHistory> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacSystemHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacSystemHistory et){
        //实体关系[DER1N_VACSYSTEMHISTORY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_VACSYSTEMHISTORY_VACLEAVESYSTEM_VACLEAVESYSTEMID]
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
    public List<VacSystemHistory> getVacsystemhistoryByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacSystemHistory> getVacsystemhistoryByEntities(List<VacSystemHistory> entities) {
        List ids =new ArrayList();
        for(VacSystemHistory entity : entities){
            Serializable id=entity.getVacsystemhistoryid();
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



