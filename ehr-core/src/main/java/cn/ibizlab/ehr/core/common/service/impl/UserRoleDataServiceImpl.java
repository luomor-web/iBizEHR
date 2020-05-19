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
import cn.ibizlab.ehr.core.common.domain.UserRoleData;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleDataService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleDataMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[数据对象能力] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleDataServiceImpl")
public class UserRoleDataServiceImpl extends ServiceImpl<UserRoleDataMapper, UserRoleData> implements IUserRoleDataService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataActionService userroledataactionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDataDetailService userroledatadetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDatasService userroledatasService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.demodel.service.IDataEntityService dataentityService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSectorService orgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgService orgService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(UserRoleData et) {
        return (!ObjectUtils.isEmpty(et.getUserroledataid()))&&(!Objects.isNull(this.getById(et.getUserroledataid())));
    }

    @Override
    @Transactional
    public boolean create(UserRoleData et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledataid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleData> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(UserRoleData et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroledataid",et.getUserroledataid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledataid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleData> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public UserRoleData get(String key) {
        UserRoleData et = getById(key);
        if(et==null){
            et=new UserRoleData();
            et.setUserroledataid(key);
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
    @Transactional
    public boolean save(UserRoleData et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleData et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleData> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public UserRoleData getDraft(UserRoleData et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<UserRoleData> selectByDeid(String deid) {
        return baseMapper.selectByDeid(deid);
    }

    @Override
    public void removeByDeid(String deid) {
        this.remove(new QueryWrapper<UserRoleData>().eq("deid",deid));
    }

	@Override
    public List<UserRoleData> selectByDstorgsectorid(String orgsectorid) {
        return baseMapper.selectByDstorgsectorid(orgsectorid);
    }

    @Override
    public void removeByDstorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<UserRoleData>().eq("dstorgsectorid",orgsectorid));
    }

	@Override
    public List<UserRoleData> selectByDstorgid(String orgid) {
        return baseMapper.selectByDstorgid(orgid);
    }

    @Override
    public void removeByDstorgid(String orgid) {
        this.remove(new QueryWrapper<UserRoleData>().eq("dstorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleData> searchDefault(UserRoleDataSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleData> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleData>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleData et){
        //实体关系[DER1N_USERROLEDATA_DATAENTITY_DEID]
        if(!ObjectUtils.isEmpty(et.getDeid())){
            cn.ibizlab.ehr.core.demodel.domain.DataEntity de=et.getDe();
            if(ObjectUtils.isEmpty(de)){
                cn.ibizlab.ehr.core.demodel.domain.DataEntity majorEntity=dataentityService.get(et.getDeid());
                et.setDe(majorEntity);
                de=majorEntity;
            }
            et.setDename(de.getDename());
        }
        //实体关系[DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getDstorgsectorid())){
            cn.ibizlab.ehr.core.common.domain.OrgSector dstorgsector=et.getDstorgsector();
            if(ObjectUtils.isEmpty(dstorgsector)){
                cn.ibizlab.ehr.core.common.domain.OrgSector majorEntity=orgsectorService.get(et.getDstorgsectorid());
                et.setDstorgsector(majorEntity);
                dstorgsector=majorEntity;
            }
            et.setDstorgsectorname(dstorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_USERROLEDATA_ORG_DSTORGID]
        if(!ObjectUtils.isEmpty(et.getDstorgid())){
            cn.ibizlab.ehr.core.common.domain.Org dstorg=et.getDstorg();
            if(ObjectUtils.isEmpty(dstorg)){
                cn.ibizlab.ehr.core.common.domain.Org majorEntity=orgService.get(et.getDstorgid());
                et.setDstorg(majorEntity);
                dstorg=majorEntity;
            }
            et.setDstorgname(dstorg.getOrgname());
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


