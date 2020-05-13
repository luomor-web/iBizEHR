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
import cn.ibizlab.ehr.core.orm.domain.ORMDepEstMan;
import cn.ibizlab.ehr.core.orm.filter.ORMDepEstManSearchContext;
import cn.ibizlab.ehr.core.orm.service.IORMDepEstManService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.orm.mapper.ORMDepEstManMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门职务编制] 服务对象接口实现
 */
@Slf4j
@Service("ORMDepEstManServiceImpl")
public class ORMDepEstManServiceImpl extends ServiceImpl<ORMDepEstManMapper, ORMDepEstMan> implements IORMDepEstManService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMDUTYService ormdutyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;

    private int batchSize = 500;

    @Override
    public ORMDepEstMan getDraft(ORMDepEstMan et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(ORMDepEstMan et) {
        return (!ObjectUtils.isEmpty(et.getOrmdepestmanid()))&&(!Objects.isNull(this.getById(et.getOrmdepestmanid())));
    }

    @Override
    @Transactional
    public boolean create(ORMDepEstMan et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdepestmanid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ORMDepEstMan> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ORMDepEstMan get(String key) {
        ORMDepEstMan et = getById(key);
        if(et==null){
            et=new ORMDepEstMan();
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
    public boolean update(ORMDepEstMan et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ormdepestmanid",et.getOrmdepestmanid())))
            return false;
        CachedBeanCopier.copy(get(et.getOrmdepestmanid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ORMDepEstMan> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(ORMDepEstMan et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ORMDepEstMan et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ORMDepEstMan> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<ORMDepEstMan> selectByOrmdutyid(String ormdutyid) {
        return baseMapper.selectByOrmdutyid(ormdutyid);
    }

    @Override
    public void removeByOrmdutyid(String ormdutyid) {
        this.remove(new QueryWrapper<ORMDepEstMan>().eq("ormdutyid",ormdutyid));
    }

	@Override
    public List<ORMDepEstMan> selectByOrmzwbzid(String orgsectorid) {
        return baseMapper.selectByOrmzwbzid(orgsectorid);
    }

    @Override
    public void removeByOrmzwbzid(String orgsectorid) {
        this.remove(new QueryWrapper<ORMDepEstMan>().eq("ormzwbzid",orgsectorid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ORMDepEstMan> searchDefault(ORMDepEstManSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ORMDepEstMan> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ORMDepEstMan>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ORMDepEstMan et){
        //实体关系[DER1N_ORMDEPESTMAN_ORMDUTY_ORMDUTYID]
        if(!ObjectUtils.isEmpty(et.getOrmdutyid())){
            cn.ibizlab.ehr.core.orm.domain.ORMDUTY ormduty=et.getOrmduty();
            if(ObjectUtils.isEmpty(ormduty)){
                cn.ibizlab.ehr.core.orm.domain.ORMDUTY majorEntity=ormdutyService.get(et.getOrmdutyid());
                et.setOrmduty(majorEntity);
                ormduty=majorEntity;
            }
            et.setOrmdutyname(ormduty.getOrmdutyname());
        }
        //实体关系[DER1N_ORMDEPESTMAN_ORMORGSECTOR_ORMZWBZID]
        if(!ObjectUtils.isEmpty(et.getOrmzwbzid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormzwbz=et.getOrmzwbz();
            if(ObjectUtils.isEmpty(ormzwbz)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmzwbzid());
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

}


