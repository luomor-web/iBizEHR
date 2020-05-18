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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZSQMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMXYGZZSQMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[试用期员工转正申请明细（停用）] 服务对象接口实现
 */
@Slf4j
@Service("PCMXYGZZSQMXServiceImpl")
public class PCMXYGZZSQMXServiceImpl extends ServiceImpl<PCMXYGZZSQMXMapper, PCMXYGZZSQMX> implements IPCMXYGZZSQMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQService pcmxygzzsqService;
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
    public PCMXYGZZSQMX getDraft(PCMXYGZZSQMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PCMXYGZZSQMX get(String key) {
        PCMXYGZZSQMX et = getById(key);
        if(et==null){
            et=new PCMXYGZZSQMX();
            et.setPcmxygzzsqmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMXYGZZSQMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmxygzzsqmxid",et.getPcmxygzzsqmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzsqmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMXYGZZSQMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMXYGZZSQMX sHBTG(PCMXYGZZSQMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMXYGZZSQMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmxygzzsqmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMXYGZZSQMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMXYGZZSQMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMXYGZZSQMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMXYGZZSQMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMXYGZZSQMX sHTG(PCMXYGZZSQMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMXYGZZSQMX zZCZ(PCMXYGZZSQMX et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMXYGZZSQMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmxygzzsqmxid()))&&(!Objects.isNull(this.getById(et.getPcmxygzzsqmxid())));
    }


	@Override
    public List<PCMXYGZZSQMX> selectByPcmxygzzsqid(String pcmxygzzsqid) {
        return baseMapper.selectByPcmxygzzsqid(pcmxygzzsqid);
    }

    @Override
    public void removeByPcmxygzzsqid(String pcmxygzzsqid) {
        this.remove(new QueryWrapper<PCMXYGZZSQMX>().eq("pcmxygzzsqid",pcmxygzzsqid));
    }

	@Override
    public List<PCMXYGZZSQMX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMXYGZZSQMX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 未完成审核的申请
     */
    @Override
    public Page<PCMXYGZZSQMX> searchWSHSQ(PCMXYGZZSQMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMXYGZZSQMX> pages=baseMapper.searchWSHSQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMXYGZZSQMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMXYGZZSQMX> searchDefault(PCMXYGZZSQMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMXYGZZSQMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMXYGZZSQMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMXYGZZSQMX et){
        //实体关系[DER1N_PCMXYGZZSQMX_PCMXYGZZSQ_PCMXYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPcmxygzzsqid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQ pcmxygzzsq=et.getPcmxygzzsq();
            if(ObjectUtils.isEmpty(pcmxygzzsq)){
                cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQ majorEntity=pcmxygzzsqService.get(et.getPcmxygzzsqid());
                et.setPcmxygzzsq(majorEntity);
                pcmxygzzsq=majorEntity;
            }
            et.setPcmxygzzsqname(pcmxygzzsq.getPcmxygzzsqname());
        }
        //实体关系[DER1N_PCMXYGZZSQMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


