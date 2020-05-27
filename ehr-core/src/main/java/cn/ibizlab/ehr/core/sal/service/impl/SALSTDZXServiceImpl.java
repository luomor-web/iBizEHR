package cn.ibizlab.ehr.core.sal.service.impl;

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
import cn.ibizlab.ehr.core.sal.domain.SALSTDZX;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZXSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALSTDZXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALSTDZXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[专项津贴标准] 服务对象接口实现
 */
@Slf4j
@Service("SALSTDZXServiceImpl")
public class SALSTDZXServiceImpl extends ServiceImpl<SALSTDZXMapper, SALSTDZX> implements ISALSTDZXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(SALSTDZX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALSTDZX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SALSTDZX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SALSTDZX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public SALSTDZX get(String key) {
        SALSTDZX et = getById(key);
        if(et==null){
            et=new SALSTDZX();
            et.setSalstdzxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(SALSTDZX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salstdzxid",et.getSalstdzxid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalstdzxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALSTDZX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(SALSTDZX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalstdzxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALSTDZX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public SALSTDZX getDraft(SALSTDZX et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SALSTDZX et) {
        return (!ObjectUtils.isEmpty(et.getSalstdzxid()))&&(!Objects.isNull(this.getById(et.getSalstdzxid())));
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
    public List<SALSTDZX> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<SALSTDZX>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<SALSTDZX> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<SALSTDZX>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALSTDZX> searchDefault(SALSTDZXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALSTDZX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALSTDZX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALSTDZX et){
        //实体关系[DER1N_SALSTDZX_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_SALSTDZX_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
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
    public List<SALSTDZX> getSalstdzxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SALSTDZX> getSalstdzxByEntities(List<SALSTDZX> entities) {
        List ids =new ArrayList();
        for(SALSTDZX entity : entities){
            Serializable id=entity.getSalstdzxid();
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


