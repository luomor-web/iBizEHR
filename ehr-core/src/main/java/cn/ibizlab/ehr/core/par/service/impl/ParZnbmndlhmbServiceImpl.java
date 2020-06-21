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
import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmb;
import cn.ibizlab.ehr.core.par.filter.ParZnbmndlhmbSearchContext;
import cn.ibizlab.ehr.core.par.service.IParZnbmndlhmbService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParZnbmndlhmbMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标（职能部门级）] 服务对象接口实现
 */
@Slf4j
@Service("ParZnbmndlhmbServiceImpl")
public class ParZnbmndlhmbServiceImpl extends ServiceImpl<ParZnbmndlhmbMapper, ParZnbmndlhmb> implements IParZnbmndlhmbService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParZnbmndlhmbmxService parznbmndlhmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(ParZnbmndlhmb et) {
        return (!ObjectUtils.isEmpty(et.getParznbmndlhmbid()))&&(!Objects.isNull(this.getById(et.getParznbmndlhmbid())));
    }
    @Override
    @Transactional
    public boolean save(ParZnbmndlhmb et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParZnbmndlhmb et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParZnbmndlhmb> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParZnbmndlhmb> list) {
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
    public boolean update(ParZnbmndlhmb et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parznbmndlhmbid",et.getParznbmndlhmbid())))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParZnbmndlhmb> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public ParZnbmndlhmb getDraft(ParZnbmndlhmb et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ParZnbmndlhmb get(String key) {
        ParZnbmndlhmb et = getById(key);
        if(et==null){
            et=new ParZnbmndlhmb();
            et.setParznbmndlhmbid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParZnbmndlhmb et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParznbmndlhmbid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParZnbmndlhmb> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<ParZnbmndlhmb> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<ParZnbmndlhmb>().eq("ormorgsectorid",orgsectorid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParZnbmndlhmb> searchDefault(ParZnbmndlhmbSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParZnbmndlhmb> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParZnbmndlhmb>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParZnbmndlhmb et){
        //实体关系[DER1N_PARZNBMNDLHMB_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
            et.setSsorg(ormorgsector.getOrgname());
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
    public List<ParZnbmndlhmb> getParznbmndlhmbByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParZnbmndlhmb> getParznbmndlhmbByEntities(List<ParZnbmndlhmb> entities) {
        List ids =new ArrayList();
        for(ParZnbmndlhmb entity : entities){
            Serializable id=entity.getParznbmndlhmbid();
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



