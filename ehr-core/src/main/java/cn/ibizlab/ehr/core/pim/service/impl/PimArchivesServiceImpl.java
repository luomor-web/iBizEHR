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
import cn.ibizlab.ehr.core.pim.domain.PimArchives;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimArchivesMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案信息] 服务对象接口实现
 */
@Slf4j
@Service("PimArchivesServiceImpl")
public class PimArchivesServiceImpl extends ServiceImpl<PimArchivesMapper, PimArchives> implements IPimArchivesService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivalCatalogueService pimarchivalcatalogueService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesChangeService pimarchiveschangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService pimarchivesloanandreturnService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesRecordService pimarchivesrecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesCenterService pimarchivescenterService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPimArchivesGetPersonOrgLogic getpersonorgLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PimArchives getPersonOrg(PimArchives et) {
        getpersonorgLogic.execute(et);
         return et ;
    }

    @Override
    public PimArchives getDraft(PimArchives et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimArchives et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimArchives et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimArchives> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimArchives> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimArchives get(String key) {
        PimArchives et = getById(key);
        if(et==null){
            et=new PimArchives();
            et.setPimarchivesid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimArchives et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarchivesid",et.getPimarchivesid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimArchives> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PimArchives et) {
        return (!ObjectUtils.isEmpty(et.getPimarchivesid()))&&(!Objects.isNull(this.getById(et.getPimarchivesid())));
    }
    @Override
    @Transactional
    public boolean create(PimArchives et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimArchives> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public List<PimArchives> selectByArchivescenterid(String archivescenterid) {
        return baseMapper.selectByArchivescenterid(archivescenterid);
    }

    @Override
    public void removeByArchivescenterid(String archivescenterid) {
        this.remove(new QueryWrapper<PimArchives>().eq("archivescenterid",archivescenterid));
    }

	@Override
    public List<PimArchives> selectByOrmorgid2(String orgid) {
        return baseMapper.selectByOrmorgid2(orgid);
    }

    @Override
    public void removeByOrmorgid2(String orgid) {
        this.remove(new QueryWrapper<PimArchives>().eq("ormorgid2",orgid));
    }

	@Override
    public List<PimArchives> selectByOrmorgid3(String orgid) {
        return baseMapper.selectByOrmorgid3(orgid);
    }

    @Override
    public void removeByOrmorgid3(String orgid) {
        this.remove(new QueryWrapper<PimArchives>().eq("ormorgid3",orgid));
    }

	@Override
    public List<PimArchives> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimArchives>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 员工不在档档案
     */
    @Override
    public Page<PimArchives> searchEMLOYEENOFILE(PimArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchives> pages=baseMapper.searchEMLOYEENOFILE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 管理单位等于当前登录人的单位（用于非员工在档数据查询）
     */
    @Override
    public Page<PimArchives> searchSysOrgIsSrfOrg(PimArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchives> pages=baseMapper.searchSysOrgIsSrfOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimArchives> searchDefault(PimArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchives> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属和个人ID不符的
     */
    @Override
    public Page<PimArchives> searchJLSS(PimArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchives> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(档案信息)
     */
    @Override
    public Page<PimArchives> searchZIZHU(PimArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchives> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 非员工在档档案
     */
    @Override
    public Page<PimArchives> searchNOEMLOYEENOFILE(PimArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchives> pages=baseMapper.searchNOEMLOYEENOFILE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 档案信息组织查询
     */
    @Override
    public Page<PimArchives> searchPIMREADGJD(PimArchivesSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchives> pages=baseMapper.searchPIMREADGJD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchives>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimArchives et){
        //实体关系[DER1N_PIMARCHIVES_ARCHIVESCENTER_ARCHIVESCENTERID]
        if(!ObjectUtils.isEmpty(et.getArchivescenterid())){
            cn.ibizlab.ehr.core.pim.domain.PimArchivesCenter archivescenter=et.getArchivescenter();
            if(ObjectUtils.isEmpty(archivescenter)){
                cn.ibizlab.ehr.core.pim.domain.PimArchivesCenter majorEntity=pimarchivescenterService.get(et.getArchivescenterid());
                et.setArchivescenter(majorEntity);
                archivescenter=majorEntity;
            }
            et.setArchivescentername(archivescenter.getPosition());
        }
        //实体关系[DER1N_PIMARCHIVES_ORMORG_ORMORGID2]
        if(!ObjectUtils.isEmpty(et.getOrmorgid2())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid2());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname2(ormorg.getOrgname());
        }
        //实体关系[DER1N_PIMARCHIVES_ORMORG_ORMORGID3]
        if(!ObjectUtils.isEmpty(et.getOrmorgid3())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg3=et.getOrmorg3();
            if(ObjectUtils.isEmpty(ormorg3)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid3());
                et.setOrmorg3(majorEntity);
                ormorg3=majorEntity;
            }
            et.setGlzzdzs(ormorg3.getZzdzs());
            et.setOrgcode(ormorg3.getOrgcode());
            et.setOrmorgname3(ormorg3.getOrgname());
            et.setZzdzs(ormorg3.getZzdzs());
        }
        //实体关系[DER1N_PIMARCHIVES_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgname(pimperson.getZzdzs());
            et.setDbdwsj(pimperson.getDbdwsj());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setLeavedate(pimperson.getLeavedate());
            et.setSszzdzs(pimperson.getZzdzs());
            et.setYgbh(pimperson.getYgbh());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setZgcode(pimperson.getZgcode());
            et.setYgzt(pimperson.getYgzt());
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
    public List<PimArchives> getPimarchivesByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimArchives> getPimarchivesByEntities(List<PimArchives> entities) {
        List ids =new ArrayList();
        for(PimArchives entity : entities){
            Serializable id=entity.getPimarchivesid();
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



