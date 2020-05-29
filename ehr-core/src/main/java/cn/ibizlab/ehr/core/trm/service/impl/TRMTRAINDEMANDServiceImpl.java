package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMAND;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDEMANDSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINDEMANDService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINDEMANDMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门需求汇总] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINDEMANDServiceImpl")
public class TRMTRAINDEMANDServiceImpl extends ServiceImpl<TRMTRAINDEMANDMapper, TRMTRAINDEMAND> implements ITRMTRAINDEMANDService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainDemandSumService trmtraindemandsumService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

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
    public boolean update(TRMTRAINDEMAND et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtraindemandid",et.getTrmtraindemandid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraindemandid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINDEMAND> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TRMTRAINDEMAND et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINDEMAND et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMTRAINDEMAND> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMTRAINDEMAND> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMTRAINDEMAND et) {
        return (!ObjectUtils.isEmpty(et.getTrmtraindemandid()))&&(!Objects.isNull(this.getById(et.getTrmtraindemandid())));
    }

    @Override
    public TRMTRAINDEMAND getDraft(TRMTRAINDEMAND et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINDEMAND et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraindemandid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINDEMAND> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMTRAINDEMAND get(String key) {
        TRMTRAINDEMAND et = getById(key);
        if(et==null){
            et=new TRMTRAINDEMAND();
            et.setTrmtraindemandid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<TRMTRAINDEMAND> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMTRAINDEMAND>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINDEMAND> searchDefault(TRMTRAINDEMANDSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINDEMAND> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINDEMAND>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINDEMAND et){
        //实体关系[DER1N_TRMTRAINDEMAND_ORMORG_ORMORGID]
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
    public List<TRMTRAINDEMAND> getTrmtraindemandByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMTRAINDEMAND> getTrmtraindemandByEntities(List<TRMTRAINDEMAND> entities) {
        List ids =new ArrayList();
        for(TRMTRAINDEMAND entity : entities){
            Serializable id=entity.getTrmtraindemandid();
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


