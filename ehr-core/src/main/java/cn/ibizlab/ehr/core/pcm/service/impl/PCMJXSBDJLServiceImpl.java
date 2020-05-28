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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSBDJL;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSBDJLSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSBDJLService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMJXSBDJLMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[见习生变动记录] 服务对象接口实现
 */
@Slf4j
@Service("PCMJXSBDJLServiceImpl")
public class PCMJXSBDJLServiceImpl extends ServiceImpl<PCMJXSBDJLMapper, PCMJXSBDJL> implements IPCMJXSBDJLService {

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
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PCMJXSBDJL et) {
        return (!ObjectUtils.isEmpty(et.getPcmjxsbdjlid()))&&(!Objects.isNull(this.getById(et.getPcmjxsbdjlid())));
    }

    @Override
    @Transactional
    public PCMJXSBDJL get(String key) {
        PCMJXSBDJL et = getById(key);
        if(et==null){
            et=new PCMJXSBDJL();
            et.setPcmjxsbdjlid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMJXSBDJL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmjxsbdjlid",et.getPcmjxsbdjlid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsbdjlid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMJXSBDJL> list) {
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
    public boolean save(PCMJXSBDJL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMJXSBDJL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMJXSBDJL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMJXSBDJL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMJXSBDJL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmjxsbdjlid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMJXSBDJL> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PCMJXSBDJL getDraft(PCMJXSBDJL et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PCMJXSBDJL> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMJXSBDJL>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PCMJXSBDJL> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMJXSBDJL>().eq("ormorgid",orgid));
    }

	@Override
    public List<PCMJXSBDJL> selectByOrmpostid(String ormpostid) {
        return baseMapper.selectByOrmpostid(ormpostid);
    }

    @Override
    public void removeByOrmpostid(String ormpostid) {
        this.remove(new QueryWrapper<PCMJXSBDJL>().eq("ormpostid",ormpostid));
    }

	@Override
    public List<PCMJXSBDJL> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMJXSBDJL>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMJXSBDJL> searchDefault(PCMJXSBDJLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMJXSBDJL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMJXSBDJL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 自助(见习记录)
     */
    @Override
    public Page<PCMJXSBDJL> searchZIZHU(PCMJXSBDJLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMJXSBDJL> pages=baseMapper.searchZIZHU(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMJXSBDJL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录所属和人员ID不符的
     */
    @Override
    public Page<PCMJXSBDJL> searchJLSS(PCMJXSBDJLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMJXSBDJL> pages=baseMapper.searchJLSS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMJXSBDJL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMJXSBDJL et){
        //实体关系[DER1N_PCMJXSBDJL_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PCMJXSBDJL_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PCMJXSBDJL_ORMPOST_ORMPOSTID]
        if(!ObjectUtils.isEmpty(et.getOrmpostid())){
            cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost=et.getOrmpost();
            if(ObjectUtils.isEmpty(ormpost)){
                cn.ibizlab.ehr.core.orm.domain.ORMPOST majorEntity=ormpostService.get(et.getOrmpostid());
                et.setOrmpost(majorEntity);
                ormpost=majorEntity;
            }
            et.setOrmpostname(ormpost.getOrmpostname());
        }
        //实体关系[DER1N_PCMJXSBDJL_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setYbm(pimperson.getOrmorgsectorname());
            et.setYgw(pimperson.getGw());
            et.setYgbh(pimperson.getYgbh());
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYzz(pimperson.getOrmorgname());
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
    public List<PCMJXSBDJL> getPcmjxsbdjlByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMJXSBDJL> getPcmjxsbdjlByEntities(List<PCMJXSBDJL> entities) {
        List ids =new ArrayList();
        for(PCMJXSBDJL entity : entities){
            Serializable id=entity.getPcmjxsbdjlid();
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


