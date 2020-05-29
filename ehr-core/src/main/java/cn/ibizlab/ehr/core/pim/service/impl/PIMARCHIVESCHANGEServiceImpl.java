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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESCHANGE;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESCHANGESearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMARCHIVESCHANGEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案归档地变更记录] 服务对象接口实现
 */
@Slf4j
@Service("PIMARCHIVESCHANGEServiceImpl")
public class PIMARCHIVESCHANGEServiceImpl extends ServiceImpl<PIMARCHIVESCHANGEMapper, PIMARCHIVESCHANGE> implements IPIMARCHIVESCHANGEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPIMARCHIVESCHANGEUpdatePersonFileLogic updatepersonfileLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PIMARCHIVESCHANGE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarchiveschangeid",et.getPimarchiveschangeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchiveschangeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMARCHIVESCHANGE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PIMARCHIVESCHANGE get(String key) {
        PIMARCHIVESCHANGE et = getById(key);
        if(et==null){
            et=new PIMARCHIVESCHANGE();
            et.setPimarchiveschangeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PIMARCHIVESCHANGE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchiveschangeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMARCHIVESCHANGE> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PIMARCHIVESCHANGE getDraft(PIMARCHIVESCHANGE et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PIMARCHIVESCHANGE et) {
        return (!ObjectUtils.isEmpty(et.getPimarchiveschangeid()))&&(!Objects.isNull(this.getById(et.getPimarchiveschangeid())));
    }

    @Override
    @Transactional
    public PIMARCHIVESCHANGE updatePersonFile(PIMARCHIVESCHANGE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMARCHIVESCHANGE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMARCHIVESCHANGE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMARCHIVESCHANGE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMARCHIVESCHANGE> list) {
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
    public List<PIMARCHIVESCHANGE> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PIMARCHIVESCHANGE>().eq("ormorgid",orgid));
    }

	@Override
    public List<PIMARCHIVESCHANGE> selectByOrmorgid2(String orgid) {
        return baseMapper.selectByOrmorgid2(orgid);
    }

    @Override
    public void removeByOrmorgid2(String orgid) {
        this.remove(new QueryWrapper<PIMARCHIVESCHANGE>().eq("ormorgid2",orgid));
    }

	@Override
    public List<PIMARCHIVESCHANGE> selectByPimarchivesid(String pimarchivesid) {
        return baseMapper.selectByPimarchivesid(pimarchivesid);
    }

    @Override
    public void removeByPimarchivesid(String pimarchivesid) {
        this.remove(new QueryWrapper<PIMARCHIVESCHANGE>().eq("pimarchivesid",pimarchivesid));
    }

	@Override
    public List<PIMARCHIVESCHANGE> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMARCHIVESCHANGE>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 档案调出记录
     */
    @Override
    public Page<PIMARCHIVESCHANGE> searchDADCJL(PIMARCHIVESCHANGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVESCHANGE> pages=baseMapper.searchDADCJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVESCHANGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMARCHIVESCHANGE> searchDefault(PIMARCHIVESCHANGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVESCHANGE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVESCHANGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMARCHIVESCHANGE et){
        //实体关系[DER1N_PIMARCHIVESCHANGE_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PIMARCHIVESCHANGE_ORMORG_ORMORGID2]
        if(!ObjectUtils.isEmpty(et.getOrmorgid2())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg2=et.getOrmorg2();
            if(ObjectUtils.isEmpty(ormorg2)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid2());
                et.setOrmorg2(majorEntity);
                ormorg2=majorEntity;
            }
            et.setOrmorgname2(ormorg2.getZzdzs());
        }
        //实体关系[DER1N_PIMARCHIVESCHANGE_PIMARCHIVES_PIMARCHIVESID]
        if(!ObjectUtils.isEmpty(et.getPimarchivesid())){
            cn.ibizlab.ehr.core.pim.domain.PimArchives pimarchives=et.getPimarchives();
            if(ObjectUtils.isEmpty(pimarchives)){
                cn.ibizlab.ehr.core.pim.domain.PimArchives majorEntity=pimarchivesService.get(et.getPimarchivesid());
                et.setPimarchives(majorEntity);
                pimarchives=majorEntity;
            }
            et.setPimpersonname(pimarchives.getPimpersonname());
            et.setPimarchivesname(pimarchives.getPimarchivesname());
            et.setYgbh(pimarchives.getYgbh());
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
    public List<PIMARCHIVESCHANGE> getPimarchiveschangeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PIMARCHIVESCHANGE> getPimarchiveschangeByEntities(List<PIMARCHIVESCHANGE> entities) {
        List ids =new ArrayList();
        for(PIMARCHIVESCHANGE entity : entities){
            Serializable id=entity.getPimarchiveschangeid();
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


