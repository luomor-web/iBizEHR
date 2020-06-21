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
import cn.ibizlab.ehr.core.pim.domain.PimTitle;
import cn.ibizlab.ehr.core.pim.filter.PimTitleSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimTitleService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimTitleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职称信息] 服务对象接口实现
 */
@Slf4j
@Service("PimTitleServiceImpl")
public class PimTitleServiceImpl extends ServiceImpl<PimTitleMapper, PimTitle> implements IPimTitleService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimTitleCatalogueService pimtitlecatalogueService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PimTitle et) {
        return (!ObjectUtils.isEmpty(et.getPimtitleid()))&&(!Objects.isNull(this.getById(et.getPimtitleid())));
    }
    @Override
    @Transactional
    public boolean update(PimTitle et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimtitleid",et.getPimtitleid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimtitleid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimTitle> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimTitle et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimtitleid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimTitle> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PimTitle getDraft(PimTitle et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimTitle et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimTitle et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimTitle> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimTitle> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimTitle ensureHighestTech(PimTitle et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimTitle get(String key) {
        PimTitle et = getById(key);
        if(et==null){
            et=new PimTitle();
            et.setPimtitleid(key);
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
    public List<PimTitle> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimTitle>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<PimTitle> selectByPimtitlecatalogueid(String pimtitlecatalogueid) {
        return baseMapper.selectByPimtitlecatalogueid(pimtitlecatalogueid);
    }

    @Override
    public void removeByPimtitlecatalogueid(String pimtitlecatalogueid) {
        this.remove(new QueryWrapper<PimTitle>().eq("pimtitlecatalogueid",pimtitlecatalogueid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimTitle> searchDefault(PimTitleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimTitle> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimTitle>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属
     */
    @Override
    public Page<PimTitle> searchJLSS(PimTitleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimTitle> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimTitle>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 职称记录所属是管理员的
     */
    @Override
    public Page<PimTitle> searchAscriptionSys(PimTitleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimTitle> pages=baseMapper.searchAscriptionSys(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimTitle>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 职称分布
     */
    @Override
    public Page<HashMap> searchREP_TITLE(PimTitleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<HashMap> pages=baseMapper.searchREP_TITLE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<HashMap>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(职称信息)
     */
    @Override
    public Page<PimTitle> searchZIZHU(PimTitleSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimTitle> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimTitle>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimTitle et){
        //实体关系[DER1N_PIMTITLE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
            et.setOrmorgname(pimperson.getZzdzs());
            et.setYgzt(pimperson.getYgzt());
            et.setOrmorgid(pimperson.getOrmorgid());
        }
        //实体关系[DER1N_PIMTITLE_PIMTITLECATALOGUE_PIMTITLECATALOGUEID]
        if(!ObjectUtils.isEmpty(et.getPimtitlecatalogueid())){
            cn.ibizlab.ehr.core.pim.domain.PimTitleCatalogue pimtitlecatalogue=et.getPimtitlecatalogue();
            if(ObjectUtils.isEmpty(pimtitlecatalogue)){
                cn.ibizlab.ehr.core.pim.domain.PimTitleCatalogue majorEntity=pimtitlecatalogueService.get(et.getPimtitlecatalogueid());
                et.setPimtitlecatalogue(majorEntity);
                pimtitlecatalogue=majorEntity;
            }
            et.setPimtitlecataloguename(pimtitlecatalogue.getPimtitlecataloguename());
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
    public List<PimTitle> getPimtitleByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimTitle> getPimtitleByEntities(List<PimTitle> entities) {
        List ids =new ArrayList();
        for(PimTitle entity : entities){
            Serializable id=entity.getPimtitleid();
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



