package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PimArmycadres;
import cn.ibizlab.ehr.core.pim.filter.PimArmycadresSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimArmycadresService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimArmycadresMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[军转干部] 服务对象接口实现
 */
@Slf4j
@Service("PimArmycadresServiceImpl")
public class PimArmycadresServiceImpl extends ServiceImpl<PimArmycadresMapper, PimArmycadres> implements IPimArmycadresService {

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
    public PimArmycadres getDraft(PimArmycadres et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PimArmycadres et) {
        return (!ObjectUtils.isEmpty(et.getPimarmycadresid()))&&(!Objects.isNull(this.getById(et.getPimarmycadresid())));
    }
    @Override
    @Transactional
    public boolean create(PimArmycadres et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarmycadresid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimArmycadres> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PimArmycadres et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarmycadresid",et.getPimarmycadresid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarmycadresid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimArmycadres> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimArmycadres get(String key) {
        PimArmycadres et = getById(key);
        if(et==null){
            et=new PimArmycadres();
            et.setPimarmycadresid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimArmycadres et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimArmycadres et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimArmycadres> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimArmycadres> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PimArmycadres> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimArmycadres>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimArmycadres> searchDefault(PimArmycadresSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArmycadres> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArmycadres>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PimArmycadres> searchJLSSGLY(PimArmycadresSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArmycadres> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArmycadres>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PimArmycadres> searchJLSSGR(PimArmycadresSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArmycadres> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArmycadres>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimArmycadres et){
        //实体关系[DER1N_PIMARMYCADRES_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setYgbh(pimperson.getYgbh());
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
    public List<PimArmycadres> getPimarmycadresByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimArmycadres> getPimarmycadresByEntities(List<PimArmycadres> entities) {
        List ids =new ArrayList();
        for(PimArmycadres entity : entities){
            Serializable id=entity.getPimarmycadresid();
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



