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
import cn.ibizlab.ehr.core.orm.domain.ORMBMGWBZ;
import cn.ibizlab.ehr.core.orm.filter.ORMBMGWBZSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMBMGWBZService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMBMGWBZMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门岗位编制] 服务对象接口实现
 */
@Slf4j
@Service("ORMBMGWBZServiceImpl")
public class ORMBMGWBZServiceImpl extends ServiceImpl<ORMBMGWBZMapper, ORMBMGWBZ> implements IORMBMGWBZService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ORMBMGWBZ et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmbmgwbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMBMGWBZ> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ORMBMGWBZ et) {
        return (!ObjectUtils.isEmpty(et.getOrmbmgwbzid()))&&(!Objects.isNull(this.getById(et.getOrmbmgwbzid())));
    }

    @Override
    @Transactional
    public ORMBMGWBZ get(String key) {
        ORMBMGWBZ et = getById(key);
        if(et==null){
            et=new ORMBMGWBZ();
            et.setOrmbmgwbzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMBMGWBZ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMBMGWBZ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ORMBMGWBZ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ORMBMGWBZ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ORMBMGWBZ et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormbmgwbzid",et.getOrmbmgwbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmbmgwbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMBMGWBZ> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public ORMBMGWBZ getDraft(ORMBMGWBZ et) {
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
    public List<ORMBMGWBZ> selectByOrmgwbzid(String orgsectorid) {
        return baseMapper.selectByOrmgwbzid(orgsectorid);
    }

    @Override
    public void removeByOrmgwbzid(String orgsectorid) {
        this.remove(new QueryWrapper<ORMBMGWBZ>().eq("ormgwbzid",orgsectorid));
    }

	@Override
    public List<ORMBMGWBZ> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<ORMBMGWBZ>().eq("ormpostid",ormpostid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMBMGWBZ> searchDefault(ORMBMGWBZSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMBMGWBZ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMBMGWBZ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMBMGWBZ et){
        //实体关系[DER1N_ORMBMGWBZ_ORMORGSECTOR_ORMGWBZID]
        if(!ObjectUtils.isEmpty(et.getOrmgwbzid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormgwbz=et.getOrmgwbz();
            if(ObjectUtils.isEmpty(ormgwbz)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmgwbzid());
                et.setOrmgwbz(majorEntity);
                ormgwbz=majorEntity;
            }
            et.setOrmgwbzmc(ormgwbz.getOrgsectorname());
        }
        //实体关系[DER1N_ORMBMGWBZ_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
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
    public List<ORMBMGWBZ> getOrmbmgwbzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ORMBMGWBZ> getOrmbmgwbzByEntities(List<ORMBMGWBZ> entities) {
        List ids =new ArrayList();
        for(ORMBMGWBZ entity : entities){
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


