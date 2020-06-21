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
import cn.ibizlab.ehr.core.pim.domain.PimExitandentry;
import cn.ibizlab.ehr.core.pim.filter.PimExitandentrySearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimExitandentryService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimExitandentryMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[出入境管理] 服务对象接口实现
 */
@Slf4j
@Service("PimExitandentryServiceImpl")
public class PimExitandentryServiceImpl extends ServiceImpl<PimExitandentryMapper, PimExitandentry> implements IPimExitandentryService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PimExitandentry et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimexitandentryid",et.getPimexitandentryid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimexitandentryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimExitandentry> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimExitandentry et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimExitandentry et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimExitandentry> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimExitandentry> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimExitandentry cX(PimExitandentry et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimExitandentry get(String key) {
        PimExitandentry et = getById(key);
        if(et==null){
            et=new PimExitandentry();
            et.setPimexitandentryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PimExitandentry getDraft(PimExitandentry et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PimExitandentry mobStart(PimExitandentry et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimExitandentry et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimexitandentryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimExitandentry> list) {
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
    @Transactional
    public PimExitandentry cB(PimExitandentry et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PimExitandentry et) {
        return (!ObjectUtils.isEmpty(et.getPimexitandentryid()))&&(!Objects.isNull(this.getById(et.getPimexitandentryid())));
    }
    @Override
    @Transactional
    public PimExitandentry start(PimExitandentry et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PimExitandentry> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimExitandentry>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 因公出国境
     */
    @Override
    public Page<PimExitandentry> searchYGCGJ(PimExitandentrySearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimExitandentry> pages=baseMapper.searchYGCGJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimExitandentry>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 员工自助
     */
    @Override
    public Page<PimExitandentry> searchYGZZ(PimExitandentrySearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimExitandentry> pages=baseMapper.searchYGZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimExitandentry>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（移动端）
     */
    @Override
    public Page<PimExitandentry> searchMOBJLSS(PimExitandentrySearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimExitandentry> pages=baseMapper.searchMOBJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimExitandentry>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 因私出国境
     */
    @Override
    public Page<PimExitandentry> searchYSCGJ(PimExitandentrySearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimExitandentry> pages=baseMapper.searchYSCGJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimExitandentry>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 FormType
     */
    @Override
    public Page<PimExitandentry> searchFormType(PimExitandentrySearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimExitandentry> pages=baseMapper.searchFormType(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimExitandentry>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimExitandentry> searchDefault(PimExitandentrySearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimExitandentry> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimExitandentry>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }


    @Autowired
    private cn.ibizlab.ehr.util.client.IBZWFFeignClient ibzwfFeignClient;

    /**
     * 查询工作流待办
     * @param context
     */
    private void fillWFTaskContext(PimExitandentrySearchContext context){

        if(!StringUtils.isEmpty(context.getUserTaskId()) && !StringUtils.isEmpty(context.getProcessDefinitionKey())){
            List<String> businessKeys= ibzwfFeignClient.getbusinesskeysByUserId("ehr", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser().getUserid(),"pimexitandentries",context.getProcessDefinitionKey(),context.getUserTaskId());
            if(businessKeys.size()>0){
                context.getSelectCond().in("pimexitandentryid",businessKeys);
            }
            else{
                context.getSelectCond().apply("1<>1");
            }
        }
    }

    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimExitandentry et){
        //实体关系[DER1N_PIMEXITANDENTRY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgname(pimperson.getZzdzs());
            et.setZw(pimperson.getZw());
            et.setYgbh(pimperson.getYgbh());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setRank(pimperson.getRank());
            et.setZzdzs(pimperson.getZzdzs());
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
    public List<PimExitandentry> getPimexitandentryByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimExitandentry> getPimexitandentryByEntities(List<PimExitandentry> entities) {
        List ids =new ArrayList();
        for(PimExitandentry entity : entities){
            Serializable id=entity.getPimexitandentryid();
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



