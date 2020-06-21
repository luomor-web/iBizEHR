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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzjlmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzjlmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzjlmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmJxsygzzjlmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[见习生员工转正记录引用明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmJxsygzzjlmxServiceImpl")
public class PcmJxsygzzjlmxServiceImpl extends ServiceImpl<PcmJxsygzzjlmxMapper, PcmJxsygzzjlmx> implements IPcmJxsygzzjlmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzsqService pcmjxsygzzsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxszzkhjgjlService pcmjxszzkhjgjlService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmJxsygzzjlmxFillPersonInfoLogic fillpersoninfoLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmJxsygzzjlmxSetPassLogic setpassLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmJxsygzzjlmxSetRejectLogic setrejectLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmJxsygzzjlmx sHBTG(PcmJxsygzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmJxsygzzjlmx sHTG(PcmJxsygzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PcmJxsygzzjlmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmJxsygzzjlmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmJxsygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmJxsygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmJxsygzzjlmx fillPersonInfo(PcmJxsygzzjlmx et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmJxsygzzjlmx zZCZ(PcmJxsygzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmJxsygzzjlmx setPass(PcmJxsygzzjlmx et) {
        setpassLogic.execute(et);
         return et ;
    }

    @Override
    public PcmJxsygzzjlmx getDraft(PcmJxsygzzjlmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmJxsygzzjlmx get(String key) {
        PcmJxsygzzjlmx et = getById(key);
        if(et==null){
            et=new PcmJxsygzzjlmx();
            et.setPcmjxsygzzjlmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmJxsygzzjlmx setReject(PcmJxsygzzjlmx et) {
        setrejectLogic.execute(et);
         return et ;
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
    public boolean create(PcmJxsygzzjlmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsygzzjlmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmJxsygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PcmJxsygzzjlmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmjxsygzzjlmxid",et.getPcmjxsygzzjlmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsygzzjlmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmJxsygzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmJxsygzzjlmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmjxsygzzjlmxid()))&&(!Objects.isNull(this.getById(et.getPcmjxsygzzjlmxid())));
    }

	@Override
    public List<PcmJxsygzzjlmx> selectByPcmjxsygzzsqid(String pcmjxsygzzsqid) {
        return baseMapper.selectByPcmjxsygzzsqid(pcmjxsygzzsqid);
    }

    @Override
    public void removeByPcmjxsygzzsqid(String pcmjxsygzzsqid) {
        this.remove(new QueryWrapper<PcmJxsygzzjlmx>().eq("pcmjxsygzzsqid",pcmjxsygzzsqid));
    }

	@Override
    public List<PcmJxsygzzjlmx> selectByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) {
        return baseMapper.selectByPcmjxszzkhjgjlid(pcmjxszzkhjgjlid);
    }

    @Override
    public void removeByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) {
        this.remove(new QueryWrapper<PcmJxsygzzjlmx>().eq("pcmjxszzkhjgjlid",pcmjxszzkhjgjlid));
    }

	@Override
    public List<PcmJxsygzzjlmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmJxsygzzjlmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmJxsygzzjlmx> searchDefault(PcmJxsygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmJxsygzzjlmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmJxsygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 未审核完成的申请
     */
    @Override
    public Page<PcmJxsygzzjlmx> searchWSHSQ(PcmJxsygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmJxsygzzjlmx> pages=baseMapper.searchWSHSQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmJxsygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 见习生转正记录
     */
    @Override
    public Page<PcmJxsygzzjlmx> searchJXSZZJL(PcmJxsygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmJxsygzzjlmx> pages=baseMapper.searchJXSZZJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmJxsygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 所有的申请明细
     */
    @Override
    public Page<PcmJxsygzzjlmx> searchALLDS(PcmJxsygzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmJxsygzzjlmx> pages=baseMapper.searchALLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmJxsygzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmJxsygzzjlmx et){
        //实体关系[DER1N_PCMJXSYGZZJLMX_PCMJXSYGZZSQ_PCMJXSYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPcmjxsygzzsqid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq pcmjxsygzzsq=et.getPcmjxsygzzsq();
            if(ObjectUtils.isEmpty(pcmjxsygzzsq)){
                cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq majorEntity=pcmjxsygzzsqService.get(et.getPcmjxsygzzsqid());
                et.setPcmjxsygzzsq(majorEntity);
                pcmjxsygzzsq=majorEntity;
            }
            et.setPcmjxsygzzsqname(pcmjxsygzzsq.getPcmjxsygzzsqname());
        }
        //实体关系[DER1N_PCMJXSYGZZJLMX_PCMJXSZZKHJGJL_PCMJXSZZKHJGJLID]
        if(!ObjectUtils.isEmpty(et.getPcmjxszzkhjgjlid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmJxszzkhjgjl pcmjxszzkhjgjl=et.getPcmjxszzkhjgjl();
            if(ObjectUtils.isEmpty(pcmjxszzkhjgjl)){
                cn.ibizlab.ehr.core.pcm.domain.PcmJxszzkhjgjl majorEntity=pcmjxszzkhjgjlService.get(et.getPcmjxszzkhjgjlid());
                et.setPcmjxszzkhjgjl(majorEntity);
                pcmjxszzkhjgjl=majorEntity;
            }
            et.setFs(pcmjxszzkhjgjl.getFs());
            et.setPj(pcmjxszzkhjgjl.getPj());
            et.setPcmjxszzkhjgjlname(pcmjxszzkhjgjl.getPcmjxszzkhjgjlname());
        }
        //实体关系[DER1N_PCMJXSYGZZJLMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setBmid(pimperson.getOrmorgsectorid());
            et.setRzqd(pimperson.getRzqd());
            et.setDuration(pimperson.getDuration());
            et.setZz(pimperson.getZzdzs());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setJssj(pimperson.getJxdq());
            et.setYgbh(pimperson.getYgbh());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setZzid(pimperson.getOrmorgid());
            et.setQssj(pimperson.getDzjbjsj());
            et.setZzgw(pimperson.getGw());
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
    public List<PcmJxsygzzjlmx> getPcmjxsygzzjlmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmJxsygzzjlmx> getPcmjxsygzzjlmxByEntities(List<PcmJxsygzzjlmx> entities) {
        List ids =new ArrayList();
        for(PcmJxsygzzjlmx entity : entities){
            Serializable id=entity.getPcmjxsygzzjlmxid();
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



