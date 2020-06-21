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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsqmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzsqmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmXygzzsqmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmXygzzsqmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试用期员工转正申请明细（停用）] 服务对象接口实现
 */
@Slf4j
@Service("PcmXygzzsqmxServiceImpl")
public class PcmXygzzsqmxServiceImpl extends ServiceImpl<PcmXygzzsqmxMapper, PcmXygzzsqmx> implements IPcmXygzzsqmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmXygzzsqService pcmxygzzsqService;
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
    public PcmXygzzsqmx getDraft(PcmXygzzsqmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmXygzzsqmx get(String key) {
        PcmXygzzsqmx et = getById(key);
        if(et==null){
            et=new PcmXygzzsqmx();
            et.setPcmxygzzsqmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmXygzzsqmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmxygzzsqmxid",et.getPcmxygzzsqmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzsqmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmXygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmXygzzsqmx sHBTG(PcmXygzzsqmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmXygzzsqmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzsqmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmXygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmXygzzsqmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmXygzzsqmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmXygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmXygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmXygzzsqmx sHTG(PcmXygzzsqmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmXygzzsqmx zZCZ(PcmXygzzsqmx et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PcmXygzzsqmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmxygzzsqmxid()))&&(!Objects.isNull(this.getById(et.getPcmxygzzsqmxid())));
    }

	@Override
    public List<PcmXygzzsqmx> selectByPcmxygzzsqid(String pcmxygzzsqid) {
        return baseMapper.selectByPcmxygzzsqid(pcmxygzzsqid);
    }

    @Override
    public void removeByPcmxygzzsqid(String pcmxygzzsqid) {
        this.remove(new QueryWrapper<PcmXygzzsqmx>().eq("pcmxygzzsqid",pcmxygzzsqid));
    }

	@Override
    public List<PcmXygzzsqmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmXygzzsqmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 未完成审核的申请
     */
    @Override
    public Page<PcmXygzzsqmx> searchWSHSQ(PcmXygzzsqmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmXygzzsqmx> pages=baseMapper.searchWSHSQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmXygzzsqmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmXygzzsqmx> searchDefault(PcmXygzzsqmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmXygzzsqmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmXygzzsqmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmXygzzsqmx et){
        //实体关系[DER1N_PCMXYGZZSQMX_PCMXYGZZSQ_PCMXYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPcmxygzzsqid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsq pcmxygzzsq=et.getPcmxygzzsq();
            if(ObjectUtils.isEmpty(pcmxygzzsq)){
                cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsq majorEntity=pcmxygzzsqService.get(et.getPcmxygzzsqid());
                et.setPcmxygzzsq(majorEntity);
                pcmxygzzsq=majorEntity;
            }
            et.setPcmxygzzsqname(pcmxygzzsq.getPcmxygzzsqname());
        }
        //实体关系[DER1N_PCMXYGZZSQMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setBm(pimperson.getOrmorgsectorname());
            et.setGw(pimperson.getGw());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setZj(pimperson.getRank());
            et.setZz(pimperson.getOrmorgname());
            et.setZw(pimperson.getZw());
        }
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
    public List<PcmXygzzsqmx> getPcmxygzzsqmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmXygzzsqmx> getPcmxygzzsqmxByEntities(List<PcmXygzzsqmx> entities) {
        List ids =new ArrayList();
        for(PcmXygzzsqmx entity : entities){
            Serializable id=entity.getPcmxygzzsqmxid();
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



