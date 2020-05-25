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
import cn.ibizlab.ehr.core.pim.domain.PIMWORKHISTORY;
import cn.ibizlab.ehr.core.pim.filter.PIMWORKHISTORYSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMWORKHISTORYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMWORKHISTORYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作履历] 服务对象接口实现
 */
@Slf4j
@Service("PIMWORKHISTORYServiceImpl")
public class PIMWORKHISTORYServiceImpl extends ServiceImpl<PIMWORKHISTORYMapper, PIMWORKHISTORY> implements IPIMWORKHISTORYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMRANKService ormrankService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PIMWORKHISTORY get(String key) {
        PIMWORKHISTORY et = getById(key);
        if(et==null){
            et=new PIMWORKHISTORY();
            et.setPimworkhistoryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PIMWORKHISTORY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimworkhistoryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMWORKHISTORY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PIMWORKHISTORY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMWORKHISTORY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMWORKHISTORY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMWORKHISTORY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PIMWORKHISTORY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimworkhistoryid",et.getPimworkhistoryid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimworkhistoryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMWORKHISTORY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PIMWORKHISTORY et) {
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
    public PIMWORKHISTORY getDraft(PIMWORKHISTORY et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PIMWORKHISTORY> selectByOrmrankid(String ormrankid) {
        return baseMapper.selectByOrmrankid(ormrankid);
    }

    @Override
    public void removeByOrmrankid(String ormrankid) {
        this.remove(new QueryWrapper<PIMWORKHISTORY>().eq("ormrankid",ormrankid));
    }

	@Override
    public List<PIMWORKHISTORY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMWORKHISTORY>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMWORKHISTORY> searchDefault(PIMWORKHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMWORKHISTORY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMWORKHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 是主要工作经历的
     */
    @Override
    public Page<PIMWORKHISTORY> searchIsMain(PIMWORKHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMWORKHISTORY> pages=baseMapper.searchIsMain(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMWORKHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PIMWORKHISTORY> searchJLSSGLY(PIMWORKHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMWORKHISTORY> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMWORKHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属(个人履历)
     */
    @Override
    public Page<PIMWORKHISTORY> searchZIZHU(PIMWORKHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMWORKHISTORY> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMWORKHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PIMWORKHISTORY> searchJLSS(PIMWORKHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMWORKHISTORY> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMWORKHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 非A转正使用
     */
    @Override
    public Page<PIMWORKHISTORY> searchFAZZSY(PIMWORKHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMWORKHISTORY> pages=baseMapper.searchFAZZSY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMWORKHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PIMWORKHISTORY> searchJLSSGR(PIMWORKHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMWORKHISTORY> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMWORKHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMWORKHISTORY et){
        //实体关系[DER1N_PIMWORKHISTORY_ORMRANK_ORMRANKID]
        if(!ObjectUtils.isEmpty(et.getOrmrankid())){
            cn.ibizlab.ehr.core.orm.domain.ORMRANK ormrank=et.getOrmrank();
            if(ObjectUtils.isEmpty(ormrank)){
                cn.ibizlab.ehr.core.orm.domain.ORMRANK majorEntity=ormrankService.get(et.getOrmrankid());
                et.setOrmrank(majorEntity);
                ormrank=majorEntity;
            }
            et.setOrmrankname(ormrank.getOrmrankname());
        }
        //实体关系[DER1N_PIMWORKHISTORY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


