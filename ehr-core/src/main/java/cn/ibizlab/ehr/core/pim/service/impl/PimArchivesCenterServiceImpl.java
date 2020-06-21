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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesCenter;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesCenterSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesCenterService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimArchivesCenterMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案室管理] 服务对象接口实现
 */
@Slf4j
@Service("PimArchivesCenterServiceImpl")
public class PimArchivesCenterServiceImpl extends ServiceImpl<PimArchivesCenterMapper, PimArchivesCenter> implements IPimArchivesCenterService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PimArchivesCenter et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimArchivesCenter et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimArchivesCenter> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimArchivesCenter> list) {
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
    @Transactional
    public boolean create(PimArchivesCenter et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getArchivescenterid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimArchivesCenter> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PimArchivesCenter et) {
        return (!ObjectUtils.isEmpty(et.getArchivescenterid()))&&(!Objects.isNull(this.getById(et.getArchivescenterid())));
    }
    @Override
    public PimArchivesCenter getDraft(PimArchivesCenter et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimArchivesCenter et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("archivescenterid",et.getArchivescenterid())))
            return false;
        CachedBeanCopier.copy(get(et.getArchivescenterid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimArchivesCenter> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PimArchivesCenter get(String key) {
        PimArchivesCenter et = getById(key);
        if(et==null){
            et=new PimArchivesCenter();
            et.setArchivescenterid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PimArchivesCenter> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimArchivesCenter>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimArchivesCenter> searchDefault(PimArchivesCenterSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchivesCenter> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchivesCenter>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimArchivesCenter et){
        //实体关系[DER1N_ARCHIVESCENTER_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
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
    public List<PimArchivesCenter> getPimarchivescenterByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimArchivesCenter> getPimarchivescenterByEntities(List<PimArchivesCenter> entities) {
        List ids =new ArrayList();
        for(PimArchivesCenter entity : entities){
            Serializable id=entity.getArchivescenterid();
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



