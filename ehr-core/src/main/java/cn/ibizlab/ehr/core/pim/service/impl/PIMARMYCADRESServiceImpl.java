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
import cn.ibizlab.ehr.core.pim.domain.PIMARMYCADRES;
import cn.ibizlab.ehr.core.pim.filter.PIMARMYCADRESSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMARMYCADRESService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMARMYCADRESMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[军转干部] 服务对象接口实现
 */
@Slf4j
@Service("PIMARMYCADRESServiceImpl")
public class PIMARMYCADRESServiceImpl extends ServiceImpl<PIMARMYCADRESMapper, PIMARMYCADRES> implements IPIMARMYCADRESService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

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
    public PIMARMYCADRES getDraft(PIMARMYCADRES et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PIMARMYCADRES et) {
        return (!ObjectUtils.isEmpty(et.getPimarmycadresid()))&&(!Objects.isNull(this.getById(et.getPimarmycadresid())));
    }

    @Override
    @Transactional
    public boolean create(PIMARMYCADRES et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarmycadresid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMARMYCADRES> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PIMARMYCADRES et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarmycadresid",et.getPimarmycadresid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarmycadresid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMARMYCADRES> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PIMARMYCADRES get(String key) {
        PIMARMYCADRES et = getById(key);
        if(et==null){
            et=new PIMARMYCADRES();
            et.setPimarmycadresid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMARMYCADRES et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMARMYCADRES et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMARMYCADRES> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMARMYCADRES> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PIMARMYCADRES> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMARMYCADRES>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMARMYCADRES> searchDefault(PIMARMYCADRESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARMYCADRES> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARMYCADRES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PIMARMYCADRES> searchJLSSGLY(PIMARMYCADRESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARMYCADRES> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARMYCADRES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PIMARMYCADRES> searchJLSSGR(PIMARMYCADRESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARMYCADRES> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARMYCADRES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMARMYCADRES et){
        //实体关系[DER1N_PIMARMYCADRES_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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
    public List<PIMARMYCADRES> getPimarmycadresByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PIMARMYCADRES> getPimarmycadresByEntities(List<PIMARMYCADRES> entities) {
        List ids =new ArrayList();
        for(PIMARMYCADRES entity : entities){
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


