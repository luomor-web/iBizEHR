package cn.ibizlab.ehr.core.common.service.impl;

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
import cn.ibizlab.ehr.core.common.domain.DataAuditDetail;
import cn.ibizlab.ehr.core.common.filter.DataAuditDetailSearchContext;
import cn.ibizlab.ehr.core.common.service.IDataAuditDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.DataAuditDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[数据审计明细] 服务对象接口实现
 */
@Slf4j
@Service("DataAuditDetailServiceImpl")
public class DataAuditDetailServiceImpl extends ServiceImpl<DataAuditDetailMapper, DataAuditDetail> implements IDataAuditDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IDataAuditService dataauditService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(DataAuditDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(DataAuditDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<DataAuditDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public DataAuditDetail getDraft(DataAuditDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public DataAuditDetail get(String key) {
        DataAuditDetail et = getById(key);
        if(et==null){
            et=new DataAuditDetail();
            et.setDataauditdetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(DataAuditDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getDataauditdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<DataAuditDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(DataAuditDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("dataauditdetailid",et.getDataauditdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getDataauditdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<DataAuditDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(DataAuditDetail et) {
        return (!ObjectUtils.isEmpty(et.getDataauditdetailid()))&&(!Objects.isNull(this.getById(et.getDataauditdetailid())));
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
    public List<DataAuditDetail> selectByDataauditid(String dataauditid) {
        return baseMapper.selectByDataauditid(dataauditid);
    }

    @Override
    public void removeByDataauditid(String dataauditid) {
        this.remove(new QueryWrapper<DataAuditDetail>().eq("dataauditid",dataauditid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DataAuditDetail> searchDefault(DataAuditDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DataAuditDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<DataAuditDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(DataAuditDetail et){
        //实体关系[DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID]
        if(!ObjectUtils.isEmpty(et.getDataauditid())){
            cn.ibizlab.ehr.core.common.domain.DataAudit dataaudit=et.getDataaudit();
            if(ObjectUtils.isEmpty(dataaudit)){
                cn.ibizlab.ehr.core.common.domain.DataAudit majorEntity=dataauditService.get(et.getDataauditid());
                et.setDataaudit(majorEntity);
                dataaudit=majorEntity;
            }
            et.setDataauditname(dataaudit.getDataauditname());
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


