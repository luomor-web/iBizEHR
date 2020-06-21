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
import cn.ibizlab.ehr.core.pcm.domain.PcmEducationExperience;
import cn.ibizlab.ehr.core.pcm.filter.PcmEducationExperienceSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmEducationExperienceService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmEducationExperienceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[教育背景] 服务对象接口实现
 */
@Slf4j
@Service("PcmEducationExperienceServiceImpl")
public class PcmEducationExperienceServiceImpl extends ServiceImpl<PcmEducationExperienceMapper, PcmEducationExperience> implements IPcmEducationExperienceService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PcmEducationExperience et) {
        return (!ObjectUtils.isEmpty(et.getPcmeducationexperienceid()))&&(!Objects.isNull(this.getById(et.getPcmeducationexperienceid())));
    }
    @Override
    @Transactional
    public PcmEducationExperience get(String key) {
        PcmEducationExperience et = getById(key);
        if(et==null){
            et=new PcmEducationExperience();
            et.setPcmeducationexperienceid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PcmEducationExperience checkHighestEdu(PcmEducationExperience et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmEducationExperience et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmeducationexperienceid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmEducationExperience> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmEducationExperience checkRepeatXL(PcmEducationExperience et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PcmEducationExperience et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmEducationExperience et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmEducationExperience> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmEducationExperience> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PcmEducationExperience getDraft(PcmEducationExperience et) {
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
    public boolean update(PcmEducationExperience et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmeducationexperienceid",et.getPcmeducationexperienceid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmeducationexperienceid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmEducationExperience> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmEducationExperience checkTime(PcmEducationExperience et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PcmEducationExperience> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PcmEducationExperience>().eq("pcmprofileid",pcmprofileid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmEducationExperience> searchDefault(PcmEducationExperienceSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmEducationExperience> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmEducationExperience>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmEducationExperience et){
        //实体关系[DER1N_PCMEDUCATIONEXPERIENCE_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PcmProfile majorEntity=pcmprofileService.get(et.getPcmprofileid());
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

    @Override
    public List<PcmEducationExperience> getPcmeducationexperienceByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmEducationExperience> getPcmeducationexperienceByEntities(List<PcmEducationExperience> entities) {
        List ids =new ArrayList();
        for(PcmEducationExperience entity : entities){
            Serializable id=entity.getPcmeducationexperienceid();
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



