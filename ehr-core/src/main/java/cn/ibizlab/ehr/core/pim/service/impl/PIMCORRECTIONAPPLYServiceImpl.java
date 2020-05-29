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
import cn.ibizlab.ehr.core.pim.domain.PIMCORRECTIONAPPLY;
import cn.ibizlab.ehr.core.pim.filter.PIMCORRECTIONAPPLYSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMCORRECTIONAPPLYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMCORRECTIONAPPLYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[B/Y类员工转正申请明细（停用）] 服务对象接口实现
 */
@Slf4j
@Service("PIMCORRECTIONAPPLYServiceImpl")
public class PIMCORRECTIONAPPLYServiceImpl extends ServiceImpl<PIMCORRECTIONAPPLYMapper, PIMCORRECTIONAPPLY> implements IPIMCORRECTIONAPPLYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMBYYGZZSQService pimbyygzzsqService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PIMCORRECTIONAPPLY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimcorrectionapplyid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMCORRECTIONAPPLY> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PIMCORRECTIONAPPLY getDraft(PIMCORRECTIONAPPLY et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PIMCORRECTIONAPPLY et) {
        return (!ObjectUtils.isEmpty(et.getPimcorrectionapplyid()))&&(!Objects.isNull(this.getById(et.getPimcorrectionapplyid())));
    }

    @Override
    @Transactional
    public boolean save(PIMCORRECTIONAPPLY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMCORRECTIONAPPLY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMCORRECTIONAPPLY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMCORRECTIONAPPLY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMCORRECTIONAPPLY get(String key) {
        PIMCORRECTIONAPPLY et = getById(key);
        if(et==null){
            et=new PIMCORRECTIONAPPLY();
            et.setPimcorrectionapplyid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PIMCORRECTIONAPPLY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimcorrectionapplyid",et.getPimcorrectionapplyid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimcorrectionapplyid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMCORRECTIONAPPLY> list) {
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
    public List<PIMCORRECTIONAPPLY> selectByPimbyygzzsqid(String pimbyygzzsqid) {
        return baseMapper.selectByPimbyygzzsqid(pimbyygzzsqid);
    }

    @Override
    public void removeByPimbyygzzsqid(String pimbyygzzsqid) {
        this.remove(new QueryWrapper<PIMCORRECTIONAPPLY>().eq("pimbyygzzsqid",pimbyygzzsqid));
    }

	@Override
    public List<PIMCORRECTIONAPPLY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMCORRECTIONAPPLY>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMCORRECTIONAPPLY> searchDefault(PIMCORRECTIONAPPLYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMCORRECTIONAPPLY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMCORRECTIONAPPLY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMCORRECTIONAPPLY et){
        //实体关系[DER1N_PIMCORRECTIONAPPLY_PIMBYYGZZSQ_PIMBYYGZZSQID]
        if(!ObjectUtils.isEmpty(et.getPimbyygzzsqid())){
            cn.ibizlab.ehr.core.pim.domain.PIMBYYGZZSQ pimbyygzzsq=et.getPimbyygzzsq();
            if(ObjectUtils.isEmpty(pimbyygzzsq)){
                cn.ibizlab.ehr.core.pim.domain.PIMBYYGZZSQ majorEntity=pimbyygzzsqService.get(et.getPimbyygzzsqid());
                et.setPimbyygzzsq(majorEntity);
                pimbyygzzsq=majorEntity;
            }
            et.setPimbyygzzsqname(pimbyygzzsq.getPimbyygzzsqname());
        }
        //实体关系[DER1N_PIMCORRECTIONAPPLY_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setGw(pimperson.getGw());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setZz(pimperson.getOrmorgname());
            et.setZj(pimperson.getRank());
            et.setZw(pimperson.getZw());
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
    public List<PIMCORRECTIONAPPLY> getPimcorrectionapplyByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PIMCORRECTIONAPPLY> getPimcorrectionapplyByEntities(List<PIMCORRECTIONAPPLY> entities) {
        List ids =new ArrayList();
        for(PIMCORRECTIONAPPLY entity : entities){
            Serializable id=entity.getPimcorrectionapplyid();
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


