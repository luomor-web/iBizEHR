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
import cn.ibizlab.ehr.core.pim.domain.PIMTITLECATALOGUE;
import cn.ibizlab.ehr.core.pim.filter.PIMTITLECATALOGUESearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMTITLECATALOGUEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMTITLECATALOGUEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职称目录] 服务对象接口实现
 */
@Slf4j
@Service("PIMTITLECATALOGUEServiceImpl")
public class PIMTITLECATALOGUEServiceImpl extends ServiceImpl<PIMTITLECATALOGUEMapper, PIMTITLECATALOGUE> implements IPIMTITLECATALOGUEService {


    private cn.ibizlab.ehr.core.pim.service.IPIMTITLECATALOGUEService pimtitlecatalogueService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMTITLEService pimtitleService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PIMTITLECATALOGUE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMTITLECATALOGUE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMTITLECATALOGUE> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PIMTITLECATALOGUE et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimtitlecatalogueid",et.getPimtitlecatalogueid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimtitlecatalogueid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMTITLECATALOGUE> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public PIMTITLECATALOGUE getDraft(PIMTITLECATALOGUE et) {
        return et;
    }

    @Override
    @Transactional
    public boolean create(PIMTITLECATALOGUE et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimtitlecatalogueid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMTITLECATALOGUE> list) {
        saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PIMTITLECATALOGUE et) {
        return (!ObjectUtils.isEmpty(et.getPimtitlecatalogueid()))&&(!Objects.isNull(this.getById(et.getPimtitlecatalogueid())));
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
    public PIMTITLECATALOGUE get(String key) {
        PIMTITLECATALOGUE et = getById(key);
        if(et==null){
            et=new PIMTITLECATALOGUE();
            et.setPimtitlecatalogueid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PIMTITLECATALOGUE> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PIMTITLECATALOGUE>().eq("ormorgid",orgid));
    }

	@Override
    public List<PIMTITLECATALOGUE> selectByPimtitlecatalogueid2(String pimtitlecatalogueid) {
        return baseMapper.selectByPimtitlecatalogueid2(pimtitlecatalogueid);
    }

    @Override
    public void removeByPimtitlecatalogueid2(String pimtitlecatalogueid) {
        this.remove(new QueryWrapper<PIMTITLECATALOGUE>().eq("pimtitlecatalogueid2",pimtitlecatalogueid));
    }


    /**
     * 查询集合 查询没有上级职称的
     */
    @Override
    public Page<PIMTITLECATALOGUE> searchIsRootDQ(PIMTITLECATALOGUESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMTITLECATALOGUE> pages=baseMapper.searchIsRootDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMTITLECATALOGUE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 不查询没有上级职称的
     */
    @Override
    public Page<PIMTITLECATALOGUE> searchNotRootDQ(PIMTITLECATALOGUESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMTITLECATALOGUE> pages=baseMapper.searchNotRootDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMTITLECATALOGUE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMTITLECATALOGUE> searchDefault(PIMTITLECATALOGUESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMTITLECATALOGUE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMTITLECATALOGUE>(pages.getRecords(), context.getPageable(), pages.getTotal());
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

