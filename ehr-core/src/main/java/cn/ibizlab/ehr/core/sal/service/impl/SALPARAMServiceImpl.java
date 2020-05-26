package cn.ibizlab.ehr.core.sal.service.impl;

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
import cn.ibizlab.ehr.core.sal.domain.SALPARAM;
import cn.ibizlab.ehr.core.sal.filter.SALPARAMSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALPARAMService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALPARAMMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬计算指标] 服务对象接口实现
 */
@Slf4j
@Service("SALPARAMServiceImpl")
public class SALPARAMServiceImpl extends ServiceImpl<SALPARAMMapper, SALPARAM> implements ISALPARAMService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALRULEDETAILService salruledetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALRULEService salruleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSOURCEService salsourceService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(SALPARAM et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALPARAM et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SALPARAM> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SALPARAM> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public SALPARAM get(String key) {
        SALPARAM et = getById(key);
        if(et==null){
            et=new SALPARAM();
            et.setSalparamid(key);
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
    public boolean checkKey(SALPARAM et) {
        return (!ObjectUtils.isEmpty(et.getSalparamid()))&&(!Objects.isNull(this.getById(et.getSalparamid())));
    }

    @Override
    @Transactional
    public boolean create(SALPARAM et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalparamid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALPARAM> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SALPARAM et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salparamid",et.getSalparamid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalparamid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALPARAM> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public SALPARAM getDraft(SALPARAM et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<SALPARAM> selectBySalsourceid(String salsourceid) {
        return baseMapper.selectBySalsourceid(salsourceid);
    }

    @Override
    public void removeBySalsourceid(String salsourceid) {
        this.remove(new QueryWrapper<SALPARAM>().eq("salsourceid",salsourceid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALPARAM> searchDefault(SALPARAMSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALPARAM> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALPARAM>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALPARAM et){
        //实体关系[DER1N_SALPARAM_SALSOURCE_SALSOURCEID]
        if(!ObjectUtils.isEmpty(et.getSalsourceid())){
            cn.ibizlab.ehr.core.sal.domain.SALSOURCE salsource=et.getSalsource();
            if(ObjectUtils.isEmpty(salsource)){
                cn.ibizlab.ehr.core.sal.domain.SALSOURCE majorEntity=salsourceService.get(et.getSalsourceid());
                et.setSalsource(majorEntity);
                salsource=majorEntity;
            }
            et.setSalsourcename(salsource.getSalsourcename());
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


