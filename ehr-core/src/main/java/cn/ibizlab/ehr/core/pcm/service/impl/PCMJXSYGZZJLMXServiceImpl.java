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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZJLMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSYGZZJLMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSYGZZJLMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMJXSYGZZJLMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[见习生员工转正记录引用明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMJXSYGZZJLMXServiceImpl")
public class PCMJXSYGZZJLMXServiceImpl extends ServiceImpl<PCMJXSYGZZJLMXMapper, PCMJXSYGZZJLMX> implements IPCMJXSYGZZJLMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMJXSYGZZSQService pcmjxsygzzsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMJXSZZKHJGJLService pcmjxszzkhjgjlService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMJXSYGZZJLMXFillPersonInfoLogic fillpersoninfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PCMJXSYGZZJLMX sHBTG(PCMJXSYGZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMJXSYGZZJLMX sHTG(PCMJXSYGZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMJXSYGZZJLMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMJXSYGZZJLMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMJXSYGZZJLMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMJXSYGZZJLMX fillPersonInfo(PCMJXSYGZZJLMX et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMJXSYGZZJLMX zZCZ(PCMJXSYGZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    public PCMJXSYGZZJLMX getDraft(PCMJXSYGZZJLMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PCMJXSYGZZJLMX get(String key) {
        PCMJXSYGZZJLMX et = getById(key);
        if(et==null){
            et=new PCMJXSYGZZJLMX();
            et.setPcmjxsygzzjlmxid(key);
        }
        else{
        }
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
    @Transactional
    public boolean create(PCMJXSYGZZJLMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsygzzjlmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMJXSYGZZJLMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PCMJXSYGZZJLMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmjxsygzzjlmxid",et.getPcmjxsygzzjlmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsygzzjlmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMJXSYGZZJLMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMJXSYGZZJLMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmjxsygzzjlmxid()))&&(!Objects.isNull(this.getById(et.getPcmjxsygzzjlmxid())));
    }


	@Override
    public List<PCMJXSYGZZJLMX> selectByPcmjxsygzzsqid(String pcmjxsygzzsqid) {
        return baseMapper.selectByPcmjxsygzzsqid(pcmjxsygzzsqid);
    }

    @Override
    public void removeByPcmjxsygzzsqid(String pcmjxsygzzsqid) {
        this.remove(new QueryWrapper<PCMJXSYGZZJLMX>().eq("pcmjxsygzzsqid",pcmjxsygzzsqid));
    }

	@Override
    public List<PCMJXSYGZZJLMX> selectByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) {
        return baseMapper.selectByPcmjxszzkhjgjlid(pcmjxszzkhjgjlid);
    }

    @Override
    public void removeByPcmjxszzkhjgjlid(String pcmjxszzkhjgjlid) {
        this.remove(new QueryWrapper<PCMJXSYGZZJLMX>().eq("pcmjxszzkhjgjlid",pcmjxszzkhjgjlid));
    }

	@Override
    public List<PCMJXSYGZZJLMX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMJXSYGZZJLMX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMJXSYGZZJLMX> searchDefault(PCMJXSYGZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMJXSYGZZJLMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMJXSYGZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 未审核完成的申请
     */
    @Override
    public Page<PCMJXSYGZZJLMX> searchWSHSQ(PCMJXSYGZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMJXSYGZZJLMX> pages=baseMapper.searchWSHSQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMJXSYGZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 见习生转正记录
     */
    @Override
    public Page<PCMJXSYGZZJLMX> searchJXSZZJL(PCMJXSYGZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMJXSYGZZJLMX> pages=baseMapper.searchJXSZZJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMJXSYGZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 所有的申请明细
     */
    @Override
    public Page<PCMJXSYGZZJLMX> searchALLDS(PCMJXSYGZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMJXSYGZZJLMX> pages=baseMapper.searchALLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMJXSYGZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMJXSYGZZJLMX et){
        //实体关系[DER1N_PCMJXSYGZZJLMX_PCMJXSYGZZSQ_PCMJXSYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPcmjxsygzzsqid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZSQ pcmjxsygzzsq=et.getPcmjxsygzzsq();
            if(ObjectUtils.isEmpty(pcmjxsygzzsq)){
                cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZSQ majorEntity=pcmjxsygzzsqService.get(et.getPcmjxsygzzsqid());
                et.setPcmjxsygzzsq(majorEntity);
                pcmjxsygzzsq=majorEntity;
            }
            et.setPcmjxsygzzsqname(pcmjxsygzzsq.getPcmjxsygzzsqname());
        }
        //实体关系[DER1N_PCMJXSYGZZJLMX_PCMJXSZZKHJGJL_PCMJXSZZKHJGJLID]
        if(!ObjectUtils.isEmpty(et.getPcmjxszzkhjgjlid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMJXSZZKHJGJL pcmjxszzkhjgjl=et.getPcmjxszzkhjgjl();
            if(ObjectUtils.isEmpty(pcmjxszzkhjgjl)){
                cn.ibizlab.ehr.core.pcm.domain.PCMJXSZZKHJGJL majorEntity=pcmjxszzkhjgjlService.get(et.getPcmjxszzkhjgjlid());
                et.setPcmjxszzkhjgjl(majorEntity);
                pcmjxszzkhjgjl=majorEntity;
            }
            et.setFs(pcmjxszzkhjgjl.getFs());
            et.setPj(pcmjxszzkhjgjl.getPj());
            et.setPcmjxszzkhjgjlname(pcmjxszzkhjgjl.getPcmjxszzkhjgjlname());
        }
        //实体关系[DER1N_PCMJXSYGZZJLMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


