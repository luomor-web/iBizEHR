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
import cn.ibizlab.ehr.core.wf.domain.WFInstance;
import cn.ibizlab.ehr.core.wf.filter.WFInstanceSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFInstanceService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFInstanceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流实例] 服务对象接口实现
 */
@Slf4j
@Service("WFInstanceServiceImpl")
public class WFInstanceServiceImpl extends ServiceImpl<WFInstanceMapper, WFInstance> implements IWFInstanceService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFAssistWorkService wfassistworkService;

    private cn.ibizlab.ehr.core.wf.service.IWFInstanceService wfinstanceService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepDataService wfstepdataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepInstService wfstepinstService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepService wfstepService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFWorkListService wfworklistService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgService orgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFWorkflowService wfworkflowService;

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
    public WFInstance getDraft(WFInstance et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFInstance et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFInstance et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFInstance> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFInstance et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfinstanceid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFInstance> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFInstance get(String key) {
        WFInstance et = getById(key);
        if(et==null){
            et=new WFInstance();
            et.setWfinstanceid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFInstance et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfinstanceid",et.getWfinstanceid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfinstanceid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFInstance> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(WFInstance et) {
        return (!ObjectUtils.isEmpty(et.getWfinstanceid()))&&(!Objects.isNull(this.getById(et.getWfinstanceid())));
    }

    @Override
    @Transactional
    public WFInstance restart(WFInstance et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public WFInstance userCancel(WFInstance et) {
        //自定义代码
        return et;
    }


	@Override
    public List<WFInstance> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<WFInstance>().eq("orgid",orgid));
    }

	@Override
    public List<WFInstance> selectByPwfinstanceid(String wfinstanceid) {
        return baseMapper.selectByPwfinstanceid(wfinstanceid);
    }

    @Override
    public void removeByPwfinstanceid(String wfinstanceid) {
        this.remove(new QueryWrapper<WFInstance>().eq("pwfinstanceid",wfinstanceid));
    }

	@Override
    public List<WFInstance> selectByWfworkflowid(String wfworkflowid) {
        return baseMapper.selectByWfworkflowid(wfworkflowid);
    }

    @Override
    public void removeByWfworkflowid(String wfworkflowid) {
        this.remove(new QueryWrapper<WFInstance>().eq("wfworkflowid",wfworkflowid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFInstance> searchDefault(WFInstanceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFInstance> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFInstance>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFInstance et){
        //实体关系[DER1N_WFINSTANCE_ORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.ehr.core.common.domain.Org org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.ehr.core.common.domain.Org majorEntity=orgService.get(et.getOrgid());
                et.setOrg(majorEntity);
                org=majorEntity;
            }
            et.setOrgname(org.getOrgname());
        }
        //实体关系[DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID]
        if(!ObjectUtils.isEmpty(et.getPwfinstanceid())){
            cn.ibizlab.ehr.core.wf.domain.WFInstance pwfinstance=et.getPwfinstance();
            if(ObjectUtils.isEmpty(pwfinstance)){
                cn.ibizlab.ehr.core.wf.domain.WFInstance majorEntity=wfinstanceService.get(et.getPwfinstanceid());
                et.setPwfinstance(majorEntity);
                pwfinstance=majorEntity;
            }
            et.setPwfinstancename(pwfinstance.getWfinstancename());
        }
        //实体关系[DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID]
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


