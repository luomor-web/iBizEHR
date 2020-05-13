package cn.ibizlab.ehr.core.wx.service.impl;

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
import cn.ibizlab.ehr.core.wx.domain.WXOrgSector;
import cn.ibizlab.ehr.core.wx.filter.WXOrgSectorSearchContext;
import cn.ibizlab.ehr.core.wx.service.IWXOrgSectorService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wx.mapper.WXOrgSectorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[微信部门] 服务对象接口实现
 */
@Slf4j
@Service("WXOrgSectorServiceImpl")
public class WXOrgSectorServiceImpl extends ServiceImpl<WXOrgSectorMapper, WXOrgSector> implements IWXOrgSectorService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgSectorService orgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXAccountService wxaccountService;

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
    public boolean checkKey(WXOrgSector et) {
        return (!ObjectUtils.isEmpty(et.getWxorgsectorid()))&&(!Objects.isNull(this.getById(et.getWxorgsectorid())));
    }

    @Override
    @Transactional
    public boolean create(WXOrgSector et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWxorgsectorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WXOrgSector> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public WXOrgSector get(String key) {
        WXOrgSector et = getById(key);
        if(et==null){
            et=new WXOrgSector();
            et.setWxorgsectorid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(WXOrgSector et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WXOrgSector et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WXOrgSector> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WXOrgSector et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wxorgsectorid",et.getWxorgsectorid())))
            return false;
        CachedBeanCopier.copy(get(et.getWxorgsectorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WXOrgSector> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public WXOrgSector getDraft(WXOrgSector et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<WXOrgSector> selectByOrgsectorid(String orgsectorid) {
        return baseMapper.selectByOrgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<WXOrgSector>().eq("orgsectorid",orgsectorid));
    }

	@Override
    public List<WXOrgSector> selectByWxaccountid(String wxaccountid) {
        return baseMapper.selectByWxaccountid(wxaccountid);
    }

    @Override
    public void removeByWxaccountid(String wxaccountid) {
        this.remove(new QueryWrapper<WXOrgSector>().eq("wxaccountid",wxaccountid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WXOrgSector> searchDefault(WXOrgSectorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WXOrgSector> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WXOrgSector>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WXOrgSector et){
        //实体关系[DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrgsectorid())){
            cn.ibizlab.ehr.core.common.domain.OrgSector orgsector=et.getOrgsector();
            if(ObjectUtils.isEmpty(orgsector)){
                cn.ibizlab.ehr.core.common.domain.OrgSector majorEntity=orgsectorService.get(et.getOrgsectorid());
                et.setOrgsector(majorEntity);
                orgsector=majorEntity;
            }
            et.setOrgsectorname(orgsector.getOrgsectorname());
        }
        //实体关系[DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID]
        if(!ObjectUtils.isEmpty(et.getWxaccountid())){
            cn.ibizlab.ehr.core.wx.domain.WXAccount wxaccount=et.getWxaccount();
            if(ObjectUtils.isEmpty(wxaccount)){
                cn.ibizlab.ehr.core.wx.domain.WXAccount majorEntity=wxaccountService.get(et.getWxaccountid());
                et.setWxaccount(majorEntity);
                wxaccount=majorEntity;
            }
            et.setWxaccountname(wxaccount.getWxaccountname());
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


