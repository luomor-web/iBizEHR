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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMARCHIVESMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案信息] 服务对象接口实现
 */
@Slf4j
@Service("PIMARCHIVESServiceImpl")
public class PIMARCHIVESServiceImpl extends ServiceImpl<PIMARCHIVESMapper, PIMARCHIVES> implements IPIMARCHIVESService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IARCHIVALCATALOGUEService archivalcatalogueService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService pimarchiveschangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESLOANANDRETURNService pimarchivesloanandreturnService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESRECORDService pimarchivesrecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IARCHIVESCENTERService archivescenterService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPIMARCHIVESGetPersonOrgLogic getpersonorgLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PIMARCHIVES getPersonOrg(PIMARCHIVES et) {
        getpersonorgLogic.execute(et);
         return et ;
    }

    @Override
    public PIMARCHIVES getDraft(PIMARCHIVES et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMARCHIVES et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMARCHIVES et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMARCHIVES> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMARCHIVES get(String key) {
        PIMARCHIVES et = getById(key);
        if(et==null){
            et=new PIMARCHIVES();
            et.setPimarchivesid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PIMARCHIVES et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarchivesid",et.getPimarchivesid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMARCHIVES> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PIMARCHIVES et) {
        return (!ObjectUtils.isEmpty(et.getPimarchivesid()))&&(!Objects.isNull(this.getById(et.getPimarchivesid())));
    }

    @Override
    @Transactional
    public boolean create(PIMARCHIVES et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMARCHIVES> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
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
    public List<PIMARCHIVES> selectByArchivescenterid(String archivescenterid) {
        return baseMapper.selectByArchivescenterid(archivescenterid);
    }

    @Override
    public void removeByArchivescenterid(String archivescenterid) {
        this.remove(new QueryWrapper<PIMARCHIVES>().eq("archivescenterid",archivescenterid));
    }

	@Override
    public List<PIMARCHIVES> selectByOrmorgid2(String orgid) {
        return baseMapper.selectByOrmorgid2(orgid);
    }

    @Override
    public void removeByOrmorgid2(String orgid) {
        this.remove(new QueryWrapper<PIMARCHIVES>().eq("ormorgid2",orgid));
    }

	@Override
    public List<PIMARCHIVES> selectByOrmorgid3(String orgid) {
        return baseMapper.selectByOrmorgid3(orgid);
    }

    @Override
    public void removeByOrmorgid3(String orgid) {
        this.remove(new QueryWrapper<PIMARCHIVES>().eq("ormorgid3",orgid));
    }

	@Override
    public List<PIMARCHIVES> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMARCHIVES>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 员工不在档档案
     */
    @Override
    public Page<PIMARCHIVES> searchEMLOYEENOFILE(PIMARCHIVESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVES> pages=baseMapper.searchEMLOYEENOFILE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 管理单位等于当前登录人的单位（用于非员工在档数据查询）
     */
    @Override
    public Page<PIMARCHIVES> searchSysOrgIsSrfOrg(PIMARCHIVESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVES> pages=baseMapper.searchSysOrgIsSrfOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMARCHIVES> searchDefault(PIMARCHIVESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVES> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属和个人ID不符的
     */
    @Override
    public Page<PIMARCHIVES> searchJLSS(PIMARCHIVESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVES> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(档案信息)
     */
    @Override
    public Page<PIMARCHIVES> searchZIZHU(PIMARCHIVESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVES> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 非员工在档档案
     */
    @Override
    public Page<PIMARCHIVES> searchNOEMLOYEENOFILE(PIMARCHIVESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVES> pages=baseMapper.searchNOEMLOYEENOFILE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 档案信息组织查询
     */
    @Override
    public Page<PIMARCHIVES> searchPIMREADGJD(PIMARCHIVESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVES> pages=baseMapper.searchPIMREADGJD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMARCHIVES et){
        //实体关系[DER1N_PIMARCHIVES_ARCHIVESCENTER_ARCHIVESCENTERID]
        if(!ObjectUtils.isEmpty(et.getArchivescenterid())){
            cn.ibizlab.ehr.core.pim.domain.ARCHIVESCENTER archivescenter=et.getArchivescenter();
            if(ObjectUtils.isEmpty(archivescenter)){
                cn.ibizlab.ehr.core.pim.domain.ARCHIVESCENTER majorEntity=archivescenterService.get(et.getArchivescenterid());
                et.setArchivescenter(majorEntity);
                archivescenter=majorEntity;
            }
            et.setArchivescentername(archivescenter.getPosition());
        }
        //实体关系[DER1N_PIMARCHIVES_ORMORG_ORMORGID2]
        if(!ObjectUtils.isEmpty(et.getOrmorgid2())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid2());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname2(ormorg.getOrgname());
        }
        //实体关系[DER1N_PIMARCHIVES_ORMORG_ORMORGID3]
        if(!ObjectUtils.isEmpty(et.getOrmorgid3())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg3=et.getOrmorg3();
            if(ObjectUtils.isEmpty(ormorg3)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid3());
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
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


