package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgsector;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgsectorSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmOrgsectorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门管理] 服务对象接口实现
 */
@Slf4j
@Service("OrmOrgsectorServiceImpl")
public class OrmOrgsectorServiceImpl extends ServiceImpl<OrmOrgsectorMapper, OrmOrgsector> implements IOrmOrgsectorService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndanceRecordTempService attendancerecordtempService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndenceOrmorgscetorService attendenceormorgscetorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmBmgwbzService ormbmgwbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmBmkqdzService ormbmkqdzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmDepEstManService ormdepestmanService;

    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmUserService ormuserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmbmxService ormxmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmrypzxqService ormxmrypzxqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParJgbmpjbzService parjgbmpjbzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParYdgzjhService parydgzjhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParZnbmmxService parznbmmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParZnbmndlhmbService parznbmndlhmbService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService pcmbdsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdmxService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPcmDetailService pcmdetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmJxsbdjlService pcmjxsbdjlService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmNoticeService pcmnoticeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileService pcmprofileService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmRecruitmentService pcmrecruitmentService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYddgmxService pcmyddgmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService pcmydjdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService pcmydjzmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmYdmxService pcmydmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimVocationalService pimvocationalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalPersonStdService salpersonstdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryBillService salsalarybillService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISalSalaryService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDepartService trmdepartService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmDutyCadresService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmGradecadresService trmgradecadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmPlanFormuService trmplanformuService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainActapplyService trmtrainactapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainFillinService trmtrainfillinService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacSystemApplicationService vacsystemapplicationService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmglService ormxmglService;

    private int batchSize = 500;

    @Override
    @Transactional
    public OrmOrgsector changeEdition(OrmOrgsector et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(OrmOrgsector et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsectorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmOrgsector> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmOrgsector synOrgSectPro(OrmOrgsector et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmOrgsector cLWC(OrmOrgsector et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(OrmOrgsector et) {
        return (!ObjectUtils.isEmpty(et.getOrgsectorid()))&&(!Objects.isNull(this.getById(et.getOrgsectorid())));
    }
    @Override
    @Transactional
    public boolean save(OrmOrgsector et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmOrgsector et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmOrgsector> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmOrgsector> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public OrmOrgsector getDraft(OrmOrgsector et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public OrmOrgsector tJ(OrmOrgsector et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrmOrgsector et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgsectorid",et.getOrgsectorid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsectorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmOrgsector> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public OrmOrgsector get(String key) {
        OrmOrgsector et = getById(key);
        if(et==null){
            et=new OrmOrgsector();
            et.setOrgsectorid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public OrmOrgsector synOrgSectOderNum(OrmOrgsector et) {
        //自定义代码
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
    public OrmOrgsector synOrgSec(OrmOrgsector et) {
        //自定义代码
        return et;
    }


	@Override
    public List<OrmOrgsector> selectByPorgsectorid(String orgsectorid) {
        return baseMapper.selectByPorgsectorid(orgsectorid);
    }

    @Override
    public void removeByPorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<OrmOrgsector>().eq("porgsectorid",orgsectorid));
    }

	@Override
    public List<OrmOrgsector> selectByProdepid(String orgsectorid) {
        return baseMapper.selectByProdepid(orgsectorid);
    }

    @Override
    public void removeByProdepid(String orgsectorid) {
        this.remove(new QueryWrapper<OrmOrgsector>().eq("prodepid",orgsectorid));
    }

	@Override
    public List<OrmOrgsector> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<OrmOrgsector>().eq("orgid",orgid));
    }

	@Override
    public List<OrmOrgsector> selectByOrmxmglid(String ormxmglid) {
        return baseMapper.selectByOrmxmglid(ormxmglid);
    }

    @Override
    public void removeByOrmxmglid(String ormxmglid) {
        this.remove(new QueryWrapper<OrmOrgsector>().eq("ormxmglid",ormxmglid));
    }

	@Override
    public List<OrmOrgsector> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<OrmOrgsector>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<OrmOrgsector> selectByProleaderid(String pimpersonid) {
        return baseMapper.selectByProleaderid(pimpersonid);
    }

    @Override
    public void removeByProleaderid(String pimpersonid) {
        this.remove(new QueryWrapper<OrmOrgsector>().eq("proleaderid",pimpersonid));
    }


    /**
     * 查询集合 通过当前组织过滤部门(ORMORGID)
     */
    @Override
    public Page<OrmOrgsector> searchCURORMORG(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchCURORMORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目部编制管理
     */
    @Override
    public Page<OrmOrgsector> searchXMBBZGL(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchXMBBZGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 局所有项目部选择（第一版规则）
     */
    @Override
    public Page<OrmOrgsector> searchJSYXMB(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchJSYXMB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下的部门
     */
    @Override
    public Page<OrmOrgsector> searchCurZZBM(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchCurZZBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织部门（考勤设置）
     */
    @Override
    public Page<OrmOrgsector> searchCurZZBM_KQSZ(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchCurZZBM_KQSZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 通过当前组织过滤部门
     */
    @Override
    public Page<OrmOrgsector> searchCURORG(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchCURORG(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前部门
     */
    @Override
    public Page<OrmOrgsector> searchCurOrgSector(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchCurOrgSector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmOrgsector> searchDefault(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人员需求
     */
    @Override
    public Page<OrmOrgsector> searchBaseInfo(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchBaseInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织（及下级组织）下部门
     */
    @Override
    public Page<OrmOrgsector> searchDQZZXBM(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchDQZZXBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 设置项目负责人
     */
    @Override
    public Page<OrmOrgsector> searchRsshInfo(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchRsshInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织部门/项目部（组织专用）
     */
    @Override
    public Page<OrmOrgsector> searchSubOrgsector(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchSubOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织部门/项目部（人员信息专用）
     */
    @Override
    public Page<OrmOrgsector> searchPimpersonInfoOrgsector(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchPimpersonInfoOrgsector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人员需求（历史版本）
     */
    @Override
    public Page<OrmOrgsector> searchHisInfo(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchHisInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子组织部门
     */
    @Override
    public Page<OrmOrgsector> searchSubZZBM(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchSubZZBM(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目拓展信息
     */
    @Override
    public Page<OrmOrgsector> searchProExpandInfo(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchProExpandInfo(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 部门编制管理
     */
    @Override
    public Page<OrmOrgsector> searchBMBZGL(OrmOrgsectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmOrgsector> pages=baseMapper.searchBMBZGL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmOrgsector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmOrgsector et){
        //实体关系[DER1N_ORMORGSECTOR_ORMORGSECTOR_PORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getPorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector porgsector=et.getPorgsector();
            if(ObjectUtils.isEmpty(porgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getPorgsectorid());
                et.setPorgsector(majorEntity);
                porgsector=majorEntity;
            }
            et.setPorgsectorname(porgsector.getOrgsectorname());
        }
        //实体关系[DER1N_ORMORGSECTOR_ORMORGSECTOR_PRODEPID]
        if(!ObjectUtils.isEmpty(et.getProdepid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector prodep=et.getProdep();
            if(ObjectUtils.isEmpty(prodep)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getProdepid());
                et.setProdep(majorEntity);
                prodep=majorEntity;
            }
            et.setProdepname(prodep.getOrgsectorname());
        }
        //实体关系[DER1N_ORMORGSECTOR_ORMORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrgid());
                et.setOrg(majorEntity);
                org=majorEntity;
            }
            et.setOrgname(org.getOrgname());
            et.setZzdzs(org.getZzdzs());
        }
        //实体关系[DER1N_ORMORGSECTOR_ORMXMGL_ORMXMGLID]
        if(!ObjectUtils.isEmpty(et.getOrmxmglid())){
            cn.ibizlab.ehr.core.orm.domain.OrmXmgl ormxmgl=et.getOrmxmgl();
            if(ObjectUtils.isEmpty(ormxmgl)){
                cn.ibizlab.ehr.core.orm.domain.OrmXmgl majorEntity=ormxmglService.get(et.getOrmxmglid());
                et.setOrmxmgl(majorEntity);
                ormxmgl=majorEntity;
            }
            et.setEngineeringscale(ormxmgl.getEngineeringscale());
            et.setOrmxmglname(ormxmgl.getProjectName());
            et.setXmbh(ormxmgl.getProjectNumber());
        }
        //实体关系[DER1N_ORMORGSECTOR_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_ORMORGSECTOR_PIMPERSON_PROLEADERID]
        if(!ObjectUtils.isEmpty(et.getProleaderid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson proleader=et.getProleader();
            if(ObjectUtils.isEmpty(proleader)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getProleaderid());
                et.setProleader(majorEntity);
                proleader=majorEntity;
            }
            et.setProleadername(proleader.getPimpersonname());
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
    public List<OrmOrgsector> getOrmorgsectorByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmOrgsector> getOrmorgsectorByEntities(List<OrmOrgsector> entities) {
        List ids =new ArrayList();
        for(OrmOrgsector entity : entities){
            Serializable id=entity.getOrgsectorid();
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



