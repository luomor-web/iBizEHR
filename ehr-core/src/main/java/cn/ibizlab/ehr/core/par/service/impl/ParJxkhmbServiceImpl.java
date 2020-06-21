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
import cn.ibizlab.ehr.core.par.domain.ParJxkhmb;
import cn.ibizlab.ehr.core.par.filter.ParJxkhmbSearchContext;
import cn.ibizlab.ehr.core.par.service.IParJxkhmbService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParJxkhmbMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效模板] 服务对象接口实现
 */
@Slf4j
@Service("ParJxkhmbServiceImpl")
public class ParJxkhmbServiceImpl extends ServiceImpl<ParJxkhmbMapper, ParJxkhmb> implements IParJxkhmbService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJxkhmbmxService parjxkhmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(ParJxkhmb et) {
        return (!ObjectUtils.isEmpty(et.getParjxkhmbid()))&&(!Objects.isNull(this.getById(et.getParjxkhmbid())));
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
    public ParJxkhmb get(String key) {
        ParJxkhmb et = getById(key);
        if(et==null){
            et=new ParJxkhmb();
            et.setParjxkhmbid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParJxkhmb et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxkhmbid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParJxkhmb> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public ParJxkhmb getDraft(ParJxkhmb et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(ParJxkhmb et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParJxkhmb et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParJxkhmb> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParJxkhmb> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ParJxkhmb et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxkhmbid",et.getParjxkhmbid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxkhmbid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParJxkhmb> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<ParJxkhmb> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<ParJxkhmb>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParJxkhmb> searchDefault(ParJxkhmbSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParJxkhmb> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParJxkhmb>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParJxkhmb et){
        //实体关系[DER1N_PARJXKHMB_ORMORG_ORMORGID]
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
    public List<ParJxkhmb> getParjxkhmbByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParJxkhmb> getParjxkhmbByEntities(List<ParJxkhmb> entities) {
        List ids =new ArrayList();
        for(ParJxkhmb entity : entities){
            Serializable id=entity.getParjxkhmbid();
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



