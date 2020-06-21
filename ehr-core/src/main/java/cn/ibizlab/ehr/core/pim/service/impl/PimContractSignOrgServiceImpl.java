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
import cn.ibizlab.ehr.core.pim.domain.PimContractSignOrg;
import cn.ibizlab.ehr.core.pim.filter.PimContractSignOrgSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimContractSignOrgService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimContractSignOrgMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[签约主体单位] 服务对象接口实现
 */
@Slf4j
@Service("PimContractSignOrgServiceImpl")
public class PimContractSignOrgServiceImpl extends ServiceImpl<PimContractSignOrgMapper, PimContractSignOrg> implements IPimContractSignOrgService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimContractService pimcontractService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmSignOrgService ormsignorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PimContractSignOrg get(String key) {
        PimContractSignOrg et = getById(key);
        if(et==null){
            et=new PimContractSignOrg();
            et.setContractsignorgid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PimContractSignOrg et) {
        return (!ObjectUtils.isEmpty(et.getContractsignorgid()))&&(!Objects.isNull(this.getById(et.getContractsignorgid())));
    }
    @Override
    @Transactional
    public boolean update(PimContractSignOrg et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("contractsignorgid",et.getContractsignorgid())))
            return false;
        CachedBeanCopier.copy(get(et.getContractsignorgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimContractSignOrg> list) {
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
    public boolean create(PimContractSignOrg et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getContractsignorgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimContractSignOrg> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PimContractSignOrg getDraft(PimContractSignOrg et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimContractSignOrg et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimContractSignOrg et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimContractSignOrg> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimContractSignOrg> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PimContractSignOrg> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PimContractSignOrg>().eq("ormorgid",orgid));
    }

	@Override
    public List<PimContractSignOrg> selectByOrmsignorgid(String ormsignorgid) {
        return baseMapper.selectByOrmsignorgid(ormsignorgid);
    }

    @Override
    public void removeByOrmsignorgid(String ormsignorgid) {
        this.remove(new QueryWrapper<PimContractSignOrg>().eq("ormsignorgid",ormsignorgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimContractSignOrg> searchDefault(PimContractSignOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContractSignOrg> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContractSignOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT2
     */
    @Override
    public Page<PimContractSignOrg> searchDefault2(PimContractSignOrgSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimContractSignOrg> pages=baseMapper.searchDefault2(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimContractSignOrg>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimContractSignOrg et){
        //实体关系[DER1N_CONTRACTSIGNORG_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_CONTRACTSIGNORG_ORMSIGNORG_ORMSIGNORGID]
        if(!ObjectUtils.isEmpty(et.getOrmsignorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmSignOrg ormsignorg=et.getOrmsignorg();
            if(ObjectUtils.isEmpty(ormsignorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmSignOrg majorEntity=ormsignorgService.get(et.getOrmsignorgid());
                et.setOrmsignorg(majorEntity);
                ormsignorg=majorEntity;
            }
            et.setOrmsignorgname(ormsignorg.getOrmsignorgname());
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
    public List<PimContractSignOrg> getPimcontractsignorgByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimContractSignOrg> getPimcontractsignorgByEntities(List<PimContractSignOrg> entities) {
        List ids =new ArrayList();
        for(PimContractSignOrg entity : entities){
            Serializable id=entity.getContractsignorgid();
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



