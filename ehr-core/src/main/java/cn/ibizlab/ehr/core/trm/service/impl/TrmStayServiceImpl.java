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
import cn.ibizlab.ehr.core.trm.domain.TrmStay;
import cn.ibizlab.ehr.core.trm.filter.TrmStaySearchContext;
import cn.ibizlab.ehr.core.trm.service.ITrmStayService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TrmStayMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训住宿] 服务对象接口实现
 */
@Slf4j
@Service("TrmStayServiceImpl")
public class TrmStayServiceImpl extends ServiceImpl<TrmStayMapper, TrmStay> implements ITrmStayService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITrmTrainAddressService trmtrainaddressService;

    private int batchSize = 500;

    @Override
    public TrmStay getDraft(TrmStay et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TrmStay get(String key) {
        TrmStay et = getById(key);
        if(et==null){
            et=new TrmStay();
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
    public boolean save(TrmStay et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TrmStay et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TrmStay> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TrmStay> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TrmStay et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmstayid",et.getTrmstayid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstayid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TrmStay> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TrmStay et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmstayid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TrmStay> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TrmStay et) {
        return (!ObjectUtils.isEmpty(et.getTrmstayid()))&&(!Objects.isNull(this.getById(et.getTrmstayid())));
    }

	@Override
    public List<TrmStay> selectByTrmtrainaddressid(String trmtrainaddressid) {
        return baseMapper.selectByTrmtrainaddressid(trmtrainaddressid);
    }

    @Override
    public void removeByTrmtrainaddressid(String trmtrainaddressid) {
        this.remove(new QueryWrapper<TrmStay>().eq("trmtrainaddressid",trmtrainaddressid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TrmStay> searchDefault(TrmStaySearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TrmStay> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TrmStay>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TrmStay et){
        //实体关系[DER1N_TRMSTAY_TRMTRAINADDRESS_TRMTRAINADDRESSID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainaddressid())){
            cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress=et.getTrmtrainaddress();
            if(ObjectUtils.isEmpty(trmtrainaddress)){
                cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress majorEntity=trmtrainaddressService.get(et.getTrmtrainaddressid());
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

    @Override
    public List<TrmStay> getTrmstayByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TrmStay> getTrmstayByEntities(List<TrmStay> entities) {
        List ids =new ArrayList();
        for(TrmStay entity : entities){
            Serializable id=entity.getTrmstayid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



