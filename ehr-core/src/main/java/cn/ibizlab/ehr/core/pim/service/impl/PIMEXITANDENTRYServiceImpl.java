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
import cn.ibizlab.ehr.core.pim.domain.PIMEXITANDENTRY;
import cn.ibizlab.ehr.core.pim.filter.PIMEXITANDENTRYSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMEXITANDENTRYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMEXITANDENTRYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[出入境管理] 服务对象接口实现
 */
@Slf4j
@Service("PIMEXITANDENTRYServiceImpl")
public class PIMEXITANDENTRYServiceImpl extends ServiceImpl<PIMEXITANDENTRYMapper, PIMEXITANDENTRY> implements IPIMEXITANDENTRYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PIMEXITANDENTRY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimexitandentryid",et.getPimexitandentryid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimexitandentryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMEXITANDENTRY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PIMEXITANDENTRY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMEXITANDENTRY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMEXITANDENTRY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMEXITANDENTRY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMEXITANDENTRY cX(PIMEXITANDENTRY et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMEXITANDENTRY get(String key) {
        PIMEXITANDENTRY et = getById(key);
        if(et==null){
            et=new PIMEXITANDENTRY();
            et.setPimexitandentryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PIMEXITANDENTRY getDraft(PIMEXITANDENTRY et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PIMEXITANDENTRY mobStart(PIMEXITANDENTRY et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PIMEXITANDENTRY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimexitandentryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMEXITANDENTRY> list) {
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
    public PIMEXITANDENTRY cB(PIMEXITANDENTRY et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PIMEXITANDENTRY et) {
        return (!ObjectUtils.isEmpty(et.getPimexitandentryid()))&&(!Objects.isNull(this.getById(et.getPimexitandentryid())));
    }

    @Override
    @Transactional
    public PIMEXITANDENTRY start(PIMEXITANDENTRY et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PIMEXITANDENTRY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMEXITANDENTRY>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 因公出国境
     */
    @Override
    public Page<PIMEXITANDENTRY> searchYGCGJ(PIMEXITANDENTRYSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEXITANDENTRY> pages=baseMapper.searchYGCGJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEXITANDENTRY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 员工自助
     */
    @Override
    public Page<PIMEXITANDENTRY> searchYGZZ(PIMEXITANDENTRYSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEXITANDENTRY> pages=baseMapper.searchYGZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEXITANDENTRY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（移动端）
     */
    @Override
    public Page<PIMEXITANDENTRY> searchMOBJLSS(PIMEXITANDENTRYSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEXITANDENTRY> pages=baseMapper.searchMOBJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEXITANDENTRY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 因私出国境
     */
    @Override
    public Page<PIMEXITANDENTRY> searchYSCGJ(PIMEXITANDENTRYSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEXITANDENTRY> pages=baseMapper.searchYSCGJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEXITANDENTRY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 FormType
     */
    @Override
    public Page<PIMEXITANDENTRY> searchFormType(PIMEXITANDENTRYSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEXITANDENTRY> pages=baseMapper.searchFormType(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEXITANDENTRY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMEXITANDENTRY> searchDefault(PIMEXITANDENTRYSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMEXITANDENTRY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMEXITANDENTRY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }


    @Autowired
    private cn.ibizlab.ehr.util.client.IBZWFFeignClient ibzwfFeignClient;

    /**
     * 查询工作流待办
     * @param context
     */
    private void fillWFTaskContext(PIMEXITANDENTRYSearchContext context){

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
    private void fillParentData(PIMEXITANDENTRY et){
        //实体关系[DER1N_PIMEXITANDENTRY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


