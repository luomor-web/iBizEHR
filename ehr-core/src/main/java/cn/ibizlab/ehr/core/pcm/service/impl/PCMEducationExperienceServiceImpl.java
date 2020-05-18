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
import cn.ibizlab.ehr.core.pcm.domain.PCMEducationExperience;
import cn.ibizlab.ehr.core.pcm.filter.PCMEducationExperienceSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMEducationExperienceService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMEducationExperienceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[教育背景] 服务对象接口实现
 */
@Slf4j
@Service("PCMEducationExperienceServiceImpl")
public class PCMEducationExperienceServiceImpl extends ServiceImpl<PCMEducationExperienceMapper, PCMEducationExperience> implements IPCMEducationExperienceService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PCMEducationExperience et) {
        return (!ObjectUtils.isEmpty(et.getPcmeducationexperienceid()))&&(!Objects.isNull(this.getById(et.getPcmeducationexperienceid())));
    }

    @Override
    @Transactional
    public PCMEducationExperience get(String key) {
        PCMEducationExperience et = getById(key);
        if(et==null){
            et=new PCMEducationExperience();
            et.setPcmeducationexperienceid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMEducationExperience checkHighestEdu(PCMEducationExperience et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMEducationExperience et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmeducationexperienceid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMEducationExperience> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMEducationExperience checkRepeatXL(PCMEducationExperience et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMEducationExperience et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMEducationExperience et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMEducationExperience> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PCMEducationExperience getDraft(PCMEducationExperience et) {
        fillParentData(et);
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
    public boolean update(PCMEducationExperience et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmeducationexperienceid",et.getPcmeducationexperienceid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmeducationexperienceid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMEducationExperience> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMEducationExperience checkTime(PCMEducationExperience et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PCMEducationExperience> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PCMEducationExperience>().eq("pcmprofileid",pcmprofileid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMEducationExperience> searchDefault(PCMEducationExperienceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMEducationExperience> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMEducationExperience>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMEducationExperience et){
        //实体关系[DER1N_PCMEDUCATIONEXPERIENCE_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE majorEntity=pcmprofileService.get(et.getPcmprofileid());
                et.setPcmprofile(majorEntity);
                pcmprofile=majorEntity;
            }
            et.setCertificatenumber(pcmprofile.getCertificatenumber());
            et.setPcmprofilename(pcmprofile.getPcmprofilename());
            et.setXznf(pcmprofile.getXznf());
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


