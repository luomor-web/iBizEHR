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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsqmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzsqmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzsqmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmJxsygzzsqmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[见习生员工转正申请明细（停用）] 服务对象接口实现
 */
@Slf4j
@Service("PcmJxsygzzsqmxServiceImpl")
public class PcmJxsygzzsqmxServiceImpl extends ServiceImpl<PcmJxsygzzsqmxMapper, PcmJxsygzzsqmx> implements IPcmJxsygzzsqmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzsqService pcmjxsygzzsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PcmJxsygzzsqmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsygzzsqmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmJxsygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmJxsygzzsqmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmJxsygzzsqmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmJxsygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmJxsygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PcmJxsygzzsqmx getDraft(PcmJxsygzzsqmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmJxsygzzsqmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmjxsygzzsqmxid",et.getPcmjxsygzzsqmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsygzzsqmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmJxsygzzsqmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmJxsygzzsqmx get(String key) {
        PcmJxsygzzsqmx et = getById(key);
        if(et==null){
            et=new PcmJxsygzzsqmx();
            et.setPcmjxsygzzsqmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PcmJxsygzzsqmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmjxsygzzsqmxid()))&&(!Objects.isNull(this.getById(et.getPcmjxsygzzsqmxid())));
    }

    @Override
    @Transactional
    public PcmJxsygzzsqmx zZAction(PcmJxsygzzsqmx et) {
        //自定义代码
        return et;
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
    public List<PcmJxsygzzsqmx> selectByPcmjxsygzzsqid(String pcmjxsygzzsqid) {
        return baseMapper.selectByPcmjxsygzzsqid(pcmjxsygzzsqid);
    }

    @Override
    public void removeByPcmjxsygzzsqid(String pcmjxsygzzsqid) {
        this.remove(new QueryWrapper<PcmJxsygzzsqmx>().eq("pcmjxsygzzsqid",pcmjxsygzzsqid));
    }

	@Override
    public List<PcmJxsygzzsqmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmJxsygzzsqmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmJxsygzzsqmx> searchDefault(PcmJxsygzzsqmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmJxsygzzsqmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmJxsygzzsqmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待审核申请
     */
    @Override
    public Page<PcmJxsygzzsqmx> searchDSHSQ(PcmJxsygzzsqmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmJxsygzzsqmx> pages=baseMapper.searchDSHSQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmJxsygzzsqmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmJxsygzzsqmx et){
        //实体关系[DER1N_PCMJXSYGZZSQMX_PCMJXSYGZZSQ_PCMJXSYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPcmjxsygzzsqid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq pcmjxsygzzsq=et.getPcmjxsygzzsq();
            if(ObjectUtils.isEmpty(pcmjxsygzzsq)){
                cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq majorEntity=pcmjxsygzzsqService.get(et.getPcmjxsygzzsqid());
                et.setPcmjxsygzzsq(majorEntity);
                pcmjxsygzzsq=majorEntity;
            }
            et.setPcmjxsygzzsqname(pcmjxsygzzsq.getPcmjxsygzzsqname());
        }
        //实体关系[DER1N_PCMJXSYGZZSQMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setBm(pimperson.getOrmorgsectorname());
            et.setZz(pimperson.getOrmorgname());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setGw(pimperson.getGw());
            et.setZj(pimperson.getRank());
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
    public List<PcmJxsygzzsqmx> getPcmjxsygzzsqmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmJxsygzzsqmx> getPcmjxsygzzsqmxByEntities(List<PcmJxsygzzsqmx> entities) {
        List ids =new ArrayList();
        for(PcmJxsygzzsqmx entity : entities){
            Serializable id=entity.getPcmjxsygzzsqmxid();
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


