package cn.ibizlab.ehr.core.common.service.impl;

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
import cn.ibizlab.ehr.core.common.domain.OrgSector;
import cn.ibizlab.ehr.core.common.filter.OrgSectorSearchContext;
import cn.ibizlab.ehr.core.common.service.IOrgSectorService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.OrgSectorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织部门] 服务对象接口实现
 */
@Slf4j
@Service("OrgSectorServiceImpl")
public class OrgSectorServiceImpl extends ServiceImpl<OrgSectorMapper, OrgSector> implements IOrgSectorService {


    private cn.ibizlab.ehr.core.common.service.IOrgSectorService orgsectorService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSecUserService orgsecuserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgUserService orguserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService trmdutycadresService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataService userroledataService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXOrgSectorService wxorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgService orgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(OrgSector et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsectorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrgSector> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(OrgSector et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrgSector et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<OrgSector> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrgSector get(String key) {
        OrgSector et = getById(key);
        if(et==null){
            et=new OrgSector();
            et.setOrgsectorid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public OrgSector initUserObject(OrgSector et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrgSector et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgsectorid",et.getOrgsectorid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsectorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrgSector> list) {
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
    public boolean checkKey(OrgSector et) {
        return (!ObjectUtils.isEmpty(et.getOrgsectorid()))&&(!Objects.isNull(this.getById(et.getOrgsectorid())));
    }

    @Override
    public OrgSector getDraft(OrgSector et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<OrgSector> selectByPorgsectorid(String orgsectorid) {
        return baseMapper.selectByPorgsectorid(orgsectorid);
    }

    @Override
    public void removeByPorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<OrgSector>().eq("porgsectorid",orgsectorid));
    }

	@Override
    public List<OrgSector> selectByReporgsectorid(String orgsectorid) {
        return baseMapper.selectByReporgsectorid(orgsectorid);
    }

    @Override
    public void removeByReporgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<OrgSector>().eq("reporgsectorid",orgsectorid));
    }

	@Override
    public List<OrgSector> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<OrgSector>().eq("orgid",orgid));
    }


    /**
     * 查询集合 当前部门子部门
     */
    @Override
    public Page<OrgSector> searchCurChild(OrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSector> pages=baseMapper.searchCurChild(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下部门
     */
    @Override
    public Page<OrgSector> searchCurOrgOrg(OrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSector> pages=baseMapper.searchCurOrgOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用户部门子部门
     */
    @Override
    public Page<OrgSector> searchUserOrgSector(OrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSector> pages=baseMapper.searchUserOrgSector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 组织根部门
     */
    @Override
    public Page<OrgSector> searchOrgRoot(OrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSector> pages=baseMapper.searchOrgRoot(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用户组织部门
     */
    @Override
    public Page<OrgSector> searchUserOrg(OrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSector> pages=baseMapper.searchUserOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织
     */
    @Override
    public Page<OrgSector> searchCurOrg(OrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSector> pages=baseMapper.searchCurOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrgSector> searchDefault(OrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSector> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrgSector et){
        //实体关系[DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getPorgsectorid())){
            cn.ibizlab.ehr.core.common.domain.OrgSector porgsector=et.getPorgsector();
            if(ObjectUtils.isEmpty(porgsector)){
                cn.ibizlab.ehr.core.common.domain.OrgSector majorEntity=orgsectorService.get(et.getPorgsectorid());
                et.setPorgsector(majorEntity);
                porgsector=majorEntity;
            }
            et.setPorgsectorname(porgsector.getOrgsectorname());
        }
        //实体关系[DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getReporgsectorid())){
            cn.ibizlab.ehr.core.common.domain.OrgSector reporgsector=et.getReporgsector();
            if(ObjectUtils.isEmpty(reporgsector)){
                cn.ibizlab.ehr.core.common.domain.OrgSector majorEntity=orgsectorService.get(et.getReporgsectorid());
                et.setReporgsector(majorEntity);
                reporgsector=majorEntity;
            }
            et.setReporgsectorname(reporgsector.getOrgsectorname());
        }
        //实体关系[DER1N_ORGSECTOR_ORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.ehr.core.common.domain.Org org=et.getOrg();
            if(ObjectUtils.isEmpty(org)){
                cn.ibizlab.ehr.core.common.domain.Org majorEntity=orgService.get(et.getOrgid());
                et.setOrg(majorEntity);
                org=majorEntity;
            }
            et.setOrgname(org.getOrgname());
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


