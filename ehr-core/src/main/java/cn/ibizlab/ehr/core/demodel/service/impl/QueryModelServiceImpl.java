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
import cn.ibizlab.ehr.core.demodel.domain.QueryModel;
import cn.ibizlab.ehr.core.demodel.filter.QueryModelSearchContext;
import cn.ibizlab.ehr.core.demodel.service.IQueryModelService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.demodel.mapper.QueryModelMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[实体查询模型] 服务对象接口实现
 */
@Slf4j
@Service("QueryModelServiceImpl")
public class QueryModelServiceImpl extends ServiceImpl<QueryModelMapper, QueryModel> implements IQueryModelService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.demodel.service.IDataEntityService dataentityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataDetailService userroledatadetailService;

    private int batchSize = 500;

    @Override
    @Transactional
    public QueryModel get(String key) {
        QueryModel et = getById(key);
        if(et==null){
            et=new QueryModel();
            et.setQuerymodelid(key);
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
    public boolean update(QueryModel et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("querymodelid",et.getQuerymodelid())))
            return false;
        CachedBeanCopier.copy(get(et.getQuerymodelid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<QueryModel> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(QueryModel et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(QueryModel et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<QueryModel> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public QueryModel getDraft(QueryModel et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(QueryModel et) {
        return (!ObjectUtils.isEmpty(et.getQuerymodelid()))&&(!Objects.isNull(this.getById(et.getQuerymodelid())));
    }

    @Override
    @Transactional
    public boolean create(QueryModel et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getQuerymodelid()),et);
        return true;
    }

    @Override
    public void createBatch(List<QueryModel> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<QueryModel> selectByDeid(String deid) {
        return baseMapper.selectByDeid(deid);
    }

    @Override
    public void removeByDeid(String deid) {
        this.remove(new QueryWrapper<QueryModel>().eq("deid",deid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<QueryModel> searchDefault(QueryModelSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<QueryModel> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<QueryModel>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前实体
     */
    @Override
    public Page<QueryModel> searchCurDE(QueryModelSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<QueryModel> pages=baseMapper.searchCurDE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<QueryModel>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(QueryModel et){
        //实体关系[DER1N_QUERYMODEL_DATAENTITY_DEID]
        if(!ObjectUtils.isEmpty(et.getDeid())){
            cn.ibizlab.ehr.core.demodel.domain.DataEntity de=et.getDe();
            if(ObjectUtils.isEmpty(de)){
                cn.ibizlab.ehr.core.demodel.domain.DataEntity majorEntity=dataentityService.get(et.getDeid());
                et.setDe(majorEntity);
                de=majorEntity;
            }
            et.setDename(de.getDename());
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


