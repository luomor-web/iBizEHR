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
import cn.ibizlab.ehr.core.common.domain.TSSDTaskLog;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskLogSearchContext;
import cn.ibizlab.ehr.core.common.service.ITSSDTaskLogService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.TSSDTaskLogMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[任务调度日志] 服务对象接口实现
 */
@Slf4j
@Service("TSSDTaskLogServiceImpl")
public class TSSDTaskLogServiceImpl extends ServiceImpl<TSSDTaskLogMapper, TSSDTaskLog> implements ITSSDTaskLogService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ITSSDTaskService tssdtaskService;

    private int batchSize = 500;

    @Override
    @Transactional
    public TSSDTaskLog get(String key) {
        TSSDTaskLog et = getById(key);
        if(et==null){
            et=new TSSDTaskLog();
            et.setTssdtasklogid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TSSDTaskLog et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("tssdtasklogid",et.getTssdtasklogid())))
            return false;
        CachedBeanCopier.copy(get(et.getTssdtasklogid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TSSDTaskLog> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public TSSDTaskLog getDraft(TSSDTaskLog et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TSSDTaskLog et) {
        return (!ObjectUtils.isEmpty(et.getTssdtasklogid()))&&(!Objects.isNull(this.getById(et.getTssdtasklogid())));
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
    public boolean save(TSSDTaskLog et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TSSDTaskLog et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TSSDTaskLog> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TSSDTaskLog et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTssdtasklogid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TSSDTaskLog> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }


	@Override
    public List<TSSDTaskLog> selectByTssdtaskid(String tssdtaskid) {
        return baseMapper.selectByTssdtaskid(tssdtaskid);
    }

    @Override
    public void removeByTssdtaskid(String tssdtaskid) {
        this.remove(new QueryWrapper<TSSDTaskLog>().eq("tssdtaskid",tssdtaskid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TSSDTaskLog> searchDefault(TSSDTaskLogSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TSSDTaskLog> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TSSDTaskLog>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TSSDTaskLog et){
        //实体关系[DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID]
        if(!ObjectUtils.isEmpty(et.getTssdtaskid())){
            cn.ibizlab.ehr.core.common.domain.TSSDTask tssdtask=et.getTssdtask();
            if(ObjectUtils.isEmpty(tssdtask)){
                cn.ibizlab.ehr.core.common.domain.TSSDTask majorEntity=tssdtaskService.get(et.getTssdtaskid());
                et.setTssdtask(majorEntity);
                tssdtask=majorEntity;
            }
            et.setTssdtaskname(tssdtask.getTssdtaskname());
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


