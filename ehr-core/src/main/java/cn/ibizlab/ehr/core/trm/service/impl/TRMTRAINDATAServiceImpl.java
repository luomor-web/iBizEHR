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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDATA;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDATASearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINDATAService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINDATAMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训资料] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINDATAServiceImpl")
public class TRMTRAINDATAServiceImpl extends ServiceImpl<TRMTRAINDATAMapper, TRMTRAINDATA> implements ITRMTRAINDATAService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TRMTRAINDATA et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINDATA et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMTRAINDATA> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMTRAINDATA> list) {
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
    public TRMTRAINDATA get(String key) {
        TRMTRAINDATA et = getById(key);
        if(et==null){
            et=new TRMTRAINDATA();
            et.setTrmtraindataid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public TRMTRAINDATA getDraft(TRMTRAINDATA et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(TRMTRAINDATA et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtraindataid",et.getTrmtraindataid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraindataid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINDATA> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMTRAINDATA et) {
        return (!ObjectUtils.isEmpty(et.getTrmtraindataid()))&&(!Objects.isNull(this.getById(et.getTrmtraindataid())));
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINDATA et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraindataid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINDATA> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<TRMTRAINDATA> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMTRAINDATA>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMTRAINDATA> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMTRAINDATA>().eq("trmtrainagencyid",trmtrainagencyid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINDATA> searchDefault(TRMTRAINDATASearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINDATA> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINDATA>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINDATA et){
        //实体关系[DER1N_TRMTRAINDATA_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMTRAINDATA_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
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
    public List<TRMTRAINDATA> getTrmtraindataByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMTRAINDATA> getTrmtraindataByEntities(List<TRMTRAINDATA> entities) {
        List ids =new ArrayList();
        for(TRMTRAINDATA entity : entities){
            Serializable id=entity.getTrmtraindataid();
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


