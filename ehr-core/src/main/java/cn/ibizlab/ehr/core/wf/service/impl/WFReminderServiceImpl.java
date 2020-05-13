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
import cn.ibizlab.ehr.core.wf.domain.WFReminder;
import cn.ibizlab.ehr.core.wf.filter.WFReminderSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFReminderService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFReminderMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流工作催办] 服务对象接口实现
 */
@Slf4j
@Service("WFReminderServiceImpl")
public class WFReminderServiceImpl extends ServiceImpl<WFReminderMapper, WFReminder> implements IWFReminderService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepActorService wfstepactorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserService;

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
    public boolean create(WFReminder et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfreminderid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFReminder> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(WFReminder et) {
        return (!ObjectUtils.isEmpty(et.getWfreminderid()))&&(!Objects.isNull(this.getById(et.getWfreminderid())));
    }

    @Override
    @Transactional
    public WFReminder get(String key) {
        WFReminder et = getById(key);
        if(et==null){
            et=new WFReminder();
            et.setWfreminderid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public WFReminder getDraft(WFReminder et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFReminder et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfreminderid",et.getWfreminderid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfreminderid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFReminder> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(WFReminder et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFReminder et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFReminder> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<WFReminder> selectByWfstepactorid(String wfstepactorid) {
        return baseMapper.selectByWfstepactorid(wfstepactorid);
    }

    @Override
    public void removeByWfstepactorid(String wfstepactorid) {
        this.remove(new QueryWrapper<WFReminder>().eq("wfstepactorid",wfstepactorid));
    }

	@Override
    public List<WFReminder> selectByWfuserid(String wfuserid) {
        return baseMapper.selectByWfuserid(wfuserid);
    }

    @Override
    public void removeByWfuserid(String wfuserid) {
        this.remove(new QueryWrapper<WFReminder>().eq("wfuserid",wfuserid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFReminder> searchDefault(WFReminderSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFReminder> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFReminder>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFReminder et){
        //实体关系[DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID]
        if(!ObjectUtils.isEmpty(et.getWfstepactorid())){
            cn.ibizlab.ehr.core.wf.domain.WFStepActor wfstepactor=et.getWfstepactor();
            if(ObjectUtils.isEmpty(wfstepactor)){
                cn.ibizlab.ehr.core.wf.domain.WFStepActor majorEntity=wfstepactorService.get(et.getWfstepactorid());
                et.setWfstepactor(majorEntity);
                wfstepactor=majorEntity;
            }
            et.setRemindercount(wfstepactor.getRemindercount());
            et.setWfstepactorname(wfstepactor.getWfstepactorname());
            et.setWfcreatedate(wfstepactor.getCreatedate());
            et.setActorid(wfstepactor.getActorid());
        }
        //实体关系[DER1N_WFREMINDER_WFUSER_WFUSERID]
        if(!ObjectUtils.isEmpty(et.getWfuserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser wfuser=et.getWfuser();
            if(ObjectUtils.isEmpty(wfuser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getWfuserid());
                et.setWfuser(majorEntity);
                wfuser=majorEntity;
            }
            et.setWfusername(wfuser.getWfusername());
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


