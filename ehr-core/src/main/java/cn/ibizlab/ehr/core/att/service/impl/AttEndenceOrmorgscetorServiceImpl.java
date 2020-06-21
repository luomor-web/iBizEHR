package cn.ibizlab.ehr.core.att.service.impl;

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
import cn.ibizlab.ehr.core.att.domain.AttEndenceOrmorgscetor;
import cn.ibizlab.ehr.core.att.filter.AttEndenceOrmorgscetorSearchContext;
import cn.ibizlab.ehr.core.att.service.IAttEndenceOrmorgscetorService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.AttEndenceOrmorgscetorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤部门] 服务对象接口实现
 */
@Slf4j
@Service("AttEndenceOrmorgscetorServiceImpl")
public class AttEndenceOrmorgscetorServiceImpl extends ServiceImpl<AttEndenceOrmorgscetorMapper, AttEndenceOrmorgscetor> implements IAttEndenceOrmorgscetorService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IAttEndenceSetupService attendencesetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgsectorService ormorgsectorService;

    private int batchSize = 500;

    @Override
    @Transactional
    public AttEndenceOrmorgscetor get(String key) {
        AttEndenceOrmorgscetor et = getById(key);
        if(et==null){
            et=new AttEndenceOrmorgscetor();
            et.setAttendenceormorgsectorid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(AttEndenceOrmorgscetor et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendenceormorgsectorid()),et);
        return true;
    }

    @Override
    public void createBatch(List<AttEndenceOrmorgscetor> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(AttEndenceOrmorgscetor et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendenceormorgsectorid",et.getAttendenceormorgsectorid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendenceormorgsectorid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<AttEndenceOrmorgscetor> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(AttEndenceOrmorgscetor et) {
        return (!ObjectUtils.isEmpty(et.getAttendenceormorgsectorid()))&&(!Objects.isNull(this.getById(et.getAttendenceormorgsectorid())));
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
    public AttEndenceOrmorgscetor getDraft(AttEndenceOrmorgscetor et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(AttEndenceOrmorgscetor et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(AttEndenceOrmorgscetor et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<AttEndenceOrmorgscetor> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<AttEndenceOrmorgscetor> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<AttEndenceOrmorgscetor> selectByAttendencesetupid(String attendencesetupid) {
        return baseMapper.selectByAttendencesetupid(attendencesetupid);
    }

    @Override
    public void removeByAttendencesetupid(String attendencesetupid) {
        this.remove(new QueryWrapper<AttEndenceOrmorgscetor>().eq("attendencesetupid",attendencesetupid));
    }

	@Override
    public List<AttEndenceOrmorgscetor> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<AttEndenceOrmorgscetor>().eq("ormorgsectorid",orgsectorid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<AttEndenceOrmorgscetor> searchDefault(AttEndenceOrmorgscetorSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<AttEndenceOrmorgscetor> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<AttEndenceOrmorgscetor>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(AttEndenceOrmorgscetor et){
        //实体关系[DER1N_ATTENDENCEORMORGSECTOR_ATTENDENCESETUP_ATTENDENCESETUPID]
        if(!ObjectUtils.isEmpty(et.getAttendencesetupid())){
            cn.ibizlab.ehr.core.att.domain.AttEndenceSetup attendencesetup=et.getAttendencesetup();
            if(ObjectUtils.isEmpty(attendencesetup)){
                cn.ibizlab.ehr.core.att.domain.AttEndenceSetup majorEntity=attendencesetupService.get(et.getAttendencesetupid());
                et.setAttendencesetup(majorEntity);
                attendencesetup=majorEntity;
            }
            et.setAttendencesetupname(attendencesetup.getAttendencesetupname());
        }
        //实体关系[DER1N_ATTENDENCEORMORGSECTOR_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrgsector majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrgname(ormorgsector.getOrgname());
            et.setOrgid(ormorgsector.getOrgid());
            et.setOrmorgsectorname(ormorgsector.getShortname());
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
    public List<AttEndenceOrmorgscetor> getAttendenceormorgscetorByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<AttEndenceOrmorgscetor> getAttendenceormorgscetorByEntities(List<AttEndenceOrmorgscetor> entities) {
        List ids =new ArrayList();
        for(AttEndenceOrmorgscetor entity : entities){
            Serializable id=entity.getAttendenceormorgsectorid();
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



