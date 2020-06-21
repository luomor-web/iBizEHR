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
import cn.ibizlab.ehr.core.pim.domain.PimPatent;
import cn.ibizlab.ehr.core.pim.filter.PimPatentSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimPatentService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimPatentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[专利信息] 服务对象接口实现
 */
@Slf4j
@Service("PimPatentServiceImpl")
public class PimPatentServiceImpl extends ServiceImpl<PimPatentMapper, PimPatent> implements IPimPatentService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PimPatent get(String key) {
        PimPatent et = getById(key);
        if(et==null){
            et=new PimPatent();
            et.setPimpatentid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PimPatent getDraft(PimPatent et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimPatent et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpatentid",et.getPimpatentid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpatentid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimPatent> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimPatent et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpatentid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimPatent> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimPatent et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimPatent et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimPatent> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimPatent> list) {
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
    public boolean checkKey(PimPatent et) {
        return (!ObjectUtils.isEmpty(et.getPimpatentid()))&&(!Objects.isNull(this.getById(et.getPimpatentid())));
    }

	@Override
    public List<PimPatent> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimPatent>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PimPatent> searchJLSSGLY(PimPatentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPatent> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPatent>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimPatent> searchDefault(PimPatentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPatent> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPatent>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PimPatent> searchJLSSGR(PimPatentSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimPatent> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimPatent>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimPatent et){
        //实体关系[DER1N_PIMPATENT_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
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

    @Override
    public List<PimPatent> getPimpatentByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimPatent> getPimpatentByEntities(List<PimPatent> entities) {
        List ids =new ArrayList();
        for(PimPatent entity : entities){
            Serializable id=entity.getPimpatentid();
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



