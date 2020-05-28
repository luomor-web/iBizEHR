package cn.ibizlab.ehr.core.sal.service.impl;

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
import cn.ibizlab.ehr.core.sal.domain.SALITEMSUB;
import cn.ibizlab.ehr.core.sal.filter.SALITEMSUBSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALITEMSUBService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALITEMSUBMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬要素项维护] 服务对象接口实现
 */
@Slf4j
@Service("SALITEMSUBServiceImpl")
public class SALITEMSUBServiceImpl extends ServiceImpl<SALITEMSUBMapper, SALITEMSUB> implements ISALITEMSUBService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALITEMService salitemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSUBJECTService salsubjectService;

    private int batchSize = 500;

    @Override
    @Transactional
    public SALITEMSUB get(String key) {
        SALITEMSUB et = getById(key);
        if(et==null){
            et=new SALITEMSUB();
            et.setSalitemsubid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(SALITEMSUB et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salitemsubid",et.getSalitemsubid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalitemsubid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALITEMSUB> list) {
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
    public boolean checkKey(SALITEMSUB et) {
        return (!ObjectUtils.isEmpty(et.getSalitemsubid()))&&(!Objects.isNull(this.getById(et.getSalitemsubid())));
    }

    @Override
    @Transactional
    public boolean save(SALITEMSUB et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALITEMSUB et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SALITEMSUB> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SALITEMSUB> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public SALITEMSUB getDraft(SALITEMSUB et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(SALITEMSUB et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalitemsubid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALITEMSUB> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<SALITEMSUB> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<SALITEMSUB>().eq("ormorgid",orgid));
    }

	@Override
    public List<SALITEMSUB> selectBySalitemid(String salitemid) {
        return baseMapper.selectBySalitemid(salitemid);
    }

    @Override
    public void removeBySalitemid(String salitemid) {
        this.remove(new QueryWrapper<SALITEMSUB>().eq("salitemid",salitemid));
    }

	@Override
    public List<SALITEMSUB> selectBySalsubjectid(String salsubjectid) {
        return baseMapper.selectBySalsubjectid(salsubjectid);
    }

    @Override
    public void removeBySalsubjectid(String salsubjectid) {
        this.remove(new QueryWrapper<SALITEMSUB>().eq("salsubjectid",salsubjectid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALITEMSUB> searchDefault(SALITEMSUBSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALITEMSUB> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALITEMSUB>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALITEMSUB et){
        //实体关系[DER1N_SALITEMSUB_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_SALITEMSUB_SALITEM_SALITEMID]
        if(!ObjectUtils.isEmpty(et.getSalitemid())){
            cn.ibizlab.ehr.core.sal.domain.SALITEM salitem=et.getSalitem();
            if(ObjectUtils.isEmpty(salitem)){
                cn.ibizlab.ehr.core.sal.domain.SALITEM majorEntity=salitemService.get(et.getSalitemid());
                et.setSalitem(majorEntity);
                salitem=majorEntity;
            }
            et.setSalitemname(salitem.getSalitemname());
        }
        //实体关系[DER1N_SALITEMSUB_SALSUBJECT_SALSUBJECTID]
        if(!ObjectUtils.isEmpty(et.getSalsubjectid())){
            cn.ibizlab.ehr.core.sal.domain.SALSUBJECT salsubject=et.getSalsubject();
            if(ObjectUtils.isEmpty(salsubject)){
                cn.ibizlab.ehr.core.sal.domain.SALSUBJECT majorEntity=salsubjectService.get(et.getSalsubjectid());
                et.setSalsubject(majorEntity);
                salsubject=majorEntity;
            }
            et.setSalsubjectname(salsubject.getSalsubjectname());
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
    public List<SALITEMSUB> getSalitemsubByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SALITEMSUB> getSalitemsubByEntities(List<SALITEMSUB> entities) {
        List ids =new ArrayList();
        for(SALITEMSUB entity : entities){
            Serializable id=entity.getSalitemsubid();
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


