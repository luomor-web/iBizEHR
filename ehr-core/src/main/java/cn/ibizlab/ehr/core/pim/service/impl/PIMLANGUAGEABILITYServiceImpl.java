package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PIMLANGUAGEABILITY;
import cn.ibizlab.ehr.core.pim.filter.PIMLANGUAGEABILITYSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMLANGUAGEABILITYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMLANGUAGEABILITYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[语言能力] 服务对象接口实现
 */
@Slf4j
@Service("PIMLANGUAGEABILITYServiceImpl")
public class PIMLANGUAGEABILITYServiceImpl extends ServiceImpl<PIMLANGUAGEABILITYMapper, PIMLANGUAGEABILITY> implements IPIMLANGUAGEABILITYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    public PIMLANGUAGEABILITY getDraft(PIMLANGUAGEABILITY et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PIMLANGUAGEABILITY get(String key) {
        PIMLANGUAGEABILITY et = getById(key);
        if(et==null){
            et=new PIMLANGUAGEABILITY();
            et.setPimlanguageabilityid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PIMLANGUAGEABILITY custRemove(PIMLANGUAGEABILITY et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMLANGUAGEABILITY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMLANGUAGEABILITY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMLANGUAGEABILITY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMLANGUAGEABILITY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PIMLANGUAGEABILITY et) {
        return (!ObjectUtils.isEmpty(et.getPimlanguageabilityid()))&&(!Objects.isNull(this.getById(et.getPimlanguageabilityid())));
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
    public boolean update(PIMLANGUAGEABILITY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimlanguageabilityid",et.getPimlanguageabilityid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimlanguageabilityid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMLANGUAGEABILITY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMLANGUAGEABILITY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimlanguageabilityid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMLANGUAGEABILITY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PIMLANGUAGEABILITY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMLANGUAGEABILITY>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PIMLANGUAGEABILITY> searchJLSSGR(PIMLANGUAGEABILITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMLANGUAGEABILITY> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMLANGUAGEABILITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMLANGUAGEABILITY> searchDefault(PIMLANGUAGEABILITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMLANGUAGEABILITY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMLANGUAGEABILITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PIMLANGUAGEABILITY> searchJLSS(PIMLANGUAGEABILITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMLANGUAGEABILITY> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMLANGUAGEABILITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(语言能力)
     */
    @Override
    public Page<PIMLANGUAGEABILITY> searchZIZHU(PIMLANGUAGEABILITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMLANGUAGEABILITY> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMLANGUAGEABILITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PIMLANGUAGEABILITY> searchJLSSGLY(PIMLANGUAGEABILITYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMLANGUAGEABILITY> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMLANGUAGEABILITY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMLANGUAGEABILITY et){
        //实体关系[DER1N_PIMLANGUAGEABILITY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setYgbh(pimperson.getYgbh());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgid(pimperson.getOrmorgid());
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


