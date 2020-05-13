package cn.ibizlab.ehr.core.att.service.impl;

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
import cn.ibizlab.ehr.core.att.domain.ATTENSUMMARY;
import cn.ibizlab.ehr.core.att.filter.ATTENSUMMARYSearchContext;
import cn.ibizlab.ehr.core.att.service.IATTENSUMMARYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.ATTENSUMMARYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤汇总] 服务对象接口实现
 */
@Slf4j
@Service("ATTENSUMMARYServiceImpl")
public class ATTENSUMMARYServiceImpl extends ServiceImpl<ATTENSUMMARYMapper, ATTENSUMMARY> implements IATTENSUMMARYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    public ATTENSUMMARY getDraft(ATTENSUMMARY et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(ATTENSUMMARY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttensummaryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ATTENSUMMARY> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
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
    public boolean update(ATTENSUMMARY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attensummaryid",et.getAttensummaryid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttensummaryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ATTENSUMMARY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public ATTENSUMMARY get(String key) {
        ATTENSUMMARY et = getById(key);
        if(et==null){
            et=new ATTENSUMMARY();
            et.setAttensummaryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(ATTENSUMMARY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ATTENSUMMARY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ATTENSUMMARY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ATTENSUMMARY et) {
        return (!ObjectUtils.isEmpty(et.getAttensummaryid()))&&(!Objects.isNull(this.getById(et.getAttensummaryid())));
    }

    @Override
    @Transactional
    public ATTENSUMMARY exportKQHZ(ATTENSUMMARY et) {
        //自定义代码
        return et;
    }


	@Override
    public List<ATTENSUMMARY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ATTENSUMMARY>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 当前组织考勤汇总
     */
    @Override
    public Page<ATTENSUMMARY> searchCurZZKQHZ(ATTENSUMMARYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENSUMMARY> pages=baseMapper.searchCurZZKQHZ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENSUMMARY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ATTENSUMMARY> searchDefault(ATTENSUMMARYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENSUMMARY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENSUMMARY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ATTENSUMMARY et){
        //实体关系[DER1N_ATTENSUMMARY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setZw(pimperson.getZw());
            et.setYgbh(pimperson.getYgbh());
            et.setZjhm(pimperson.getZjhm());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgname(pimperson.getZzdzs());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setOrmorgsectorname(pimperson.getOrmorgsectorname());
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


