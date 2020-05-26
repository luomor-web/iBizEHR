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
import cn.ibizlab.ehr.core.pcm.domain.PCMTXFPSQ;
import cn.ibizlab.ehr.core.pcm.filter.PCMTXFPSQSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMTXFPSQService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMTXFPSQMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[退休返聘申请] 服务对象接口实现
 */
@Slf4j
@Service("PCMTXFPSQServiceImpl")
public class PCMTXFPSQServiceImpl extends ServiceImpl<PCMTXFPSQMapper, PCMTXFPSQ> implements IPCMTXFPSQService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMTXFPSQFillPersonInfoLogic fillpersoninfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PCMTXFPSQ fillPersonInfo(PCMTXFPSQ et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean update(PCMTXFPSQ et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmtxfpsqid",et.getPcmtxfpsqid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmtxfpsqid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMTXFPSQ> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMTXFPSQ fPCZ(PCMTXFPSQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMTXFPSQ get(String key) {
        PCMTXFPSQ et = getById(key);
        if(et==null){
            et=new PCMTXFPSQ();
            et.setPcmtxfpsqid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMTXFPSQ finishFP(PCMTXFPSQ et) {
        //自定义代码
        return et;
    }

    @Override
    public PCMTXFPSQ getDraft(PCMTXFPSQ et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PCMTXFPSQ sHTG(PCMTXFPSQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMTXFPSQ sHBTG(PCMTXFPSQ et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMTXFPSQ et) {
        return (!ObjectUtils.isEmpty(et.getPcmtxfpsqid()))&&(!Objects.isNull(this.getById(et.getPcmtxfpsqid())));
    }

    @Override
    @Transactional
    public boolean save(PCMTXFPSQ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMTXFPSQ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMTXFPSQ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMTXFPSQ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMTXFPSQ et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmtxfpsqid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMTXFPSQ> list) {
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
    public List<PCMTXFPSQ> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PCMTXFPSQ>().eq("pcmprofileid",pcmprofileid));
    }

	@Override
    public List<PCMTXFPSQ> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMTXFPSQ>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 返聘记录
     */
    @Override
    public Page<PCMTXFPSQ> searchFPJL(PCMTXFPSQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMTXFPSQ> pages=baseMapper.searchFPJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMTXFPSQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMTXFPSQ> searchDefault(PCMTXFPSQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMTXFPSQ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMTXFPSQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 未审核申请
     */
    @Override
    public Page<PCMTXFPSQ> searchYXSQDS(PCMTXFPSQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMTXFPSQ> pages=baseMapper.searchYXSQDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMTXFPSQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 返聘管理
     */
    @Override
    public Page<PCMTXFPSQ> searchFPGL(PCMTXFPSQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMTXFPSQ> pages=baseMapper.searchFPGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMTXFPSQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMTXFPSQ et){
        //实体关系[DER1N_PCMTXFPSQ_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE majorEntity=pcmprofileService.get(et.getPcmprofileid());
                et.setPcmprofile(majorEntity);
                pcmprofile=majorEntity;
            }
            et.setXygbh(pcmprofile.getYgbh());
        }
        //实体关系[DER1N_PCMTXFPSQ_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


