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
import cn.ibizlab.ehr.core.wf.domain.WFAssistWork;
import cn.ibizlab.ehr.core.wf.filter.WFAssistWorkSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFAssistWorkService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFAssistWorkMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流代办工作] 服务对象接口实现
 */
@Slf4j
@Service("WFAssistWorkServiceImpl")
public class WFAssistWorkServiceImpl extends ServiceImpl<WFAssistWorkMapper, WFAssistWork> implements IWFAssistWorkService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFInstanceService wfinstanceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepActorService wfstepactorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFWorkflowService wfworkflowService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(WFAssistWork et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfassistworkid",et.getWfassistworkid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfassistworkid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFAssistWork> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFAssistWork et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfassistworkid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFAssistWork> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFAssistWork get(String key) {
        WFAssistWork et = getById(key);
        if(et==null){
            et=new WFAssistWork();
            et.setWfassistworkid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public WFAssistWork getDraft(WFAssistWork et) {
        fillParentData(et);
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
    public boolean checkKey(WFAssistWork et) {
        return (!ObjectUtils.isEmpty(et.getWfassistworkid()))&&(!Objects.isNull(this.getById(et.getWfassistworkid())));
    }

    @Override
    @Transactional
    public boolean save(WFAssistWork et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFAssistWork et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFAssistWork> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<WFAssistWork> selectByWfinstanceid(String wfinstanceid) {
        return baseMapper.selectByWfinstanceid(wfinstanceid);
    }

    @Override
    public void removeByWfinstanceid(String wfinstanceid) {
        this.remove(new QueryWrapper<WFAssistWork>().eq("wfinstanceid",wfinstanceid));
    }

	@Override
    public List<WFAssistWork> selectByWfstepactorid(String wfstepactorid) {
        return baseMapper.selectByWfstepactorid(wfstepactorid);
    }

    @Override
    public void removeByWfstepactorid(String wfstepactorid) {
        this.remove(new QueryWrapper<WFAssistWork>().eq("wfstepactorid",wfstepactorid));
    }

	@Override
    public List<WFAssistWork> selectByWfworkflowid(String wfworkflowid) {
        return baseMapper.selectByWfworkflowid(wfworkflowid);
    }

    @Override
    public void removeByWfworkflowid(String wfworkflowid) {
        this.remove(new QueryWrapper<WFAssistWork>().eq("wfworkflowid",wfworkflowid));
    }


    /**
     * 查询集合 当前用户代办工作
     */
    @Override
    public Page<WFAssistWork> searchCurUserAssistWork(WFAssistWorkSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFAssistWork> pages=baseMapper.searchCurUserAssistWork(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFAssistWork>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFAssistWork> searchDefault(WFAssistWorkSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFAssistWork> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFAssistWork>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFAssistWork et){
        //实体关系[DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID]
        if(!ObjectUtils.isEmpty(et.getWfinstanceid())){
            cn.ibizlab.ehr.core.wf.domain.WFInstance wfinstance=et.getWfinstance();
            if(ObjectUtils.isEmpty(wfinstance)){
                cn.ibizlab.ehr.core.wf.domain.WFInstance majorEntity=wfinstanceService.get(et.getWfinstanceid());
                et.setWfinstance(majorEntity);
                wfinstance=majorEntity;
            }
            et.setWfinstancename(wfinstance.getWfinstancename());
            et.setUserdata4(wfinstance.getUserdata4());
            et.setUserdata(wfinstance.getUserdata());
            et.setActivestepid(wfinstance.getActivestepid());
        }
        //实体关系[DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID]
        if(!ObjectUtils.isEmpty(et.getWfstepactorid())){
            cn.ibizlab.ehr.core.wf.domain.WFStepActor wfstepactor=et.getWfstepactor();
            if(ObjectUtils.isEmpty(wfstepactor)){
                cn.ibizlab.ehr.core.wf.domain.WFStepActor majorEntity=wfstepactorService.get(et.getWfstepactorid());
                et.setWfstepactor(majorEntity);
                wfstepactor=majorEntity;
            }
            et.setWfstepactorname(wfstepactor.getWfstepactorname());
        }
        //实体关系[DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID]
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


