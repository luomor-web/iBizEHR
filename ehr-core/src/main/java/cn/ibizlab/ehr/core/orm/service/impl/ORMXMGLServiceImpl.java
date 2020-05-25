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
import cn.ibizlab.ehr.core.orm.domain.ORMXMGL;
import cn.ibizlab.ehr.core.orm.filter.ORMXMGLSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMXMGLService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMXMGLMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目管理] 服务对象接口实现
 */
@Slf4j
@Service("ORMXMGLServiceImpl")
public class ORMXMGLServiceImpl extends ServiceImpl<ORMXMGLMapper, ORMXMGL> implements IORMXMGLService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMXQJHService ormxmxqjhService;

    private int batchSize = 500;

    @Override
    @Transactional
    public ORMXMGL get(String key) {
        ORMXMGL et = getById(key);
        if(et==null){
            et=new ORMXMGL();
            et.setOrmxmglid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ORMXMGL et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmglid()))&&(!Objects.isNull(this.getById(et.getOrmxmglid())));
    }

    @Override
    public ORMXMGL getDraft(ORMXMGL et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(ORMXMGL et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmglid",et.getOrmxmglid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmglid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMXMGL> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ORMXMGL et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmglid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMXMGL> list) {
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
    public ORMXMGL synchro(ORMXMGL et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMXMGL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMXMGL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ORMXMGL> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ORMXMGL> list) {
        saveOrUpdateBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMXMGL> searchDefault(ORMXMGLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMGL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMGL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 有效项目
     */
    @Override
    public Page<ORMXMGL> searchValidPro(ORMXMGLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMGL> pages=baseMapper.searchValidPro(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMGL>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


