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
import cn.ibizlab.ehr.core.wf.domain.WFStepActor;
import cn.ibizlab.ehr.core.wf.filter.WFStepActorSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFStepActorService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFStepActorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流步骤操作者] 服务对象接口实现
 */
@Slf4j
@Service("WFStepActorServiceImpl")
public class WFStepActorServiceImpl extends ServiceImpl<WFStepActorMapper, WFStepActor> implements IWFStepActorService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFAssistWorkService wfassistworkService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFReminderService wfreminderService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepService wfstepService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(WFStepActor et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFStepActor et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFStepActor> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFStepActor remindSave(WFStepActor et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public WFStepActor get(String key) {
        WFStepActor et = getById(key);
        if(et==null){
            et=new WFStepActor();
            et.setWfstepactorid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFStepActor et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfstepactorid",et.getWfstepactorid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfstepactorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFStepActor> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFStepActor et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfstepactorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFStepActor> list) {
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
    public WFStepActor getDraft(WFStepActor et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(WFStepActor et) {
        return (!ObjectUtils.isEmpty(et.getWfstepactorid()))&&(!Objects.isNull(this.getById(et.getWfstepactorid())));
    }


	@Override
    public List<WFStepActor> selectByWfstepid(String wfstepid) {
        return baseMapper.selectByWfstepid(wfstepid);
    }

    @Override
    public void removeByWfstepid(String wfstepid) {
        this.remove(new QueryWrapper<WFStepActor>().eq("wfstepid",wfstepid));
    }

	@Override
    public List<WFStepActor> selectByOriginalwfuserid(String wfuserid) {
        return baseMapper.selectByOriginalwfuserid(wfuserid);
    }

    @Override
    public void removeByOriginalwfuserid(String wfuserid) {
        this.remove(new QueryWrapper<WFStepActor>().eq("originalwfuserid",wfuserid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFStepActor> searchDefault(WFStepActorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFStepActor> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFStepActor>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFStepActor et){
        //实体关系[DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID]
        if(!ObjectUtils.isEmpty(et.getWfstepid())){
            cn.ibizlab.ehr.core.wf.domain.WFStep wfstep=et.getWfstep();
            if(ObjectUtils.isEmpty(wfstep)){
                cn.ibizlab.ehr.core.wf.domain.WFStep majorEntity=wfstepService.get(et.getWfstepid());
                et.setWfstep(majorEntity);
                wfstep=majorEntity;
            }
            et.setWfstepname(wfstep.getWfplogicname());
            et.setWfinstanceid(wfstep.getWfinstanceid());
        }
        //实体关系[DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID]
        if(!ObjectUtils.isEmpty(et.getOriginalwfuserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser originalwfuser=et.getOriginalwfuser();
            if(ObjectUtils.isEmpty(originalwfuser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getOriginalwfuserid());
                et.setOriginalwfuser(majorEntity);
                originalwfuser=majorEntity;
            }
            et.setOriginalwfusername(originalwfuser.getWfusername());
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


