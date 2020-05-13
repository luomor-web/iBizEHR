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
import cn.ibizlab.ehr.core.wf.domain.WFUserCandidate;
import cn.ibizlab.ehr.core.wf.filter.WFUserCandidateSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFUserCandidateService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFUserCandidateMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流用户候选者] 服务对象接口实现
 */
@Slf4j
@Service("WFUserCandidateServiceImpl")
public class WFUserCandidateServiceImpl extends ServiceImpl<WFUserCandidateMapper, WFUserCandidate> implements IWFUserCandidateService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserService;

    private int batchSize = 500;

    @Override
    @Transactional
    public WFUserCandidate get(String key) {
        WFUserCandidate et = getById(key);
        if(et==null){
            et=new WFUserCandidate();
            et.setWfusercandidateid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(WFUserCandidate et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfusercandidateid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFUserCandidate> list) {
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
    public boolean update(WFUserCandidate et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfusercandidateid",et.getWfusercandidateid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfusercandidateid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFUserCandidate> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(WFUserCandidate et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFUserCandidate et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFUserCandidate> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public WFUserCandidate getDraft(WFUserCandidate et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(WFUserCandidate et) {
        return (!ObjectUtils.isEmpty(et.getWfusercandidateid()))&&(!Objects.isNull(this.getById(et.getWfusercandidateid())));
    }


	@Override
    public List<WFUserCandidate> selectByWfmajoruserid(String wfuserid) {
        return baseMapper.selectByWfmajoruserid(wfuserid);
    }

    @Override
    public void removeByWfmajoruserid(String wfuserid) {
        this.remove(new QueryWrapper<WFUserCandidate>().eq("wfmajoruserid",wfuserid));
    }

	@Override
    public List<WFUserCandidate> selectByWfminoruserid(String wfuserid) {
        return baseMapper.selectByWfminoruserid(wfuserid);
    }

    @Override
    public void removeByWfminoruserid(String wfuserid) {
        this.remove(new QueryWrapper<WFUserCandidate>().eq("wfminoruserid",wfuserid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFUserCandidate> searchDefault(WFUserCandidateSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFUserCandidate> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFUserCandidate>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFUserCandidate et){
        //实体关系[DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID]
        if(!ObjectUtils.isEmpty(et.getWfmajoruserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser wfmajoruser=et.getWfmajoruser();
            if(ObjectUtils.isEmpty(wfmajoruser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getWfmajoruserid());
                et.setWfmajoruser(majorEntity);
                wfmajoruser=majorEntity;
            }
            et.setWfmajorusername(wfmajoruser.getWfusername());
        }
        //实体关系[DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID]
        if(!ObjectUtils.isEmpty(et.getWfminoruserid())){
            cn.ibizlab.ehr.core.wf.domain.WFUser wfminoruser=et.getWfminoruser();
            if(ObjectUtils.isEmpty(wfminoruser)){
                cn.ibizlab.ehr.core.wf.domain.WFUser majorEntity=wfuserService.get(et.getWfminoruserid());
                et.setWfminoruser(majorEntity);
                wfminoruser=majorEntity;
            }
            et.setWfminorusername(wfminoruser.getWfusername());
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


