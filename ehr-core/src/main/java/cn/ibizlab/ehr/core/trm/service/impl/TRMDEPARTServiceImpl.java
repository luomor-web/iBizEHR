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
import cn.ibizlab.ehr.core.trm.domain.TRMDEPART;
import cn.ibizlab.ehr.core.trm.filter.TRMDEPARTSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMDEPARTService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMDEPARTMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训需求通知] 服务对象接口实现
 */
@Slf4j
@Service("TRMDEPARTServiceImpl")
public class TRMDEPARTServiceImpl extends ServiceImpl<TRMDEPARTMapper, TRMDEPART> implements ITRMDEPARTService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEMDEFTIONService trmdemdeftionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService trmtrainfillinService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public TRMDEPART get(String key) {
        TRMDEPART et = getById(key);
        if(et==null){
            et=new TRMDEPART();
            et.setTrmdepartid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(TRMDEPART et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMDEPART et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMDEPART> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMDEPART> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TRMDEPART et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmdepartid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMDEPART> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public boolean checkKey(TRMDEPART et) {
        return (!ObjectUtils.isEmpty(et.getTrmdepartid()))&&(!Objects.isNull(this.getById(et.getTrmdepartid())));
    }

    @Override
    @Transactional
    public boolean update(TRMDEPART et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmdepartid",et.getTrmdepartid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmdepartid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMDEPART> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public TRMDEPART getDraft(TRMDEPART et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<TRMDEPART> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<TRMDEPART>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<TRMDEPART> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMDEPART>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMDEPART> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMDEPART>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMDEPART> searchDefault(TRMDEPARTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMDEPART> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMDEPART>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMDEPART et){
        //实体关系[DER1N_TRMDEPART_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
            et.setShortname(ormorgsector.getShortname());
        }
        //实体关系[DER1N_TRMDEPART_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMDEPART_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
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
    public List<TRMDEPART> getTrmdepartByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMDEPART> getTrmdepartByEntities(List<TRMDEPART> entities) {
        List ids =new ArrayList();
        for(TRMDEPART entity : entities){
            Serializable id=entity.getTrmdepartid();
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


