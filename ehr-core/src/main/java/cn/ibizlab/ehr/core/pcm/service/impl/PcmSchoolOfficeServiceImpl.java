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
import cn.ibizlab.ehr.core.pcm.domain.PcmSchoolOffice;
import cn.ibizlab.ehr.core.pcm.filter.PcmSchoolOfficeSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmSchoolOfficeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmSchoolOfficeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[在校职务] 服务对象接口实现
 */
@Slf4j
@Service("PcmSchoolOfficeServiceImpl")
public class PcmSchoolOfficeServiceImpl extends ServiceImpl<PcmSchoolOfficeMapper, PcmSchoolOffice> implements IPcmSchoolOfficeService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmSchoolOffice get(String key) {
        PcmSchoolOffice et = getById(key);
        if(et==null){
            et=new PcmSchoolOffice();
            et.setPcmschoolofficeid(key);
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
    public boolean checkKey(PcmSchoolOffice et) {
        return (!ObjectUtils.isEmpty(et.getPcmschoolofficeid()))&&(!Objects.isNull(this.getById(et.getPcmschoolofficeid())));
    }
    @Override
    public PcmSchoolOffice getDraft(PcmSchoolOffice et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmSchoolOffice et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmschoolofficeid",et.getPcmschoolofficeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmschoolofficeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmSchoolOffice> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PcmSchoolOffice et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmSchoolOffice et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmSchoolOffice> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmSchoolOffice> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PcmSchoolOffice et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmschoolofficeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmSchoolOffice> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PcmSchoolOffice> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<PcmSchoolOffice>().eq("pcmprofileid",pcmprofileid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmSchoolOffice> searchDefault(PcmSchoolOfficeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmSchoolOffice> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmSchoolOffice>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmSchoolOffice et){
        //实体关系[DER1N_PCMSCHOOLOFFICE_PCMPROFILE_PCMPROFILEID]
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
    public List<PcmSchoolOffice> getPcmschoolofficeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmSchoolOffice> getPcmschoolofficeByEntities(List<PcmSchoolOffice> entities) {
        List ids =new ArrayList();
        for(PcmSchoolOffice entity : entities){
            Serializable id=entity.getPcmschoolofficeid();
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



