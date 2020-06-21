package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmXmrypzxq;
import cn.ibizlab.ehr.core.orm.filter.OrmXmrypzxqSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmXmrypzxqService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmXmrypzxqMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目人员需求] 服务对象接口实现
 */
@Slf4j
@Service("OrmXmrypzxqServiceImpl")
public class OrmXmrypzxqServiceImpl extends ServiceImpl<OrmXmrypzxqMapper, OrmXmrypzxq> implements IOrmXmrypzxqService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmXmxqjhService ormxmxqjhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    public OrmXmrypzxq getDraft(OrmXmrypzxq et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq synTJ(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq mODSPTG(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(OrmXmrypzxq et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmrypzxqid()))&&(!Objects.isNull(this.getById(et.getOrmxmrypzxqid())));
    }
    @Override
    @Transactional
    public OrmXmrypzxq sFBH(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq ensure(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq get(String key) {
        OrmXmrypzxq et = getById(key);
        if(et==null){
            et=new OrmXmrypzxq();
            et.setOrmxmrypzxqid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq synDeployInfo(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq mODBH(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq sFQR(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq synPersonInfo(OrmXmrypzxq et) {
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
    public OrmXmrypzxq synRelease(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq sHTG(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq tPSPTG(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq bH(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(OrmXmrypzxq et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmXmrypzxq et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmXmrypzxq> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmXmrypzxq> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmXmrypzxq sFSPTG(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq tPBH(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public OrmXmrypzxq tPQR(OrmXmrypzxq et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(OrmXmrypzxq et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmrypzxqid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmXmrypzxq> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(OrmXmrypzxq et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmrypzxqid",et.getOrmxmrypzxqid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmrypzxqid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmXmrypzxq> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<OrmXmrypzxq> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<OrmXmrypzxq>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<OrmXmrypzxq> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<OrmXmrypzxq>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<OrmXmrypzxq> selectByOrmxmxqjhid(String ormxmxqjhid) {
        return baseMapper.selectByOrmxmxqjhid(ormxmxqjhid);
    }

    @Override
    public void removeByOrmxmxqjhid(String ormxmxqjhid) {
        this.remove(new QueryWrapper<OrmXmrypzxq>().eq("ormxmxqjhid",ormxmxqjhid));
    }

	@Override
    public List<OrmXmrypzxq> selectByModpimpersonid(String pimpersonid) {
        return baseMapper.selectByModpimpersonid(pimpersonid);
    }

    @Override
    public void removeByModpimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<OrmXmrypzxq>().eq("modpimpersonid",pimpersonid));
    }

	@Override
    public List<OrmXmrypzxq> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<OrmXmrypzxq>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<OrmXmrypzxq> selectByRealpersonid(String pimpersonid) {
        return baseMapper.selectByRealpersonid(pimpersonid);
    }

    @Override
    public void removeByRealpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<OrmXmrypzxq>().eq("realperosnid",pimpersonid));
    }


    /**
     * 查询集合 人事审核
     */
    @Override
    public Page<OrmXmrypzxq> searchRSSH(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchRSSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 判定调配
     */
    @Override
    public Page<OrmXmrypzxq> searchCURFQTP(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchCURFQTP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询调配数据
     */
    @Override
    public Page<OrmXmrypzxq> searchCXSJ(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchCXSJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 控制项目人员需求（修改、删除）权限
     */
    @Override
    public Page<OrmXmrypzxq> searchKZXMQX(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchKZXMQX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 释放台账
     */
    @Override
    public Page<OrmXmrypzxq> searchSFSH(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchSFSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 判定释放
     */
    @Override
    public Page<OrmXmrypzxq> searchCURFQSF(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchCURFQSF(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 调配审核
     */
    @Override
    public Page<OrmXmrypzxq> searchTPSH(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchTPSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 释放数据查询
     */
    @Override
    public Page<OrmXmrypzxq> searchSFCXSJ(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchSFCXSJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 拟用人员变更审核
     */
    @Override
    public Page<OrmXmrypzxq> searchMODSPSH(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchMODSPSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmXmrypzxq> searchDefault(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人力成本明细
     */
    @Override
    public Page<OrmXmrypzxq> searchXMCBMX(OrmXmrypzxqSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmXmrypzxq> pages=baseMapper.searchXMCBMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmXmrypzxq>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmXmrypzxq et){
        //实体关系[DER1N_ORMXMRYPZXQ_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
            et.setXmmc(ormorgsector.getGcmcjbm());
        }
        //实体关系[DER1N_ORMXMRYPZXQ_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.OrmPost majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
            et.setIskeypostion(ormpost.getIskeypostion());
        }
        //实体关系[DER1N_ORMXMRYPZXQ_ORMXMXQJH_ORMXMXQJHID]
        if(!ObjectUtils.isEmpty(et.getOrmxmxqjhid())){
            cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh ormxmxqjh=et.getOrmxmxqjh();
            if(ObjectUtils.isEmpty(ormxmxqjh)){
                cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh majorEntity=ormxmxqjhService.get(et.getOrmxmxqjhid());
                et.setOrmxmxqjh(majorEntity);
                ormxmxqjh=majorEntity;
            }
            et.setOrgshortname(ormxmxqjh.getOrgshortname());
            et.setGcmcjbm(ormxmxqjh.getGcmcjbm());
            et.setOrginfoid(ormxmxqjh.getOrginfoid());
            et.setXmbmc(ormxmxqjh.getXmbmc());
            et.setOrgsecinfoid(ormxmxqjh.getOrgsecinfoid());
        }
        //实体关系[DER1N_ORMXMRYPZXQ_PIMPERSON_MODPIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getModpimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson modpimperson=et.getModpimperson();
            if(ObjectUtils.isEmpty(modpimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getModpimpersonid());
                et.setModpimperson(majorEntity);
                modpimperson=majorEntity;
            }
            et.setModpersonname(modpimperson.getPimpersonname());
        }
        //实体关系[DER1N_ORMXMRYPZXQ_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setCertificateability(pimperson.getCerttificate());
            et.setAge(pimperson.getNj());
            et.setSex(pimperson.getXb());
            et.setCurpost(pimperson.getGw());
            et.setPersonnum(pimperson.getYgbh());
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_ORMXMRYPZXQ_PIMPERSON_REALPEROSNID]
        if(!ObjectUtils.isEmpty(et.getRealpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson realperson=et.getRealperson();
            if(ObjectUtils.isEmpty(realperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getRealpersonid());
                et.setRealperson(majorEntity);
                realperson=majorEntity;
            }
            et.setRealpersonname(realperson.getPimpersonname());
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
    public List<OrmXmrypzxq> getOrmxmrypzxqByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmXmrypzxq> getOrmxmrypzxqByEntities(List<OrmXmrypzxq> entities) {
        List ids =new ArrayList();
        for(OrmXmrypzxq entity : entities){
            Serializable id=entity.getOrmxmrypzxqid();
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



