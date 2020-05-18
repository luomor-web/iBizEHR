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
import cn.ibizlab.ehr.core.common.domain.OrgUser;
import cn.ibizlab.ehr.core.common.filter.OrgUserSearchContext;
import cn.ibizlab.ehr.core.common.service.IOrgUserService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.OrgUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织人员] 服务对象接口实现
 */
@Slf4j
@Service("OrgUserServiceImpl")
public class OrgUserServiceImpl extends ServiceImpl<OrgUserMapper, OrgUser> implements IOrgUserService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSecUserService orgsecuserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSectorService orgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSecUserTypeService orgsecusertypeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgUserLevelService orguserlevelService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgService orgService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.logic.IOrgUserUpdateRelatedInfoLogic updaterelatedinfoLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.logic.IOrgUserUpdateCurUserLogic updatecuruserLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.logic.IOrgUserCreateRelatedInfoLogic createrelatedinfoLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.logic.IOrgUserGetCurUserLogic getcuruserLogic;

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
    public OrgUser getDraft(OrgUser et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(OrgUser et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orguserid",et.getOrguserid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrguserid()),et);
        updaterelatedinfoLogic.execute(et);
        return true;
    }

    @Override
    public void updateBatch(List<OrgUser> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public OrgUser get(String key) {
        OrgUser et = getById(key);
        if(et==null){
            et=new OrgUser();
            et.setOrguserid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrgUser et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrgUser et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<OrgUser> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrgUser updateCurUser(OrgUser et) {
        updatecuruserLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean create(OrgUser et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrguserid()),et);
        createrelatedinfoLogic.execute(et);
        return true;
    }

    @Override
    public void createBatch(List<OrgUser> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrgUser getCurUser(OrgUser et) {
        getcuruserLogic.execute(et);
         return et ;
    }

    @Override
    public boolean checkKey(OrgUser et) {
        return (!ObjectUtils.isEmpty(et.getOrguserid()))&&(!Objects.isNull(this.getById(et.getOrguserid())));
    }


	@Override
    public List<OrgUser> selectByOrgsectorid(String orgsectorid) {
        return baseMapper.selectByOrgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<OrgUser>().eq("orgsectorid",orgsectorid));
    }

	@Override
    public List<OrgUser> selectByOrgsecusertypeid(String orgsecusertypeid) {
        return baseMapper.selectByOrgsecusertypeid(orgsecusertypeid);
    }

    @Override
    public void removeByOrgsecusertypeid(String orgsecusertypeid) {
        this.remove(new QueryWrapper<OrgUser>().eq("orgsecusertypeid",orgsecusertypeid));
    }

	@Override
    public List<OrgUser> selectByOrguserlevelid(String orguserlevelid) {
        return baseMapper.selectByOrguserlevelid(orguserlevelid);
    }

    @Override
    public void removeByOrguserlevelid(String orguserlevelid) {
        this.remove(new QueryWrapper<OrgUser>().eq("orguserlevelid",orguserlevelid));
    }

	@Override
    public List<OrgUser> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<OrgUser>().eq("orgid",orgid));
    }


    /**
     * 查询集合 当前组织
     */
    @Override
    public Page<OrgUser> searchCurOrg(OrgUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgUser> pages=baseMapper.searchCurOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrgUser> searchDefault(OrgUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgUser> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前部门
     */
    @Override
    public Page<OrgUser> searchCurOrgSector(OrgUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgUser> pages=baseMapper.searchCurOrgSector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用户所在部门用户
     */
    @Override
    public Page<OrgUser> searchUserOrgSector(OrgUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgUser> pages=baseMapper.searchUserOrgSector(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 用户所在组织范围
     */
    @Override
    public Page<OrgUser> searchUserOrg(OrgUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgUser> pages=baseMapper.searchUserOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织及下级组织
     */
    @Override
    public Page<OrgUser> searchDQZZJXJZZ(OrgUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgUser> pages=baseMapper.searchDQZZJXJZZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrgUser et){
        //实体关系[DER1N_ORGUSER_ORGSECTOR_ORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrgsectorid())){
            cn.ibizlab.ehr.core.common.domain.OrgSector orgsector=et.getOrgsector();
            if(ObjectUtils.isEmpty(orgsector)){
                cn.ibizlab.ehr.core.common.domain.OrgSector majorEntity=orgsectorService.get(et.getOrgsectorid());
                et.setOrgsector(majorEntity);
                orgsector=majorEntity;
            }
            et.setBizcode(orgsector.getBizcode());
            et.setOrgsectorname(orgsector.getOrgsectorname());
        }
        //实体关系[DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID]
        if(!ObjectUtils.isEmpty(et.getOrgsecusertypeid())){
            cn.ibizlab.ehr.core.common.domain.OrgSecUserType orgsecusertype=et.getOrgsecusertype();
            if(ObjectUtils.isEmpty(orgsecusertype)){
                cn.ibizlab.ehr.core.common.domain.OrgSecUserType majorEntity=orgsecusertypeService.get(et.getOrgsecusertypeid());
                et.setOrgsecusertype(majorEntity);
                orgsecusertype=majorEntity;
            }
            et.setOrgsecusertypename(orgsecusertype.getOrgsecusertypename());
        }
        //实体关系[DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID]
        if(!ObjectUtils.isEmpty(et.getOrguserlevelid())){
            cn.ibizlab.ehr.core.common.domain.OrgUserLevel orguserlevel=et.getOrguserlevel();
            if(ObjectUtils.isEmpty(orguserlevel)){
                cn.ibizlab.ehr.core.common.domain.OrgUserLevel majorEntity=orguserlevelService.get(et.getOrguserlevelid());
                et.setOrguserlevel(majorEntity);
                orguserlevel=majorEntity;
            }
            et.setOrguserlevelname(orguserlevel.getOrguserlevelname());
        }
        //实体关系[DER1N_ORGUSER_ORG_ORGID]
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


