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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainAddressSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainAddressService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmTrainAddressMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训场地] 服务对象接口实现
 */
@Slf4j
@Service("TrmTrainAddressServiceImpl")
public class TrmTrainAddressServiceImpl extends ServiceImpl<TrmTrainAddressMapper, TrmTrainAddress> implements ITrmTrainAddressService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmStayService trmstayService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTeacherTrainService trmteachertrainService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrafficService trmtrafficService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainFaciesService trmtrainfaciesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TrmTrainAddress et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmTrainAddress et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmTrainAddress> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmTrainAddress> list) {
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
    public TrmTrainAddress getDraft(TrmTrainAddress et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TrmTrainAddress et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainaddressid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmTrainAddress> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TrmTrainAddress et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainaddressid",et.getTrmtrainaddressid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainaddressid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmTrainAddress> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public TrmTrainAddress get(String key) {
        TrmTrainAddress et = getById(key);
        if(et==null){
            et=new TrmTrainAddress();
            et.setTrmtrainaddressid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(TrmTrainAddress et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainaddressid()))&&(!Objects.isNull(this.getById(et.getTrmtrainaddressid())));
    }

	@Override
    public List<TrmTrainAddress> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TrmTrainAddress>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmTrainAddress> searchDefault(TrmTrainAddressSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmTrainAddress> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmTrainAddress>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmTrainAddress et){
        //实体关系[DER1N_TRMTRAINADDRESS_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setShortname(ormorg.getShortname());
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
    public List<TrmTrainAddress> getTrmtrainaddressByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmTrainAddress> getTrmtrainaddressByEntities(List<TrmTrainAddress> entities) {
        List ids =new ArrayList();
        for(TrmTrainAddress entity : entities){
            Serializable id=entity.getTrmtrainaddressid();
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



