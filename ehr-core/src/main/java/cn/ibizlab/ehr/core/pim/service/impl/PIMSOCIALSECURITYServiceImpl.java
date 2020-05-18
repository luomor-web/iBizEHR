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
import cn.ibizlab.ehr.core.pim.domain.PIMSOCIALSECURITY;
import cn.ibizlab.ehr.core.pim.filter.PIMSOCIALSECURITYSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMSOCIALSECURITYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMSOCIALSECURITYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[社保信息] 服务对象接口实现
 */
@Slf4j
@Service("PIMSOCIALSECURITYServiceImpl")
public class PIMSOCIALSECURITYServiceImpl extends ServiceImpl<PIMSOCIALSECURITYMapper, PIMSOCIALSECURITY> implements IPIMSOCIALSECURITYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

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
    public boolean checkKey(PIMSOCIALSECURITY et) {
        return (!ObjectUtils.isEmpty(et.getPimsocialsecurityid()))&&(!Objects.isNull(this.getById(et.getPimsocialsecurityid())));
    }

    @Override
    @Transactional
    public PIMSOCIALSECURITY get(String key) {
        PIMSOCIALSECURITY et = getById(key);
        if(et==null){
            et=new PIMSOCIALSECURITY();
            et.setPimsocialsecurityid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PIMSOCIALSECURITY getDraft(PIMSOCIALSECURITY et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(PIMSOCIALSECURITY et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimsocialsecurityid",et.getPimsocialsecurityid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimsocialsecurityid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMSOCIALSECURITY> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMSOCIALSECURITY et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimsocialsecurityid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMSOCIALSECURITY> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PIMSOCIALSECURITY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMSOCIALSECURITY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMSOCIALSECURITY> list) {
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PIMSOCIALSECURITY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMSOCIALSECURITY>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 自助(社保信息)
     */
    @Override
    public Page<PIMSOCIALSECURITY> searchZIZHU(PIMSOCIALSECURITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMSOCIALSECURITY> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMSOCIALSECURITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMSOCIALSECURITY> searchDefault(PIMSOCIALSECURITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMSOCIALSECURITY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMSOCIALSECURITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PIMSOCIALSECURITY> searchJLSS(PIMSOCIALSECURITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMSOCIALSECURITY> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMSOCIALSECURITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


