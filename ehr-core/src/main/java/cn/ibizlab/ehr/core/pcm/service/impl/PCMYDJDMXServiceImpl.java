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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDJDMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJDMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDJDMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDJDMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动借调明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDJDMXServiceImpl")
public class PCMYDJDMXServiceImpl extends ServiceImpl<PCMYDJDMXMapper, PCMYDJDMX> implements IPCMYDJDMXService {

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
    private cn.ibizlab.ehr.core.orm.service.IORMPOSTService ormpostService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService pimdistirbutionService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PCMYDJDMX get(String key) {
        PCMYDJDMX et = getById(key);
        if(et==null){
            et=new PCMYDJDMX();
            et.setPcmydjdmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMYDJDMX fillPersonInfo(PCMYDJDMX et) {
        //自定义代码
        return et;
    }

    @Override
    public PCMYDJDMX getDraft(PCMYDJDMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMYDJDMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydjdmxid",et.getPcmydjdmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjdmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDJDMX> list) {
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
    public PCMYDJDMX rYHG(PCMYDJDMX et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PCMYDJDMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmydjdmxid()))&&(!Objects.isNull(this.getById(et.getPcmydjdmxid())));
    }

    @Override
    @Transactional
    public boolean save(PCMYDJDMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDJDMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMYDJDMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMYDJDMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMYDJDMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjdmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDJDMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }


	@Override
    public List<PCMYDJDMX> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<PCMYDJDMX>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<PCMYDJDMX> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMYDJDMX>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PCMYDJDMX> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMYDJDMX>().eq("ormorgid",orgid));
    }

	@Override
    public List<PCMYDJDMX> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PCMYDJDMX>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PCMYDJDMX> selectByPimdistirbutionid(String pimdistirbutionid) {
        return baseMapper.selectByPimdistirbutionid(pimdistirbutionid);
    }

    @Override
    public void removeByPimdistirbutionid(String pimdistirbutionid) {
        this.remove(new QueryWrapper<PCMYDJDMX>().eq("pimdistirbutionid",pimdistirbutionid));
    }


    /**
     * 查询集合 借调管理查询
     */
    @Override
    public Page<PCMYDJDMX> searchJDGLDQ(PCMYDJDMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJDMX> pages=baseMapper.searchJDGLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 借调历史记录查询
     */
    @Override
    public Page<PCMYDJDMX> searchJDLSJLDQ(PCMYDJDMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJDMX> pages=baseMapper.searchJDLSJLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDJDMX> searchDefault(PCMYDJDMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJDMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJDMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMYDJDMX et){
        //实体关系[DER1N_PCMYDJDMX_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_PCMYDJDMX_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setJdshortname(ormorgsector.getShortname());
            et.setOrmorgsectorname(ormorgsector.getShortname());
        }
        //实体关系[DER1N_PCMYDJDMX_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setJdzzdzs(ormorg.getZzdzs());
            et.setOrmorgname(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PCMYDJDMX_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
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
    public List<PCMYDJDMX> getPcmydjdmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMYDJDMX> getPcmydjdmxByEntities(List<PCMYDJDMX> entities) {
        List ids =new ArrayList();
        for(PCMYDJDMX entity : entities){
            Serializable id=entity.getPcmydjdmxid();
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


