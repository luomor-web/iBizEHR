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
import cn.ibizlab.ehr.core.pim.domain.PimFaminfo;
import cn.ibizlab.ehr.core.pim.filter.PimFaminfoSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimFaminfoService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimFaminfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[家庭情况] 服务对象接口实现
 */
@Slf4j
@Service("PimFaminfoServiceImpl")
public class PimFaminfoServiceImpl extends ServiceImpl<PimFaminfoMapper, PimFaminfo> implements IPimFaminfoService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PimFaminfo et) {
        return (!ObjectUtils.isEmpty(et.getPimfaminfoid()))&&(!Objects.isNull(this.getById(et.getPimfaminfoid())));
    }
    @Override
    @Transactional
    public PimFaminfo updateInfo(PimFaminfo et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimFaminfo updateContact(PimFaminfo et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimFaminfo et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimfaminfoid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimFaminfo> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PimFaminfo et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimfaminfoid",et.getPimfaminfoid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimfaminfoid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimFaminfo> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PimFaminfo getDraft(PimFaminfo et) {
        fillParentData(et);
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
    public boolean save(PimFaminfo et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimFaminfo et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimFaminfo> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimFaminfo> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimFaminfo get(String key) {
        PimFaminfo et = getById(key);
        if(et==null){
            et=new PimFaminfo();
            et.setPimfaminfoid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PimFaminfo> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimFaminfo>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PimFaminfo> searchJLSSGR(PimFaminfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFaminfo> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFaminfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询该人员的家庭联系人
     */
    @Override
    public Page<PimFaminfo> searchJTLXR(PimFaminfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFaminfo> pages=baseMapper.searchJTLXR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFaminfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimFaminfo> searchDefault(PimFaminfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFaminfo> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFaminfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PimFaminfo> searchJLSSGLY(PimFaminfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFaminfo> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFaminfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 非A类员工转正使用
     */
    @Override
    public Page<PimFaminfo> searchFAZZSY(PimFaminfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFaminfo> pages=baseMapper.searchFAZZSY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFaminfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(家庭情况)
     */
    @Override
    public Page<PimFaminfo> searchZIZHU(PimFaminfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFaminfo> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFaminfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PimFaminfo> searchJLSS(PimFaminfoSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimFaminfo> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimFaminfo>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimFaminfo et){
        //实体关系[DER1N_PIMFAMINFO_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setYgbh(pimperson.getYgbh());
            et.setPimpersonname(pimperson.getPimpersonname());
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
    public List<PimFaminfo> getPimfaminfoByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimFaminfo> getPimfaminfoByEntities(List<PimFaminfo> entities) {
        List ids =new ArrayList();
        for(PimFaminfo entity : entities){
            Serializable id=entity.getPimfaminfoid();
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



