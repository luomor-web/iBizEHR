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
import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqdmx;
import cn.ibizlab.ehr.core.pcm.filter.PcmDdsqdmxSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdmxService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmDdsqdmxMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[调动申请单明细] 服务对象接口实现
 */
@Slf4j
@Service("PcmDdsqdmxServiceImpl")
public class PcmDdsqdmxServiceImpl extends ServiceImpl<PcmDdsqdmxMapper, PcmDdsqdmx> implements IPcmDdsqdmxService {

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
    private cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdService pcmddsqdService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService pimdistirbutionService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PcmDdsqdmx et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmddsqdmxid",et.getPcmddsqdmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmddsqdmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmDdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PcmDdsqdmx dDUpdate(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmDdsqdmx sQBTG(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmDdsqdmx jDCZ(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    public PcmDdsqdmx getDraft(PcmDdsqdmx et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PcmDdsqdmx et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmddsqdmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmDdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmDdsqdmx dDCreate(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmDdsqdmx get(String key) {
        PcmDdsqdmx et = getById(key);
        if(et==null){
            et=new PcmDdsqdmx();
            et.setPcmddsqdmxid(key);
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
    @Transactional
    public PcmDdsqdmx zZSQ(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PcmDdsqdmx et) {
        return (!ObjectUtils.isEmpty(et.getPcmddsqdmxid()))&&(!Objects.isNull(this.getById(et.getPcmddsqdmxid())));
    }
    @Override
    @Transactional
    public PcmDdsqdmx dDCZ(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PcmDdsqdmx sQTG(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(PcmDdsqdmx et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmDdsqdmx et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmDdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmDdsqdmx> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PcmDdsqdmx jZCZ(PcmDdsqdmx et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PcmDdsqdmx> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PcmDdsqdmx>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PcmDdsqdmx> selectByOrgsectorid(String orgsectorid) {
        return baseMapper.selectByOrgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PcmDdsqdmx>().eq("orgsectorid",orgsectorid));
    }

	@Override
    public List<PcmDdsqdmx> selectByOrgid(String orgid) {
        return baseMapper.selectByOrgid(orgid);
    }

    @Override
    public void removeByOrgid(String orgid) {
        this.remove(new QueryWrapper<PcmDdsqdmx>().eq("orgid",orgid));
    }

	@Override
    public List<PcmDdsqdmx> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PcmDdsqdmx>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PcmDdsqdmx> selectByPcmddsqdid(String pcmddsqdid) {
        return baseMapper.selectByPcmddsqdid(pcmddsqdid);
    }

    @Override
    public void removeByPcmddsqdid(String pcmddsqdid) {
        this.remove(new QueryWrapper<PcmDdsqdmx>().eq("pcmddsqdid",pcmddsqdid));
    }

	@Override
    public List<PcmDdsqdmx> selectByPimdistirbutionid(String pimdistirbutionid) {
        return baseMapper.selectByPimdistirbutionid(pimdistirbutionid);
    }

    @Override
    public void removeByPimdistirbutionid(String pimdistirbutionid) {
        this.remove(new QueryWrapper<PcmDdsqdmx>().eq("pimdistirbutionid",pimdistirbutionid));
    }


    /**
     * 查询集合 兼职申请明细（未审核完成）
     */
    @Override
    public Page<PcmDdsqdmx> searchJZSQMX(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchJZSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 借调申请（个人）
     */
    @Override
    public Page<PcmDdsqdmx> searchJDSQGR(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchJDSQGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmDdsqdmx> searchDefault(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 借调申请明细（未审核完成）
     */
    @Override
    public Page<PcmDdsqdmx> searchJDSQMX(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchJDSQMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 调动记录
     */
    @Override
    public Page<PcmDdsqdmx> searchDDJL(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchDDJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 调动记录
     */
    @Override
    public Page<PcmDdsqdmx> searchGBDDJL(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchGBDDJL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 调动申请（个人）
     */
    @Override
    public Page<PcmDdsqdmx> searchDDSQGR(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchDDSQGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 调动明细
     */
    @Override
    public Page<PcmDdsqdmx> searchDDMX(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchDDMX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 兼职申请（个人）
     */
    @Override
    public Page<PcmDdsqdmx> searchJZSQGR(PcmDdsqdmxSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmDdsqdmx> pages=baseMapper.searchJZSQGR(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmDdsqdmx>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmDdsqdmx et){
        //实体关系[DER1N_PCMDDSQDMX_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.OrmDuty majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_PCMDDSQDMX_ORMORGSECTOR_ORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrgsectorname(ormorgsector.getShortname());
        }
        //实体关系[DER1N_PCMDDSQDMX_ORMORG_ORGID]
        if(!ObjectUtils.isEmpty(et.getOrgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrgname(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PCMDDSQDMX_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.OrmPost majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_PCMDDSQDMX_PCMDDSQD_PCMDDSQDID]
        if(!ObjectUtils.isEmpty(et.getPcmddsqdid())){
            cn.ibizlab.ehr.core.pcm.domain.PcmDdsqd pcmddsqd=et.getPcmddsqd();
            if(ObjectUtils.isEmpty(pcmddsqd)){
                cn.ibizlab.ehr.core.pcm.domain.PcmDdsqd majorEntity=pcmddsqdService.get(et.getPcmddsqdid());
                et.setPcmddsqd(majorEntity);
                pcmddsqd=majorEntity;
            }
            et.setPcmddsqdname(pcmddsqd.getPcmddsqdname());
        }
        //实体关系[DER1N_PCMDDSQDMX_PIMDISTIRBUTION_PIMDISTIRBUTIONID]
        if(!ObjectUtils.isEmpty(et.getPimdistirbutionid())){
            cn.ibizlab.ehr.core.pim.domain.PimDistirbution pimdistirbution=et.getPimdistirbution();
            if(ObjectUtils.isEmpty(pimdistirbution)){
                cn.ibizlab.ehr.core.pim.domain.PimDistirbution majorEntity=pimdistirbutionService.get(et.getPimdistirbutionid());
                et.setPimdistirbution(majorEntity);
                pimdistirbution=majorEntity;
            }
            et.setOrmorgname(pimdistirbution.getZzdzs());
            et.setOrmygw(pimdistirbution.getOrmpostname());
            et.setPimdistirbutionname(pimdistirbution.getPimpersonname());
            et.setOrmyzw(pimdistirbution.getOrmdutyname());
            et.setYgbh(pimdistirbution.getYgbh());
            et.setOrmorgsectorname(pimdistirbution.getShortname());
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
    public List<PcmDdsqdmx> getPcmddsqdmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmDdsqdmx> getPcmddsqdmxByEntities(List<PcmDdsqdmx> entities) {
        List ids =new ArrayList();
        for(PcmDdsqdmx entity : entities){
            Serializable id=entity.getPcmddsqdmxid();
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



