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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEMDETAIL;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVESYSTEMDETAILSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVESYSTEMDETAILService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VACLEAVESYSTEMDETAILMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[休假制度明细] 服务对象接口实现
 */
@Slf4j
@Service("VACLEAVESYSTEMDETAILServiceImpl")
public class VACLEAVESYSTEMDETAILServiceImpl extends ServiceImpl<VACLEAVESYSTEMDETAILMapper, VACLEAVESYSTEMDETAIL> implements IVACLEAVESYSTEMDETAILService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACLEAVESYSTEMService vacleavesystemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(VACLEAVESYSTEMDETAIL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavesystemdetailid",et.getVacleavesystemdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavesystemdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VACLEAVESYSTEMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(VACLEAVESYSTEMDETAIL et) {
        return (!ObjectUtils.isEmpty(et.getVacleavesystemdetailid()))&&(!Objects.isNull(this.getById(et.getVacleavesystemdetailid())));
    }

    @Override
    @Transactional
    public boolean save(VACLEAVESYSTEMDETAIL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VACLEAVESYSTEMDETAIL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VACLEAVESYSTEMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VACLEAVESYSTEMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
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
    public VACLEAVESYSTEMDETAIL getDraft(VACLEAVESYSTEMDETAIL et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public VACLEAVESYSTEMDETAIL get(String key) {
        VACLEAVESYSTEMDETAIL et = getById(key);
        if(et==null){
            et=new VACLEAVESYSTEMDETAIL();
            et.setVacleavesystemdetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(VACLEAVESYSTEMDETAIL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavesystemdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VACLEAVESYSTEMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<VACLEAVESYSTEMDETAIL> selectByVacleavesystemid(String vacleavesystemid) {
        return baseMapper.selectByVacleavesystemid(vacleavesystemid);
    }

    @Override
    public void removeByVacleavesystemid(String vacleavesystemid) {
        this.remove(new QueryWrapper<VACLEAVESYSTEMDETAIL>().eq("vacleavesystemid",vacleavesystemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VACLEAVESYSTEMDETAIL> searchDefault(VACLEAVESYSTEMDETAILSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVESYSTEMDETAIL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVESYSTEMDETAIL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VACLEAVESYSTEMDETAIL et){
        //实体关系[DER1N_VACLEAVESYSTEMDETAIL_VACLEAVESYSTEM_VACLEAVESYSTEMID]
        if(!ObjectUtils.isEmpty(et.getVacleavesystemid())){
            cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEM vacleavesystem=et.getVacleavesystem();
            if(ObjectUtils.isEmpty(vacleavesystem)){
                cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEM majorEntity=vacleavesystemService.get(et.getVacleavesystemid());
                et.setVacleavesystem(majorEntity);
                vacleavesystem=majorEntity;
            }
            et.setVacleavesystemname(vacleavesystem.getVacleavesystemname());
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


