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
import cn.ibizlab.ehr.core.pcm.domain.PcmTxfpsq;
import cn.ibizlab.ehr.core.pcm.filter.PcmTxfpsqSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmTxfpsqService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmTxfpsqMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[退休返聘申请] 服务对象接口实现
 */
@Slf4j
@Service("PcmTxfpsqServiceImpl")
public class PcmTxfpsqServiceImpl extends ServiceImpl<PcmTxfpsqMapper, PcmTxfpsq> implements IPcmTxfpsqService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmTxfpsqFillPersonInfoLogic fillpersoninfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmTxfpsq fillPersonInfo(PcmTxfpsq et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean update(PcmTxfpsq et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmtxfpsqid",et.getPcmtxfpsqid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmtxfpsqid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmTxfpsq> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmTxfpsq fPCZ(PcmTxfpsq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmTxfpsq get(String key) {
        PcmTxfpsq et = getById(key);
        if(et==null){
            et=new PcmTxfpsq();
            et.setPcmtxfpsqid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmTxfpsq finishFP(PcmTxfpsq et) {
        //自定义代码
        return et;
    }

    @Override
    public PcmTxfpsq getDraft(PcmTxfpsq et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmTxfpsq sHTG(PcmTxfpsq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmTxfpsq sHBTG(PcmTxfpsq et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PcmTxfpsq et) {
        return (!ObjectUtils.isEmpty(et.getPcmtxfpsqid()))&&(!Objects.isNull(this.getById(et.getPcmtxfpsqid())));
    }
    @Override
    @Transactional
    public boolean save(PcmTxfpsq et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmTxfpsq et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmTxfpsq> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmTxfpsq> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PcmTxfpsq et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmtxfpsqid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmTxfpsq> list) {
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
    public List<PcmTxfpsq> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PcmTxfpsq>().eq("pcmprofileid",pcmprofileid));
    }

	@Override
    public List<PcmTxfpsq> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmTxfpsq>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 返聘记录
     */
    @Override
    public Page<PcmTxfpsq> searchFPJL(PcmTxfpsqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmTxfpsq> pages=baseMapper.searchFPJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmTxfpsq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmTxfpsq> searchDefault(PcmTxfpsqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmTxfpsq> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmTxfpsq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 未审核申请
     */
    @Override
    public Page<PcmTxfpsq> searchYXSQDS(PcmTxfpsqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmTxfpsq> pages=baseMapper.searchYXSQDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmTxfpsq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 返聘管理
     */
    @Override
    public Page<PcmTxfpsq> searchFPGL(PcmTxfpsqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmTxfpsq> pages=baseMapper.searchFPGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmTxfpsq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmTxfpsq et){
        //实体关系[DER1N_PCMTXFPSQ_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PcmProfile majorEntity=pcmprofileService.get(et.getPcmprofileid());
                et.setPcmprofile(majorEntity);
                pcmprofile=majorEntity;
            }
            et.setXygbh(pcmprofile.getYgbh());
        }
        //实体关系[DER1N_PCMTXFPSQ_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setZz(pimperson.getOrmorgname());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYzw(pimperson.getZw());
            et.setNl(pimperson.getNl());
            et.setBmid(pimperson.getOrmorgsectorid());
            et.setYgbh(pimperson.getYgbh());
            et.setPostaladdress(pimperson.getPostaladdress());
            et.setYgw(pimperson.getGw());
            et.setRank(pimperson.getRank());
            et.setZzid(pimperson.getOrmorgid());
            et.setTxdq(pimperson.getTxdq());
            et.setLxdh(pimperson.getLxdh());
            et.setBm(pimperson.getOrmorgsectorname());
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
    public List<PcmTxfpsq> getPcmtxfpsqByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmTxfpsq> getPcmtxfpsqByEntities(List<PcmTxfpsq> entities) {
        List ids =new ArrayList();
        for(PcmTxfpsq entity : entities){
            Serializable id=entity.getPcmtxfpsqid();
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



