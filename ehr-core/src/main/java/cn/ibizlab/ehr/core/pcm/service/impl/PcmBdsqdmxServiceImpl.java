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
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmBdsqdmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmBdsqdmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[职级变动明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmBdsqdmxServiceImpl")
public class PcmBdsqdmxServiceImpl extends ServiceImpl<PcmBdsqdmxMapper, PcmBdsqdmx> implements IPcmBdsqdmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmSgqMgrService pcmsgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmPcmSgqMgrService pcmpcmsgqmgrService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmDutyService ormdutyService;
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
    private cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdService pcmbdsqdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxZJJScodelist2Logic zjjscodelist2Logic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxSetPersonInfoNewLogic setpersoninfonewLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxSetPersonInfoNew2Logic setpersoninfonew2Logic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxZJcodelistLogic zjcodelistLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxSetPersonInfoLogic setpersoninfoLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.logic.IPcmBdsqdmxZJJScodelist3Logic zjjscodelist3Logic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PcmBdsqdmx zJJSDMB(PcmBdsqdmx et) {
        zjjscodelist2Logic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmBdsqdmx cQBXCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx sXJSDMB(PcmBdsqdmx et) {
        setpersoninfonewLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmBdsqdmx pDZJ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx sXJSDMB2(PcmBdsqdmx et) {
        setpersoninfonew2Logic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean create(PcmBdsqdmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmbdsqdmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmBdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmBdsqdmx zZSQ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx sXDMB(PcmBdsqdmx et) {
        zjcodelistLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmBdsqdmx dGCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx setPersonInfo(PcmBdsqdmx et) {
        setpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmBdsqdmx gZCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx jPCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PcmBdsqdmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmBdsqdmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmBdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmBdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmBdsqdmx lZCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx nTCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PcmBdsqdmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmbdsqdmxid",et.getPcmbdsqdmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmbdsqdmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmBdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmBdsqdmx get(String key) {
        PcmBdsqdmx et = getById(key);
        if(et==null){
            et=new PcmBdsqdmx();
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
    public PcmBdsqdmx getDraft(PcmBdsqdmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx sHBTG(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx zJBDCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PcmBdsqdmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmbdsqdmxid()))&&(!Objects.isNull(this.getById(et.getPcmbdsqdmxid())));
    }
    @Override
    @Transactional
    public PcmBdsqdmx tXCZ(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmBdsqdmx jZJJSDMB(PcmBdsqdmx et) {
        zjjscodelist3Logic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public PcmBdsqdmx sHTG(PcmBdsqdmx et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PcmBdsqdmx> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PcmBdsqdmx> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PcmBdsqdmx> selectByOrmorgsectorid2(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid2(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid2(String orgsectorid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("ormorgsectorid2",orgsectorid));
    }

	@Override
    public List<PcmBdsqdmx> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("ormorgid",orgid));
    }

	@Override
    public List<PcmBdsqdmx> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PcmBdsqdmx> selectByPcmbdsqdid(String pcmbdsqdid) {
        return baseMapper.selectByPcmbdsqdid(pcmbdsqdid);
    }

    @Override
    public void removeByPcmbdsqdid(String pcmbdsqdid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("pcmbdsqdid",pcmbdsqdid));
    }

	@Override
    public List<PcmBdsqdmx> selectByLzmtrid(String pimpersonid) {
        return baseMapper.selectByLzmtrid(pimpersonid);
    }

    @Override
    public void removeByLzmtrid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("lzmtrid",pimpersonid));
    }

	@Override
    public List<PcmBdsqdmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PcmBdsqdmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 解聘申请（未审核）
     */
    @Override
    public Page<PcmBdsqdmx> searchJPSQMX(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchJPSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 内退申请明细（未审核）
     */
    @Override
    public Page<PcmBdsqdmx> searchNTSQMX(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchNTSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 内退申请明细（个人）
     */
    @Override
    public Page<PcmBdsqdmx> searchNTSQMXGR(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchNTSQMXGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 退休申请明细（未审核）
     */
    @Override
    public Page<PcmBdsqdmx> searchTXSQMX(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchTXSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 挂职申请明细（未审核）
     */
    @Override
    public Page<PcmBdsqdmx> searchGZSQMX(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchGZSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 职级变动申请明细
     */
    @Override
    public Page<PcmBdsqdmx> searchZJBDSQMX(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchZJBDSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待岗申请明细
     */
    @Override
    public Page<PcmBdsqdmx> searchDGSQMX(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchDGSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 长期病休申请明细
     */
    @Override
    public Page<PcmBdsqdmx> searchCQBXSQMXDS(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchCQBXSQMXDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离职申请明细
     */
    @Override
    public Page<PcmBdsqdmx> searchLZSQMX(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchLZSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 离职申请明细（个人）
     */
    @Override
    public Page<PcmBdsqdmx> searchLZSQMXGR(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchLZSQMXGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmBdsqdmx> searchDefault(PcmBdsqdmxSearchContext context) {
        fillWFTaskContext(context);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmBdsqdmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmBdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }


    @Autowired
    private cn.ibizlab.ehr.util.client.IBZWFFeignClient ibzwfFeignClient;

    /**
     * 查询工作流待办
     * @param context
     */
    private void fillWFTaskContext(PcmBdsqdmxSearchContext context){

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
    private void fillParentData(PcmBdsqdmx et){
        //实体关系[DER1N_PCMBDSQDMX_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.OrmDuty majorEntity=ormdutyService.get(et.getOrmdutyid());
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
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimpersonLzmtr=et.getPimpersonLzmtr();
            if(ObjectUtils.isEmpty(pimpersonLzmtr)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getLzmtrid());
                et.setPimpersonLzmtr(majorEntity);
                pimpersonLzmtr=majorEntity;
            }
            et.setLzmtr(pimpersonLzmtr.getPimpersonname());
        }
        //实体关系[DER1N_PCMBDSQDMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
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
    public List<PcmBdsqdmx> getPcmbdsqdmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmBdsqdmx> getPcmbdsqdmxByEntities(List<PcmBdsqdmx> entities) {
        List ids =new ArrayList();
        for(PcmBdsqdmx entity : entities){
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



