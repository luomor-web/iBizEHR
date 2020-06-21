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
import cn.ibizlab.ehr.core.pim.domain.PimResearchFindings;
import cn.ibizlab.ehr.core.pim.filter.PimResearchFindingsSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimResearchFindingsService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimResearchFindingsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[科研成果] 服务对象接口实现
 */
@Slf4j
@Service("PimResearchFindingsServiceImpl")
public class PimResearchFindingsServiceImpl extends ServiceImpl<PimResearchFindingsMapper, PimResearchFindings> implements IPimResearchFindingsService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PimResearchFindings et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimresearchfindingsid",et.getPimresearchfindingsid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimresearchfindingsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimResearchFindings> list) {
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
    public PimResearchFindings get(String key) {
        PimResearchFindings et = getById(key);
        if(et==null){
            et=new PimResearchFindings();
            et.setPimresearchfindingsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PimResearchFindings getDraft(PimResearchFindings et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PimResearchFindings et) {
        return (!ObjectUtils.isEmpty(et.getPimresearchfindingsid()))&&(!Objects.isNull(this.getById(et.getPimresearchfindingsid())));
    }
    @Override
    @Transactional
    public boolean save(PimResearchFindings et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimResearchFindings et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimResearchFindings> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimResearchFindings> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimResearchFindings et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimresearchfindingsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimResearchFindings> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PimResearchFindings> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimResearchFindings>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimResearchFindings> searchDefault(PimResearchFindingsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimResearchFindings> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimResearchFindings>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（管理员）
     */
    @Override
    public Page<PimResearchFindings> searchJLSSGLY(PimResearchFindingsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimResearchFindings> pages=baseMapper.searchJLSSGLY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimResearchFindings>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属（个人）
     */
    @Override
    public Page<PimResearchFindings> searchJLSSGR(PimResearchFindingsSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimResearchFindings> pages=baseMapper.searchJLSSGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimResearchFindings>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimResearchFindings et){
        //实体关系[DER1N_PIMRESEARCHFINDINGS_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
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

    @Override
    public List<PimResearchFindings> getPimresearchfindingsByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimResearchFindings> getPimresearchfindingsByEntities(List<PimResearchFindings> entities) {
        List ids =new ArrayList();
        for(PimResearchFindings entity : entities){
            Serializable id=entity.getPimresearchfindingsid();
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



