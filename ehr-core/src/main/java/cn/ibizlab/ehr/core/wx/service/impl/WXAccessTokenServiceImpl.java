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
import cn.ibizlab.ehr.core.wx.domain.WXAccessToken;
import cn.ibizlab.ehr.core.wx.filter.WXAccessTokenSearchContext;
import cn.ibizlab.ehr.core.wx.service.IWXAccessTokenService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wx.mapper.WXAccessTokenMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[微信访问票据] 服务对象接口实现
 */
@Slf4j
@Service("WXAccessTokenServiceImpl")
public class WXAccessTokenServiceImpl extends ServiceImpl<WXAccessTokenMapper, WXAccessToken> implements IWXAccessTokenService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXAccountService wxaccountService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(WXAccessToken et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wxaccesstokenid",et.getWxaccesstokenid())))
            return false;
        CachedBeanCopier.copy(get(et.getWxaccesstokenid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WXAccessToken> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public WXAccessToken get(String key) {
        WXAccessToken et = getById(key);
        if(et==null){
            et=new WXAccessToken();
            et.setWxaccesstokenid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(WXAccessToken et) {
        return (!ObjectUtils.isEmpty(et.getWxaccesstokenid()))&&(!Objects.isNull(this.getById(et.getWxaccesstokenid())));
    }

    @Override
    @Transactional
    public boolean save(WXAccessToken et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WXAccessToken et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WXAccessToken> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(WXAccessToken et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWxaccesstokenid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WXAccessToken> list) {
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
    public WXAccessToken getDraft(WXAccessToken et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<WXAccessToken> selectByWxaccountid(String wxaccountid) {
        return baseMapper.selectByWxaccountid(wxaccountid);
    }

    @Override
    public void removeByWxaccountid(String wxaccountid) {
        this.remove(new QueryWrapper<WXAccessToken>().eq("wxaccountid",wxaccountid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WXAccessToken> searchDefault(WXAccessTokenSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WXAccessToken> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WXAccessToken>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WXAccessToken et){
        //实体关系[DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID]
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


