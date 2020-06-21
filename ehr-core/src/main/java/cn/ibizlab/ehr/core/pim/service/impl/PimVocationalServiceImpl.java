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
import cn.ibizlab.ehr.core.pim.domain.PimVocational;
import cn.ibizlab.ehr.core.pim.filter.PimVocationalSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimVocationalService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimVocationalMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[证书信息] 服务对象接口实现
 */
@Slf4j
@Service("PimVocationalServiceImpl")
public class PimVocationalServiceImpl extends ServiceImpl<PimVocationalMapper, PimVocational> implements IPimVocationalService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmSignOrgService ormsignorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimQualMajorService pimqualmajorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimQualTypeService pimqualtypeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVocationalCatalogService pimvocationalcatalogService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PimVocational et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimvocationalid",et.getPimvocationalid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimvocationalid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimVocational> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimVocational et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimvocationalid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimVocational> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PimVocational et) {
        return (!ObjectUtils.isEmpty(et.getPimvocationalid()))&&(!Objects.isNull(this.getById(et.getPimvocationalid())));
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
    public boolean save(PimVocational et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimVocational et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimVocational> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimVocational> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimVocational get(String key) {
        PimVocational et = getById(key);
        if(et==null){
            et=new PimVocational();
            et.setPimvocationalid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PimVocational getDraft(PimVocational et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PimVocational> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PimVocational>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PimVocational> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimVocational>().eq("ormorgid",orgid));
    }

	@Override
    public List<PimVocational> selectByOrmsignorgid(String ormsignorgid) {
        return baseMapper.selectByOrmsignorgid(ormsignorgid);
    }

    @Override
    public void removeByOrmsignorgid(String ormsignorgid) {
        this.remove(new QueryWrapper<PimVocational>().eq("ormsignorgid",ormsignorgid));
    }

	@Override
    public List<PimVocational> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimVocational>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<PimVocational> selectByPimqualmajorid(String pimqualmajorid) {
        return baseMapper.selectByPimqualmajorid(pimqualmajorid);
    }

    @Override
    public void removeByPimqualmajorid(String pimqualmajorid) {
        this.remove(new QueryWrapper<PimVocational>().eq("pimqualmajorid",pimqualmajorid));
    }

	@Override
    public List<PimVocational> selectByPimqualtypeid(String pimqualtypeid) {
        return baseMapper.selectByPimqualtypeid(pimqualtypeid);
    }

    @Override
    public void removeByPimqualtypeid(String pimqualtypeid) {
        this.remove(new QueryWrapper<PimVocational>().eq("pimqualtypeid",pimqualtypeid));
    }

	@Override
    public List<PimVocational> selectByPimvocationalcatalogid(String pimvocationalcatalogid) {
        return baseMapper.selectByPimvocationalcatalogid(pimvocationalcatalogid);
    }

    @Override
    public void removeByPimvocationalcatalogid(String pimvocationalcatalogid) {
        this.remove(new QueryWrapper<PimVocational>().eq("pimvocationalcatalogid",pimvocationalcatalogid));
    }


    /**
     * 查询集合 REP_VOCATIONAL
     */
    @Override
    public Page<HashMap> searchREP_VOCATIONAL(PimVocationalSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_VOCATIONAL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属是管理员的
     */
    @Override
    public Page<PimVocational> searchAscriptionSysDQ(PimVocationalSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimVocational> pages=baseMapper.searchAscriptionSysDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimVocational>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimVocational> searchDefault(PimVocationalSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimVocational> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimVocational>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属于
     */
    @Override
    public Page<PimVocational> searchJLSS(PimVocationalSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimVocational> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimVocational>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(证书信息)
     */
    @Override
    public Page<PimVocational> searchZIZHU(PimVocationalSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimVocational> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimVocational>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimVocational et){
        //实体关系[DER1N_PIMVOCATIONAL_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PIMVOCATIONAL_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PIMVOCATIONAL_ORMSIGNORG_ORMSIGNORGID]
        if(!ObjectUtils.isEmpty(et.getOrmsignorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmSignOrg ormsignorg=et.getOrmsignorg();
            if(ObjectUtils.isEmpty(ormsignorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmSignOrg majorEntity=ormsignorgService.get(et.getOrmsignorgid());
                et.setOrmsignorg(majorEntity);
                ormsignorg=majorEntity;
            }
            et.setOrmsignorgname(ormsignorg.getOrmsignorgname());
        }
        //实体关系[DER1N_PIMVOCATIONAL_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgid2(pimperson.getOrmorgid());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgname2(pimperson.getOrmorgname());
            et.setZzdzs(pimperson.getZzdzs());
            et.setYgbh(pimperson.getYgbh());
            et.setYgzt(pimperson.getYgzt());
        }
        //实体关系[DER1N_PIMVOCATIONAL_PIMQUALMAJOR_PIMQUALMAJORID]
        if(!ObjectUtils.isEmpty(et.getPimqualmajorid())){
            cn.ibizlab.ehr.core.pim.domain.PimQualMajor pimqualmajor=et.getPimqualmajor();
            if(ObjectUtils.isEmpty(pimqualmajor)){
                cn.ibizlab.ehr.core.pim.domain.PimQualMajor majorEntity=pimqualmajorService.get(et.getPimqualmajorid());
                et.setPimqualmajor(majorEntity);
                pimqualmajor=majorEntity;
            }
            et.setPimqualmajorname(pimqualmajor.getPimqualmajorname());
        }
        //实体关系[DER1N_PIMVOCATIONAL_PIMQUALTYPE_PIMQUALTYPEID]
        if(!ObjectUtils.isEmpty(et.getPimqualtypeid())){
            cn.ibizlab.ehr.core.pim.domain.PimQualType pimqualtype=et.getPimqualtype();
            if(ObjectUtils.isEmpty(pimqualtype)){
                cn.ibizlab.ehr.core.pim.domain.PimQualType majorEntity=pimqualtypeService.get(et.getPimqualtypeid());
                et.setPimqualtype(majorEntity);
                pimqualtype=majorEntity;
            }
            et.setPimqualtypename(pimqualtype.getPimqualtypename());
        }
        //实体关系[DER1N_PIMVOCATIONAL_PIMVOCATIONALCATALOG_PIMVOCATIONALCATALOGID]
        if(!ObjectUtils.isEmpty(et.getPimvocationalcatalogid())){
            cn.ibizlab.ehr.core.pim.domain.PimVocationalCatalog pimvocationalcatalog=et.getPimvocationalcatalog();
            if(ObjectUtils.isEmpty(pimvocationalcatalog)){
                cn.ibizlab.ehr.core.pim.domain.PimVocationalCatalog majorEntity=pimvocationalcatalogService.get(et.getPimvocationalcatalogid());
                et.setPimvocationalcatalog(majorEntity);
                pimvocationalcatalog=majorEntity;
            }
            et.setPimvocationalcatalogname(pimvocationalcatalog.getPimvocationalcatalogname());
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
    public List<PimVocational> getPimvocationalByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimVocational> getPimvocationalByEntities(List<PimVocational> entities) {
        List ids =new ArrayList();
        for(PimVocational entity : entities){
            Serializable id=entity.getPimvocationalid();
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



