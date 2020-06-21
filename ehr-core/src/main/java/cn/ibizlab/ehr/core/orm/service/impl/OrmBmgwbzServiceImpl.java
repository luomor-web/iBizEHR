package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmBmgwbz;
import cn.ibizlab.ehr.core.orm.filter.OrmBmgwbzSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmBmgwbzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmBmgwbzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门岗位编制] 服务对象接口实现
 */
@Slf4j
@Service("OrmBmgwbzServiceImpl")
public class OrmBmgwbzServiceImpl extends ServiceImpl<OrmBmgwbzMapper, OrmBmgwbz> implements IOrmBmgwbzService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(OrmBmgwbz et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmbmgwbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmBmgwbz> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(OrmBmgwbz et) {
        return (!ObjectUtils.isEmpty(et.getOrmbmgwbzid()))&&(!Objects.isNull(this.getById(et.getOrmbmgwbzid())));
    }
    @Override
    @Transactional
    public OrmBmgwbz get(String key) {
        OrmBmgwbz et = getById(key);
        if(et==null){
            et=new OrmBmgwbz();
            et.setOrmbmgwbzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmBmgwbz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmBmgwbz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmBmgwbz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmBmgwbz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(OrmBmgwbz et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormbmgwbzid",et.getOrmbmgwbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmbmgwbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmBmgwbz> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public OrmBmgwbz getDraft(OrmBmgwbz et) {
        fillParentData(et);
        return et;
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
    public List<OrmBmgwbz> selectByOrmgwbzid(String orgsectorid) {
        return baseMapper.selectByOrmgwbzid(orgsectorid);
    }

    @Override
    public void removeByOrmgwbzid(String orgsectorid) {
        this.remove(new QueryWrapper<OrmBmgwbz>().eq("ormgwbzid",orgsectorid));
    }

	@Override
    public List<OrmBmgwbz> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<OrmBmgwbz>().eq("ormpostid",ormpostid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmBmgwbz> searchDefault(OrmBmgwbzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmBmgwbz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmBmgwbz>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmBmgwbz et){
        //实体关系[DER1N_ORMBMGWBZ_ORMORGSECTOR_ORMGWBZID]
        if(!ObjectUtils.isEmpty(et.getOrmgwbzid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormgwbz=et.getOrmgwbz();
            if(ObjectUtils.isEmpty(ormgwbz)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmgwbzid());
                et.setOrmgwbz(majorEntity);
                ormgwbz=majorEntity;
            }
            et.setOrmgwbzmc(ormgwbz.getOrgsectorname());
        }
        //实体关系[DER1N_ORMBMGWBZ_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.OrmPost majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
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
    public List<OrmBmgwbz> getOrmbmgwbzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmBmgwbz> getOrmbmgwbzByEntities(List<OrmBmgwbz> entities) {
        List ids =new ArrayList();
        for(OrmBmgwbz entity : entities){
            Serializable id=entity.getOrmbmgwbzid();
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



