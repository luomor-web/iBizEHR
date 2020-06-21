package cn.ibizlab.ehr.core.orm.service.impl;

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
import cn.ibizlab.ehr.core.orm.domain.OrmDepEstMan;
import cn.ibizlab.ehr.core.orm.filter.OrmDepEstManSearchContext;
import cn.ibizlab.ehr.core.orm.service.IOrmDepEstManService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.OrmDepEstManMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门职务编制] 服务对象接口实现
 */
@Slf4j
@Service("OrmDepEstManServiceImpl")
public class OrmDepEstManServiceImpl extends ServiceImpl<OrmDepEstManMapper, OrmDepEstMan> implements IOrmDepEstManService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmDutyService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;

    private int batchSize = 500;

    @Override
    public OrmDepEstMan getDraft(OrmDepEstMan et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(OrmDepEstMan et) {
        return (!ObjectUtils.isEmpty(et.getOrmdepestmanid()))&&(!Objects.isNull(this.getById(et.getOrmdepestmanid())));
    }
    @Override
    @Transactional
    public boolean create(OrmDepEstMan et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdepestmanid()),et);
        return true;
    }

    @Override
    public void createBatch(List<OrmDepEstMan> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public OrmDepEstMan get(String key) {
        OrmDepEstMan et = getById(key);
        if(et==null){
            et=new OrmDepEstMan();
            et.setOrmdepestmanid(key);
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
    public boolean update(OrmDepEstMan et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormdepestmanid",et.getOrmdepestmanid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdepestmanid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<OrmDepEstMan> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(OrmDepEstMan et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(OrmDepEstMan et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<OrmDepEstMan> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<OrmDepEstMan> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<OrmDepEstMan> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<OrmDepEstMan>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<OrmDepEstMan> selectByOrmzwbzid(String orgsectorid) {
        return baseMapper.selectByOrmzwbzid(orgsectorid);
    }

    @Override
    public void removeByOrmzwbzid(String orgsectorid) {
        this.remove(new QueryWrapper<OrmDepEstMan>().eq("ormzwbzid",orgsectorid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<OrmDepEstMan> searchDefault(OrmDepEstManSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<OrmDepEstMan> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<OrmDepEstMan>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(OrmDepEstMan et){
        //实体关系[DER1N_ORMDEPESTMAN_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.OrmDuty majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_ORMDEPESTMAN_ORMORGSECTOR_ORMZWBZID]
        if(!ObjectUtils.isEmpty(et.getOrmzwbzid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormzwbz=et.getOrmzwbz();
            if(ObjectUtils.isEmpty(ormzwbz)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmzwbzid());
                et.setOrmzwbz(majorEntity);
                ormzwbz=majorEntity;
            }
            et.setOrmzwbzmc(ormzwbz.getOrgsectorname());
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
    public List<OrmDepEstMan> getOrmdepestmanByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<OrmDepEstMan> getOrmdepestmanByEntities(List<OrmDepEstMan> entities) {
        List ids =new ArrayList();
        for(OrmDepEstMan entity : entities){
            Serializable id=entity.getOrmdepestmanid();
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



