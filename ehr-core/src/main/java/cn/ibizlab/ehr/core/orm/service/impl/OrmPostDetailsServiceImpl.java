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
import cn.ibizlab.ehr.core.orm.domain.OrmPostDetails;
import cn.ibizlab.ehr.core.orm.filter.OrmPostDetailsSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmPostDetailsService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmPostDetailsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[岗位明细] 服务对象接口实现
 */
@Slf4j
@Service("OrmPostDetailsServiceImpl")
public class OrmPostDetailsServiceImpl extends ServiceImpl<OrmPostDetailsMapper, OrmPostDetails> implements IOrmPostDetailsService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostLibService ormpostlibService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(OrmPostDetails et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostdetailsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmPostDetails> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmPostDetails get(String key) {
        OrmPostDetails et = getById(key);
        if(et==null){
            et=new OrmPostDetails();
            et.setOrmpostdetailsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(OrmPostDetails et) {
        return (!ObjectUtils.isEmpty(et.getOrmpostdetailsid()))&&(!Objects.isNull(this.getById(et.getOrmpostdetailsid())));
    }
    @Override
    @Transactional
    public boolean update(OrmPostDetails et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormpostdetailsid",et.getOrmpostdetailsid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostdetailsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmPostDetails> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public OrmPostDetails getDraft(OrmPostDetails et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmPostDetails et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmPostDetails et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmPostDetails> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmPostDetails> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
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
    public List<OrmPostDetails> selectByOrmpostlibid(String ormpostlibid) {
        return baseMapper.selectByOrmpostlibid(ormpostlibid);
    }

    @Override
    public void removeByOrmpostlibid(String ormpostlibid) {
        this.remove(new QueryWrapper<OrmPostDetails>().eq("ormpostlibid",ormpostlibid));
    }

	@Override
    public List<OrmPostDetails> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<OrmPostDetails>().eq("ormpostid",ormpostid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmPostDetails> searchDefault(OrmPostDetailsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmPostDetails> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmPostDetails>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmPostDetails et){
        //实体关系[DER1N_ORMPOSTDETAILS_ORMPOSTLIB_ORMPOSTLIBID]
        if(!ObjectUtils.isEmpty(et.getOrmpostlibid())){
            cn.ibizlab.ehr.core.orm.domain.OrmPostLib ormpostlib=et.getOrmpostlib();
            if(ObjectUtils.isEmpty(ormpostlib)){
                cn.ibizlab.ehr.core.orm.domain.OrmPostLib majorEntity=ormpostlibService.get(et.getOrmpostlibid());
                et.setOrmpostlib(majorEntity);
                ormpostlib=majorEntity;
            }
            et.setGwflag(ormpostlib.getGwflag());
            et.setSugexcyear(ormpostlib.getSugexcyear());
            et.setGwtype(ormpostlib.getGwtype());
            et.setPostnature(ormpostlib.getPostnature());
            et.setMustexcyear(ormpostlib.getMustexcyear());
            et.setOrmpostlibname(ormpostlib.getOrmpostlibname());
            et.setIsconfidential(ormpostlib.getIsconfidential());
        }
        //实体关系[DER1N_ORMPOSTDETAILS_ORMPOST_ORMPOSTID]
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
    public List<OrmPostDetails> getOrmpostdetailsByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmPostDetails> getOrmpostdetailsByEntities(List<OrmPostDetails> entities) {
        List ids =new ArrayList();
        for(OrmPostDetails entity : entities){
            Serializable id=entity.getOrmpostdetailsid();
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



