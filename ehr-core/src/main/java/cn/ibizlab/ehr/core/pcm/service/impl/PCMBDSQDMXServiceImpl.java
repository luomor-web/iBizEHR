package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMBDSQDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMBDSQDMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMBDSQDMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职级变动明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMBDSQDMXServiceImpl")
public class PCMBDSQDMXServiceImpl extends ServiceImpl<PCMBDSQDMXMapper, PCMBDSQDMX> implements IPCMBDSQDMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMSgqMgrService pcmsgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.ISGQMgrService sgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDService pcmbdsqdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMBDSQDMXZJJScodelist2Logic zjjscodelist2Logic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMBDSQDMXSetPersonInfoNewLogic setpersoninfonewLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMBDSQDMXSetPersonInfoNew2Logic setpersoninfonew2Logic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMBDSQDMXZJcodelistLogic zjcodelistLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMBDSQDMXSetPersonInfoLogic setpersoninfoLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPCMBDSQDMXZJJScodelist3Logic zjjscodelist3Logic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PCMBDSQDMX zJJSDMB(PCMBDSQDMX et) {
        zjjscodelist2Logic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMBDSQDMX cQBXCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX sXJSDMB(PCMBDSQDMX et) {
        setpersoninfonewLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMBDSQDMX pDZJ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX sXJSDMB2(PCMBDSQDMX et) {
        setpersoninfonew2Logic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean create(PCMBDSQDMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmbdsqdmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMBDSQDMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMBDSQDMX zZSQ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX sXDMB(PCMBDSQDMX et) {
        zjcodelistLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMBDSQDMX dGCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX setPersonInfo(PCMBDSQDMX et) {
        setpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMBDSQDMX gZCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX jPCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMBDSQDMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMBDSQDMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMBDSQDMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMBDSQDMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMBDSQDMX lZCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX nTCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMBDSQDMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmbdsqdmxid",et.getPcmbdsqdmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmbdsqdmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMBDSQDMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMBDSQDMX get(String key) {
        PCMBDSQDMX et = getById(key);
        if(et==null){
            et=new PCMBDSQDMX();
            et.setPcmbdsqdmxid(key);
        }
        else{
        }
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
    public PCMBDSQDMX getDraft(PCMBDSQDMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX sHBTG(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX zJBDCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMBDSQDMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmbdsqdmxid()))&&(!Objects.isNull(this.getById(et.getPcmbdsqdmxid())));
    }

    @Override
    @Transactional
    public PCMBDSQDMX tXCZ(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMBDSQDMX jZJJSDMB(PCMBDSQDMX et) {
        zjjscodelist3Logic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PCMBDSQDMX sHTG(PCMBDSQDMX et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PCMBDSQDMX> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PCMBDSQDMX> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PCMBDSQDMX> selectByOrmorgsectorid2(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid2(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid2(String orgsectorid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("ormorgsectorid2",orgsectorid));
    }

	@Override
    public List<PCMBDSQDMX> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("ormorgid",orgid));
    }

	@Override
    public List<PCMBDSQDMX> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PCMBDSQDMX> selectByPcmbdsqdid(String pcmbdsqdid) {
        return baseMapper.selectByPcmbdsqdid(pcmbdsqdid);
    }

    @Override
    public void removeByPcmbdsqdid(String pcmbdsqdid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("pcmbdsqdid",pcmbdsqdid));
    }

	@Override
    public List<PCMBDSQDMX> selectByLzmtrid(String pimpersonid) {
        return baseMapper.selectByLzmtrid(pimpersonid);
    }

    @Override
    public void removeByLzmtrid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("lzmtrid",pimpersonid));
    }

	@Override
    public List<PCMBDSQDMX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMBDSQDMX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 解聘申请（未审核）
     */
    @Override
    public Page<PCMBDSQDMX> searchJPSQMX(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchJPSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 内退申请明细（未审核）
     */
    @Override
    public Page<PCMBDSQDMX> searchNTSQMX(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchNTSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 内退申请明细（个人）
     */
    @Override
    public Page<PCMBDSQDMX> searchNTSQMXGR(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchNTSQMXGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 退休申请明细（未审核）
     */
    @Override
    public Page<PCMBDSQDMX> searchTXSQMX(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchTXSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职申请明细（未审核）
     */
    @Override
    public Page<PCMBDSQDMX> searchGZSQMX(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchGZSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 职级变动申请明细
     */
    @Override
    public Page<PCMBDSQDMX> searchZJBDSQMX(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchZJBDSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待岗申请明细
     */
    @Override
    public Page<PCMBDSQDMX> searchDGSQMX(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchDGSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 长期病休申请明细
     */
    @Override
    public Page<PCMBDSQDMX> searchCQBXSQMXDS(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchCQBXSQMXDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离职申请明细
     */
    @Override
    public Page<PCMBDSQDMX> searchLZSQMX(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchLZSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离职申请明细（个人）
     */
    @Override
    public Page<PCMBDSQDMX> searchLZSQMXGR(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchLZSQMXGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMBDSQDMX> searchDefault(PCMBDSQDMXSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMBDSQDMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMBDSQDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }


    @Autowired
    private cn.ibizlab.ehr.util.client.IBZWFFeignClient ibzwfFeignClient;

    /**
     * 查询工作流待办
     * @param context
     */
    private void fillWFTaskContext(PCMBDSQDMXSearchContext context){

        if(!StringUtils.isEmpty(context.getUserTaskId()) && !StringUtils.isEmpty(context.getProcessDefinitionKey())){
            List<String> businessKeys= ibzwfFeignClient.getbusinesskeysByUserId("ehr", cn.ibizlab.ehr.util.security.AuthenticationUser.getAuthenticationUser().getUserid(),"pcmbdsqdmxes",context.getProcessDefinitionKey(),context.getUserTaskId());
            if(businessKeys.size()>0){
                context.getSelectCond().in("pcmbdsqdmxid",businessKeys);
            }
            else{
                context.getSelectCond().apply("1<>1");
            }
        }
    }

    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMBDSQDMX et){
        //实体关系[DER1N_PCMBDSQDMX_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_PCMBDSQDMX_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PCMBDSQDMX_ORMORGSECTOR_ORMORGSECTORID2]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid2())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector2=et.getOrmorgsector2();
            if(ObjectUtils.isEmpty(ormorgsector2)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid2());
                et.setOrmorgsector2(majorEntity);
                ormorgsector2=majorEntity;
            }
            et.setOrmorgsectorname2(ormorgsector2.getOrgsectorname());
        }
        //实体关系[DER1N_PCMBDSQDMX_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PCMBDSQDMX_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.OrmPost majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_PCMBDSQDMX_PIMPERSON_LZMTRID]
        if(!ObjectUtils.isEmpty(et.getLzmtrid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimpersonLzmtr=et.getPimpersonLzmtr();
            if(ObjectUtils.isEmpty(pimpersonLzmtr)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getLzmtrid());
                et.setPimpersonLzmtr(majorEntity);
                pimpersonLzmtr=majorEntity;
            }
            et.setLzmtr(pimpersonLzmtr.getPimpersonname());
        }
        //实体关系[DER1N_PCMBDSQDMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setZjhm(pimperson.getZjhm());
            et.setLxdh(pimperson.getLxdh());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setZz(pimperson.getOrmorgname());
            et.setZzid(pimperson.getOrmorgid());
            et.setRank(pimperson.getRank());
            et.setZzmm(pimperson.getZzmm());
            et.setYgbh(pimperson.getYgbh());
            et.setBmid(pimperson.getOrmorgsectorid());
            et.setYzw(pimperson.getZw());
            et.setYgw(pimperson.getGw());
            et.setNl(pimperson.getNl());
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
    public List<PCMBDSQDMX> getPcmbdsqdmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMBDSQDMX> getPcmbdsqdmxByEntities(List<PCMBDSQDMX> entities) {
        List ids =new ArrayList();
        for(PCMBDSQDMX entity : entities){
            Serializable id=entity.getPcmbdsqdmxid();
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


