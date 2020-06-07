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
import cn.ibizlab.ehr.core.pcm.domain.PcmSgqMgr;
import cn.ibizlab.ehr.core.pcm.filter.PcmSgqMgrSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmSgqMgrService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmSgqMgrMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试岗期管理] 服务对象接口实现
 */
@Slf4j
@Service("PcmSgqMgrServiceImpl")
public class PcmSgqMgrServiceImpl extends ServiceImpl<PcmSgqMgrMapper, PcmSgqMgr> implements IPcmSgqMgrService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

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
    @Transactional
    public PcmSgqMgr sGTG(PcmSgqMgr et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmSgqMgr get(String key) {
        PcmSgqMgr et = getById(key);
        if(et==null){
            et=new PcmSgqMgr();
            et.setPcmsgqmgrid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmSgqMgr sGBTG(PcmSgqMgr et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PcmSgqMgr et) {
        return (!ObjectUtils.isEmpty(et.getPcmsgqmgrid()))&&(!Objects.isNull(this.getById(et.getPcmsgqmgrid())));
    }

    @Override
    @Transactional
    public boolean update(PcmSgqMgr et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmsgqmgrid",et.getPcmsgqmgrid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmsgqmgrid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmSgqMgr> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PcmSgqMgr et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmsgqmgrid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmSgqMgr> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmSgqMgr et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmSgqMgr et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmSgqMgr> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmSgqMgr> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PcmSgqMgr getDraft(PcmSgqMgr et) {
        return et;
    }


	@Override
    public List<PcmSgqMgr> selectByPcmbdsqdmxid(String pcmbdsqdmxid) {
        return baseMapper.selectByPcmbdsqdmxid(pcmbdsqdmxid);
    }

    @Override
    public void removeByPcmbdsqdmxid(String pcmbdsqdmxid) {
        this.remove(new QueryWrapper<PcmSgqMgr>().eq("pcmbdsqdmxid",pcmbdsqdmxid));
    }

	@Override
    public List<PcmSgqMgr> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmSgqMgr>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmSgqMgr> searchDefault(PcmSgqMgrSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmSgqMgr> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmSgqMgr>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
    public List<PcmSgqMgr> getPcmsgqmgrByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmSgqMgr> getPcmsgqmgrByEntities(List<PcmSgqMgr> entities) {
        List ids =new ArrayList();
        for(PcmSgqMgr entity : entities){
            Serializable id=entity.getPcmsgqmgrid();
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


