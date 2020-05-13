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
import cn.ibizlab.ehr.core.trm.domain.TRMGRADECADRES;
import cn.ibizlab.ehr.core.trm.filter.TRMGRADECADRESSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMGRADECADRESService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMGRADECADRESMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[优秀青年干部推荐] 服务对象接口实现
 */
@Slf4j
@Service("TRMGRADECADRESServiceImpl")
public class TRMGRADECADRESServiceImpl extends ServiceImpl<TRMGRADECADRESMapper, TRMGRADECADRES> implements ITRMGRADECADRESService {

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
    private cn.ibizlab.ehr.core.orm.service.IORMRANKService ormrankService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(TRMGRADECADRES et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmgradecadresid",et.getTrmgradecadresid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmgradecadresid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMGRADECADRES> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMGRADECADRES et) {
        return (!ObjectUtils.isEmpty(et.getTrmgradecadresid()))&&(!Objects.isNull(this.getById(et.getTrmgradecadresid())));
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
    public boolean create(TRMGRADECADRES et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmgradecadresid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMGRADECADRES> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public TRMGRADECADRES getDraft(TRMGRADECADRES et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(TRMGRADECADRES et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMGRADECADRES et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMGRADECADRES> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMGRADECADRES get(String key) {
        TRMGRADECADRES et = getById(key);
        if(et==null){
            et=new TRMGRADECADRES();
            et.setTrmgradecadresid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<TRMGRADECADRES> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<TRMGRADECADRES> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<TRMGRADECADRES> selectByOrmorgsectorid2(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid2(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid2(String orgsectorid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("ormorgsectorid2",orgsectorid));
    }

	@Override
    public List<TRMGRADECADRES> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMGRADECADRES> selectByOrmorgid2(String orgid) {
        return baseMapper.selectByOrmorgid2(orgid);
    }

    @Override
    public void removeByOrmorgid2(String orgid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("ormorgid2",orgid));
    }

	@Override
    public List<TRMGRADECADRES> selectByOrmrankid(String ormrankid) {
        return baseMapper.selectByOrmrankid(ormrankid);
    }

    @Override
    public void removeByOrmrankid(String ormrankid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("ormrankid",ormrankid));
    }

	@Override
    public List<TRMGRADECADRES> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<TRMGRADECADRES> selectByPimpersonid2(String pimpersonid) {
        return baseMapper.selectByPimpersonid2(pimpersonid);
    }

    @Override
    public void removeByPimpersonid2(String pimpersonid) {
        this.remove(new QueryWrapper<TRMGRADECADRES>().eq("pimpersonid2",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMGRADECADRES> searchDefault(TRMGRADECADRESSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMGRADECADRES> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMGRADECADRES>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMGRADECADRES et){
        //实体关系[DER1N_TRMGRADECADRES_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_TRMGRADECADRES_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_TRMGRADECADRES_ORMORGSECTOR_ORMORGSECTORID2]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid2())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector2=et.getOrmorgsector2();
            if(ObjectUtils.isEmpty(ormorgsector2)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid2());
                et.setOrmorgsector2(majorEntity);
                ormorgsector2=majorEntity;
            }
            et.setOrmorgsectorname2(ormorgsector2.getOrgsectorname());
        }
        //实体关系[DER1N_TRMGRADECADRES_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMGRADECADRES_ORMORG_ORMORGID2]
        if(!ObjectUtils.isEmpty(et.getOrmorgid2())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg2=et.getOrmorg2();
            if(ObjectUtils.isEmpty(ormorg2)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid2());
                et.setOrmorg2(majorEntity);
                ormorg2=majorEntity;
            }
            et.setOrmorgname2(ormorg2.getOrgname());
        }
        //实体关系[DER1N_TRMGRADECADRES_ORMRANK_ORMRANKID]
        if(!ObjectUtils.isEmpty(et.getOrmrankid())){
            cn.ibizlab.ehr.core.orm.domain.ORMRANK ormrank=et.getOrmrank();
            if(ObjectUtils.isEmpty(ormrank)){
                cn.ibizlab.ehr.core.orm.domain.ORMRANK majorEntity=ormrankService.get(et.getOrmrankid());
                et.setOrmrank(majorEntity);
                ormrank=majorEntity;
            }
            et.setOrmrankname(ormrank.getOrmrankname());
        }
        //实体关系[DER1N_TRMGRADECADRES_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_TRMGRADECADRES_PIMPERSON_PIMPERSONID2]
        if(!ObjectUtils.isEmpty(et.getPimpersonid2())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson2=et.getPimperson2();
            if(ObjectUtils.isEmpty(pimperson2)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid2());
                et.setPimperson2(majorEntity);
                pimperson2=majorEntity;
            }
            et.setPimpersonname2(pimperson2.getPimpersonname());
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


