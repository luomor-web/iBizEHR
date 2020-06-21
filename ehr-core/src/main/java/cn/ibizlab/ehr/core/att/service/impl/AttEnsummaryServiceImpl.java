package cn.ibizlab.ehr.core.att.service.impl;

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
import cn.ibizlab.ehr.core.att.domain.AttEnsummary;
import cn.ibizlab.ehr.core.att.filter.AttEnsummarySearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEnsummaryService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEnsummaryMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤汇总] 服务对象接口实现
 */
@Slf4j
@Service("AttEnsummaryServiceImpl")
public class AttEnsummaryServiceImpl extends ServiceImpl<AttEnsummaryMapper, AttEnsummary> implements IAttEnsummaryService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    public AttEnsummary getDraft(AttEnsummary et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(AttEnsummary et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttensummaryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEnsummary> list) {
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
    public boolean update(AttEnsummary et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attensummaryid",et.getAttensummaryid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttensummaryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEnsummary> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public AttEnsummary get(String key) {
        AttEnsummary et = getById(key);
        if(et==null){
            et=new AttEnsummary();
            et.setAttensummaryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(AttEnsummary et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEnsummary et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEnsummary> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEnsummary> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(AttEnsummary et) {
        return (!ObjectUtils.isEmpty(et.getAttensummaryid()))&&(!Objects.isNull(this.getById(et.getAttensummaryid())));
    }
    @Override
    @Transactional
    public AttEnsummary exportKQHZ(AttEnsummary et) {
        //自定义代码
        return et;
    }


	@Override
    public List<AttEnsummary> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<AttEnsummary>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 当前组织考勤汇总
     */
    @Override
    public Page<AttEnsummary> searchCurZZKQHZ(AttEnsummarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEnsummary> pages=baseMapper.searchCurZZKQHZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEnsummary>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEnsummary> searchDefault(AttEnsummarySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEnsummary> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEnsummary>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(AttEnsummary et){
        //实体关系[DER1N_ATTENSUMMARY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setZw(pimperson.getZw());
            et.setYgbh(pimperson.getYgbh());
            et.setZjhm(pimperson.getZjhm());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgname(pimperson.getZzdzs());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setOrmorgsectorname(pimperson.getOrmorgsectorname());
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
    public List<AttEnsummary> getAttensummaryByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEnsummary> getAttensummaryByEntities(List<AttEnsummary> entities) {
        List ids =new ArrayList();
        for(AttEnsummary entity : entities){
            Serializable id=entity.getAttensummaryid();
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



