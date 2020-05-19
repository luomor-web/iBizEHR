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
import cn.ibizlab.ehr.core.common.domain.TSSDTask;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskSearchContext;
import cn.ibizlab.ehr.core.common.service.ITSSDTaskService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.TSSDTaskMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[任务调度任务项] 服务对象接口实现
 */
@Slf4j
@Service("TSSDTaskServiceImpl")
public class TSSDTaskServiceImpl extends ServiceImpl<TSSDTaskMapper, TSSDTask> implements ITSSDTaskService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDTaskLogService tssdtasklogService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDTaskPolicyService tssdtaskpolicyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDEngineService tssdengineService;

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
    public boolean create(TSSDTask et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTssdtaskid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TSSDTask> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TSSDTask et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("tssdtaskid",et.getTssdtaskid())))
            return false;
        CachedBeanCopier.copy(get(et.getTssdtaskid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TSSDTask> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TSSDTask et) {
        return (!ObjectUtils.isEmpty(et.getTssdtaskid()))&&(!Objects.isNull(this.getById(et.getTssdtaskid())));
    }

    @Override
    public TSSDTask getDraft(TSSDTask et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(TSSDTask et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TSSDTask et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TSSDTask> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TSSDTask get(String key) {
        TSSDTask et = getById(key);
        if(et==null){
            et=new TSSDTask();
            et.setTssdtaskid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<TSSDTask> selectByTssdengineid(String tssdengineid) {
        return baseMapper.selectByTssdengineid(tssdengineid);
    }

    @Override
    public void removeByTssdengineid(String tssdengineid) {
        this.remove(new QueryWrapper<TSSDTask>().eq("tssdengineid",tssdengineid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TSSDTask> searchDefault(TSSDTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TSSDTask> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TSSDTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TSSDTask et){
        //实体关系[DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID]
        if(!ObjectUtils.isEmpty(et.getTssdengineid())){
            cn.ibizlab.ehr.core.common.domain.TSSDEngine tssdengine=et.getTssdengine();
            if(ObjectUtils.isEmpty(tssdengine)){
                cn.ibizlab.ehr.core.common.domain.TSSDEngine majorEntity=tssdengineService.get(et.getTssdengineid());
                et.setTssdengine(majorEntity);
                tssdengine=majorEntity;
            }
            et.setTssdenginename(tssdengine.getTssdenginename());
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


