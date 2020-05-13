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
import cn.ibizlab.ehr.core.pim.domain.AppCenter;
import cn.ibizlab.ehr.core.pim.filter.AppCenterSearchContext;
import cn.ibizlab.ehr.core.pim.service.IAppCenterService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.AppCenterMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[应用中心（工作流专用）] 服务对象接口实现
 */
@Slf4j
@Service("AppCenterServiceImpl")
public class AppCenterServiceImpl extends ServiceImpl<AppCenterMapper, AppCenter> implements IAppCenterService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(AppCenter et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AppCenter et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<AppCenter> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(AppCenter et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAppcenterid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AppCenter> list) {
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
    public boolean update(AppCenter et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("appcenterid",et.getAppcenterid())))
            return false;
        CachedBeanCopier.copy(get(et.getAppcenterid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AppCenter> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public AppCenter getDraft(AppCenter et) {
        return et;
    }

    @Override
    @Transactional
    public AppCenter get(String key) {
        AppCenter et = getById(key);
        if(et==null){
            et=new AppCenter();
            et.setAppcenterid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(AppCenter et) {
        return (!ObjectUtils.isEmpty(et.getAppcenterid()))&&(!Objects.isNull(this.getById(et.getAppcenterid())));
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AppCenter> searchDefault(AppCenterSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AppCenter> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AppCenter>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


