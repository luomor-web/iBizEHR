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
import cn.ibizlab.ehr.core.pim.domain.PIMDISTIRBUTION;
import cn.ibizlab.ehr.core.pim.filter.PIMDISTIRBUTIONSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMDISTIRBUTIONMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[分配信息] 服务对象接口实现
 */
@Slf4j
@Service("PIMDISTIRBUTIONServiceImpl")
public class PIMDISTIRBUTIONServiceImpl extends ServiceImpl<PIMDISTIRBUTIONMapper, PIMDISTIRBUTION> implements IPIMDISTIRBUTIONService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService pcmddsqdmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMNoticeService pcmnoticeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMYDJDMXService pcmydjdmxService;
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
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

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
    public boolean checkKey(PIMDISTIRBUTION et) {
        return (!ObjectUtils.isEmpty(et.getPimdistirbutionid()))&&(!Objects.isNull(this.getById(et.getPimdistirbutionid())));
    }

    @Override
    @Transactional
    public boolean update(PIMDISTIRBUTION et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimdistirbutionid",et.getPimdistirbutionid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimdistirbutionid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMDISTIRBUTION> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public PIMDISTIRBUTION getDraft(PIMDISTIRBUTION et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PIMDISTIRBUTION dDCZC(PIMDISTIRBUTION et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PIMDISTIRBUTION et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMDISTIRBUTION et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMDISTIRBUTION> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMDISTIRBUTION et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimdistirbutionid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMDISTIRBUTION> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMDISTIRBUTION get(String key) {
        PIMDISTIRBUTION et = getById(key);
        if(et==null){
            et=new PIMDISTIRBUTION();
            et.setPimdistirbutionid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<PIMDISTIRBUTION> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PIMDISTIRBUTION> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PIMDISTIRBUTION> selectByYbmid(String orgsectorid) {
        return baseMapper.selectByYbmid(orgsectorid);
    }

    @Override
    public void removeByYbmid(String orgsectorid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("ybmid",orgsectorid));
    }

	@Override
    public List<PIMDISTIRBUTION> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("ormorgid",orgid));
    }

	@Override
    public List<PIMDISTIRBUTION> selectByYzzid(String orgid) {
        return baseMapper.selectByYzzid(orgid);
    }

    @Override
    public void removeByYzzid(String orgid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("yzzid",orgid));
    }

	@Override
    public List<PIMDISTIRBUTION> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PIMDISTIRBUTION> selectByOrmpostid1(String ormpostid) {
        return baseMapper.selectByOrmpostid1(ormpostid);
    }

    @Override
    public void removeByOrmpostid1(String ormpostid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("ormpostid1",ormpostid));
    }

	@Override
    public List<PIMDISTIRBUTION> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMDISTIRBUTION>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 干部可调动的分配
     */
    @Override
    public Page<PIMDISTIRBUTION> searchGBYXZFP(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchGBYXZFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 轮岗查询
     */
    @Override
    public Page<PIMDISTIRBUTION> searchLGTX(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchLGTX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 外单位履历为1的（支持增删改查）
     */
    @Override
    public Page<PIMDISTIRBUTION> searchISOUTRECORD(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchISOUTRECORD(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 已调出分配
     */
    @Override
    public Page<PIMDISTIRBUTION> searchYDCFP(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchYDCFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可调动的分配(有效分配)
     */
    @Override
    public Page<PIMDISTIRBUTION> searchYXFP(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchYXFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 招聘创建分配
     */
    @Override
    public Page<PIMDISTIRBUTION> searchZPCJFP(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchZPCJFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 原单位权限
     */
    @Override
    public Page<PIMDISTIRBUTION> searchYDWQX(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchYDWQX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前有效用户分配
     */
    @Override
    public Page<PIMDISTIRBUTION> searchDQYXFP(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchDQYXFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 借调人员花名册
     */
    @Override
    public Page<PIMDISTIRBUTION> searchJDRYHMC(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchJDRYHMC(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 借调人员
     */
    @Override
    public Page<PIMDISTIRBUTION> searchJDDQ(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchJDDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 是否主要经历（工作履历）
     */
    @Override
    public Page<PIMDISTIRBUTION> searchEXPEREENCE(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchEXPEREENCE(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属和人员ID不符的
     */
    @Override
    public Page<PIMDISTIRBUTION> searchJLSS(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(分配信息)
     */
    @Override
    public Page<PIMDISTIRBUTION> searchZIZHU(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMDISTIRBUTION> searchDefault(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前分配
     */
    @Override
    public Page<PIMDISTIRBUTION> searchDQFP(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchDQFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 移动端默认查询
     */
    @Override
    public Page<PIMDISTIRBUTION> searchMobDefault(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchMobDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 可调动的有效主分配
     */
    @Override
    public Page<PIMDISTIRBUTION> searchKDDYXZFP(PIMDISTIRBUTIONSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMDISTIRBUTION> pages=baseMapper.searchKDDYXZFP(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMDISTIRBUTION>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMDISTIRBUTION et){
        //实体关系[DER1N_PIMDISTIRBUTION_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_PIMDISTIRBUTION_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
            et.setShortname(ormorgsector.getShortname());
        }
        //实体关系[DER1N_PIMDISTIRBUTION_ORMORGSECTOR_YBMID]
        if(!ObjectUtils.isEmpty(et.getYbmid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsectorYbm=et.getOrmorgsectorYbm();
            if(ObjectUtils.isEmpty(ormorgsectorYbm)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getYbmid());
                et.setOrmorgsectorYbm(majorEntity);
                ormorgsectorYbm=majorEntity;
            }
            et.setYbmshortname(ormorgsectorYbm.getShortname());
            et.setYbm(ormorgsectorYbm.getOrgsectorname());
        }
        //实体关系[DER1N_PIMDISTIRBUTION_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PIMDISTIRBUTION_ORMORG_YZZID]
        if(!ObjectUtils.isEmpty(et.getYzzid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorgYzz=et.getOrmorgYzz();
            if(ObjectUtils.isEmpty(ormorgYzz)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getYzzid());
                et.setOrmorgYzz(majorEntity);
                ormorgYzz=majorEntity;
            }
            et.setYzz(ormorgYzz.getOrgname());
            et.setYzzzzdzs(ormorgYzz.getZzdzs());
        }
        //实体关系[DER1N_PIMDISTIRBUTION_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
            et.setLgnx(ormpost.getLgnx());
        }
        //实体关系[DER1N_PIMDISTIRBUTION_ORMPOST_ORMPOSTID1]
        if(!ObjectUtils.isEmpty(et.getOrmpostid1())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost1=et.getOrmpost1();
            if(ObjectUtils.isEmpty(ormpost1)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid1());
                et.setOrmpost1(majorEntity);
                ormpost1=majorEntity;
            }
            et.setOrmpostname1(ormpost1.getOrmpostname());
        }
        //实体关系[DER1N_PIMDISTIRBUTION_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setRank(pimperson.getRank());
            et.setYgzt(pimperson.getYgzt());
            et.setXb(pimperson.getXb());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setZgcode(pimperson.getZgcode());
            et.setZzmm(pimperson.getZzmm());
            et.setYgbh(pimperson.getYgbh());
            et.setYdzt(pimperson.getYdzt());
            et.setNj(pimperson.getNj());
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


