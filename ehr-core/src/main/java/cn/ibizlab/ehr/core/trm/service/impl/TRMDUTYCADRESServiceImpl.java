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
import cn.ibizlab.ehr.core.trm.domain.TRMDUTYCADRES;
import cn.ibizlab.ehr.core.trm.filter.TRMDUTYCADRESSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMDUTYCADRESService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMDUTYCADRESMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[优秀年轻干部梯队] 服务对象接口实现
 */
@Slf4j
@Service("TRMDUTYCADRESServiceImpl")
public class TRMDUTYCADRESServiceImpl extends ServiceImpl<TRMDUTYCADRESMapper, TRMDUTYCADRES> implements ITRMDUTYCADRESService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMRANKService ormrankService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITRMDUTYCADRESSetNQGBXXLogic setnqgbxxLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITRMDUTYCADRESUpdateSateteSXLogic updatesatetesxLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITRMDUTYCADRESUpdateStateXXLogic updatestatexxLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TRMDUTYCADRES et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMDUTYCADRES et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMDUTYCADRES> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMDUTYCADRES> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMDUTYCADRES setNQGBXX(TRMDUTYCADRES et) {
        setnqgbxxLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public TRMDUTYCADRES sX(TRMDUTYCADRES et) {
        updatesatetesxLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean create(TRMDUTYCADRES et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmdutycadresid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMDUTYCADRES> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public TRMDUTYCADRES getDraft(TRMDUTYCADRES et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TRMDUTYCADRES et) {
        return (!ObjectUtils.isEmpty(et.getTrmdutycadresid()))&&(!Objects.isNull(this.getById(et.getTrmdutycadresid())));
    }

    @Override
    @Transactional
    public TRMDUTYCADRES xX(TRMDUTYCADRES et) {
        updatestatexxLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public TRMDUTYCADRES get(String key) {
        TRMDUTYCADRES et = getById(key);
        if(et==null){
            et=new TRMDUTYCADRES();
            et.setTrmdutycadresid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TRMDUTYCADRES et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmdutycadresid",et.getTrmdutycadresid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmdutycadresid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMDUTYCADRES> list) {
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
    public List<TRMDUTYCADRES> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<TRMDUTYCADRES>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<TRMDUTYCADRES> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<TRMDUTYCADRES>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<TRMDUTYCADRES> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMDUTYCADRES>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMDUTYCADRES> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<TRMDUTYCADRES>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<TRMDUTYCADRES> selectByOrmrankid(String ormrankid) {
        return baseMapper.selectByOrmrankid(ormrankid);
    }

    @Override
    public void removeByOrmrankid(String ormrankid) {
        this.remove(new QueryWrapper<TRMDUTYCADRES>().eq("ormrankid",ormrankid));
    }

	@Override
    public List<TRMDUTYCADRES> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMDUTYCADRES>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TRMDUTYCADRES> selectByPimpersonid2(String pimpersonid) {
        return baseMapper.selectByPimpersonid2(pimpersonid);
    }

    @Override
    public void removeByPimpersonid2(String pimpersonid) {
        this.remove(new QueryWrapper<TRMDUTYCADRES>().eq("pimpersonid2",pimpersonid));
    }


    /**
     * 查询集合 数据范围选择
     */
    @Override
    public Page<TRMDUTYCADRES> searchCurCXFW(TRMDUTYCADRESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMDUTYCADRES> pages=baseMapper.searchCurCXFW(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMDUTYCADRES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMDUTYCADRES> searchDefault(TRMDUTYCADRESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMDUTYCADRES> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMDUTYCADRES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMDUTYCADRES et){
        //实体关系[DER1N_TRMDUTYCADRES_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_TRMDUTYCADRES_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_TRMDUTYCADRES_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_TRMDUTYCADRES_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_TRMDUTYCADRES_ORMRANK_ORMRANKID]
        if(!ObjectUtils.isEmpty(et.getOrmrankid())){
            cn.ibizlab.ehr.core.orm.domain.ORMRANK ormrank=et.getOrmrank();
            if(ObjectUtils.isEmpty(ormrank)){
                cn.ibizlab.ehr.core.orm.domain.ORMRANK majorEntity=ormrankService.get(et.getOrmrankid());
                et.setOrmrank(majorEntity);
                ormrank=majorEntity;
            }
            et.setOrmrankname(ormrank.getOrmrankname());
        }
        //实体关系[DER1N_TRMDUTYCADRES_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_TRMDUTYCADRES_PIMPERSON_PIMPERSONID2]
        if(!ObjectUtils.isEmpty(et.getPimpersonid2())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson2=et.getPimperson2();
            if(ObjectUtils.isEmpty(pimperson2)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid2());
                et.setPimperson2(majorEntity);
                pimperson2=majorEntity;
            }
            et.setOrmorgsectorname2(pimperson2.getOrmorgsectorname());
            et.setRank(pimperson2.getRank());
            et.setZwrq(pimperson2.getZwrq());
            et.setOrmorgname2(pimperson2.getOrmorgname());
            et.setPimpersonname2(pimperson2.getPimpersonname());
            et.setGw(pimperson2.getGw());
            et.setZw(pimperson2.getZw());
            et.setYgbh(pimperson2.getYgbh());
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
    public List<TRMDUTYCADRES> getTrmdutycadresByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMDUTYCADRES> getTrmdutycadresByEntities(List<TRMDUTYCADRES> entities) {
        List ids =new ArrayList();
        for(TRMDUTYCADRES entity : entities){
            Serializable id=entity.getTrmdutycadresid();
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


