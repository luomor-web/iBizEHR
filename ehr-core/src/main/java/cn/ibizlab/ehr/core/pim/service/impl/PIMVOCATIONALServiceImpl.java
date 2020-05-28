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
import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONAL;
import cn.ibizlab.ehr.core.pim.filter.PIMVOCATIONALSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMVOCATIONALMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[证书信息] 服务对象接口实现
 */
@Slf4j
@Service("PIMVOCATIONALServiceImpl")
public class PIMVOCATIONALServiceImpl extends ServiceImpl<PIMVOCATIONALMapper, PIMVOCATIONAL> implements IPIMVOCATIONALService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmSignOrgService ormsignorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMQUALMAJORService pimqualmajorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMQUALTYPEService pimqualtypeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALCATALOGService pimvocationalcatalogService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PIMVOCATIONAL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimvocationalid",et.getPimvocationalid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimvocationalid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMVOCATIONAL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMVOCATIONAL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimvocationalid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMVOCATIONAL> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PIMVOCATIONAL et) {
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
    public boolean save(PIMVOCATIONAL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMVOCATIONAL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMVOCATIONAL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMVOCATIONAL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMVOCATIONAL get(String key) {
        PIMVOCATIONAL et = getById(key);
        if(et==null){
            et=new PIMVOCATIONAL();
            et.setPimvocationalid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PIMVOCATIONAL getDraft(PIMVOCATIONAL et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PIMVOCATIONAL> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PIMVOCATIONAL>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PIMVOCATIONAL> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PIMVOCATIONAL>().eq("ormorgid",orgid));
    }

	@Override
    public List<PIMVOCATIONAL> selectByOrmsignorgid(String ormsignorgid) {
        return baseMapper.selectByOrmsignorgid(ormsignorgid);
    }

    @Override
    public void removeByOrmsignorgid(String ormsignorgid) {
        this.remove(new QueryWrapper<PIMVOCATIONAL>().eq("ormsignorgid",ormsignorgid));
    }

	@Override
    public List<PIMVOCATIONAL> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMVOCATIONAL>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<PIMVOCATIONAL> selectByPimqualmajorid(String pimqualmajorid) {
        return baseMapper.selectByPimqualmajorid(pimqualmajorid);
    }

    @Override
    public void removeByPimqualmajorid(String pimqualmajorid) {
        this.remove(new QueryWrapper<PIMVOCATIONAL>().eq("pimqualmajorid",pimqualmajorid));
    }

	@Override
    public List<PIMVOCATIONAL> selectByPimqualtypeid(String pimqualtypeid) {
        return baseMapper.selectByPimqualtypeid(pimqualtypeid);
    }

    @Override
    public void removeByPimqualtypeid(String pimqualtypeid) {
        this.remove(new QueryWrapper<PIMVOCATIONAL>().eq("pimqualtypeid",pimqualtypeid));
    }

	@Override
    public List<PIMVOCATIONAL> selectByPimvocationalcatalogid(String pimvocationalcatalogid) {
        return baseMapper.selectByPimvocationalcatalogid(pimvocationalcatalogid);
    }

    @Override
    public void removeByPimvocationalcatalogid(String pimvocationalcatalogid) {
        this.remove(new QueryWrapper<PIMVOCATIONAL>().eq("pimvocationalcatalogid",pimvocationalcatalogid));
    }


    /**
     * 查询集合 REP_VOCATIONAL
     */
    @Override
    public Page<HashMap> searchREP_VOCATIONAL(PIMVOCATIONALSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_VOCATIONAL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属是管理员的
     */
    @Override
    public Page<PIMVOCATIONAL> searchAscriptionSysDQ(PIMVOCATIONALSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMVOCATIONAL> pages=baseMapper.searchAscriptionSysDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMVOCATIONAL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMVOCATIONAL> searchDefault(PIMVOCATIONALSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMVOCATIONAL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMVOCATIONAL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属于
     */
    @Override
    public Page<PIMVOCATIONAL> searchJLSS(PIMVOCATIONALSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMVOCATIONAL> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMVOCATIONAL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(证书信息)
     */
    @Override
    public Page<PIMVOCATIONAL> searchZIZHU(PIMVOCATIONALSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMVOCATIONAL> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMVOCATIONAL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMVOCATIONAL et){
        //实体关系[DER1N_PIMVOCATIONAL_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PIMVOCATIONAL_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
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
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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
            cn.ibizlab.ehr.core.pim.domain.PIMQUALMAJOR pimqualmajor=et.getPimqualmajor();
            if(ObjectUtils.isEmpty(pimqualmajor)){
                cn.ibizlab.ehr.core.pim.domain.PIMQUALMAJOR majorEntity=pimqualmajorService.get(et.getPimqualmajorid());
                et.setPimqualmajor(majorEntity);
                pimqualmajor=majorEntity;
            }
            et.setPimqualmajorname(pimqualmajor.getPimqualmajorname());
        }
        //实体关系[DER1N_PIMVOCATIONAL_PIMQUALTYPE_PIMQUALTYPEID]
        if(!ObjectUtils.isEmpty(et.getPimqualtypeid())){
            cn.ibizlab.ehr.core.pim.domain.PIMQUALTYPE pimqualtype=et.getPimqualtype();
            if(ObjectUtils.isEmpty(pimqualtype)){
                cn.ibizlab.ehr.core.pim.domain.PIMQUALTYPE majorEntity=pimqualtypeService.get(et.getPimqualtypeid());
                et.setPimqualtype(majorEntity);
                pimqualtype=majorEntity;
            }
            et.setPimqualtypename(pimqualtype.getPimqualtypename());
        }
        //实体关系[DER1N_PIMVOCATIONAL_PIMVOCATIONALCATALOG_PIMVOCATIONALCATALOGID]
        if(!ObjectUtils.isEmpty(et.getPimvocationalcatalogid())){
            cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONALCATALOG pimvocationalcatalog=et.getPimvocationalcatalog();
            if(ObjectUtils.isEmpty(pimvocationalcatalog)){
                cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONALCATALOG majorEntity=pimvocationalcatalogService.get(et.getPimvocationalcatalogid());
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
    public List<PIMVOCATIONAL> getPimvocationalByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PIMVOCATIONAL> getPimvocationalByEntities(List<PIMVOCATIONAL> entities) {
        List ids =new ArrayList();
        for(PIMVOCATIONAL entity : entities){
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


