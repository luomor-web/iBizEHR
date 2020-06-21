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
import cn.ibizlab.ehr.core.pim.domain.PimByzzjlmx;
import cn.ibizlab.ehr.core.pim.filter.PimByzzjlmxSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimByzzjlmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimByzzjlmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[B/Y类员工转正记录引用明细] 服务对象接口实现
 */
@Slf4j
@Service("PimByzzjlmxServiceImpl")
public class PimByzzjlmxServiceImpl extends ServiceImpl<PimByzzjlmxMapper, PimByzzjlmx> implements IPimByzzjlmxService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPcmProfileApprovalService pcmprofileapprovalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmPostService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimByygzzsqService pimbyygzzsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimExaminationResultsService pimexaminationresultsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPimByzzjlmxFillPersonInfoLogic fillpersoninfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PimByzzjlmx sHTG(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx get(String key) {
        PimByzzjlmx et = getById(key);
        if(et==null){
            et=new PimByzzjlmx();
            et.setPimbyzzjlmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx returnYPZ(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx jSPTG(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx fillPersonInfo(PimByzzjlmx et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    public PimByzzjlmx getDraft(PimByzzjlmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx jSHTG(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx jSHBTG(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx ensure(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx sHBTG(PimByzzjlmx et) {
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
    public PimByzzjlmx gSDSZSP(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx zZCZ(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx dSB(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimByzzjlmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimbyzzjlmxid",et.getPimbyzzjlmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimbyzzjlmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PimByzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimByzzjlmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimbyzzjlmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PimByzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimByzzjlmx jZBSHQR(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx gSDSZSPBTG(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx gSCSBTG(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx jSPBTG(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PimByzzjlmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimByzzjlmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimByzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimByzzjlmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PimByzzjlmx gSCS(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PimByzzjlmx et) {
        return (!ObjectUtils.isEmpty(et.getPimbyzzjlmxid()))&&(!Objects.isNull(this.getById(et.getPimbyzzjlmxid())));
    }
    @Override
    @Transactional
    public PimByzzjlmx updatePeopleNum(PimByzzjlmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PimByzzjlmx jZBSPQR(PimByzzjlmx et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PimByzzjlmx> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PimByzzjlmx>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PimByzzjlmx> selectByPimbyygzzsqid(String pimbyygzzsqid) {
        return baseMapper.selectByPimbyygzzsqid(pimbyygzzsqid);
    }

    @Override
    public void removeByPimbyygzzsqid(String pimbyygzzsqid) {
        this.remove(new QueryWrapper<PimByzzjlmx>().eq("pimbyygzzsqid",pimbyygzzsqid));
    }

	@Override
    public List<PimByzzjlmx> selectByPimexaminationresultsid(String pimexaminationresultsid) {
        return baseMapper.selectByPimexaminationresultsid(pimexaminationresultsid);
    }

    @Override
    public void removeByPimexaminationresultsid(String pimexaminationresultsid) {
        this.remove(new QueryWrapper<PimByzzjlmx>().eq("pimexaminationresultsid",pimexaminationresultsid));
    }

	@Override
    public List<PimByzzjlmx> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimByzzjlmx>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 转正未审核
     */
    @Override
    public Page<PimByzzjlmx> searchZZWSHDS(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchZZWSHDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待公司初审
     */
    @Override
    public Page<PimByzzjlmx> searchUnApproved(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchUnApproved(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待局总部审核
     */
    @Override
    public Page<PimByzzjlmx> searchDDJZBSH(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchDDJZBSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 B/Y类员工转正记录
     */
    @Override
    public Page<PimByzzjlmx> searchBYLZZJL(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchBYLZZJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待公司董事长审批
     */
    @Override
    public Page<PimByzzjlmx> searchDGSDSZSH(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchDGSDSZSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 回退人员
     */
    @Override
    public Page<PimByzzjlmx> searchHTRY(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchHTRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待局总部审批
     */
    @Override
    public Page<PimByzzjlmx> searchDJZBSP(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchDJZBSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待上报
     */
    @Override
    public Page<PimByzzjlmx> searchDSB(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchDSB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 已变更员工编号名单
     */
    @Override
    public Page<PimByzzjlmx> searchFinishYGBH(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchFinishYGBH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待局总部初审
     */
    @Override
    public Page<PimByzzjlmx> searchDJZBSH(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchDJZBSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimByzzjlmx> searchDefault(PimByzzjlmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimByzzjlmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimByzzjlmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimByzzjlmx et){
        //实体关系[DER1N_PIMBYZZJLMX_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.OrmPost majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_PIMBYZZJLMX_PIMBYYGZZSQ_PIMBYYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPimbyygzzsqid())){
            cn.ibizlab.ehr.core.pim.domain.PimByygzzsq pimbyygzzsq=et.getPimbyygzzsq();
            if(ObjectUtils.isEmpty(pimbyygzzsq)){
                cn.ibizlab.ehr.core.pim.domain.PimByygzzsq majorEntity=pimbyygzzsqService.get(et.getPimbyygzzsqid());
                et.setPimbyygzzsq(majorEntity);
                pimbyygzzsq=majorEntity;
            }
            et.setPimbyygzzsqname(pimbyygzzsq.getPimbyygzzsqname());
        }
        //实体关系[DER1N_PIMBYZZJLMX_PIMEXAMINATIONRESULTS_PIMEXAMINATIONRESULTSID]
        if(!ObjectUtils.isEmpty(et.getPimexaminationresultsid())){
            cn.ibizlab.ehr.core.pim.domain.PimExaminationResults pimexaminationresults=et.getPimexaminationresults();
            if(ObjectUtils.isEmpty(pimexaminationresults)){
                cn.ibizlab.ehr.core.pim.domain.PimExaminationResults majorEntity=pimexaminationresultsService.get(et.getPimexaminationresultsid());
                et.setPimexaminationresults(majorEntity);
                pimexaminationresults=majorEntity;
            }
            et.setFs(pimexaminationresults.getFs());
            et.setPimexaminationresultsname(pimexaminationresults.getPimexaminationresultsname());
            et.setPj(pimexaminationresults.getPj());
            et.setQssj(pimexaminationresults.getQssj());
            et.setJssj(pimexaminationresults.getJssj());
        }
        //实体关系[DER1N_PIMBYZZJLMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setCjgzsj(pimperson.getCjgzsj());
            et.setYgbh(pimperson.getYgbh());
            et.setYgw(pimperson.getGw());
            et.setXb(pimperson.getXb());
            et.setBmid(pimperson.getOrmorgsectorid());
            et.setHklx(pimperson.getHklx());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setYyglx(pimperson.getYglx());
            et.setLxdh(pimperson.getLxdh());
            et.setYbhqysj(pimperson.getYgbhqysj());
            et.setHightitle(pimperson.getHightitle());
            et.setPostaladdress(pimperson.getPostaladdress());
            et.setHjdz(pimperson.getHjdz());
            et.setZjhm(pimperson.getZjhm());
            et.setDzjbjsj(pimperson.getDzjbjsj());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setJg(pimperson.getJg());
            et.setZz(pimperson.getZzdzs());
            et.setZzmm(pimperson.getZzmm());
            et.setCsrq(pimperson.getCsrq());
            et.setJkzk(pimperson.getJkzk());
            et.setMz(pimperson.getMz());
            et.setZzid(pimperson.getOrmorgid());
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
    public List<PimByzzjlmx> getPimbyzzjlmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimByzzjlmx> getPimbyzzjlmxByEntities(List<PimByzzjlmx> entities) {
        List ids =new ArrayList();
        for(PimByzzjlmx entity : entities){
            Serializable id=entity.getPimbyzzjlmxid();
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



