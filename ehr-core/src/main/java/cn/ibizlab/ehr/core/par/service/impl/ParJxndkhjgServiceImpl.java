package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.ParJxndkhjg;
import cn.ibizlab.ehr.core.par.filter.ParJxndkhjgSearchContext;
import cn.ibizlab.ehr.core.par.service.IParJxndkhjgService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.ParJxndkhjgMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效年度考核结果] 服务对象接口实现
 */
@Slf4j
@Service("ParJxndkhjgServiceImpl")
public class ParJxndkhjgServiceImpl extends ServiceImpl<ParJxndkhjgMapper, ParJxndkhjg> implements IParJxndkhjgService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(ParJxndkhjg et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ParJxndkhjg et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ParJxndkhjg> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ParJxndkhjg> list) {
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
    public ParJxndkhjg getDraft(ParJxndkhjg et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(ParJxndkhjg et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxndkhjgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ParJxndkhjg> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ParJxndkhjg et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxndkhjgid",et.getParjxndkhjgid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxndkhjgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ParJxndkhjg> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public ParJxndkhjg get(String key) {
        ParJxndkhjg et = getById(key);
        if(et==null){
            et=new ParJxndkhjg();
            et.setParjxndkhjgid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ParJxndkhjg et) {
        return (!ObjectUtils.isEmpty(et.getParjxndkhjgid()))&&(!Objects.isNull(this.getById(et.getParjxndkhjgid())));
    }

	@Override
    public List<ParJxndkhjg> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ParJxndkhjg>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ParJxndkhjg> searchDefault(ParJxndkhjgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParJxndkhjg> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParJxndkhjg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 最近2年下半年考核成绩
     */
    @Override
    public Page<ParJxndkhjg> searchLastTwoYear(ParJxndkhjgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ParJxndkhjg> pages=baseMapper.searchLastTwoYear(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ParJxndkhjg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ParJxndkhjg et){
        //实体关系[DER1N_PARJXNDKHJG_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
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
    public List<ParJxndkhjg> getParjxndkhjgByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ParJxndkhjg> getParjxndkhjgByEntities(List<ParJxndkhjg> entities) {
        List ids =new ArrayList();
        for(ParJxndkhjg entity : entities){
            Serializable id=entity.getParjxndkhjgid();
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



