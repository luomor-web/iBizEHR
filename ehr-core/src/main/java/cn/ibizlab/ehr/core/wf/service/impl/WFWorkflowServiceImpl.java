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
import cn.ibizlab.ehr.core.wf.domain.WFWorkflow;
import cn.ibizlab.ehr.core.wf.filter.WFWorkflowSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFWorkflowService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFWorkflowMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流配置] 服务对象接口实现
 */
@Slf4j
@Service("WFWorkflowServiceImpl")
public class WFWorkflowServiceImpl extends ServiceImpl<WFWorkflowMapper, WFWorkflow> implements IWFWorkflowService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMWorkflowRefService pimworkflowrefService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFActionService wfactionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFAssistWorkService wfassistworkService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFInstanceService wfinstanceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserAssistService wfuserassistService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFVersionService wfversionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IMsgTemplateService msgtemplateService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WFWorkflow et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfworkflowid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFWorkflow> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
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
    public boolean save(WFWorkflow et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFWorkflow et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFWorkflow> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFWorkflow et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfworkflowid",et.getWfworkflowid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfworkflowid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFWorkflow> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public WFWorkflow getDraft(WFWorkflow et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public WFWorkflow get(String key) {
        WFWorkflow et = getById(key);
        if(et==null){
            et=new WFWorkflow();
            et.setWfworkflowid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(WFWorkflow et) {
        return (!ObjectUtils.isEmpty(et.getWfworkflowid()))&&(!Objects.isNull(this.getById(et.getWfworkflowid())));
    }


	@Override
    public List<WFWorkflow> selectByRemindmsgtemplid(String msgtemplateid) {
        return baseMapper.selectByRemindmsgtemplid(msgtemplateid);
    }

    @Override
    public void removeByRemindmsgtemplid(String msgtemplateid) {
        this.remove(new QueryWrapper<WFWorkflow>().eq("remindmsgtemplid",msgtemplateid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFWorkflow> searchDefault(WFWorkflowSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFWorkflow> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFWorkflow>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFWorkflow et){
        //实体关系[DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID]
        if(!ObjectUtils.isEmpty(et.getRemindmsgtemplid())){
            cn.ibizlab.ehr.core.common.domain.MsgTemplate remindmsgtempl=et.getRemindmsgtempl();
            if(ObjectUtils.isEmpty(remindmsgtempl)){
                cn.ibizlab.ehr.core.common.domain.MsgTemplate majorEntity=msgtemplateService.get(et.getRemindmsgtemplid());
                et.setRemindmsgtempl(majorEntity);
                remindmsgtempl=majorEntity;
            }
            et.setRemindmsgtemplname(remindmsgtempl.getMsgtemplatename());
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

