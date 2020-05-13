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
import cn.ibizlab.ehr.core.orm.domain.ORMXMRLCB;
import cn.ibizlab.ehr.core.orm.filter.ORMXMRLCBSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMXMRLCBService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMXMRLCBMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目人力成本] 服务对象接口实现
 */
@Slf4j
@Service("ORMXMRLCBServiceImpl")
public class ORMXMRLCBServiceImpl extends ServiceImpl<ORMXMRLCBMapper, ORMXMRLCB> implements IORMXMRLCBService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(ORMXMRLCB et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmrlcbid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMXMRLCB> list) {
        saveBatch(list,batchSize);
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
    public boolean update(ORMXMRLCB et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmrlcbid",et.getOrmxmrlcbid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmrlcbid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMXMRLCB> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(ORMXMRLCB et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmrlcbid()))&&(!Objects.isNull(this.getById(et.getOrmxmrlcbid())));
    }

    @Override
    @Transactional
    public boolean save(ORMXMRLCB et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMXMRLCB et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMXMRLCB> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public ORMXMRLCB getDraft(ORMXMRLCB et) {
        return et;
    }

    @Override
    @Transactional
    public ORMXMRLCB get(String key) {
        ORMXMRLCB et = getById(key);
        if(et==null){
            et=new ORMXMRLCB();
            et.setOrmxmrlcbid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 项目人工成本查询
     */
    @Override
    public Page<ORMXMRLCB> searchCBCX(ORMXMRLCBSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRLCB> pages=baseMapper.searchCBCX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRLCB>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMXMRLCB> searchDefault(ORMXMRLCBSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRLCB> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRLCB>(pages.getRecords(), context.getPageable(), pages.getTotal());
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

