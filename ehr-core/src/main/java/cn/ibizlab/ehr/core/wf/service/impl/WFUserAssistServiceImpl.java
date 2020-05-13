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
import cn.ibizlab.ehr.core.wf.domain.WFUserAssist;
import cn.ibizlab.ehr.core.wf.filter.WFUserAssistSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFUserAssistService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFUserAssistMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流用户代办] 服务对象接口实现
 */
@Slf4j
@Service("WFUserAssistServiceImpl")
public class WFUserAssistServiceImpl extends ServiceImpl<WFUserAssistMapper, WFUserAssist> implements IWFUserAssistService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFWorkflowService wfworkflowService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WFUserAssist et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfuserassistid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFUserAssist> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFUserAssist et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfuserassistid",et.getWfuserassistid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfuserassistid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFUserAssist> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    public boolean checkKey(WFUserAssist et) {
        return (!ObjectUtils.isEmpty(et.getWfuserassistid()))&&(!Objects.isNull(this.getById(et.getWfuserassistid())));
    }

    @Override
    public WFUserAssist getDraft(WFUserAssist et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFUserAssist et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFUserAssist et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFUserAssist> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFUserAssist get(String key) {
        WFUserAssist et = getById(key);
        if(et==null){
            et=new WFUserAssist();
            et.setWfuserassistid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<WFUserAssist> selectByWfmajoruserid(String wfuserid) {
        return baseMapper.selectByWfmajoruserid(wfuserid);
    }

    @Override
    public void removeByWfmajoruserid(String wfuserid) {
        this.remove(new QueryWrapper<WFUserAssist>().eq("wfmajoruserid",wfuserid));
    }

	@Override
    public List<WFUserAssist> selectByWfminoruserid(String wfuserid) {
        return baseMapper.selectByWfminoruserid(wfuserid);
    }

    @Override
    public void removeByWfminoruserid(String wfuserid) {
        this.remove(new QueryWrapper<WFUserAssist>().eq("wfminoruserid",wfuserid));
    }

	@Override
    public List<WFUserAssist> selectByWfworkflowid(String wfworkflowid) {
        return baseMapper.selectByWfworkflowid(wfworkflowid);
    }

    @Override
    public void removeByWfworkflowid(String wfworkflowid) {
        this.remove(new QueryWrapper<WFUserAssist>().eq("wfworkflowid",wfworkflowid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUserAssist> searchDefault(WFUserAssistSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFUserAssist> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFUserAssist>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFUserAssist et){
        //实体关系[DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID]
        if(!ObjectUtils.isEmpty(et.getWfmajoruserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser wfmajoruser=et.getWfmajoruser();
            if(ObjectUtils.isEmpty(wfmajoruser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getWfmajoruserid());
                et.setWfmajoruser(majorEntity);
                wfmajoruser=majorEntity;
            }
            et.setWfmajorusername(wfmajoruser.getWfusername());
        }
        //实体关系[DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID]
        if(!ObjectUtils.isEmpty(et.getWfminoruserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser wfminoruser=et.getWfminoruser();
            if(ObjectUtils.isEmpty(wfminoruser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getWfminoruserid());
                et.setWfminoruser(majorEntity);
                wfminoruser=majorEntity;
            }
            et.setWfminorusername(wfminoruser.getWfusername());
        }
        //实体关系[DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID]
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


