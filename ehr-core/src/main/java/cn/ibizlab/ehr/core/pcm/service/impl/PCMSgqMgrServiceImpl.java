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
import cn.ibizlab.ehr.core.pcm.domain.PCMSgqMgr;
import cn.ibizlab.ehr.core.pcm.filter.PCMSgqMgrSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMSgqMgrService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMSgqMgrMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试岗期管理] 服务对象接口实现
 */
@Slf4j
@Service("PCMSgqMgrServiceImpl")
public class PCMSgqMgrServiceImpl extends ServiceImpl<PCMSgqMgrMapper, PCMSgqMgr> implements IPCMSgqMgrService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService pcmbdsqdmxService;
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
    @Transactional
    public PCMSgqMgr sGTG(PCMSgqMgr et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMSgqMgr get(String key) {
        PCMSgqMgr et = getById(key);
        if(et==null){
            et=new PCMSgqMgr();
            et.setPcmsgqmgrid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMSgqMgr sGBTG(PCMSgqMgr et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMSgqMgr et) {
        return (!ObjectUtils.isEmpty(et.getPcmsgqmgrid()))&&(!Objects.isNull(this.getById(et.getPcmsgqmgrid())));
    }

    @Override
    @Transactional
    public boolean update(PCMSgqMgr et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmsgqmgrid",et.getPcmsgqmgrid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmsgqmgrid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMSgqMgr> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMSgqMgr et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmsgqmgrid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMSgqMgr> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMSgqMgr et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMSgqMgr et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMSgqMgr> list) {
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMSgqMgr> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PCMSgqMgr getDraft(PCMSgqMgr et) {
        return et;
    }


	@Override
    public List<PCMSgqMgr> selectByPcmbdsqdmxid(String pcmbdsqdmxid) {
        return baseMapper.selectByPcmbdsqdmxid(pcmbdsqdmxid);
    }

    @Override
    public void removeByPcmbdsqdmxid(String pcmbdsqdmxid) {
        this.remove(new QueryWrapper<PCMSgqMgr>().eq("pcmbdsqdmxid",pcmbdsqdmxid));
    }

	@Override
    public List<PCMSgqMgr> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMSgqMgr>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMSgqMgr> searchDefault(PCMSgqMgrSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMSgqMgr> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMSgqMgr>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


