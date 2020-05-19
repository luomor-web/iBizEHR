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
import cn.ibizlab.ehr.core.wf.domain.WFTmpStepActor;
import cn.ibizlab.ehr.core.wf.filter.WFTmpStepActorSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFTmpStepActorService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFTmpStepActorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流步骤操作者（临时）] 服务对象接口实现
 */
@Slf4j
@Service("WFTmpStepActorServiceImpl")
public class WFTmpStepActorServiceImpl extends ServiceImpl<WFTmpStepActorMapper, WFTmpStepActor> implements IWFTmpStepActorService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFActorService wfactorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepService wfstepService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(WFTmpStepActor et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wftmpstepactorid",et.getWftmpstepactorid())))
            return false;
        CachedBeanCopier.copy(get(et.getWftmpstepactorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFTmpStepActor> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(WFTmpStepActor et) {
        return (!ObjectUtils.isEmpty(et.getWftmpstepactorid()))&&(!Objects.isNull(this.getById(et.getWftmpstepactorid())));
    }

    @Override
    @Transactional
    public boolean create(WFTmpStepActor et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWftmpstepactorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFTmpStepActor> list) {
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
    public WFTmpStepActor getDraft(WFTmpStepActor et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public WFTmpStepActor get(String key) {
        WFTmpStepActor et = getById(key);
        if(et==null){
            et=new WFTmpStepActor();
            et.setWftmpstepactorid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFTmpStepActor et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFTmpStepActor et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFTmpStepActor> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<WFTmpStepActor> selectByWfactorid(String wfactorid) {
        return baseMapper.selectByWfactorid(wfactorid);
    }

    @Override
    public void removeByWfactorid(String wfactorid) {
        this.remove(new QueryWrapper<WFTmpStepActor>().eq("wfactorid",wfactorid));
    }

	@Override
    public List<WFTmpStepActor> selectByPrevwfstepid(String wfstepid) {
        return baseMapper.selectByPrevwfstepid(wfstepid);
    }

    @Override
    public void removeByPrevwfstepid(String wfstepid) {
        this.remove(new QueryWrapper<WFTmpStepActor>().eq("prevwfstepid",wfstepid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFTmpStepActor> searchDefault(WFTmpStepActorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTmpStepActor> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFTmpStepActor>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFTmpStepActor et){
        //实体关系[DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID]
        if(!ObjectUtils.isEmpty(et.getWfactorid())){
            cn.ibizlab.ehr.core.wf.domain.WFActor wfactor=et.getWfactor();
            if(ObjectUtils.isEmpty(wfactor)){
                cn.ibizlab.ehr.core.wf.domain.WFActor majorEntity=wfactorService.get(et.getWfactorid());
                et.setWfactor(majorEntity);
                wfactor=majorEntity;
            }
            et.setWfactorname(wfactor.getWfactorname());
        }
        //实体关系[DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID]
        if(!ObjectUtils.isEmpty(et.getPrevwfstepid())){
            cn.ibizlab.ehr.core.wf.domain.WFStep wfstep=et.getWfstep();
            if(ObjectUtils.isEmpty(wfstep)){
                cn.ibizlab.ehr.core.wf.domain.WFStep majorEntity=wfstepService.get(et.getPrevwfstepid());
                et.setWfstep(majorEntity);
                wfstep=majorEntity;
            }
            et.setPrevwfstepname(wfstep.getWfplogicname());
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


