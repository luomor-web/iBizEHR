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
import cn.ibizlab.ehr.core.par.domain.ParJgbmpjbz;
import cn.ibizlab.ehr.core.par.filter.ParJgbmpjbzSearchContext;
import cn.ibizlab.ehr.core.par.service.IParJgbmpjbzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParJgbmpjbzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门评级标准] 服务对象接口实现
 */
@Slf4j
@Service("ParJgbmpjbzServiceImpl")
public class ParJgbmpjbzServiceImpl extends ServiceImpl<ParJgbmpjbzMapper, ParJgbmpjbz> implements IParJgbmpjbzService {


    private cn.ibizlab.ehr.core.par.service.IParJgbmpjbzService parjgbmpjbzService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(ParJgbmpjbz et) {
        return (!ObjectUtils.isEmpty(et.getParjgbmpjbzid()))&&(!Objects.isNull(this.getById(et.getParjgbmpjbzid())));
    }
    @Override
    @Transactional
    public ParJgbmpjbz get(String key) {
        ParJgbmpjbz et = getById(key);
        if(et==null){
            et=new ParJgbmpjbz();
            et.setParjgbmpjbzid(key);
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
    @Transactional
    public boolean create(ParJgbmpjbz et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjgbmpjbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParJgbmpjbz> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ParJgbmpjbz et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjgbmpjbzid",et.getParjgbmpjbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjgbmpjbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParJgbmpjbz> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ParJgbmpjbz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParJgbmpjbz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParJgbmpjbz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParJgbmpjbz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ParJgbmpjbz getDraft(ParJgbmpjbz et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<ParJgbmpjbz> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<ParJgbmpjbz>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<ParJgbmpjbz> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<ParJgbmpjbz>().eq("ormorgid",orgid));
    }

	@Override
    public List<ParJgbmpjbz> selectByPjbzid(String parjgbmpjbzid) {
        return baseMapper.selectByPjbzid(parjgbmpjbzid);
    }

    @Override
    public void removeByPjbzid(String parjgbmpjbzid) {
        this.remove(new QueryWrapper<ParJgbmpjbz>().eq("pjbzid",parjgbmpjbzid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParJgbmpjbz> searchDefault(ParJgbmpjbzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParJgbmpjbz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParJgbmpjbz>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParJgbmpjbz et){
        //实体关系[DER1N_PARJGBMPJBZ_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PARJGBMPJBZ_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PARJGBMPJBZ_PARJGBMPJBZ_PJBZID]
        if(!ObjectUtils.isEmpty(et.getPjbzid())){
            cn.ibizlab.ehr.core.par.domain.ParJgbmpjbz pjbz=et.getPjbz();
            if(ObjectUtils.isEmpty(pjbz)){
                cn.ibizlab.ehr.core.par.domain.ParJgbmpjbz majorEntity=parjgbmpjbzService.get(et.getPjbzid());
                et.setPjbz(majorEntity);
                pjbz=majorEntity;
            }
            et.setPjbzmc(pjbz.getParjgbmpjbzname());
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
    public List<ParJgbmpjbz> getParjgbmpjbzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParJgbmpjbz> getParjgbmpjbzByEntities(List<ParJgbmpjbz> entities) {
        List ids =new ArrayList();
        for(ParJgbmpjbz entity : entities){
            Serializable id=entity.getParjgbmpjbzid();
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



