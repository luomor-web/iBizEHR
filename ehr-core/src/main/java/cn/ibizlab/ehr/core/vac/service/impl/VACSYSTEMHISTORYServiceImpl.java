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
import cn.ibizlab.ehr.core.vac.domain.VACSYSTEMHISTORY;
import cn.ibizlab.ehr.core.vac.filter.VACSYSTEMHISTORYSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVACSYSTEMHISTORYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VACSYSTEMHISTORYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[制度历史] 服务对象接口实现
 */
@Slf4j
@Service("VACSYSTEMHISTORYServiceImpl")
public class VACSYSTEMHISTORYServiceImpl extends ServiceImpl<VACSYSTEMHISTORYMapper, VACSYSTEMHISTORY> implements IVACSYSTEMHISTORYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACLEAVESYSTEMService vacleavesystemService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(VACSYSTEMHISTORY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacsystemhistoryid",et.getVacsystemhistoryid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacsystemhistoryid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VACSYSTEMHISTORY> list) {
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
    @Transactional
    public boolean save(VACSYSTEMHISTORY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VACSYSTEMHISTORY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<VACSYSTEMHISTORY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VACSYSTEMHISTORY get(String key) {
        VACSYSTEMHISTORY et = getById(key);
        if(et==null){
            et=new VACSYSTEMHISTORY();
            et.setVacsystemhistoryid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(VACSYSTEMHISTORY et) {
        return (!ObjectUtils.isEmpty(et.getVacsystemhistoryid()))&&(!Objects.isNull(this.getById(et.getVacsystemhistoryid())));
    }

    @Override
    @Transactional
    public boolean create(VACSYSTEMHISTORY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacsystemhistoryid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VACSYSTEMHISTORY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public VACSYSTEMHISTORY getDraft(VACSYSTEMHISTORY et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<VACSYSTEMHISTORY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VACSYSTEMHISTORY>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<VACSYSTEMHISTORY> selectByVacleavesystemid(String vacleavesystemid) {
        return baseMapper.selectByVacleavesystemid(vacleavesystemid);
    }

    @Override
    public void removeByVacleavesystemid(String vacleavesystemid) {
        this.remove(new QueryWrapper<VACSYSTEMHISTORY>().eq("vacleavesystemid",vacleavesystemid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VACSYSTEMHISTORY> searchDefault(VACSYSTEMHISTORYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACSYSTEMHISTORY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACSYSTEMHISTORY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VACSYSTEMHISTORY et){
        //实体关系[DER1N_VACSYSTEMHISTORY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_VACSYSTEMHISTORY_VACLEAVESYSTEM_VACLEAVESYSTEMID]
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


