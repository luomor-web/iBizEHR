package cn.ibizlab.ehr.core.demodel.service.impl;

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
import cn.ibizlab.ehr.core.demodel.domain.DataEntity;
import cn.ibizlab.ehr.core.demodel.filter.DataEntitySearchContext;
import cn.ibizlab.ehr.core.demodel.service.IDataEntityService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.demodel.mapper.DataEntityMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[实体***] 服务对象接口实现
 */
@Slf4j
@Service("DataEntityServiceImpl")
public class DataEntityServiceImpl extends ServiceImpl<DataEntityMapper, DataEntity> implements IDataEntityService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ICodeList1Service codelist1Service;

    private cn.ibizlab.ehr.core.demodel.service.IDataEntityService dataentityService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IDataSyncIn2Service datasyncin2Service;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IDataSyncInService datasyncinService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IDataSyncOut2Service datasyncout2Service;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IDataSyncOutService datasyncoutService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IDEDataChg2Service dedatachg2Service;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IDEDataChgService dedatachgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IMsgTemplateService msgtemplateService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.demodel.service.IQueryModelService querymodelService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataService userroledataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDEFieldService userroledefieldService;

    private int batchSize = 500;

    @Override
    @Transactional
    public DataEntity initUserRoleData(DataEntity et) {
        //自定义代码
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
    public DataEntity getDraft(DataEntity et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public DataEntity get(String key) {
        DataEntity et = getById(key);
        if(et==null){
            et=new DataEntity();
            et.setDeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public DataEntity initAll(DataEntity et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(DataEntity et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getDeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<DataEntity> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(DataEntity et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(DataEntity et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<DataEntity> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(DataEntity et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("deid",et.getDeid())))
            return false;
        CachedBeanCopier.copy(get(et.getDeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<DataEntity> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(DataEntity et) {
        return (!ObjectUtils.isEmpty(et.getDeid()))&&(!Objects.isNull(this.getById(et.getDeid())));
    }


	@Override
    public List<DataEntity> selectByDer11deid(String deid) {
        return baseMapper.selectByDer11deid(deid);
    }

    @Override
    public void removeByDer11deid(String deid) {
        this.remove(new QueryWrapper<DataEntity>().eq("der11deid",deid));
    }

	@Override
    public List<DataEntity> selectByAcquerymodelid(String querymodelid) {
        return baseMapper.selectByAcquerymodelid(querymodelid);
    }

    @Override
    public void removeByAcquerymodelid(String querymodelid) {
        this.remove(new QueryWrapper<DataEntity>().eq("acquerymodelid",querymodelid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DataEntity> searchDefault(DataEntitySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DataEntity> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<DataEntity>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(DataEntity et){
        //实体关系[DER1N_DATAENTITY_DATAENTITY_DER11DEID]
        if(!ObjectUtils.isEmpty(et.getDer11deid())){
            cn.ibizlab.ehr.core.demodel.domain.DataEntity der11de=et.getDer11de();
            if(ObjectUtils.isEmpty(der11de)){
                cn.ibizlab.ehr.core.demodel.domain.DataEntity majorEntity=dataentityService.get(et.getDer11deid());
                et.setDer11de(majorEntity);
                der11de=majorEntity;
            }
            et.setDer11dename(der11de.getDename());
        }
        //实体关系[DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID]
        if(!ObjectUtils.isEmpty(et.getAcquerymodelid())){
            cn.ibizlab.ehr.core.demodel.domain.QueryModel acquerymodel=et.getAcquerymodel();
            if(ObjectUtils.isEmpty(acquerymodel)){
                cn.ibizlab.ehr.core.demodel.domain.QueryModel majorEntity=querymodelService.get(et.getAcquerymodelid());
                et.setAcquerymodel(majorEntity);
                acquerymodel=majorEntity;
            }
            et.setAcquerymodelname(acquerymodel.getQuerymodelname());
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


