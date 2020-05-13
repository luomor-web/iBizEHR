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
import cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX;
import cn.ibizlab.ehr.core.pim.filter.PIMBYZZJLMXSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMBYZZJLMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[B/Y类员工转正记录引用明细] 服务对象接口实现
 */
@Slf4j
@Service("PIMBYZZJLMXServiceImpl")
public class PIMBYZZJLMXServiceImpl extends ServiceImpl<PIMBYZZJLMXMapper, PIMBYZZJLMX> implements IPIMBYZZJLMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEAPPROVALService pcmprofileapprovalService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMBYYGZZSQService pimbyygzzsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMEXAMINATIONRESULTSService pimexaminationresultsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPIMBYZZJLMXFillPersonInfoLogic fillpersoninfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PIMBYZZJLMX sHTG(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX get(String key) {
        PIMBYZZJLMX et = getById(key);
        if(et==null){
            et=new PIMBYZZJLMX();
            et.setPimbyzzjlmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX returnYPZ(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX jSPTG(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX fillPersonInfo(PIMBYZZJLMX et) {
        fillpersoninfoLogic.execute(et);
         return et ;
    }

    @Override
    public PIMBYZZJLMX getDraft(PIMBYZZJLMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX jSHTG(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX jSHBTG(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX ensure(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX sHBTG(PIMBYZZJLMX et) {
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
    public PIMBYZZJLMX gSDSZSP(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX zZCZ(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX dSB(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PIMBYZZJLMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimbyzzjlmxid",et.getPimbyzzjlmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimbyzzjlmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMBYZZJLMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMBYZZJLMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimbyzzjlmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMBYZZJLMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMBYZZJLMX jZBSHQR(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX gSDSZSPBTG(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX gSCSBTG(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX jSPBTG(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMBYZZJLMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMBYZZJLMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMBYZZJLMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMBYZZJLMX gSCS(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PIMBYZZJLMX et) {
        return (!ObjectUtils.isEmpty(et.getPimbyzzjlmxid()))&&(!Objects.isNull(this.getById(et.getPimbyzzjlmxid())));
    }

    @Override
    @Transactional
    public PIMBYZZJLMX updatePeopleNum(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMBYZZJLMX jZBSPQR(PIMBYZZJLMX et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PIMBYZZJLMX> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PIMBYZZJLMX>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PIMBYZZJLMX> selectByPimbyygzzsqid(String pimbyygzzsqid) {
        return baseMapper.selectByPimbyygzzsqid(pimbyygzzsqid);
    }

    @Override
    public void removeByPimbyygzzsqid(String pimbyygzzsqid) {
        this.remove(new QueryWrapper<PIMBYZZJLMX>().eq("pimbyygzzsqid",pimbyygzzsqid));
    }

	@Override
    public List<PIMBYZZJLMX> selectByPimexaminationresultsid(String pimexaminationresultsid) {
        return baseMapper.selectByPimexaminationresultsid(pimexaminationresultsid);
    }

    @Override
    public void removeByPimexaminationresultsid(String pimexaminationresultsid) {
        this.remove(new QueryWrapper<PIMBYZZJLMX>().eq("pimexaminationresultsid",pimexaminationresultsid));
    }

	@Override
    public List<PIMBYZZJLMX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMBYZZJLMX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 转正未审核
     */
    @Override
    public Page<PIMBYZZJLMX> searchZZWSHDS(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchZZWSHDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待公司初审
     */
    @Override
    public Page<PIMBYZZJLMX> searchUnApproved(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchUnApproved(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待局总部审核
     */
    @Override
    public Page<PIMBYZZJLMX> searchDDJZBSH(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchDDJZBSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 B/Y类员工转正记录
     */
    @Override
    public Page<PIMBYZZJLMX> searchBYLZZJL(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchBYLZZJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待公司董事长审批
     */
    @Override
    public Page<PIMBYZZJLMX> searchDGSDSZSH(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchDGSDSZSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 回退人员
     */
    @Override
    public Page<PIMBYZZJLMX> searchHTRY(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchHTRY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待局总部审批
     */
    @Override
    public Page<PIMBYZZJLMX> searchDJZBSP(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchDJZBSP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待上报
     */
    @Override
    public Page<PIMBYZZJLMX> searchDSB(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchDSB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 已变更员工编号名单
     */
    @Override
    public Page<PIMBYZZJLMX> searchFinishYGBH(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchFinishYGBH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待局总部初审
     */
    @Override
    public Page<PIMBYZZJLMX> searchDJZBSH(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchDJZBSH(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMBYZZJLMX> searchDefault(PIMBYZZJLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMBYZZJLMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMBYZZJLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMBYZZJLMX et){
        //实体关系[DER1N_PIMBYZZJLMX_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_PIMBYZZJLMX_PIMBYYGZZSQ_PIMBYYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPimbyygzzsqid())){
            cn.ibizlab.ehr.core.pim.domain.PIMBYYGZZSQ pimbyygzzsq=et.getPimbyygzzsq();
            if(ObjectUtils.isEmpty(pimbyygzzsq)){
                cn.ibizlab.ehr.core.pim.domain.PIMBYYGZZSQ majorEntity=pimbyygzzsqService.get(et.getPimbyygzzsqid());
                et.setPimbyygzzsq(majorEntity);
                pimbyygzzsq=majorEntity;
            }
            et.setPimbyygzzsqname(pimbyygzzsq.getPimbyygzzsqname());
        }
        //实体关系[DER1N_PIMBYZZJLMX_PIMEXAMINATIONRESULTS_PIMEXAMINATIONRESULTSID]
        if(!ObjectUtils.isEmpty(et.getPimexaminationresultsid())){
            cn.ibizlab.ehr.core.pim.domain.PIMEXAMINATIONRESULTS pimexaminationresults=et.getPimexaminationresults();
            if(ObjectUtils.isEmpty(pimexaminationresults)){
                cn.ibizlab.ehr.core.pim.domain.PIMEXAMINATIONRESULTS majorEntity=pimexaminationresultsService.get(et.getPimexaminationresultsid());
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
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
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

}


