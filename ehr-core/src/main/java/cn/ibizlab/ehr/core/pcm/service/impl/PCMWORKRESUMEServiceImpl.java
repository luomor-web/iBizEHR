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
import cn.ibizlab.ehr.core.pcm.domain.PCMWORKRESUME;
import cn.ibizlab.ehr.core.pcm.filter.PCMWORKRESUMESearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMWORKRESUMEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMWORKRESUMEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[工作履历] 服务对象接口实现
 */
@Slf4j
@Service("PCMWORKRESUMEServiceImpl")
public class PCMWORKRESUMEServiceImpl extends ServiceImpl<PCMWORKRESUMEMapper, PCMWORKRESUME> implements IPCMWORKRESUMEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PCMWORKRESUME et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmworkresumeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMWORKRESUME> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public PCMWORKRESUME getDraft(PCMWORKRESUME et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMWORKRESUME et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMWORKRESUME et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMWORKRESUME> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMWORKRESUME get(String key) {
        PCMWORKRESUME et = getById(key);
        if(et==null){
            et=new PCMWORKRESUME();
            et.setPcmworkresumeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMWORKRESUME et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmworkresumeid",et.getPcmworkresumeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmworkresumeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMWORKRESUME> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMWORKRESUME et) {
        return (!ObjectUtils.isEmpty(et.getPcmworkresumeid()))&&(!Objects.isNull(this.getById(et.getPcmworkresumeid())));
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
    public List<PCMWORKRESUME> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PCMWORKRESUME>().eq("pcmprofileid",pcmprofileid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMWORKRESUME> searchDefault(PCMWORKRESUMESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMWORKRESUME> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMWORKRESUME>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMWORKRESUME et){
        //实体关系[DER1N_PCMWORKRESUME_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE majorEntity=pcmprofileService.get(et.getPcmprofileid());
                et.setPcmprofile(majorEntity);
                pcmprofile=majorEntity;
            }
            et.setPcmprofilename(pcmprofile.getPcmprofilename());
            et.setCertificatenumber(pcmprofile.getCertificatenumber());
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

