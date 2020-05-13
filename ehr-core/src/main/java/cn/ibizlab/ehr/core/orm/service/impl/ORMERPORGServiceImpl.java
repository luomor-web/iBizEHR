package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.ORMERPORG;
import cn.ibizlab.ehr.core.orm.filter.ORMERPORGSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMERPORGService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMERPORGMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[ERP组织中间表] 服务对象接口实现
 */
@Slf4j
@Service("ORMERPORGServiceImpl")
public class ORMERPORGServiceImpl extends ServiceImpl<ORMERPORGMapper, ORMERPORG> implements IORMERPORGService {


    private int batchSize = 500;

    @Override
    @Transactional
    public ORMERPORG get(String key) {
        ORMERPORG et = getById(key);
        if(et==null){
            et=new ORMERPORG();
            et.setOrmerporgid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(ORMERPORG et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormerporgid",et.getOrmerporgid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmerporgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMERPORG> list) {
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
    public ORMERPORG synOrg(ORMERPORG et) {
        //自定义代码
        return et;
    }

    @Override
    public ORMERPORG getDraft(ORMERPORG et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMERPORG et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMERPORG et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMERPORG> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ORMERPORG et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmerporgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMERPORG> list) {
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ORMERPORG et) {
        return (!ObjectUtils.isEmpty(et.getOrmerporgid()))&&(!Objects.isNull(this.getById(et.getOrmerporgid())));
    }



    /**
     * 查询集合 查询可用ERP部门
     */
    @Override
    public Page<ORMERPORG> searchCXBM(ORMERPORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMERPORG> pages=baseMapper.searchCXBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMERPORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 管理单位选择
     */
    @Override
    public Page<ORMERPORG> searchLegalChoice(ORMERPORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMERPORG> pages=baseMapper.searchLegalChoice(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMERPORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMERPORG> searchDefault(ORMERPORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMERPORG> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMERPORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询可用ERP组织
     */
    @Override
    public Page<ORMERPORG> searchCX(ORMERPORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMERPORG> pages=baseMapper.searchCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMERPORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询可用ERP部门
     */
    @Override
    public Page<ORMERPORG> searchCXZBM(ORMERPORGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMERPORG> pages=baseMapper.searchCXZBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMERPORG>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


