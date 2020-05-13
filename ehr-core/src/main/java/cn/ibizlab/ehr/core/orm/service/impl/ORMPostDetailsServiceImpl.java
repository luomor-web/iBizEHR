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
import cn.ibizlab.ehr.core.orm.domain.ORMPostDetails;
import cn.ibizlab.ehr.core.orm.filter.ORMPostDetailsSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMPostDetailsService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMPostDetailsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[岗位明细] 服务对象接口实现
 */
@Slf4j
@Service("ORMPostDetailsServiceImpl")
public class ORMPostDetailsServiceImpl extends ServiceImpl<ORMPostDetailsMapper, ORMPostDetails> implements IORMPostDetailsService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPostLibService ormpostlibService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ORMPostDetails et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostdetailsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMPostDetails> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMPostDetails get(String key) {
        ORMPostDetails et = getById(key);
        if(et==null){
            et=new ORMPostDetails();
            et.setOrmpostdetailsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ORMPostDetails et) {
        return (!ObjectUtils.isEmpty(et.getOrmpostdetailsid()))&&(!Objects.isNull(this.getById(et.getOrmpostdetailsid())));
    }

    @Override
    @Transactional
    public boolean update(ORMPostDetails et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormpostdetailsid",et.getOrmpostdetailsid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmpostdetailsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMPostDetails> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public ORMPostDetails getDraft(ORMPostDetails et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMPostDetails et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMPostDetails et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMPostDetails> list) {
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
    public List<ORMPostDetails> selectByOrmpostlibid(String ormpostlibid) {
        return baseMapper.selectByOrmpostlibid(ormpostlibid);
    }

    @Override
    public void removeByOrmpostlibid(String ormpostlibid) {
        this.remove(new QueryWrapper<ORMPostDetails>().eq("ormpostlibid",ormpostlibid));
    }

	@Override
    public List<ORMPostDetails> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<ORMPostDetails>().eq("ormpostid",ormpostid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMPostDetails> searchDefault(ORMPostDetailsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMPostDetails> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMPostDetails>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMPostDetails et){
        //实体关系[DER1N_ORMPOSTDETAILS_ORMPOSTLIB_ORMPOSTLIBID]
        if(!ObjectUtils.isEmpty(et.getOrmpostlibid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPostLib ormpostlib=et.getOrmpostlib();
            if(ObjectUtils.isEmpty(ormpostlib)){
                cn.ibizlab.ehr.core.orm.domain.ORMPostLib majorEntity=ormpostlibService.get(et.getOrmpostlibid());
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

}


