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
import cn.ibizlab.ehr.core.par.domain.ParLdkhqz;
import cn.ibizlab.ehr.core.par.filter.ParLdkhqzSearchContext;
import cn.ibizlab.ehr.core.par.service.IParLdkhqzService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParLdkhqzMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[评分权重分配] 服务对象接口实现
 */
@Slf4j
@Service("ParLdkhqzServiceImpl")
public class ParLdkhqzServiceImpl extends ServiceImpl<ParLdkhqzMapper, ParLdkhqz> implements IParLdkhqzService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParKhzcmxService parkhzcmxService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(ParLdkhqz et) {
        return (!ObjectUtils.isEmpty(et.getParldkhqzid()))&&(!Objects.isNull(this.getById(et.getParldkhqzid())));
    }
    @Override
    @Transactional
    public boolean create(ParLdkhqz et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParldkhqzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParLdkhqz> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public ParLdkhqz getDraft(ParLdkhqz et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ParLdkhqz get(String key) {
        ParLdkhqz et = getById(key);
        if(et==null){
            et=new ParLdkhqz();
            et.setParldkhqzid(key);
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
    public boolean save(ParLdkhqz et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParLdkhqz et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParLdkhqz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParLdkhqz> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ParLdkhqz et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parldkhqzid",et.getParldkhqzid())))
            return false;
        CachedBeanCopier.copy(get(et.getParldkhqzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParLdkhqz> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<ParLdkhqz> selectByParkhzcmxid(String parkhzcmxid) {
        return baseMapper.selectByParkhzcmxid(parkhzcmxid);
    }

    @Override
    public void removeByParkhzcmxid(String parkhzcmxid) {
        this.remove(new QueryWrapper<ParLdkhqz>().eq("parkhzcmxid",parkhzcmxid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParLdkhqz> searchDefault(ParLdkhqzSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParLdkhqz> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParLdkhqz>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParLdkhqz et){
        //实体关系[DER1N_PARLDKHQZ_PARKHZCMX_PARKHZCMXID]
        if(!ObjectUtils.isEmpty(et.getParkhzcmxid())){
            cn.ibizlab.ehr.core.par.domain.ParKhzcmx parkhzcmx=et.getParkhzcmx();
            if(ObjectUtils.isEmpty(parkhzcmx)){
                cn.ibizlab.ehr.core.par.domain.ParKhzcmx majorEntity=parkhzcmxService.get(et.getParkhzcmxid());
                et.setParkhzcmx(majorEntity);
                parkhzcmx=majorEntity;
            }
            et.setParkhzcmxname(parkhzcmx.getParkhzcmxname());
            et.setKhdx(parkhzcmx.getKhdx());
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
    public List<ParLdkhqz> getParldkhqzByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParLdkhqz> getParldkhqzByEntities(List<ParLdkhqz> entities) {
        List ids =new ArrayList();
        for(ParLdkhqz entity : entities){
            Serializable id=entity.getParldkhqzid();
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



