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
import cn.ibizlab.ehr.core.pcm.domain.PcmPracticeExperience;
import cn.ibizlab.ehr.core.pcm.filter.PcmPracticeExperienceSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmPracticeExperienceService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmPracticeExperienceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[实习经验] 服务对象接口实现
 */
@Slf4j
@Service("PcmPracticeExperienceServiceImpl")
public class PcmPracticeExperienceServiceImpl extends ServiceImpl<PcmPracticeExperienceMapper, PcmPracticeExperience> implements IPcmPracticeExperienceService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;

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
    public boolean create(PcmPracticeExperience et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmpracticeexperienceid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmPracticeExperience> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PcmPracticeExperience et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmpracticeexperienceid",et.getPcmpracticeexperienceid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmpracticeexperienceid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmPracticeExperience> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PcmPracticeExperience getDraft(PcmPracticeExperience et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmPracticeExperience get(String key) {
        PcmPracticeExperience et = getById(key);
        if(et==null){
            et=new PcmPracticeExperience();
            et.setPcmpracticeexperienceid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PcmPracticeExperience et) {
        return (!ObjectUtils.isEmpty(et.getPcmpracticeexperienceid()))&&(!Objects.isNull(this.getById(et.getPcmpracticeexperienceid())));
    }
    @Override
    @Transactional
    public boolean save(PcmPracticeExperience et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmPracticeExperience et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmPracticeExperience> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmPracticeExperience> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PcmPracticeExperience> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PcmPracticeExperience>().eq("pcmprofileid",pcmprofileid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmPracticeExperience> searchDefault(PcmPracticeExperienceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmPracticeExperience> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmPracticeExperience>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmPracticeExperience et){
        //实体关系[DER1N_PCMPRACTICEEXPERIENCE_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PcmProfile majorEntity=pcmprofileService.get(et.getPcmprofileid());
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

    @Override
    public List<PcmPracticeExperience> getPcmpracticeexperienceByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmPracticeExperience> getPcmpracticeexperienceByEntities(List<PcmPracticeExperience> entities) {
        List ids =new ArrayList();
        for(PcmPracticeExperience entity : entities){
            Serializable id=entity.getPcmpracticeexperienceid();
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



