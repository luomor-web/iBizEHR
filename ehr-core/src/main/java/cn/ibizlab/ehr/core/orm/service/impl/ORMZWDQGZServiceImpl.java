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
import cn.ibizlab.ehr.core.orm.domain.ORMZWDQGZ;
import cn.ibizlab.ehr.core.orm.filter.ORMZWDQGZSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMZWDQGZService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMZWDQGZMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职级到期规则] 服务对象接口实现
 */
@Slf4j
@Service("ORMZWDQGZServiceImpl")
public class ORMZWDQGZServiceImpl extends ServiceImpl<ORMZWDQGZMapper, ORMZWDQGZ> implements IORMZWDQGZService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMRANKService ormrankService;

    private int batchSize = 500;

    @Override
    @Transactional
    public ORMZWDQGZ get(String key) {
        ORMZWDQGZ et = getById(key);
        if(et==null){
            et=new ORMZWDQGZ();
            et.setOrmzwdqgzid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMZWDQGZ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMZWDQGZ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ORMZWDQGZ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ORMZWDQGZ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ORMZWDQGZ et) {
        return (!ObjectUtils.isEmpty(et.getOrmzwdqgzid()))&&(!Objects.isNull(this.getById(et.getOrmzwdqgzid())));
    }

    @Override
    @Transactional
    public boolean update(ORMZWDQGZ et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormzwdqgzid",et.getOrmzwdqgzid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmzwdqgzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMZWDQGZ> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public ORMZWDQGZ getDraft(ORMZWDQGZ et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(ORMZWDQGZ et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmzwdqgzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMZWDQGZ> list) {
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
    public List<ORMZWDQGZ> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<ORMZWDQGZ>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<ORMZWDQGZ> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<ORMZWDQGZ>().eq("ormorgid",orgid));
    }

	@Override
    public List<ORMZWDQGZ> selectByOrmrankid(String ormrankid) {
        return baseMapper.selectByOrmrankid(ormrankid);
    }

    @Override
    public void removeByOrmrankid(String ormrankid) {
        this.remove(new QueryWrapper<ORMZWDQGZ>().eq("ormrankid",ormrankid));
    }


    /**
     * 查询集合 查看当前单位的职级到期规则
     */
    @Override
    public Page<ORMZWDQGZ> searchDQYHZZ(ORMZWDQGZSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMZWDQGZ> pages=baseMapper.searchDQYHZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMZWDQGZ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMZWDQGZ> searchDefault(ORMZWDQGZSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMZWDQGZ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMZWDQGZ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMZWDQGZ et){
        //实体关系[DER1N_ORMZWDQGZ_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setZwbm(ormduty.getFglx());
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_ORMZWDQGZ_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_ORMZWDQGZ_ORMRANK_ORMRANKID]
        if(!ObjectUtils.isEmpty(et.getOrmrankid())){
            cn.ibizlab.ehr.core.orm.domain.ORMRANK ormrank=et.getOrmrank();
            if(ObjectUtils.isEmpty(ormrank)){
                cn.ibizlab.ehr.core.orm.domain.ORMRANK majorEntity=ormrankService.get(et.getOrmrankid());
                et.setOrmrank(majorEntity);
                ormrank=majorEntity;
            }
            et.setOrmrankname(ormrank.getOrmrankname());
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
    public List<ORMZWDQGZ> getOrmzwdqgzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ORMZWDQGZ> getOrmzwdqgzByEntities(List<ORMZWDQGZ> entities) {
        List ids =new ArrayList();
        for(ORMZWDQGZ entity : entities){
            Serializable id=entity.getOrmzwdqgzid();
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


