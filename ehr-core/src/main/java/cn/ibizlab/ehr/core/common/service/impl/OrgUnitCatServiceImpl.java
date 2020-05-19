package cn.ibizlab.ehr.core.common.service.impl;

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
import cn.ibizlab.ehr.core.common.domain.OrgUnitCat;
import cn.ibizlab.ehr.core.common.filter.OrgUnitCatSearchContext;
import cn.ibizlab.ehr.core.common.service.IOrgUnitCatService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.OrgUnitCatMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织单元类别] 服务对象接口实现
 */
@Slf4j
@Service("OrgUnitCatServiceImpl")
public class OrgUnitCatServiceImpl extends ServiceImpl<OrgUnitCatMapper, OrgUnitCat> implements IOrgUnitCatService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(OrgUnitCat et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgunitcatid",et.getOrgunitcatid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrgunitcatid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrgUnitCat> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(OrgUnitCat et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrgunitcatid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrgUnitCat> list) {
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
    public OrgUnitCat getDraft(OrgUnitCat et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrgUnitCat et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrgUnitCat et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<OrgUnitCat> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(OrgUnitCat et) {
        return (!ObjectUtils.isEmpty(et.getOrgunitcatid()))&&(!Objects.isNull(this.getById(et.getOrgunitcatid())));
    }

    @Override
    @Transactional
    public OrgUnitCat get(String key) {
        OrgUnitCat et = getById(key);
        if(et==null){
            et=new OrgUnitCat();
            et.setOrgunitcatid(key);
        }
        else{
        }
        return et;
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrgUnitCat> searchDefault(OrgUnitCatSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgUnitCat> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgUnitCat>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


