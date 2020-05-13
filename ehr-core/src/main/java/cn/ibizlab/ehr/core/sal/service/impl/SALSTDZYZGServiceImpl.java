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
import cn.ibizlab.ehr.core.sal.domain.SALSTDZYZG;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZYZGSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALSTDZYZGService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALSTDZYZGMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[执业资格津贴标准] 服务对象接口实现
 */
@Slf4j
@Service("SALSTDZYZGServiceImpl")
public class SALSTDZYZGServiceImpl extends ServiceImpl<SALSTDZYZGMapper, SALSTDZYZG> implements ISALSTDZYZGService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(SALSTDZYZG et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salstdzyzgid",et.getSalstdzyzgid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalstdzyzgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALSTDZYZG> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public SALSTDZYZG get(String key) {
        SALSTDZYZG et = getById(key);
        if(et==null){
            et=new SALSTDZYZG();
            et.setSalstdzyzgid(key);
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
    public boolean create(SALSTDZYZG et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalstdzyzgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALSTDZYZG> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public SALSTDZYZG getDraft(SALSTDZYZG et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SALSTDZYZG et) {
        return (!ObjectUtils.isEmpty(et.getSalstdzyzgid()))&&(!Objects.isNull(this.getById(et.getSalstdzyzgid())));
    }

    @Override
    @Transactional
    public boolean save(SALSTDZYZG et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALSTDZYZG et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<SALSTDZYZG> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<SALSTDZYZG> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<SALSTDZYZG>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALSTDZYZG> searchDefault(SALSTDZYZGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALSTDZYZG> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALSTDZYZG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALSTDZYZG et){
        //实体关系[DER1N_SALSTDZYZG_ORMORG_ORMORGID]
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

}


