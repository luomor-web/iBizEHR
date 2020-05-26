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
import cn.ibizlab.ehr.core.pim.domain.ARCHIVALCATALOGUE;
import cn.ibizlab.ehr.core.pim.filter.ARCHIVALCATALOGUESearchContext;
import cn.ibizlab.ehr.core.pim.service.IARCHIVALCATALOGUEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.ARCHIVALCATALOGUEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案目录] 服务对象接口实现
 */
@Slf4j
@Service("ARCHIVALCATALOGUEServiceImpl")
public class ARCHIVALCATALOGUEServiceImpl extends ServiceImpl<ARCHIVALCATALOGUEMapper, ARCHIVALCATALOGUE> implements IARCHIVALCATALOGUEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESRECORDService pimarchivesrecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService pimarchivesService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(ARCHIVALCATALOGUE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ARCHIVALCATALOGUE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ARCHIVALCATALOGUE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ARCHIVALCATALOGUE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ARCHIVALCATALOGUE et) {
        return (!ObjectUtils.isEmpty(et.getArchivalcatalogueid()))&&(!Objects.isNull(this.getById(et.getArchivalcatalogueid())));
    }

    @Override
    @Transactional
    public ARCHIVALCATALOGUE get(String key) {
        ARCHIVALCATALOGUE et = getById(key);
        if(et==null){
            et=new ARCHIVALCATALOGUE();
            et.setArchivalcatalogueid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public ARCHIVALCATALOGUE getDraft(ARCHIVALCATALOGUE et) {
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
    public boolean update(ARCHIVALCATALOGUE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("archivalcatalogueid",et.getArchivalcatalogueid())))
            return false;
        CachedBeanCopier.copy(get(et.getArchivalcatalogueid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ARCHIVALCATALOGUE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ARCHIVALCATALOGUE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getArchivalcatalogueid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ARCHIVALCATALOGUE> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<ARCHIVALCATALOGUE> selectByPimarchivesid(String pimarchivesid) {
        return baseMapper.selectByPimarchivesid(pimarchivesid);
    }

    @Override
    public void removeByPimarchivesid(String pimarchivesid) {
        this.remove(new QueryWrapper<ARCHIVALCATALOGUE>().eq("pimarchivesid",pimarchivesid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ARCHIVALCATALOGUE> searchDefault(ARCHIVALCATALOGUESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ARCHIVALCATALOGUE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ARCHIVALCATALOGUE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ARCHIVALCATALOGUE et){
        //实体关系[DER1N_ARCHIVALCATALOGUE_PIMARCHIVES_PIMARCHIVESID]
        if(!ObjectUtils.isEmpty(et.getPimarchivesid())){
            cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES pimarchives=et.getPimarchives();
            if(ObjectUtils.isEmpty(pimarchives)){
                cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES majorEntity=pimarchivesService.get(et.getPimarchivesid());
                et.setPimarchives(majorEntity);
                pimarchives=majorEntity;
            }
            et.setPimarchivesname(pimarchives.getPimarchivesname());
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


