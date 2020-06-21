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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdlzmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdlzmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdlzmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmYdlzmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动离职明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmYdlzmxServiceImpl")
public class PcmYdlzmxServiceImpl extends ServiceImpl<PcmYdlzmxMapper, PcmYdlzmx> implements IPcmYdlzmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmYdlzmxSetFinishedLogic setfinishedLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PcmYdlzmx et) {
        fillParentData(et);
        pcmydmxService.update(pcmydlzmxInheritMapping.toPcmydmx(et));
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydlzmxid",et.getPcmydlzmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydlzmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmYdlzmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmYdlzmx isFinished(PcmYdlzmx et) {
        setfinishedLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmYdlzmx fillPersonInfo(PcmYdlzmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmYdlzmx get(String key) {
        PcmYdlzmx et = getById(key);
        if(et==null){
            et=new PcmYdlzmx();
            et.setPcmydlzmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmYdlzmx et) {
        fillParentData(et);
        createIndexMajorEntityData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydlzmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmYdlzmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmYdlzmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmydlzmxid()))&&(!Objects.isNull(this.getById(et.getPcmydlzmxid())));
    }
    @Override
    public PcmYdlzmx getDraft(PcmYdlzmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PcmYdlzmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmYdlzmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmYdlzmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmYdlzmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        pcmydmxService.remove(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }


	@Override
    public List<PcmYdlzmx> selectByLzmtrid(String pimpersonid) {
        return baseMapper.selectByLzmtrid(pimpersonid);
    }

    @Override
    public void removeByLzmtrid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmYdlzmx>().eq("lzmtrid",pimpersonid));
    }


    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PcmYdlzmx> searchGLDQ(PcmYdlzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdlzmx> pages=baseMapper.searchGLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdlzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录查询
     */
    @Override
    public Page<PcmYdlzmx> searchJLDQ(PcmYdlzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdlzmx> pages=baseMapper.searchJLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdlzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmYdlzmx> searchDefault(PcmYdlzmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmYdlzmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmYdlzmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmYdlzmx et){
        //实体关系[DER1N_PCMYDLZMX_PIMPERSON_LZMTRID]
        if(!ObjectUtils.isEmpty(et.getLzmtrid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson lzmtr=et.getLzmtr();
            if(ObjectUtils.isEmpty(lzmtr)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getLzmtrid());
                et.setLzmtr(majorEntity);
                lzmtr=majorEntity;
            }
            et.setLzmtrname(lzmtr.getPimpersonname());
        }
    }



    @Autowired
    cn.ibizlab.ehr.core.pcm.mapping.PcmYdlzmxInheritMapping pcmydlzmxInheritMapping;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService pcmydmxService;

    /**
     * 创建索引主实体数据
     * @param et
     */
    private void createIndexMajorEntityData(PcmYdlzmx et){
        if(ObjectUtils.isEmpty(et.getPcmydlzmxid()))
            et.setPcmydlzmxid((String)et.getDefaultKey(true));
        cn.ibizlab.ehr.core.pcm.domain.PcmYdmx pcmydmx =pcmydlzmxInheritMapping.toPcmydmx(et);
        pcmydmx.set("pcmydmxtype","30");
        pcmydmxService.create(pcmydmx);
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
    public List<PcmYdlzmx> getPcmydlzmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmYdlzmx> getPcmydlzmxByEntities(List<PcmYdlzmx> entities) {
        List ids =new ArrayList();
        for(PcmYdlzmx entity : entities){
            Serializable id=entity.getPcmydlzmxid();
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



