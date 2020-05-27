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
import cn.ibizlab.ehr.core.pim.domain.PCMDETAIL;
import cn.ibizlab.ehr.core.pim.filter.PCMDETAILSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPCMDETAILService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PCMDETAILMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人员花名册] 服务对象接口实现
 */
@Slf4j
@Service("PCMDETAILServiceImpl")
public class PCMDETAILServiceImpl extends ServiceImpl<PCMDETAILMapper, PCMDETAIL> implements IPCMDETAILService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

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
    @Transactional
    public boolean update(PCMDETAIL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmdetailid",et.getPcmdetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmdetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMDETAIL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmdetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMDETAIL et) {
        return (!ObjectUtils.isEmpty(et.getPcmdetailid()))&&(!Objects.isNull(this.getById(et.getPcmdetailid())));
    }

    @Override
    @Transactional
    public PCMDETAIL get(String key) {
        PCMDETAIL et = getById(key);
        if(et==null){
            et=new PCMDETAIL();
            et.setPcmdetailid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMDETAIL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMDETAIL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMDETAIL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PCMDETAIL getDraft(PCMDETAIL et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PCMDETAIL> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMDETAIL>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PCMDETAIL> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMDETAIL>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMDETAIL> searchDefault(PCMDETAILSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMDETAIL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMDETAIL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMDETAIL et){
        //实体关系[DER1N_PCMDETAIL_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setShortname(ormorgsector.getShortname());
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PCMDETAIL_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setZzdzs(ormorg.getZzdzs());
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
    public List<PCMDETAIL> getPcmdetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PCMDETAIL> getPcmdetailByEntities(List<PCMDETAIL> entities) {
        List ids =new ArrayList();
        for(PCMDETAIL entity : entities){
            Serializable id=entity.getPcmdetailid();
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


