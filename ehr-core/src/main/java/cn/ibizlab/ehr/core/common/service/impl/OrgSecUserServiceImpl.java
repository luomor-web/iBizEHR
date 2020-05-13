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
import cn.ibizlab.ehr.core.common.domain.OrgSecUser;
import cn.ibizlab.ehr.core.common.filter.OrgSecUserSearchContext;
import cn.ibizlab.ehr.core.common.service.IOrgSecUserService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.OrgSecUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组织部门人员] 服务对象接口实现
 */
@Slf4j
@Service("OrgSecUserServiceImpl")
public class OrgSecUserServiceImpl extends ServiceImpl<OrgSecUserMapper, OrgSecUser> implements IOrgSecUserService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSectorService orgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSecUserTypeService orgsecusertypeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgUserService orguserService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgService orgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(OrgSecUser et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("orgsecuserid",et.getOrgsecuserid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsecuserid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrgSecUser> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public OrgSecUser getDraft(OrgSecUser et) {
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
    public boolean create(OrgSecUser et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrgsecuserid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrgSecUser> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(OrgSecUser et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrgSecUser et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<OrgSecUser> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrgSecUser removeDefault(OrgSecUser et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrgSecUser get(String key) {
        OrgSecUser et = getById(key);
        if(et==null){
            et=new OrgSecUser();
            et.setOrgsecuserid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(OrgSecUser et) {
        return (!ObjectUtils.isEmpty(et.getOrgsecuserid()))&&(!Objects.isNull(this.getById(et.getOrgsecuserid())));
    }


	@Override
    public List<OrgSecUser> selectByOrgsectorid(String orgsectorid) {
        return baseMapper.selectByOrgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<OrgSecUser>().eq("orgsectorid",orgsectorid));
    }

	@Override
    public List<OrgSecUser> selectByOrgsecusertypeid(String orgsecusertypeid) {
        return baseMapper.selectByOrgsecusertypeid(orgsecusertypeid);
    }

    @Override
    public void removeByOrgsecusertypeid(String orgsecusertypeid) {
        this.remove(new QueryWrapper<OrgSecUser>().eq("orgsecusertypeid",orgsecusertypeid));
    }

	@Override
    public List<OrgSecUser> selectByOrguserid(String orguserid) {
        return baseMapper.selectByOrguserid(orguserid);
    }

    @Override
    public void removeByOrguserid(String orguserid) {
        this.remove(new QueryWrapper<OrgSecUser>().eq("orguserid",orguserid));
    }

	@Override
    public List<OrgSecUser> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<OrgSecUser>().eq("orgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrgSecUser> searchDefault(OrgSecUserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrgSecUser> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrgSecUser>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrgSecUser et){
        //实体关系[DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrgsectorid())){
            cn.ibizlab.ehr.core.common.domain.OrgSector orgsector=et.getOrgsector();
            if(ObjectUtils.isEmpty(orgsector)){
                cn.ibizlab.ehr.core.common.domain.OrgSector majorEntity=orgsectorService.get(et.getOrgsectorid());
                et.setOrgsector(majorEntity);
                orgsector=majorEntity;
            }
            et.setOrgsectorname(orgsector.getOrgsectorname());
        }
        //实体关系[DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID]
        if(!ObjectUtils.isEmpty(et.getOrgsecusertypeid())){
            cn.ibizlab.ehr.core.common.domain.OrgSecUserType orgsecusertype=et.getOrgsecusertype();
            if(ObjectUtils.isEmpty(orgsecusertype)){
                cn.ibizlab.ehr.core.common.domain.OrgSecUserType majorEntity=orgsecusertypeService.get(et.getOrgsecusertypeid());
                et.setOrgsecusertype(majorEntity);
                orgsecusertype=majorEntity;
            }
            et.setOrgsecusertypename(orgsecusertype.getOrgsecusertypename());
        }
        //实体关系[DER1N_ORGSECUSER_ORGUSER_ORGUSERID]
        if(!ObjectUtils.isEmpty(et.getOrguserid())){
            cn.ibizlab.ehr.core.common.domain.OrgUser orguser=et.getOrguser();
            if(ObjectUtils.isEmpty(orguser)){
                cn.ibizlab.ehr.core.common.domain.OrgUser majorEntity=orguserService.get(et.getOrguserid());
                et.setOrguser(majorEntity);
                orguser=majorEntity;
            }
            et.setOrgusername(orguser.getOrgusername());
        }
        //实体关系[DER1N_ORGSECUSER_ORG_ORGID]
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


