package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.SGQMgr;
import cn.ibizlab.ehr.core.pcm.filter.SGQMgrSearchContext;
import cn.ibizlab.ehr.core.pcm.service.ISGQMgrService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.SGQMgrMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试岗期管理（弃用）] 服务对象接口实现
 */
@Slf4j
@Service("SGQMgrServiceImpl")
public class SGQMgrServiceImpl extends ServiceImpl<SGQMgrMapper, SGQMgr> implements ISGQMgrService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public SGQMgr get(String key) {
        SGQMgr et = getById(key);
        if(et==null){
            et=new SGQMgr();
            et.setSgqmgrid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public SGQMgr getDraft(SGQMgr et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(SGQMgr et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSgqmgrid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SGQMgr> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SGQMgr et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("sgqmgrid",et.getSgqmgrid())))
            return false;
        CachedBeanCopier.copy(get(et.getSgqmgrid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SGQMgr> list) {
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
    public boolean checkKey(SGQMgr et) {
        return (!ObjectUtils.isEmpty(et.getSgqmgrid()))&&(!Objects.isNull(this.getById(et.getSgqmgrid())));
    }

    @Override
    @Transactional
    public boolean save(SGQMgr et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SGQMgr et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SGQMgr> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SGQMgr> list) {
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SGQMgr> selectByPcmbdsqdmxid(String pcmbdsqdmxid) {
        return baseMapper.selectByPcmbdsqdmxid(pcmbdsqdmxid);
    }

    @Override
    public void removeByPcmbdsqdmxid(String pcmbdsqdmxid) {
        this.remove(new QueryWrapper<SGQMgr>().eq("pcmbdsqdmxid",pcmbdsqdmxid));
    }

	@Override
    public List<SGQMgr> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<SGQMgr>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SGQMgr> searchDefault(SGQMgrSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SGQMgr> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SGQMgr>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


