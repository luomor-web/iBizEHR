package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TRMSTAY;
import cn.ibizlab.ehr.core.trm.filter.TRMSTAYSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMSTAYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMSTAYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训住宿] 服务对象接口实现
 */
@Slf4j
@Service("TRMSTAYServiceImpl")
public class TRMSTAYServiceImpl extends ServiceImpl<TRMSTAYMapper, TRMSTAY> implements ITRMSTAYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINADDRESSService trmtrainaddressService;

    private int batchSize = 500;

    @Override
    public TRMSTAY getDraft(TRMSTAY et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TRMSTAY get(String key) {
        TRMSTAY et = getById(key);
        if(et==null){
            et=new TRMSTAY();
            et.setTrmstayid(key);
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
    public boolean save(TRMSTAY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMSTAY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMSTAY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TRMSTAY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmstayid",et.getTrmstayid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstayid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMSTAY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TRMSTAY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstayid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMSTAY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMSTAY et) {
        return (!ObjectUtils.isEmpty(et.getTrmstayid()))&&(!Objects.isNull(this.getById(et.getTrmstayid())));
    }


	@Override
    public List<TRMSTAY> selectByTrmtrainaddressid(String trmtrainaddressid) {
        return baseMapper.selectByTrmtrainaddressid(trmtrainaddressid);
    }

    @Override
    public void removeByTrmtrainaddressid(String trmtrainaddressid) {
        this.remove(new QueryWrapper<TRMSTAY>().eq("trmtrainaddressid",trmtrainaddressid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMSTAY> searchDefault(TRMSTAYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMSTAY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMSTAY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMSTAY et){
        //实体关系[DER1N_TRMSTAY_TRMTRAINADDRESS_TRMTRAINADDRESSID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainaddressid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINADDRESS trmtrainaddress=et.getTrmtrainaddress();
            if(ObjectUtils.isEmpty(trmtrainaddress)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINADDRESS majorEntity=trmtrainaddressService.get(et.getTrmtrainaddressid());
                et.setTrmtrainaddress(majorEntity);
                trmtrainaddress=majorEntity;
            }
            et.setTrmtrainaddressname(trmtrainaddress.getTrmtrainaddressname());
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


