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
import cn.ibizlab.ehr.core.orm.domain.ORMXMRYPZXQ;
import cn.ibizlab.ehr.core.orm.filter.ORMXMRYPZXQSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMXMRYPZXQService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMXMRYPZXQMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目人员需求] 服务对象接口实现
 */
@Slf4j
@Service("ORMXMRYPZXQServiceImpl")
public class ORMXMRYPZXQServiceImpl extends ServiceImpl<ORMXMRYPZXQMapper, ORMXMRYPZXQ> implements IORMXMRYPZXQService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMXMXQJHService ormxmxqjhService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    public ORMXMRYPZXQ getDraft(ORMXMRYPZXQ et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ synTJ(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ mODSPTG(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(ORMXMRYPZXQ et) {
        return (!ObjectUtils.isEmpty(et.getOrmxmrypzxqid()))&&(!Objects.isNull(this.getById(et.getOrmxmrypzxqid())));
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ sFBH(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ ensure(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ get(String key) {
        ORMXMRYPZXQ et = getById(key);
        if(et==null){
            et=new ORMXMRYPZXQ();
            et.setOrmxmrypzxqid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ synDeployInfo(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ mODBH(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ sFQR(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ synPersonInfo(ORMXMRYPZXQ et) {
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
    public ORMXMRYPZXQ synRelease(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ sHTG(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ tPSPTG(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ bH(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(ORMXMRYPZXQ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMXMRYPZXQ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ORMXMRYPZXQ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ORMXMRYPZXQ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ sFSPTG(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ tPBH(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ORMXMRYPZXQ tPQR(ORMXMRYPZXQ et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(ORMXMRYPZXQ et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmrypzxqid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMXMRYPZXQ> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(ORMXMRYPZXQ et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormxmrypzxqid",et.getOrmxmrypzxqid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmxmrypzxqid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMXMRYPZXQ> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<ORMXMRYPZXQ> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<ORMXMRYPZXQ>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<ORMXMRYPZXQ> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<ORMXMRYPZXQ>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<ORMXMRYPZXQ> selectByOrmxmxqjhid(String ormxmxqjhid) {
        return baseMapper.selectByOrmxmxqjhid(ormxmxqjhid);
    }

    @Override
    public void removeByOrmxmxqjhid(String ormxmxqjhid) {
        this.remove(new QueryWrapper<ORMXMRYPZXQ>().eq("ormxmxqjhid",ormxmxqjhid));
    }

	@Override
    public List<ORMXMRYPZXQ> selectByModpimpersonid(String pimpersonid) {
        return baseMapper.selectByModpimpersonid(pimpersonid);
    }

    @Override
    public void removeByModpimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ORMXMRYPZXQ>().eq("modpimpersonid",pimpersonid));
    }

	@Override
    public List<ORMXMRYPZXQ> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ORMXMRYPZXQ>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<ORMXMRYPZXQ> selectByRealpersonid(String pimpersonid) {
        return baseMapper.selectByRealpersonid(pimpersonid);
    }

    @Override
    public void removeByRealpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<ORMXMRYPZXQ>().eq("realperosnid",pimpersonid));
    }


    /**
     * 查询集合 人事审核
     */
    @Override
    public Page<ORMXMRYPZXQ> searchRSSH(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchRSSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 判定调配
     */
    @Override
    public Page<ORMXMRYPZXQ> searchCURFQTP(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchCURFQTP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 查询调配数据
     */
    @Override
    public Page<ORMXMRYPZXQ> searchCXSJ(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchCXSJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 控制项目人员需求（修改、删除）权限
     */
    @Override
    public Page<ORMXMRYPZXQ> searchKZXMQX(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchKZXMQX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 释放台账
     */
    @Override
    public Page<ORMXMRYPZXQ> searchSFSH(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchSFSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 判定释放
     */
    @Override
    public Page<ORMXMRYPZXQ> searchCURFQSF(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchCURFQSF(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 调配审核
     */
    @Override
    public Page<ORMXMRYPZXQ> searchTPSH(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchTPSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 释放数据查询
     */
    @Override
    public Page<ORMXMRYPZXQ> searchSFCXSJ(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchSFCXSJ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 拟用人员变更审核
     */
    @Override
    public Page<ORMXMRYPZXQ> searchMODSPSH(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchMODSPSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMXMRYPZXQ> searchDefault(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 项目人力成本明细
     */
    @Override
    public Page<ORMXMRYPZXQ> searchXMCBMX(ORMXMRYPZXQSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMXMRYPZXQ> pages=baseMapper.searchXMCBMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMXMRYPZXQ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMXMRYPZXQ et){
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
            cn.ibizlab.ehr.core.orm.domain.ORMXMXQJH ormxmxqjh=et.getOrmxmxqjh();
            if(ObjectUtils.isEmpty(ormxmxqjh)){
                cn.ibizlab.ehr.core.orm.domain.ORMXMXQJH majorEntity=ormxmxqjhService.get(et.getOrmxmxqjhid());
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
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON modpimperson=et.getModpimperson();
            if(ObjectUtils.isEmpty(modpimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getModpimpersonid());
                et.setModpimperson(majorEntity);
                modpimperson=majorEntity;
            }
            et.setModpersonname(modpimperson.getPimpersonname());
        }
        //实体关系[DER1N_ORMXMRYPZXQ_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON realperson=et.getRealperson();
            if(ObjectUtils.isEmpty(realperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getRealpersonid());
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
    public List<ORMXMRYPZXQ> getOrmxmrypzxqByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<ORMXMRYPZXQ> getOrmxmrypzxqByEntities(List<ORMXMRYPZXQ> entities) {
        List ids =new ArrayList();
        for(ORMXMRYPZXQ entity : entities){
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


