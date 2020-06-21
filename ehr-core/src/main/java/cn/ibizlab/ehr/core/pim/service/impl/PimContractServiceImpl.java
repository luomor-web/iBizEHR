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
import cn.ibizlab.ehr.core.pim.domain.PimContract;
import cn.ibizlab.ehr.core.pim.filter.PimContractSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimContractService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimContractMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[合同信息] 服务对象接口实现
 */
@Slf4j
@Service("PimContractServiceImpl")
public class PimContractServiceImpl extends ServiceImpl<PimContractMapper, PimContract> implements IPimContractService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractSignOrgService pimcontractsignorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmSignOrgService ormsignorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimLabourcampanyService pimlabourcampanyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPimContractCalContractTimeLogic calcontracttimeLogic;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PimContract et) {
        return (!ObjectUtils.isEmpty(et.getPimcontractid()))&&(!Objects.isNull(this.getById(et.getPimcontractid())));
    }
    @Override
    @Transactional
    public PimContract calContractTime(PimContract et) {
        //自定义代码
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
    public PimContract get(String key) {
        PimContract et = getById(key);
        if(et==null){
            et=new PimContract();
            et.setPimcontractid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PimContract et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimcontractid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimContract> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PimContract et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimContract et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimContract> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimContract> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimContract stopContract(PimContract et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimContract et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimcontractid",et.getPimcontractid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimcontractid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimContract> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PimContract getDraft(PimContract et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PimContract> selectByContractsignorgid(String contractsignorgid) {
        return baseMapper.selectByContractsignorgid(contractsignorgid);
    }

    @Override
    public void removeByContractsignorgid(String contractsignorgid) {
        this.remove(new QueryWrapper<PimContract>().eq("contractsignorgid",contractsignorgid));
    }

	@Override
    public List<PimContract> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimContract>().eq("ormorgid",orgid));
    }

	@Override
    public List<PimContract> selectByOrmsignorgid(String ormsignorgid) {
        return baseMapper.selectByOrmsignorgid(ormsignorgid);
    }

    @Override
    public void removeByOrmsignorgid(String ormsignorgid) {
        this.remove(new QueryWrapper<PimContract>().eq("ormsignorgid",ormsignorgid));
    }

	@Override
    public List<PimContract> selectByPimlabourcampanyid(String pimlabourcampanyid) {
        return baseMapper.selectByPimlabourcampanyid(pimlabourcampanyid);
    }

    @Override
    public void removeByPimlabourcampanyid(String pimlabourcampanyid) {
        this.remove(new QueryWrapper<PimContract>().eq("pimlabourcampanyid",pimlabourcampanyid));
    }

	@Override
    public List<PimContract> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimContract>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 人事提醒
     */
    @Override
    public Page<PimContract> searchRSTXDS(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchRSTXDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属和人员ID不符的
     */
    @Override
    public Page<PimContract> searchJLSS(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 按组织树过滤
     */
    @Override
    public Page<PimContract> searchOrderByOrg(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchOrderByOrg(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待终止合同
     */
    @Override
    public Page<PimContract> searchStopContracts(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchStopContracts(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待签订合同
     */
    @Override
    public Page<PimContract> searchSignContracts(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchSignContracts(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimContract> searchDefault(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 协议合同
     */
    @Override
    public Page<PimContract> searchXYHT(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchXYHT(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(合同信息)
     */
    @Override
    public Page<PimContract> searchZIZHU(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 劳动合同
     */
    @Override
    public Page<PimContract> searchLDHT(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchLDHT(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 劳务合同
     */
    @Override
    public Page<PimContract> searchLWHT(PimContractSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContract> pages=baseMapper.searchLWHT(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContract>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimContract et){
        //实体关系[DER1N_PIMCONTRACT_CONTRACTSIGNORG_CONTRACTSIGNORGID]
        if(!ObjectUtils.isEmpty(et.getContractsignorgid())){
            cn.ibizlab.ehr.core.pim.domain.PimContractSignOrg contractsignorg=et.getContractsignorg();
            if(ObjectUtils.isEmpty(contractsignorg)){
                cn.ibizlab.ehr.core.pim.domain.PimContractSignOrg majorEntity=pimcontractsignorgService.get(et.getContractsignorgid());
                et.setContractsignorg(majorEntity);
                contractsignorg=majorEntity;
            }
            et.setContractsignorgname(contractsignorg.getContractsignorgname());
        }
        //实体关系[DER1N_PIMCONTRACT_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setLevelcode(ormorg.getLevelcode());
            et.setHtzzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PIMCONTRACT_ORMSIGNORG_ORMSIGNORGID]
        if(!ObjectUtils.isEmpty(et.getOrmsignorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmSignOrg ormsignorg=et.getOrmsignorg();
            if(ObjectUtils.isEmpty(ormsignorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmSignOrg majorEntity=ormsignorgService.get(et.getOrmsignorgid());
                et.setOrmsignorg(majorEntity);
                ormsignorg=majorEntity;
            }
            et.setOrmsignorgname(ormsignorg.getOrmsignorgname());
        }
        //实体关系[DER1N_PIMCONTRACT_PIMLABOURCAMPANY_PIMLABOURCAMPANYID]
        if(!ObjectUtils.isEmpty(et.getPimlabourcampanyid())){
            cn.ibizlab.ehr.core.pim.domain.PimLabourcampany pimlabourcampany=et.getPimlabourcampany();
            if(ObjectUtils.isEmpty(pimlabourcampany)){
                cn.ibizlab.ehr.core.pim.domain.PimLabourcampany majorEntity=pimlabourcampanyService.get(et.getPimlabourcampanyid());
                et.setPimlabourcampany(majorEntity);
                pimlabourcampany=majorEntity;
            }
            et.setPimlabourcampanyname(pimlabourcampany.getPimlabourcampanyname());
        }
        //实体关系[DER1N_PIMCONTRACT_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setZgcode(pimperson.getZgcode());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setPersonorgid(pimperson.getOrmorgid());
            et.setZzdzs(pimperson.getZzdzs());
            et.setYgbh(pimperson.getYgbh());
            et.setYgzt(pimperson.getYgzt());
            et.setDbdwsj(pimperson.getDbdwsj());
            et.setPersonorgname(pimperson.getZzdzs());
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
    public List<PimContract> getPimcontractByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimContract> getPimcontractByEntities(List<PimContract> entities) {
        List ids =new ArrayList();
        for(PimContract entity : entities){
            Serializable id=entity.getPimcontractid();
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



