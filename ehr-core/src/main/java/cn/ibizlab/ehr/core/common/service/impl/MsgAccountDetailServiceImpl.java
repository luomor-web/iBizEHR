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
import cn.ibizlab.ehr.core.common.domain.MsgAccountDetail;
import cn.ibizlab.ehr.core.common.filter.MsgAccountDetailSearchContext;
import cn.ibizlab.ehr.core.common.service.IMsgAccountDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.MsgAccountDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[组消息账户明细] 服务对象接口实现
 */
@Slf4j
@Service("MsgAccountDetailServiceImpl")
public class MsgAccountDetailServiceImpl extends ServiceImpl<MsgAccountDetailMapper, MsgAccountDetail> implements IMsgAccountDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IMsgAccountService msgaccountService;

    private int batchSize = 500;

    @Override
    public MsgAccountDetail getDraft(MsgAccountDetail et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(MsgAccountDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("msgaccountdetailid",et.getMsgaccountdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getMsgaccountdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<MsgAccountDetail> list) {
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
    public boolean checkKey(MsgAccountDetail et) {
        return (!ObjectUtils.isEmpty(et.getMsgaccountdetailid()))&&(!Objects.isNull(this.getById(et.getMsgaccountdetailid())));
    }

    @Override
    @Transactional
    public boolean save(MsgAccountDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(MsgAccountDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<MsgAccountDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(MsgAccountDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getMsgaccountdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<MsgAccountDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public MsgAccountDetail get(String key) {
        MsgAccountDetail et = getById(key);
        if(et==null){
            et=new MsgAccountDetail();
            et.setMsgaccountdetailid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<MsgAccountDetail> selectByMajormsgaccountid(String msgaccountid) {
        return baseMapper.selectByMajormsgaccountid(msgaccountid);
    }

    @Override
    public void removeByMajormsgaccountid(String msgaccountid) {
        this.remove(new QueryWrapper<MsgAccountDetail>().eq("majormsgaccountid",msgaccountid));
    }

	@Override
    public List<MsgAccountDetail> selectByMinormsgaccountid(String msgaccountid) {
        return baseMapper.selectByMinormsgaccountid(msgaccountid);
    }

    @Override
    public void removeByMinormsgaccountid(String msgaccountid) {
        this.remove(new QueryWrapper<MsgAccountDetail>().eq("minormsgaccountid",msgaccountid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<MsgAccountDetail> searchDefault(MsgAccountDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<MsgAccountDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<MsgAccountDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(MsgAccountDetail et){
        //实体关系[DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID]
        if(!ObjectUtils.isEmpty(et.getMajormsgaccountid())){
            cn.ibizlab.ehr.core.common.domain.MsgAccount majormsgaccount=et.getMajormsgaccount();
            if(ObjectUtils.isEmpty(majormsgaccount)){
                cn.ibizlab.ehr.core.common.domain.MsgAccount majorEntity=msgaccountService.get(et.getMajormsgaccountid());
                et.setMajormsgaccount(majorEntity);
                majormsgaccount=majorEntity;
            }
            et.setMajormsgaccountname(majormsgaccount.getMsgaccountname());
        }
        //实体关系[DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID]
        if(!ObjectUtils.isEmpty(et.getMinormsgaccountid())){
            cn.ibizlab.ehr.core.common.domain.MsgAccount minormsgaccount=et.getMinormsgaccount();
            if(ObjectUtils.isEmpty(minormsgaccount)){
                cn.ibizlab.ehr.core.common.domain.MsgAccount majorEntity=msgaccountService.get(et.getMinormsgaccountid());
                et.setMinormsgaccount(majorEntity);
                minormsgaccount=majorEntity;
            }
            et.setMinormsgaccountname(minormsgaccount.getMsgaccountname());
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


