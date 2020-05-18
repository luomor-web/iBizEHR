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
import cn.ibizlab.ehr.core.wf.domain.WFVersion;
import cn.ibizlab.ehr.core.wf.filter.WFVersionSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFVersionService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFVersionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流配置版本] 服务对象接口实现
 */
@Slf4j
@Service("WFVersionServiceImpl")
public class WFVersionServiceImpl extends ServiceImpl<WFVersionMapper, WFVersion> implements IWFVersionService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFWorkflowService wfworkflowService;

    private int batchSize = 500;

    @Override
    @Transactional
    public WFVersion get(String key) {
        WFVersion et = getById(key);
        if(et==null){
            et=new WFVersion();
            et.setWfversionid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(WFVersion et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfversionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFVersion> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(WFVersion et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFVersion et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFVersion> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public WFVersion getDraft(WFVersion et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFVersion et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfwfversionid",et.getWfversionid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfversionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFVersion> list) {
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
    public boolean checkKey(WFVersion et) {
        return (!ObjectUtils.isEmpty(et.getWfversionid()))&&(!Objects.isNull(this.getById(et.getWfversionid())));
    }


	@Override
    public List<WFVersion> selectByWfwfid(String wfworkflowid) {
        return baseMapper.selectByWfwfid(wfworkflowid);
    }

    @Override
    public void removeByWfwfid(String wfworkflowid) {
        this.remove(new QueryWrapper<WFVersion>().eq("wfwfid",wfworkflowid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFVersion> searchDefault(WFVersionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFVersion> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFVersion>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFVersion et){
        //实体关系[DER1N_WFWFVERSION_WFWORKFLOW_WFWFID]
        if(!ObjectUtils.isEmpty(et.getWfwfid())){
            cn.ibizlab.ehr.core.wf.domain.WFWorkflow wfworkflow=et.getWfworkflow();
            if(ObjectUtils.isEmpty(wfworkflow)){
                cn.ibizlab.ehr.core.wf.domain.WFWorkflow majorEntity=wfworkflowService.get(et.getWfwfid());
                et.setWfworkflow(majorEntity);
                wfworkflow=majorEntity;
            }
            et.setWfwfname(wfworkflow.getWfworkflowname());
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


