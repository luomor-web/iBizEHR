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
import cn.ibizlab.ehr.core.common.domain.DEDataChg2;
import cn.ibizlab.ehr.core.common.filter.DEDataChg2SearchContext;
import cn.ibizlab.ehr.core.common.service.IDEDataChg2Service;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.DEDataChg2Mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[实体数据变更（已处理）] 服务对象接口实现
 */
@Slf4j
@Service("DEDataChg2ServiceImpl")
public class DEDataChg2ServiceImpl extends ServiceImpl<DEDataChg2Mapper, DEDataChg2> implements IDEDataChg2Service {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.demodel.service.IDataEntityService dataentityService;

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
    @Transactional
    public DEDataChg2 get(String key) {
        DEDataChg2 et = getById(key);
        if(et==null){
            et=new DEDataChg2();
            et.setDedatachg2id(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(DEDataChg2 et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("dedatachg2id",et.getDedatachg2id())))
            return false;
        CachedBeanCopier.copy(get(et.getDedatachg2id()),et);
        return true;
    }

    @Override
    public void updateBatch(List<DEDataChg2> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public DEDataChg2 getDraft(DEDataChg2 et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(DEDataChg2 et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getDedatachg2id()),et);
        return true;
    }

    @Override
    public void createBatch(List<DEDataChg2> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(DEDataChg2 et) {
        return (!ObjectUtils.isEmpty(et.getDedatachg2id()))&&(!Objects.isNull(this.getById(et.getDedatachg2id())));
    }

    @Override
    @Transactional
    public boolean save(DEDataChg2 et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(DEDataChg2 et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<DEDataChg2> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<DEDataChg2> selectByDeid(String deid) {
        return baseMapper.selectByDeid(deid);
    }

    @Override
    public void removeByDeid(String deid) {
        this.remove(new QueryWrapper<DEDataChg2>().eq("deid",deid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DEDataChg2> searchDefault(DEDataChg2SearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<DEDataChg2> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<DEDataChg2>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(DEDataChg2 et){
        //实体关系[DER1N_DEDATACHG2_DATAENTITY_DEID]
        if(!ObjectUtils.isEmpty(et.getDeid())){
            cn.ibizlab.ehr.core.demodel.domain.DataEntity de=et.getDe();
            if(ObjectUtils.isEmpty(de)){
                cn.ibizlab.ehr.core.demodel.domain.DataEntity majorEntity=dataentityService.get(et.getDeid());
                et.setDe(majorEntity);
                de=majorEntity;
            }
            et.setDename(de.getDename());
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


