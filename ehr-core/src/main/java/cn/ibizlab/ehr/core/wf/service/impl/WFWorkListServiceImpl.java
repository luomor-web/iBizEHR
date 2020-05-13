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
import cn.ibizlab.ehr.core.wf.domain.WFWorkList;
import cn.ibizlab.ehr.core.wf.filter.WFWorkListSearchContext;
import cn.ibizlab.ehr.core.wf.service.IWFWorkListService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wf.mapper.WFWorkListMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作流工作列表] 服务对象接口实现
 */
@Slf4j
@Service("WFWorkListServiceImpl")
public class WFWorkListServiceImpl extends ServiceImpl<WFWorkListMapper, WFWorkList> implements IWFWorkListService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFInstanceService wfinstanceService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wf.service.IWFUserService wfuserService;

    private int batchSize = 500;

    @Override
    public WFWorkList getDraft(WFWorkList et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(WFWorkList et) {
        return (!ObjectUtils.isEmpty(et.getWfworklistid()))&&(!Objects.isNull(this.getById(et.getWfworklistid())));
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
    public boolean save(WFWorkList et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WFWorkList et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WFWorkList> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WFWorkList et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWfworklistid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WFWorkList> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WFWorkList get(String key) {
        WFWorkList et = getById(key);
        if(et==null){
            et=new WFWorkList();
            et.setWfworklistid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(WFWorkList et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wfworklistid",et.getWfworklistid())))
            return false;
        CachedBeanCopier.copy(get(et.getWfworklistid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WFWorkList> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<WFWorkList> selectByWfinstanceid(String wfinstanceid) {
        return baseMapper.selectByWfinstanceid(wfinstanceid);
    }

    @Override
    public void removeByWfinstanceid(String wfinstanceid) {
        this.remove(new QueryWrapper<WFWorkList>().eq("wfinstanceid",wfinstanceid));
    }

	@Override
    public List<WFWorkList> selectByOriginalwfuserid(String wfuserid) {
        return baseMapper.selectByOriginalwfuserid(wfuserid);
    }

    @Override
    public void removeByOriginalwfuserid(String wfuserid) {
        this.remove(new QueryWrapper<WFWorkList>().eq("originalwfuserid",wfuserid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFWorkList> searchDefault(WFWorkListSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFWorkList> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFWorkList>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WFWorkList et){
        //实体关系[DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID]
        if(!ObjectUtils.isEmpty(et.getWfinstanceid())){
            cn.ibizlab.ehr.core.wf.domain.WFInstance wfinstance=et.getWfinstance();
            if(ObjectUtils.isEmpty(wfinstance)){
                cn.ibizlab.ehr.core.wf.domain.WFInstance majorEntity=wfinstanceService.get(et.getWfinstanceid());
                et.setWfinstance(majorEntity);
                wfinstance=majorEntity;
            }
            et.setWfinstancename(wfinstance.getWfinstancename());
        }
        //实体关系[DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID]
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


