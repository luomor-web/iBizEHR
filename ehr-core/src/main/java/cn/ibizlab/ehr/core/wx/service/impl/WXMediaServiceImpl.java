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
import cn.ibizlab.ehr.core.wx.domain.WXMedia;
import cn.ibizlab.ehr.core.wx.filter.WXMediaSearchContext;
import cn.ibizlab.ehr.core.wx.service.IWXMediaService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.wx.mapper.WXMediaMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[微信多媒体内容] 服务对象接口实现
 */
@Slf4j
@Service("WXMediaServiceImpl")
public class WXMediaServiceImpl extends ServiceImpl<WXMediaMapper, WXMedia> implements IWXMediaService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXAccountService wxaccountService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.wx.service.IWXEntAppService wxentappService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(WXMedia et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getWxmediaid()),et);
        return true;
    }

    @Override
    public void createBatch(List<WXMedia> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(WXMedia et) {
        return (!ObjectUtils.isEmpty(et.getWxmediaid()))&&(!Objects.isNull(this.getById(et.getWxmediaid())));
    }

    @Override
    public WXMedia getDraft(WXMedia et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(WXMedia et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(WXMedia et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<WXMedia> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(WXMedia et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("wxmediaid",et.getWxmediaid())))
            return false;
        CachedBeanCopier.copy(get(et.getWxmediaid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<WXMedia> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public WXMedia get(String key) {
        WXMedia et = getById(key);
        if(et==null){
            et=new WXMedia();
            et.setWxmediaid(key);
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
    public List<WXMedia> selectByWxaccountid(String wxaccountid) {
        return baseMapper.selectByWxaccountid(wxaccountid);
    }

    @Override
    public void removeByWxaccountid(String wxaccountid) {
        this.remove(new QueryWrapper<WXMedia>().eq("wxaccountid",wxaccountid));
    }

	@Override
    public List<WXMedia> selectByWxentappid(String wxentappid) {
        return baseMapper.selectByWxentappid(wxentappid);
    }

    @Override
    public void removeByWxentappid(String wxentappid) {
        this.remove(new QueryWrapper<WXMedia>().eq("wxentappid",wxentappid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WXMedia> searchDefault(WXMediaSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WXMedia> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WXMedia>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(WXMedia et){
        //实体关系[DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID]
        if(!ObjectUtils.isEmpty(et.getWxaccountid())){
            cn.ibizlab.ehr.core.wx.domain.WXAccount wxaccount=et.getWxaccount();
            if(ObjectUtils.isEmpty(wxaccount)){
                cn.ibizlab.ehr.core.wx.domain.WXAccount majorEntity=wxaccountService.get(et.getWxaccountid());
                et.setWxaccount(majorEntity);
                wxaccount=majorEntity;
            }
            et.setWxaccountname(wxaccount.getWxaccountname());
        }
        //实体关系[DER1N_WXMEDIA_WXENTAPP_WXENTAPPID]
        if(!ObjectUtils.isEmpty(et.getWxentappid())){
            cn.ibizlab.ehr.core.wx.domain.WXEntApp wxentapp=et.getWxentapp();
            if(ObjectUtils.isEmpty(wxentapp)){
                cn.ibizlab.ehr.core.wx.domain.WXEntApp majorEntity=wxentappService.get(et.getWxentappid());
                et.setWxentapp(majorEntity);
                wxentapp=majorEntity;
            }
            et.setWxentappname(wxentapp.getWxentappname());
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

