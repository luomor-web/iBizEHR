package cn.ibizlab.ehr.core.wf.service.impl;

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
import cn.ibizlab.ehr.core.wf.domain.WFAction;
import cn.ibizlab.ehr.core.wf.filter.WFActionSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFActionService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFActionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流用户操作] 服务对象接口实现
 */
@Slf4j
@Service("WFActionServiceImpl")
public class WFActionServiceImpl extends ServiceImpl<WFActionMapper, WFAction> implements IWFActionService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFWorkflowService wfworkflowService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(WFAction et) {
        return (!ObjectUtils.isEmpty(et.getWfactionid()))&&(!Objects.isNull(this.getById(et.getWfactionid())));
    }

    @Override
    public WFAction getDraft(WFAction et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFAction et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfactionid",et.getWfactionid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfactionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFAction> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(WFAction et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFAction et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFAction> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFAction et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfactionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFAction> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public WFAction get(String key) {
        WFAction et = getById(key);
        if(et==null){
            et=new WFAction();
            et.setWfactionid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<WFAction> selectByWfworkflowid(String wfworkflowid) {
        return baseMapper.selectByWfworkflowid(wfworkflowid);
    }

    @Override
    public void removeByWfworkflowid(String wfworkflowid) {
        this.remove(new QueryWrapper<WFAction>().eq("wfworkflowid",wfworkflowid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFAction> searchDefault(WFActionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFAction> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFAction>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFAction et){
        //实体关系[DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID]
        if(!ObjectUtils.isEmpty(et.getWfworkflowid())){
            cn.ibizlab.ehr.core.wf.domain.WFWorkflow wfworkflow=et.getWfworkflow();
            if(ObjectUtils.isEmpty(wfworkflow)){
                cn.ibizlab.ehr.core.wf.domain.WFWorkflow majorEntity=wfworkflowService.get(et.getWfworkflowid());
                et.setWfworkflow(majorEntity);
                wfworkflow=majorEntity;
            }
            et.setWfworkflowname(wfworkflow.getWfworkflowname());
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


