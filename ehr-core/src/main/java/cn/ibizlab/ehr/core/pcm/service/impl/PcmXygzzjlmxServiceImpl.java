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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzjlmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzjlmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmXygzzjlmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmXygzzjlmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试用期员工转正记录引用明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmXygzzjlmxServiceImpl")
public class PcmXygzzjlmxServiceImpl extends ServiceImpl<PcmXygzzjlmxMapper, PcmXygzzjlmx> implements IPcmXygzzjlmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmXygzzkhjgjlService pcmxygzzkhjgjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmXygzzsqService pcmxygzzsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmXygzzjlmxSetPersonInfoLogic setpersoninfoLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmXygzzjlmxSetPassLogic setpassLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmXygzzjlmxSetRejectLogic setrejectLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmXygzzjlmx xYGZZCZ(PcmXygzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmXygzzjlmx get(String key) {
        PcmXygzzjlmx et = getById(key);
        if(et==null){
            et=new PcmXygzzjlmx();
            et.setPcmxygzzjlmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmXygzzjlmx sHTG(PcmXygzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmXygzzjlmx fillPersonInfo(PcmXygzzjlmx et) {
        setpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmXygzzjlmx setPass(PcmXygzzjlmx et) {
        setpassLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean create(PcmXygzzjlmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzjlmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmXygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
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
    public boolean checkKey(PcmXygzzjlmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmxygzzjlmxid()))&&(!Objects.isNull(this.getById(et.getPcmxygzzjlmxid())));
    }
    @Override
    @Transactional
    public boolean update(PcmXygzzjlmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmxygzzjlmxid",et.getPcmxygzzjlmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzjlmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmXygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PcmXygzzjlmx getDraft(PcmXygzzjlmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmXygzzjlmx setRejcet(PcmXygzzjlmx et) {
        setrejectLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmXygzzjlmx sHBTG(PcmXygzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PcmXygzzjlmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmXygzzjlmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmXygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmXygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PcmXygzzjlmx> selectByPcmxygzzkhjgjlid(String pcmxygzzkhjgjlid) {
        return baseMapper.selectByPcmxygzzkhjgjlid(pcmxygzzkhjgjlid);
    }

    @Override
    public void removeByPcmxygzzkhjgjlid(String pcmxygzzkhjgjlid) {
        this.remove(new QueryWrapper<PcmXygzzjlmx>().eq("pcmxygzzkhjgjlid",pcmxygzzkhjgjlid));
    }

	@Override
    public List<PcmXygzzjlmx> selectByPcmxygzzsqid(String pcmxygzzsqid) {
        return baseMapper.selectByPcmxygzzsqid(pcmxygzzsqid);
    }

    @Override
    public void removeByPcmxygzzsqid(String pcmxygzzsqid) {
        this.remove(new QueryWrapper<PcmXygzzjlmx>().eq("pcmxygzzsqid",pcmxygzzsqid));
    }

	@Override
    public List<PcmXygzzjlmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmXygzzjlmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 试用期转正申请未审核
     */
    @Override
    public Page<PcmXygzzjlmx> searchZZWSHDS(PcmXygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmXygzzjlmx> pages=baseMapper.searchZZWSHDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmXygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 所有的试用期转正申请
     */
    @Override
    public Page<PcmXygzzjlmx> searchALLDS(PcmXygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmXygzzjlmx> pages=baseMapper.searchALLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmXygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 试用期转正记录
     */
    @Override
    public Page<PcmXygzzjlmx> searchSYQZZJL(PcmXygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmXygzzjlmx> pages=baseMapper.searchSYQZZJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmXygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmXygzzjlmx> searchDefault(PcmXygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmXygzzjlmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmXygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmXygzzjlmx et){
        //实体关系[DER1N_PCMXYGZZJLMX_PCMXYGZZKHJGJL_PCMXYGZZKHJGJLID]
        if(!ObjectUtils.isEmpty(et.getPcmxygzzkhjgjlid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmXygzzkhjgjl pcmxygzzkhjgjl=et.getPcmxygzzkhjgjl();
            if(ObjectUtils.isEmpty(pcmxygzzkhjgjl)){
                cn.ibizlab.ehr.core.pcm.domain.PcmXygzzkhjgjl majorEntity=pcmxygzzkhjgjlService.get(et.getPcmxygzzkhjgjlid());
                et.setPcmxygzzkhjgjl(majorEntity);
                pcmxygzzkhjgjl=majorEntity;
            }
            et.setPcmxygzzkhjgjlname(pcmxygzzkhjgjl.getPcmxygzzkhjgjlname());
            et.setFs(pcmxygzzkhjgjl.getFs());
            et.setPj(pcmxygzzkhjgjl.getPj());
        }
        //实体关系[DER1N_PCMXYGZZJLMX_PCMXYGZZSQ_PCMXYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPcmxygzzsqid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsq pcmxygzzsq=et.getPcmxygzzsq();
            if(ObjectUtils.isEmpty(pcmxygzzsq)){
                cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsq majorEntity=pcmxygzzsqService.get(et.getPcmxygzzsqid());
                et.setPcmxygzzsq(majorEntity);
                pcmxygzzsq=majorEntity;
            }
            et.setPcmxygzzsqname(pcmxygzzsq.getPcmxygzzsqname());
        }
        //实体关系[DER1N_PCMXYGZZJLMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setRzqd(pimperson.getRzqd());
            et.setJssj(pimperson.getSydq());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setDuration(pimperson.getDuration());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
            et.setQssj(pimperson.getDzjbjsj());
            et.setZz(pimperson.getZzdzs());
            et.setZzgw(pimperson.getGw());
            et.setZzid(pimperson.getOrmorgid());
            et.setBmid(pimperson.getOrmorgsectorid());
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
    public List<PcmXygzzjlmx> getPcmxygzzjlmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmXygzzjlmx> getPcmxygzzjlmxByEntities(List<PcmXygzzjlmx> entities) {
        List ids =new ArrayList();
        for(PcmXygzzjlmx entity : entities){
            Serializable id=entity.getPcmxygzzjlmxid();
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



