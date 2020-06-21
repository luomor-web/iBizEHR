package cn.ibizlab.ehr.core.soc.service.impl;

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
import cn.ibizlab.ehr.core.soc.domain.SocSelfareBase;
import cn.ibizlab.ehr.core.soc.filter.SocSelfareBaseSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISocSelfareBaseService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SocSelfareBaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[参保地管理] 服务对象接口实现
 */
@Slf4j
@Service("SocSelfareBaseServiceImpl")
public class SocSelfareBaseServiceImpl extends ServiceImpl<SocSelfareBaseMapper, SocSelfareBase> implements ISocSelfareBaseService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocCompanyWelService soccompanywelService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocSelfarebasemxService socselfarebasemxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    public SocSelfareBase getDraft(SocSelfareBase et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SocSelfareBase et) {
        return (!ObjectUtils.isEmpty(et.getSocselfarebaseid()))&&(!Objects.isNull(this.getById(et.getSocselfarebaseid())));
    }
    @Override
    @Transactional
    public boolean save(SocSelfareBase et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SocSelfareBase et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SocSelfareBase> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SocSelfareBase> list) {
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
    @Transactional
    public boolean create(SocSelfareBase et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSocselfarebaseid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SocSelfareBase> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SocSelfareBase et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("socselfarebaseid",et.getSocselfarebaseid())))
            return false;
        CachedBeanCopier.copy(get(et.getSocselfarebaseid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SocSelfareBase> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public SocSelfareBase get(String key) {
        SocSelfareBase et = getById(key);
        if(et==null){
            et=new SocSelfareBase();
            et.setSocselfarebaseid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<SocSelfareBase> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<SocSelfareBase>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SocSelfareBase> searchDefault(SocSelfareBaseSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SocSelfareBase> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SocSelfareBase>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SocSelfareBase et){
        //实体关系[DER1N_SOCSELFAREBASE_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
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
    public List<SocSelfareBase> getSocselfarebaseByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SocSelfareBase> getSocselfarebaseByEntities(List<SocSelfareBase> entities) {
        List ids =new ArrayList();
        for(SocSelfareBase entity : entities){
            Serializable id=entity.getSocselfarebaseid();
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



