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
import cn.ibizlab.ehr.core.common.domain.MsgSendQueueHis;
import cn.ibizlab.ehr.core.common.filter.MsgSendQueueHisSearchContext;
import cn.ibizlab.ehr.core.common.service.IMsgSendQueueHisService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.MsgSendQueueHisMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[消息发送队列（历史）] 服务对象接口实现
 */
@Slf4j
@Service("MsgSendQueueHisServiceImpl")
public class MsgSendQueueHisServiceImpl extends ServiceImpl<MsgSendQueueHisMapper, MsgSendQueueHis> implements IMsgSendQueueHisService {


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
    public MsgSendQueueHis getDraft(MsgSendQueueHis et) {
        return et;
    }

    @Override
    public boolean checkKey(MsgSendQueueHis et) {
        return (!ObjectUtils.isEmpty(et.getMsgsendqueuehisid()))&&(!Objects.isNull(this.getById(et.getMsgsendqueuehisid())));
    }

    @Override
    @Transactional
    public boolean update(MsgSendQueueHis et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("msgsendqueuehisid",et.getMsgsendqueuehisid())))
            return false;
        CachedBeanCopier.copy(get(et.getMsgsendqueuehisid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<MsgSendQueueHis> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public MsgSendQueueHis get(String key) {
        MsgSendQueueHis et = getById(key);
        if(et==null){
            et=new MsgSendQueueHis();
            et.setMsgsendqueuehisid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(MsgSendQueueHis et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(MsgSendQueueHis et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<MsgSendQueueHis> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(MsgSendQueueHis et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getMsgsendqueuehisid()),et);
        return true;
    }

    @Override
    public void createBatch(List<MsgSendQueueHis> list) {
        saveBatch(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<MsgSendQueueHis> searchDefault(MsgSendQueueHisSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<MsgSendQueueHis> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<MsgSendQueueHis>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


