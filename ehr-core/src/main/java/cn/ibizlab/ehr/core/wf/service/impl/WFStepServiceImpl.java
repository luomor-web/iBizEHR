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
import cn.ibizlab.ehr.core.wf.domain.WFStep;
import cn.ibizlab.ehr.core.wf.filter.WFStepSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFStepService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFStepMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流步骤] 服务对象接口实现
 */
@Slf4j
@Service("WFStepServiceImpl")
public class WFStepServiceImpl extends ServiceImpl<WFStepMapper, WFStep> implements IWFStepService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFIAActionService wfiaactionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepActorService wfstepactorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepDataService wfstepdataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepInstService wfstepinstService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFTmpStepActorService wftmpstepactorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFInstanceService wfinstanceService;

    private int batchSize = 500;

    @Override
    @Transactional
    public WFStep get(String key) {
        WFStep et = getById(key);
        if(et==null){
            et=new WFStep();
            et.setWfstepid(key);
        }
        else{
        }
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
    public WFStep getDraft(WFStep et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(WFStep et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfstepid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFStep> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(WFStep et) {
        return (!ObjectUtils.isEmpty(et.getWfstepid()))&&(!Objects.isNull(this.getById(et.getWfstepid())));
    }

    @Override
    @Transactional
    public boolean save(WFStep et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFStep et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFStep> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WFStep et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfstepid",et.getWfstepid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfstepid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFStep> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<WFStep> selectByWfinstanceid(String wfinstanceid) {
        return baseMapper.selectByWfinstanceid(wfinstanceid);
    }

    @Override
    public void removeByWfinstanceid(String wfinstanceid) {
        this.remove(new QueryWrapper<WFStep>().eq("wfinstanceid",wfinstanceid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFStep> searchDefault(WFStepSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFStep> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFStep>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFStep et){
        //实体关系[DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID]
        if(!ObjectUtils.isEmpty(et.getWfinstanceid())){
            cn.ibizlab.ehr.core.wf.domain.WFInstance wfinstance=et.getWfinstance();
            if(ObjectUtils.isEmpty(wfinstance)){
                cn.ibizlab.ehr.core.wf.domain.WFInstance majorEntity=wfinstanceService.get(et.getWfinstanceid());
                et.setWfinstance(majorEntity);
                wfinstance=majorEntity;
            }
            et.setWfinstancename(wfinstance.getWfinstancename());
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


