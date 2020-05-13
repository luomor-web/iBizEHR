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
import cn.ibizlab.ehr.core.trm.domain.TRMDEMDEFTION;
import cn.ibizlab.ehr.core.trm.filter.TRMDEMDEFTIONSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMDEMDEFTIONService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMDEMDEFTIONMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训需求汇总] 服务对象接口实现
 */
@Slf4j
@Service("TRMDEMDEFTIONServiceImpl")
public class TRMDEMDEFTIONServiceImpl extends ServiceImpl<TRMDEMDEFTIONMapper, TRMDEMDEFTION> implements ITRMDEMDEFTIONService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANService trmtrainplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMDEPARTService trmdepartService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService trmtrainfillinService;

    private int batchSize = 500;

    @Override
    public TRMDEMDEFTION getDraft(TRMDEMDEFTION et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(TRMDEMDEFTION et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmdemdeftionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMDEMDEFTION> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TRMDEMDEFTION et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmdemdeftionid",et.getTrmdemdeftionid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmdemdeftionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMDEMDEFTION> list) {
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
    public boolean save(TRMDEMDEFTION et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMDEMDEFTION et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMDEMDEFTION> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMDEMDEFTION et) {
        return (!ObjectUtils.isEmpty(et.getTrmdemdeftionid()))&&(!Objects.isNull(this.getById(et.getTrmdemdeftionid())));
    }

    @Override
    @Transactional
    public TRMDEMDEFTION get(String key) {
        TRMDEMDEFTION et = getById(key);
        if(et==null){
            et=new TRMDEMDEFTION();
            et.setTrmdemdeftionid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<TRMDEMDEFTION> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMDEMDEFTION>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMDEMDEFTION> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMDEMDEFTION>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TRMDEMDEFTION> selectByTrmdepartid(String trmdepartid) {
        return baseMapper.selectByTrmdepartid(trmdepartid);
    }

    @Override
    public void removeByTrmdepartid(String trmdepartid) {
        this.remove(new QueryWrapper<TRMDEMDEFTION>().eq("trmdepartid",trmdepartid));
    }

	@Override
    public List<TRMDEMDEFTION> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TRMDEMDEFTION>().eq("trmtraincourseid",trmtraincourseid));
    }

	@Override
    public List<TRMDEMDEFTION> selectByTrmtrainfillinid(String trmtrainfillinid) {
        return baseMapper.selectByTrmtrainfillinid(trmtrainfillinid);
    }

    @Override
    public void removeByTrmtrainfillinid(String trmtrainfillinid) {
        this.remove(new QueryWrapper<TRMDEMDEFTION>().eq("trmtrainfillinid",trmtrainfillinid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMDEMDEFTION> searchDefault(TRMDEMDEFTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMDEMDEFTION> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMDEMDEFTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMDEMDEFTION et){
        //实体关系[DER1N_TRMDEMDEFTION_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMDEMDEFTION_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_TRMDEMDEFTION_TRMDEPART_TRMDEPARTID]
        if(!ObjectUtils.isEmpty(et.getTrmdepartid())){
            cn.ibizlab.ehr.core.trm.domain.TRMDEPART trmdepart=et.getTrmdepart();
            if(ObjectUtils.isEmpty(trmdepart)){
                cn.ibizlab.ehr.core.trm.domain.TRMDEPART majorEntity=trmdepartService.get(et.getTrmdepartid());
                et.setTrmdepart(majorEntity);
                trmdepart=majorEntity;
            }
            et.setTrmdepartname(trmdepart.getTrmdepartname());
        }
        //实体关系[DER1N_TRMDEMDEFTION_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
        }
        //实体关系[DER1N_TRMDEMDEFTION_TRMTRAINFILLIN_TRMTRAINFILLINID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainfillinid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN trmtrainfillin=et.getTrmtrainfillin();
            if(ObjectUtils.isEmpty(trmtrainfillin)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN majorEntity=trmtrainfillinService.get(et.getTrmtrainfillinid());
                et.setTrmtrainfillin(majorEntity);
                trmtrainfillin=majorEntity;
            }
            et.setTrmtrainfillinname(trmtrainfillin.getTrmtrainfillinname());
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


