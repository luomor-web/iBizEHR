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
import cn.ibizlab.ehr.core.wx.domain.WXAccount;
import cn.ibizlab.ehr.core.wx.filter.WXAccountSearchContext;
import cn.ibizlab.ehr.core.wx.service.IWXAccountService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wx.mapper.WXAccountMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[微信公众号] 服务对象接口实现
 */
@Slf4j
@Service("WXAccountServiceImpl")
public class WXAccountServiceImpl extends ServiceImpl<WXAccountMapper, WXAccount> implements IWXAccountService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXAccessTokenService wxaccesstokenService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXEntAppService wxentappService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXMediaService wxmediaService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXMessageService wxmessageService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXOrgSectorService wxorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IOrgService orgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WXAccount et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWxaccountid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WXAccount> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(WXAccount et) {
        return (!ObjectUtils.isEmpty(et.getWxaccountid()))&&(!Objects.isNull(this.getById(et.getWxaccountid())));
    }

    @Override
    @Transactional
    public boolean update(WXAccount et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wxaccountid",et.getWxaccountid())))
            return false;
        CachedBeanCopier.copy(get(et.getWxaccountid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WXAccount> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public WXAccount syncOrgSector(WXAccount et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public WXAccount pubMenu(WXAccount et) {
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
    public WXAccount syncOrgUser(WXAccount et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public WXAccount get(String key) {
        WXAccount et = getById(key);
        if(et==null){
            et=new WXAccount();
            et.setWxaccountid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(WXAccount et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WXAccount et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WXAccount> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public WXAccount getDraft(WXAccount et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<WXAccount> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<WXAccount>().eq("orgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WXAccount> searchDefault(WXAccountSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WXAccount> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WXAccount>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WXAccount et){
        //实体关系[DER1N_WXACCOUNT_ORG_ORGID]
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


