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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveManage;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveManageSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveManageService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacLeaveManageMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假管理] 服务对象接口实现
 */
@Slf4j
@Service("VacLeaveManageServiceImpl")
public class VacLeaveManageServiceImpl extends ServiceImpl<VacLeaveManageMapper, VacLeaveManage> implements IVacLeaveManageService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public VacLeaveManage updateQJMX(VacLeaveManage et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public VacLeaveManage cB(VacLeaveManage et) {
        //自定义代码
        return et;
    }

    @Override
    public VacLeaveManage getDraft(VacLeaveManage et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public VacLeaveManage cX(VacLeaveManage et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(VacLeaveManage et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavemanageid",et.getVacleavemanageid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavemanageid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacLeaveManage> list) {
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
    public VacLeaveManage getFJSJofPerson(VacLeaveManage et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(VacLeaveManage et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacLeaveManage et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacLeaveManage> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacLeaveManage> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(VacLeaveManage et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavemanageid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacLeaveManage> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VacLeaveManage get(String key) {
        VacLeaveManage et = getById(key);
        if(et==null){
            et=new VacLeaveManage();
            et.setVacleavemanageid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(VacLeaveManage et) {
        return (!ObjectUtils.isEmpty(et.getVacleavemanageid()))&&(!Objects.isNull(this.getById(et.getVacleavemanageid())));
    }
    @Override
    @Transactional
    public VacLeaveManage mobStart(VacLeaveManage et) {
        //自定义代码
        return et;
    }


	@Override
    public List<VacLeaveManage> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VacLeaveManage>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 FormType
     */
    @Override
    public Page<VacLeaveManage> searchFormType(VacLeaveManageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveManage> pages=baseMapper.searchFormType(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveManage>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 个人
     */
    @Override
    public Page<VacLeaveManage> searchGR(VacLeaveManageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveManage> pages=baseMapper.searchGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveManage>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（移动端）
     */
    @Override
    public Page<VacLeaveManage> searchMOBJLSS(VacLeaveManageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveManage> pages=baseMapper.searchMOBJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveManage>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属和人员ID不符的
     */
    @Override
    public Page<VacLeaveManage> searchJLSS(VacLeaveManageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveManage> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveManage>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacLeaveManage> searchDefault(VacLeaveManageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveManage> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveManage>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 只查看审批中、已同意的请假记录
     */
    @Override
    public Page<VacLeaveManage> searchOnlySPTY(VacLeaveManageSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveManage> pages=baseMapper.searchOnlySPTY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveManage>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacLeaveManage et){
        //实体关系[DER1N_VACLEAVEMANAGE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
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
    public List<VacLeaveManage> getVacleavemanageByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacLeaveManage> getVacleavemanageByEntities(List<VacLeaveManage> entities) {
        List ids =new ArrayList();
        for(VacLeaveManage entity : entities){
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



