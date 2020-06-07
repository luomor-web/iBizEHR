package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.ParXmbpjbz;
import cn.ibizlab.ehr.core.par.filter.ParXmbpjbzSearchContext;
import cn.ibizlab.ehr.core.par.service.IParXmbpjbzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParXmbpjbzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目部评级标准] 服务对象接口实现
 */
@Slf4j
@Service("ParXmbpjbzServiceImpl")
public class ParXmbpjbzServiceImpl extends ServiceImpl<ParXmbpjbzMapper, ParXmbpjbz> implements IParXmbpjbzService {


    private cn.ibizlab.ehr.core.par.service.IParXmbpjbzService parxmbpjbzService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public ParXmbpjbz get(String key) {
        ParXmbpjbz et = getById(key);
        if(et==null){
            et=new ParXmbpjbz();
            et.setParxmbpjbzid(key);
        }
        else{
        }
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
    public boolean checkKey(ParXmbpjbz et) {
        return (!ObjectUtils.isEmpty(et.getParxmbpjbzid()))&&(!Objects.isNull(this.getById(et.getParxmbpjbzid())));
    }

    @Override
    @Transactional
    public boolean update(ParXmbpjbz et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parxmbpjbzid",et.getParxmbpjbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getParxmbpjbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParXmbpjbz> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ParXmbpjbz et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParxmbpjbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParXmbpjbz> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ParXmbpjbz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParXmbpjbz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParXmbpjbz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParXmbpjbz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ParXmbpjbz getDraft(ParXmbpjbz et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<ParXmbpjbz> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<ParXmbpjbz>().eq("ormorgid",orgid));
    }

	@Override
    public List<ParXmbpjbz> selectByXmbpjbzid(String parxmbpjbzid) {
        return baseMapper.selectByXmbpjbzid(parxmbpjbzid);
    }

    @Override
    public void removeByXmbpjbzid(String parxmbpjbzid) {
        this.remove(new QueryWrapper<ParXmbpjbz>().eq("xmbpjbzid",parxmbpjbzid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParXmbpjbz> searchDefault(ParXmbpjbzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParXmbpjbz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParXmbpjbz>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParXmbpjbz et){
        //实体关系[DER1N_PARXMBPJBZ_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PARXMBPJBZ_PARXMBPJBZ_XMBPJBZID]
        if(!ObjectUtils.isEmpty(et.getXmbpjbzid())){
            cn.ibizlab.ehr.core.par.domain.ParXmbpjbz parxmbpjbz=et.getParxmbpjbz();
            if(ObjectUtils.isEmpty(parxmbpjbz)){
                cn.ibizlab.ehr.core.par.domain.ParXmbpjbz majorEntity=parxmbpjbzService.get(et.getXmbpjbzid());
                et.setParxmbpjbz(majorEntity);
                parxmbpjbz=majorEntity;
            }
            et.setXmbpjbzmc(parxmbpjbz.getParxmbpjbzname());
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
    public List<ParXmbpjbz> getParxmbpjbzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParXmbpjbz> getParxmbpjbzByEntities(List<ParXmbpjbz> entities) {
        List ids =new ArrayList();
        for(ParXmbpjbz entity : entities){
            Serializable id=entity.getParxmbpjbzid();
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


