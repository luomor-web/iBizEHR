package cn.ibizlab.ehr.core.vac.service.impl;

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
import cn.ibizlab.ehr.core.vac.domain.VACUSENXJMX;
import cn.ibizlab.ehr.core.vac.filter.VACUSENXJMXSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVACUSENXJMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VACUSENXJMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[假期使用明细] 服务对象接口实现
 */
@Slf4j
@Service("VACUSENXJMXServiceImpl")
public class VACUSENXJMXServiceImpl extends ServiceImpl<VACUSENXJMXMapper, VACUSENXJMX> implements IVACUSENXJMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACLEAVEDETAILService vacleavedetailService;

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
    public boolean checkKey(VACUSENXJMX et) {
        return (!ObjectUtils.isEmpty(et.getVacusenxjmxid()))&&(!Objects.isNull(this.getById(et.getVacusenxjmxid())));
    }

    @Override
    @Transactional
    public boolean create(VACUSENXJMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacusenxjmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VACUSENXJMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(VACUSENXJMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacusenxjmxid",et.getVacusenxjmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacusenxjmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VACUSENXJMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(VACUSENXJMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VACUSENXJMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<VACUSENXJMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public VACUSENXJMX getDraft(VACUSENXJMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public VACUSENXJMX get(String key) {
        VACUSENXJMX et = getById(key);
        if(et==null){
            et=new VACUSENXJMX();
            et.setVacusenxjmxid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<VACUSENXJMX> selectByVacleavedetailid(String vacleavedetailid) {
        return baseMapper.selectByVacleavedetailid(vacleavedetailid);
    }

    @Override
    public void removeByVacleavedetailid(String vacleavedetailid) {
        this.remove(new QueryWrapper<VACUSENXJMX>().eq("vacleavedetailid",vacleavedetailid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VACUSENXJMX> searchDefault(VACUSENXJMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACUSENXJMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACUSENXJMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VACUSENXJMX et){
        //实体关系[DER1N_VACUSENXJMX_VACLEAVEDETAIL_VACLEAVEDETAILID]
        if(!ObjectUtils.isEmpty(et.getVacleavedetailid())){
            cn.ibizlab.ehr.core.vac.domain.VACLEAVEDETAIL vacleavedetail=et.getVacleavedetail();
            if(ObjectUtils.isEmpty(vacleavedetail)){
                cn.ibizlab.ehr.core.vac.domain.VACLEAVEDETAIL majorEntity=vacleavedetailService.get(et.getVacleavedetailid());
                et.setVacleavedetail(majorEntity);
                vacleavedetail=majorEntity;
            }
            et.setPimpersonid(vacleavedetail.getPimpersonid());
            et.setPimpersonname(vacleavedetail.getPimpersonname());
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


