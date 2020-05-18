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
import cn.ibizlab.ehr.core.wf.domain.WFIAAction;
import cn.ibizlab.ehr.core.wf.filter.WFIAActionSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFIAActionService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFIAActionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流交互操作] 服务对象接口实现
 */
@Slf4j
@Service("WFIAActionServiceImpl")
public class WFIAActionServiceImpl extends ServiceImpl<WFIAActionMapper, WFIAAction> implements IWFIAActionService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepService wfstepService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WFIAAction et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfiaactionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFIAAction> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFIAAction get(String key) {
        WFIAAction et = getById(key);
        if(et==null){
            et=new WFIAAction();
            et.setWfiaactionid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFIAAction et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfiaactionid",et.getWfiaactionid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfiaactionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFIAAction> list) {
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
    public boolean checkKey(WFIAAction et) {
        return (!ObjectUtils.isEmpty(et.getWfiaactionid()))&&(!Objects.isNull(this.getById(et.getWfiaactionid())));
    }

    @Override
    public WFIAAction getDraft(WFIAAction et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFIAAction et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFIAAction et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFIAAction> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<WFIAAction> selectByWfstepid(String wfstepid) {
        return baseMapper.selectByWfstepid(wfstepid);
    }

    @Override
    public void removeByWfstepid(String wfstepid) {
        this.remove(new QueryWrapper<WFIAAction>().eq("wfstepid",wfstepid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFIAAction> searchDefault(WFIAActionSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFIAAction> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFIAAction>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFIAAction et){
        //实体关系[DER1N_WFIAACTION_WFSTEP_WFSTEPID]
        if(!ObjectUtils.isEmpty(et.getWfstepid())){
            cn.ibizlab.ehr.core.wf.domain.WFStep wfstep=et.getWfstep();
            if(ObjectUtils.isEmpty(wfstep)){
                cn.ibizlab.ehr.core.wf.domain.WFStep majorEntity=wfstepService.get(et.getWfstepid());
                et.setWfstep(majorEntity);
                wfstep=majorEntity;
            }
            et.setWfstepname(wfstep.getWfplogicname());
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


