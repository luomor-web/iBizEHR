package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PimQualMajor;
import cn.ibizlab.ehr.core.pim.filter.PimQualMajorSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimQualMajorService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimQualMajorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[执业资格专业] 服务对象接口实现
 */
@Slf4j
@Service("PimQualMajorServiceImpl")
public class PimQualMajorServiceImpl extends ServiceImpl<PimQualMajorMapper, PimQualMajor> implements IPimQualMajorService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmCertofregService pcmcertofregService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVocationalService pimvocationalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimQualTypeService pimqualtypeService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PimQualMajor et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimqualmajorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimQualMajor> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PimQualMajor et) {
        return (!ObjectUtils.isEmpty(et.getPimqualmajorid()))&&(!Objects.isNull(this.getById(et.getPimqualmajorid())));
    }
    @Override
    @Transactional
    public boolean update(PimQualMajor et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimqualmajorid",et.getPimqualmajorid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimqualmajorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimQualMajor> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    public PimQualMajor getDraft(PimQualMajor et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimQualMajor et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimQualMajor et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimQualMajor> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimQualMajor> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimQualMajor get(String key) {
        PimQualMajor et = getById(key);
        if(et==null){
            et=new PimQualMajor();
            et.setPimqualmajorid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PimQualMajor> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimQualMajor>().eq("ormorgid",orgid));
    }

	@Override
    public List<PimQualMajor> selectByPimqualtypeid(String pimqualtypeid) {
        return baseMapper.selectByPimqualtypeid(pimqualtypeid);
    }

    @Override
    public void removeByPimqualtypeid(String pimqualtypeid) {
        this.remove(new QueryWrapper<PimQualMajor>().eq("pimqualtypeid",pimqualtypeid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimQualMajor> searchDefault(PimQualMajorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimQualMajor> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimQualMajor>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 选择资格类别下对应的资格专业
     */
    @Override
    public Page<PimQualMajor> searchXZZGZY(PimQualMajorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimQualMajor> pages=baseMapper.searchXZZGZY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimQualMajor>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimQualMajor et){
        //实体关系[DER1N_PIMQUALMAJOR_PIMQUALTYPE_PIMQUALTYPEID]
        if(!ObjectUtils.isEmpty(et.getPimqualtypeid())){
            cn.ibizlab.ehr.core.pim.domain.PimQualType pimqualtype=et.getPimqualtype();
            if(ObjectUtils.isEmpty(pimqualtype)){
                cn.ibizlab.ehr.core.pim.domain.PimQualType majorEntity=pimqualtypeService.get(et.getPimqualtypeid());
                et.setPimqualtype(majorEntity);
                pimqualtype=majorEntity;
            }
            et.setPimqualtypename(pimqualtype.getPimqualtypename());
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
    public List<PimQualMajor> getPimqualmajorByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimQualMajor> getPimqualmajorByEntities(List<PimQualMajor> entities) {
        List ids =new ArrayList();
        for(PimQualMajor entity : entities){
            Serializable id=entity.getPimqualmajorid();
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



