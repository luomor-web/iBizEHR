package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PimWorkflowRef;
import cn.ibizlab.ehr.core.pim.filter.PimWorkflowRefSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimWorkflowRefService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimWorkflowRefMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[平台流程配置] 服务对象接口实现
 */
@Slf4j
@Service("PimWorkflowRefServiceImpl")
public class PimWorkflowRefServiceImpl extends ServiceImpl<PimWorkflowRefMapper, PimWorkflowRef> implements IPimWorkflowRefService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimWorkflowService pimworkflowService;

    private int batchSize = 500;

    @Override
    public PimWorkflowRef getDraft(PimWorkflowRef et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimWorkflowRef et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimworkflowrefid",et.getPimworkflowrefid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimworkflowrefid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimWorkflowRef> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimWorkflowRef get(String key) {
        PimWorkflowRef et = getById(key);
        if(et==null){
            et=new PimWorkflowRef();
            et.setPimworkflowrefid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimWorkflowRef et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimWorkflowRef et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimWorkflowRef> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimWorkflowRef> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
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
    public boolean create(PimWorkflowRef et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimworkflowrefid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimWorkflowRef> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PimWorkflowRef et) {
        return (!ObjectUtils.isEmpty(et.getPimworkflowrefid()))&&(!Objects.isNull(this.getById(et.getPimworkflowrefid())));
    }

	@Override
    public List<PimWorkflowRef> selectByPimworkflowid(String pimworkflowid) {
        return baseMapper.selectByPimworkflowid(pimworkflowid);
    }

    @Override
    public void removeByPimworkflowid(String pimworkflowid) {
        this.remove(new QueryWrapper<PimWorkflowRef>().eq("pimworkflowid",pimworkflowid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimWorkflowRef> searchDefault(PimWorkflowRefSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkflowRef> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkflowRef>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimWorkflowRef et){
        //实体关系[DER1N_PIMWORKFLOWREF_PIMWORKFLOW_PIMWORKFLOWID]
        if(!ObjectUtils.isEmpty(et.getPimworkflowid())){
            cn.ibizlab.ehr.core.pim.domain.PimWorkflow pimworkflow=et.getPimworkflow();
            if(ObjectUtils.isEmpty(pimworkflow)){
                cn.ibizlab.ehr.core.pim.domain.PimWorkflow majorEntity=pimworkflowService.get(et.getPimworkflowid());
                et.setPimworkflow(majorEntity);
                pimworkflow=majorEntity;
            }
            et.setPimworkflowname(pimworkflow.getPimworkflowname());
            et.setOrmorgid(pimworkflow.getOrmorgid());
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

    @Override
    public List<PimWorkflowRef> getPimworkflowrefByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimWorkflowRef> getPimworkflowrefByEntities(List<PimWorkflowRef> entities) {
        List ids =new ArrayList();
        for(PimWorkflowRef entity : entities){
            Serializable id=entity.getPimworkflowrefid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



