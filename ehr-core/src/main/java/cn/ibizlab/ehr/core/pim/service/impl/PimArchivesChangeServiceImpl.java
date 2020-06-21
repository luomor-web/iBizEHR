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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesChange;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesChangeSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesChangeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimArchivesChangeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案归档地变更记录] 服务对象接口实现
 */
@Slf4j
@Service("PimArchivesChangeServiceImpl")
public class PimArchivesChangeServiceImpl extends ServiceImpl<PimArchivesChangeMapper, PimArchivesChange> implements IPimArchivesChangeService {

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
    private cn.ibizlab.ehr.core.pim.service.logic.IPimArchivesChangeUpdatePersonFileLogic updatepersonfileLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PimArchivesChange et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarchiveschangeid",et.getPimarchiveschangeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchiveschangeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimArchivesChange> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimArchivesChange get(String key) {
        PimArchivesChange et = getById(key);
        if(et==null){
            et=new PimArchivesChange();
            et.setPimarchiveschangeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimArchivesChange et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchiveschangeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimArchivesChange> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PimArchivesChange getDraft(PimArchivesChange et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PimArchivesChange et) {
        return (!ObjectUtils.isEmpty(et.getPimarchiveschangeid()))&&(!Objects.isNull(this.getById(et.getPimarchiveschangeid())));
    }
    @Override
    @Transactional
    public PimArchivesChange updatePersonFile(PimArchivesChange et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimArchivesChange et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimArchivesChange et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimArchivesChange> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimArchivesChange> list) {
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
    public List<PimArchivesChange> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimArchivesChange>().eq("ormorgid",orgid));
    }

	@Override
    public List<PimArchivesChange> selectByOrmorgid2(String orgid) {
        return baseMapper.selectByOrmorgid2(orgid);
    }

    @Override
    public void removeByOrmorgid2(String orgid) {
        this.remove(new QueryWrapper<PimArchivesChange>().eq("ormorgid2",orgid));
    }

	@Override
    public List<PimArchivesChange> selectByPimarchivesid(String pimarchivesid) {
        return baseMapper.selectByPimarchivesid(pimarchivesid);
    }

    @Override
    public void removeByPimarchivesid(String pimarchivesid) {
        this.remove(new QueryWrapper<PimArchivesChange>().eq("pimarchivesid",pimarchivesid));
    }

	@Override
    public List<PimArchivesChange> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimArchivesChange>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 档案调出记录
     */
    @Override
    public Page<PimArchivesChange> searchDADCJL(PimArchivesChangeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchivesChange> pages=baseMapper.searchDADCJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchivesChange>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimArchivesChange> searchDefault(PimArchivesChangeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchivesChange> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchivesChange>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimArchivesChange et){
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
    public List<PimArchivesChange> getPimarchiveschangeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimArchivesChange> getPimarchiveschangeByEntities(List<PimArchivesChange> entities) {
        List ids =new ArrayList();
        for(PimArchivesChange entity : entities){
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



