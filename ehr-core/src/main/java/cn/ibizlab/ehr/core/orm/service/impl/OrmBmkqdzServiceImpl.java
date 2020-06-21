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
import cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz;
import cn.ibizlab.ehr.core.orm.filter.OrmBmkqdzSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmBmkqdzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmBmkqdzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门地址维护] 服务对象接口实现
 */
@Slf4j
@Service("OrmBmkqdzServiceImpl")
public class OrmBmkqdzServiceImpl extends ServiceImpl<OrmBmkqdzMapper, OrmBmkqdz> implements IOrmBmkqdzService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordService attendancerecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;

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
    public OrmBmkqdz getDraft(OrmBmkqdz et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(OrmBmkqdz et) {
        return (!ObjectUtils.isEmpty(et.getOrmbmkqdzid()))&&(!Objects.isNull(this.getById(et.getOrmbmkqdzid())));
    }
    @Override
    @Transactional
    public boolean save(OrmBmkqdz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmBmkqdz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmBmkqdz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmBmkqdz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(OrmBmkqdz et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormbmkqdzid",et.getOrmbmkqdzid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmbmkqdzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmBmkqdz> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(OrmBmkqdz et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmbmkqdzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmBmkqdz> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmBmkqdz get(String key) {
        OrmBmkqdz et = getById(key);
        if(et==null){
            et=new OrmBmkqdz();
            et.setOrmbmkqdzid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<OrmBmkqdz> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<OrmBmkqdz>().eq("ormorgsectorid",orgsectorid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmBmkqdz> searchDefault(OrmBmkqdzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmBmkqdz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmBmkqdz>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmBmkqdz et){
        //实体关系[DER1N_ORMBMKQDZ_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
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
    public List<OrmBmkqdz> getOrmbmkqdzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmBmkqdz> getOrmbmkqdzByEntities(List<OrmBmkqdz> entities) {
        List ids =new ArrayList();
        for(OrmBmkqdz entity : entities){
            Serializable id=entity.getOrmbmkqdzid();
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



