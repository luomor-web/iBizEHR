package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINFILLINSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINFILLINMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训需求填报] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINFILLINServiceImpl")
public class TRMTRAINFILLINServiceImpl extends ServiceImpl<TRMTRAINFILLINMapper, TRMTRAINFILLIN> implements ITRMTRAINFILLINService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEMDEFTIONService trmdemdeftionService;

    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService trmtrainfillinService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEPARTService trmdepartService;

    private int batchSize = 500;

    @Override
    @Transactional
    public TRMTRAINFILLIN get(String key) {
        TRMTRAINFILLIN et = getById(key);
        if(et==null){
            et=new TRMTRAINFILLIN();
            et.setTrmtrainfillinid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TRMTRAINFILLIN et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainfillinid",et.getTrmtrainfillinid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainfillinid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINFILLIN> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMTRAINFILLIN et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainfillinid()))&&(!Objects.isNull(this.getById(et.getTrmtrainfillinid())));
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINFILLIN et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainfillinid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINFILLIN> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TRMTRAINFILLIN et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINFILLIN et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMTRAINFILLIN> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMTRAINFILLIN> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public TRMTRAINFILLIN getDraft(TRMTRAINFILLIN et) {
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
    public List<TRMTRAINFILLIN> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<TRMTRAINFILLIN>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<TRMTRAINFILLIN> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMTRAINFILLIN>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMTRAINFILLIN> selectByTrmdepartid(String trmdepartid) {
        return baseMapper.selectByTrmdepartid(trmdepartid);
    }

    @Override
    public void removeByTrmdepartid(String trmdepartid) {
        this.remove(new QueryWrapper<TRMTRAINFILLIN>().eq("trmdepartid",trmdepartid));
    }

	@Override
    public List<TRMTRAINFILLIN> selectByTrmtrainfillinid2(String trmtrainfillinid) {
        return baseMapper.selectByTrmtrainfillinid2(trmtrainfillinid);
    }

    @Override
    public void removeByTrmtrainfillinid2(String trmtrainfillinid) {
        this.remove(new QueryWrapper<TRMTRAINFILLIN>().eq("trmtrainfillinid2",trmtrainfillinid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINFILLIN> searchDefault(TRMTRAINFILLINSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINFILLIN> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINFILLIN>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINFILLIN et){
        //实体关系[DER1N_TRMTRAINFILLIN_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
            et.setShortname(ormorgsector.getShortname());
        }
        //实体关系[DER1N_TRMTRAINFILLIN_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMTRAINFILLIN_TRMDEPART_TRMDEPARTID]
        if(!ObjectUtils.isEmpty(et.getTrmdepartid())){
            cn.ibizlab.ehr.core.trm.domain.TRMDEPART trmdepart=et.getTrmdepart();
            if(ObjectUtils.isEmpty(trmdepart)){
                cn.ibizlab.ehr.core.trm.domain.TRMDEPART majorEntity=trmdepartService.get(et.getTrmdepartid());
                et.setTrmdepart(majorEntity);
                trmdepart=majorEntity;
            }
            et.setNd(trmdepart.getNd());
            et.setJd(trmdepart.getJd());
            et.setTrmdepartname(trmdepart.getTrmdepartname());
            et.setJzrq(trmdepart.getJzrq());
        }
        //实体关系[DER1N_TRMTRAINFILLIN_TRMTRAINFILLIN_TRMTRAINFILLINID2]
        if(!ObjectUtils.isEmpty(et.getTrmtrainfillinid2())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN trmtrainfillin2=et.getTrmtrainfillin2();
            if(ObjectUtils.isEmpty(trmtrainfillin2)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN majorEntity=trmtrainfillinService.get(et.getTrmtrainfillinid2());
                et.setTrmtrainfillin2(majorEntity);
                trmtrainfillin2=majorEntity;
            }
            et.setTrmtrainfillinname2(trmtrainfillin2.getTrmtrainfillinname());
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
    public List<TRMTRAINFILLIN> getTrmtrainfillinByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMTRAINFILLIN> getTrmtrainfillinByEntities(List<TRMTRAINFILLIN> entities) {
        List ids =new ArrayList();
        for(TRMTRAINFILLIN entity : entities){
            Serializable id=entity.getTrmtrainfillinid();
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


