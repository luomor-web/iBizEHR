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
import cn.ibizlab.ehr.core.pim.domain.PimWorkHistory;
import cn.ibizlab.ehr.core.pim.filter.PimWorkHistorySearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimWorkHistoryService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimWorkHistoryMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作履历] 服务对象接口实现
 */
@Slf4j
@Service("PimWorkHistoryServiceImpl")
public class PimWorkHistoryServiceImpl extends ServiceImpl<PimWorkHistoryMapper, PimWorkHistory> implements IPimWorkHistoryService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmRankService ormrankService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PimWorkHistory get(String key) {
        PimWorkHistory et = getById(key);
        if(et==null){
            et=new PimWorkHistory();
            et.setPimworkhistoryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimWorkHistory et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimworkhistoryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimWorkHistory> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimWorkHistory et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimWorkHistory et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimWorkHistory> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimWorkHistory> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PimWorkHistory et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimworkhistoryid",et.getPimworkhistoryid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimworkhistoryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimWorkHistory> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PimWorkHistory et) {
        return (!ObjectUtils.isEmpty(et.getPimworkhistoryid()))&&(!Objects.isNull(this.getById(et.getPimworkhistoryid())));
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
    public PimWorkHistory getDraft(PimWorkHistory et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PimWorkHistory> selectByOrmrankid(String ormrankid) {
        return baseMapper.selectByOrmrankid(ormrankid);
    }

    @Override
    public void removeByOrmrankid(String ormrankid) {
        this.remove(new QueryWrapper<PimWorkHistory>().eq("ormrankid",ormrankid));
    }

	@Override
    public List<PimWorkHistory> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimWorkHistory>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimWorkHistory> searchDefault(PimWorkHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkHistory> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 是主要工作经历的
     */
    @Override
    public Page<PimWorkHistory> searchIsMain(PimWorkHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkHistory> pages=baseMapper.searchIsMain(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PimWorkHistory> searchJLSSGLY(PimWorkHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkHistory> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属(个人履历)
     */
    @Override
    public Page<PimWorkHistory> searchZIZHU(PimWorkHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkHistory> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PimWorkHistory> searchJLSS(PimWorkHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkHistory> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 非A转正使用
     */
    @Override
    public Page<PimWorkHistory> searchFAZZSY(PimWorkHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkHistory> pages=baseMapper.searchFAZZSY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PimWorkHistory> searchJLSSGR(PimWorkHistorySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimWorkHistory> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimWorkHistory>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimWorkHistory et){
        //实体关系[DER1N_PIMWORKHISTORY_ORMRANK_ORMRANKID]
        if(!ObjectUtils.isEmpty(et.getOrmrankid())){
            cn.ibizlab.ehr.core.orm.domain.OrmRank ormrank=et.getOrmrank();
            if(ObjectUtils.isEmpty(ormrank)){
                cn.ibizlab.ehr.core.orm.domain.OrmRank majorEntity=ormrankService.get(et.getOrmrankid());
                et.setOrmrank(majorEntity);
                ormrank=majorEntity;
            }
            et.setOrmrankname(ormrank.getOrmrankname());
        }
        //实体关系[DER1N_PIMWORKHISTORY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
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
    public List<PimWorkHistory> getPimworkhistoryByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimWorkHistory> getPimworkhistoryByEntities(List<PimWorkHistory> entities) {
        List ids =new ArrayList();
        for(PimWorkHistory entity : entities){
            Serializable id=entity.getPimworkhistoryid();
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



