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
import cn.ibizlab.ehr.core.pcm.domain.PCMCERTOFREG;
import cn.ibizlab.ehr.core.pcm.filter.PCMCERTOFREGSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMCERTOFREGService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMCERTOFREGMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[注册证书] 服务对象接口实现
 */
@Slf4j
@Service("PCMCERTOFREGServiceImpl")
public class PCMCERTOFREGServiceImpl extends ServiceImpl<PCMCERTOFREGMapper, PCMCERTOFREG> implements IPCMCERTOFREGService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMQUALMAJORService pimqualmajorService;

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
    @Transactional
    public boolean save(PCMCERTOFREG et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMCERTOFREG et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMCERTOFREG> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PCMCERTOFREG getDraft(PCMCERTOFREG et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMCERTOFREG et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmcertofregid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMCERTOFREG> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PCMCERTOFREG et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmcertofregid",et.getPcmcertofregid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmcertofregid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMCERTOFREG> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMCERTOFREG get(String key) {
        PCMCERTOFREG et = getById(key);
        if(et==null){
            et=new PCMCERTOFREG();
            et.setPcmcertofregid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PCMCERTOFREG et) {
        return (!ObjectUtils.isEmpty(et.getPcmcertofregid()))&&(!Objects.isNull(this.getById(et.getPcmcertofregid())));
    }


	@Override
    public List<PCMCERTOFREG> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PCMCERTOFREG>().eq("pcmprofileid",pcmprofileid));
    }

	@Override
    public List<PCMCERTOFREG> selectByPimqualmajorid(String pimqualmajorid) {
        return baseMapper.selectByPimqualmajorid(pimqualmajorid);
    }

    @Override
    public void removeByPimqualmajorid(String pimqualmajorid) {
        this.remove(new QueryWrapper<PCMCERTOFREG>().eq("pimqualmajorid",pimqualmajorid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMCERTOFREG> searchDefault(PCMCERTOFREGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMCERTOFREG> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMCERTOFREG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMCERTOFREG et){
        //实体关系[DER1N_PCMCERTOFREG_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE majorEntity=pcmprofileService.get(et.getPcmprofileid());
                et.setPcmprofile(majorEntity);
                pcmprofile=majorEntity;
            }
            et.setCertificatenumber(pcmprofile.getCertificatenumber());
            et.setPcmprofilename(pcmprofile.getPcmprofilename());
        }
        //实体关系[DER1N_PCMCERTOFREG_PIMQUALMAJOR_PIMQUALMAJORID]
        if(!ObjectUtils.isEmpty(et.getPimqualmajorid())){
            cn.ibizlab.ehr.core.pim.domain.PIMQUALMAJOR pimqualmajor=et.getPimqualmajor();
            if(ObjectUtils.isEmpty(pimqualmajor)){
                cn.ibizlab.ehr.core.pim.domain.PIMQUALMAJOR majorEntity=pimqualmajorService.get(et.getPimqualmajorid());
                et.setPimqualmajor(majorEntity);
                pimqualmajor=majorEntity;
            }
            et.setZyzgzy(pimqualmajor.getZyzgzy());
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


