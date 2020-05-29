package cn.ibizlab.ehr.core.vac.service.impl;

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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVEMANAGE;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVEMANAGESearchContext;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVEMANAGEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VACLEAVEMANAGEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假管理] 服务对象接口实现
 */
@Slf4j
@Service("VACLEAVEMANAGEServiceImpl")
public class VACLEAVEMANAGEServiceImpl extends ServiceImpl<VACLEAVEMANAGEMapper, VACLEAVEMANAGE> implements IVACLEAVEMANAGEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService vacleavedetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public VACLEAVEMANAGE updateQJMX(VACLEAVEMANAGE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public VACLEAVEMANAGE cB(VACLEAVEMANAGE et) {
        //自定义代码
        return et;
    }

    @Override
    public VACLEAVEMANAGE getDraft(VACLEAVEMANAGE et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public VACLEAVEMANAGE cX(VACLEAVEMANAGE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(VACLEAVEMANAGE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavemanageid",et.getVacleavemanageid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavemanageid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VACLEAVEMANAGE> list) {
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
    @Transactional
    public VACLEAVEMANAGE getFJSJofPerson(VACLEAVEMANAGE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(VACLEAVEMANAGE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VACLEAVEMANAGE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VACLEAVEMANAGE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VACLEAVEMANAGE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(VACLEAVEMANAGE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavemanageid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VACLEAVEMANAGE> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VACLEAVEMANAGE get(String key) {
        VACLEAVEMANAGE et = getById(key);
        if(et==null){
            et=new VACLEAVEMANAGE();
            et.setVacleavemanageid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(VACLEAVEMANAGE et) {
        return (!ObjectUtils.isEmpty(et.getVacleavemanageid()))&&(!Objects.isNull(this.getById(et.getVacleavemanageid())));
    }

    @Override
    @Transactional
    public VACLEAVEMANAGE mobStart(VACLEAVEMANAGE et) {
        //自定义代码
        return et;
    }


	@Override
    public List<VACLEAVEMANAGE> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VACLEAVEMANAGE>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 FormType
     */
    @Override
    public Page<VACLEAVEMANAGE> searchFormType(VACLEAVEMANAGESearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVEMANAGE> pages=baseMapper.searchFormType(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVEMANAGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 个人
     */
    @Override
    public Page<VACLEAVEMANAGE> searchGR(VACLEAVEMANAGESearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVEMANAGE> pages=baseMapper.searchGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVEMANAGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（移动端）
     */
    @Override
    public Page<VACLEAVEMANAGE> searchMOBJLSS(VACLEAVEMANAGESearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVEMANAGE> pages=baseMapper.searchMOBJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVEMANAGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属和人员ID不符的
     */
    @Override
    public Page<VACLEAVEMANAGE> searchJLSS(VACLEAVEMANAGESearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVEMANAGE> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVEMANAGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VACLEAVEMANAGE> searchDefault(VACLEAVEMANAGESearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVEMANAGE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVEMANAGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 只查看审批中、已同意的请假记录
     */
    @Override
    public Page<VACLEAVEMANAGE> searchOnlySPTY(VACLEAVEMANAGESearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVEMANAGE> pages=baseMapper.searchOnlySPTY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVEMANAGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }


    @Autowired
    private cn.ibizlab.ehr.util.client.IBZWFFeignClient ibzwfFeignClient;

    /**
     * 查询工作流待办
     * @param context
     */
    private void fillWFTaskContext(VACLEAVEMANAGESearchContext context){

        if(!StringUtils.isEmpty(context.getUserTaskId()) && !StringUtils.isEmpty(context.getProcessDefinitionKey())){
            List<String> businessKeys= ibzwfFeignClient.getbusinesskeysByUserId("ehr", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser().getUserid(),"vacleavemanages",context.getProcessDefinitionKey(),context.getUserTaskId());
            if(businessKeys.size()>0){
                context.getSelectCond().in("vacleavemanageid",businessKeys);
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
    private void fillParentData(VACLEAVEMANAGE et){
        //实体关系[DER1N_VACLEAVEMANAGE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setOrmorgsectorname(pimperson.getOrmorgsectorname());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setZzdzs(pimperson.getZzdzs());
            et.setYgbh(pimperson.getYgbh());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgname(pimperson.getZzdzs());
            et.setJlss(pimperson.getJlss());
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
    public List<VACLEAVEMANAGE> getVacleavemanageByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VACLEAVEMANAGE> getVacleavemanageByEntities(List<VACLEAVEMANAGE> entities) {
        List ids =new ArrayList();
        for(VACLEAVEMANAGE entity : entities){
            Serializable id=entity.getVacleavemanageid();
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


