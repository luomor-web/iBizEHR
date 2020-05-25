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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEAPPROVAL;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEAPPROVALSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEAPPROVALService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMPROFILEAPPROVALMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[应聘者审批表] 服务对象接口实现
 */
@Slf4j
@Service("PCMPROFILEAPPROVALServiceImpl")
public class PCMPROFILEAPPROVALServiceImpl extends ServiceImpl<PCMPROFILEAPPROVALMapper, PCMPROFILEAPPROVAL> implements IPCMPROFILEAPPROVALService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService pimbyzzjlmxService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PCMPROFILEAPPROVAL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmprofileapprovalid",et.getPcmprofileapprovalid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileapprovalid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMPROFILEAPPROVAL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PCMPROFILEAPPROVAL getDraft(PCMPROFILEAPPROVAL et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMPROFILEAPPROVAL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofileapprovalid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMPROFILEAPPROVAL> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMPROFILEAPPROVAL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMPROFILEAPPROVAL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMPROFILEAPPROVAL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMPROFILEAPPROVAL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
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
    public PCMPROFILEAPPROVAL get(String key) {
        PCMPROFILEAPPROVAL et = getById(key);
        if(et==null){
            et=new PCMPROFILEAPPROVAL();
            et.setPcmprofileapprovalid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PCMPROFILEAPPROVAL et) {
        return (!ObjectUtils.isEmpty(et.getPcmprofileapprovalid()))&&(!Objects.isNull(this.getById(et.getPcmprofileapprovalid())));
    }


	@Override
    public List<PCMPROFILEAPPROVAL> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PCMPROFILEAPPROVAL>().eq("pcmprofileid",pcmprofileid));
    }

	@Override
    public List<PCMPROFILEAPPROVAL> selectByPimbyzzjlmxid(String pimbyzzjlmxid) {
        return baseMapper.selectByPimbyzzjlmxid(pimbyzzjlmxid);
    }

    @Override
    public void removeByPimbyzzjlmxid(String pimbyzzjlmxid) {
        this.remove(new QueryWrapper<PCMPROFILEAPPROVAL>().eq("pimbyzzjlmxid",pimbyzzjlmxid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMPROFILEAPPROVAL> searchDefault(PCMPROFILEAPPROVALSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILEAPPROVAL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILEAPPROVAL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 拒绝
     */
    @Override
    public Page<PCMPROFILEAPPROVAL> searchDisagree(PCMPROFILEAPPROVALSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILEAPPROVAL> pages=baseMapper.searchDisagree(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILEAPPROVAL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMPROFILEAPPROVAL et){
        //实体关系[DER1N_PCMPROFILEAPPROVAL_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE majorEntity=pcmprofileService.get(et.getPcmprofileid());
                et.setPcmprofile(majorEntity);
                pcmprofile=majorEntity;
            }
            et.setPcmprofilename(pcmprofile.getPcmprofilename());
        }
        //实体关系[DER1N_PCMPROFILEAPPROVAL_PIMBYZZJLMX_PIMBYZZJLMXID]
        if(!ObjectUtils.isEmpty(et.getPimbyzzjlmxid())){
            cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX pimbyzzjlmx=et.getPimbyzzjlmx();
            if(ObjectUtils.isEmpty(pimbyzzjlmx)){
                cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX majorEntity=pimbyzzjlmxService.get(et.getPimbyzzjlmxid());
                et.setPimbyzzjlmx(majorEntity);
                pimbyzzjlmx=majorEntity;
            }
            et.setPimbyzzjlmxname(pimbyzzjlmx.getPimbyzzjlmxname());
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


