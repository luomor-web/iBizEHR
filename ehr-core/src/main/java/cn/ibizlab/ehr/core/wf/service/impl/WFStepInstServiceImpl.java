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
import cn.ibizlab.ehr.core.wf.domain.WFStepInst;
import cn.ibizlab.ehr.core.wf.filter.WFStepInstSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFStepInstService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFStepInstMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流步骤子实例] 服务对象接口实现
 */
@Slf4j
@Service("WFStepInstServiceImpl")
public class WFStepInstServiceImpl extends ServiceImpl<WFStepInstMapper, WFStepInst> implements IWFStepInstService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFInstanceService wfinstanceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFStepService wfstepService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(WFStepInst et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfstepinstid",et.getWfstepinstid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfstepinstid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFStepInst> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(WFStepInst et) {
        return (!ObjectUtils.isEmpty(et.getWfstepinstid()))&&(!Objects.isNull(this.getById(et.getWfstepinstid())));
    }

    @Override
    public WFStepInst getDraft(WFStepInst et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public WFStepInst get(String key) {
        WFStepInst et = getById(key);
        if(et==null){
            et=new WFStepInst();
            et.setWfstepinstid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(WFStepInst et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFStepInst et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFStepInst> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFStepInst et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfstepinstid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFStepInst> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
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
    public List<WFStepInst> selectByWfinstanceid(String wfinstanceid) {
        return baseMapper.selectByWfinstanceid(wfinstanceid);
    }

    @Override
    public void removeByWfinstanceid(String wfinstanceid) {
        this.remove(new QueryWrapper<WFStepInst>().eq("wfinstanceid",wfinstanceid));
    }

	@Override
    public List<WFStepInst> selectByWfstepid(String wfstepid) {
        return baseMapper.selectByWfstepid(wfstepid);
    }

    @Override
    public void removeByWfstepid(String wfstepid) {
        this.remove(new QueryWrapper<WFStepInst>().eq("wfstepid",wfstepid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFStepInst> searchDefault(WFStepInstSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFStepInst> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFStepInst>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFStepInst et){
        //实体关系[DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID]
        if(!ObjectUtils.isEmpty(et.getWfinstanceid())){
            cn.ibizlab.ehr.core.wf.domain.WFInstance wfinstance=et.getWfinstance();
            if(ObjectUtils.isEmpty(wfinstance)){
                cn.ibizlab.ehr.core.wf.domain.WFInstance majorEntity=wfinstanceService.get(et.getWfinstanceid());
                et.setWfinstance(majorEntity);
                wfinstance=majorEntity;
            }
            et.setWfinstancename(wfinstance.getWfinstancename());
        }
        //实体关系[DER1N_WFSTEPINST_WFSTEP_WFSTEPID]
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


