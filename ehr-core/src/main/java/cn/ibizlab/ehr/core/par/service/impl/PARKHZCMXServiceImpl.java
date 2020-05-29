package cn.ibizlab.ehr.core.par.service.impl;

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
import cn.ibizlab.ehr.core.par.domain.PARKHZCMX;
import cn.ibizlab.ehr.core.par.filter.PARKHZCMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARKHZCMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARKHZCMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考核内容] 服务对象接口实现
 */
@Slf4j
@Service("PARKHZCMXServiceImpl")
public class PARKHZCMXServiceImpl extends ServiceImpl<PARKHZCMXMapper, PARKHZCMX> implements IPARKHZCMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IParDxkhnrmxService pardxkhnrmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARLDKHQZService parldkhqzService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXKHJCSZService parjxkhjcszService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PARKHZCMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParkhzcmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARKHZCMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARKHZCMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARKHZCMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PARKHZCMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PARKHZCMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PARKHZCMX get(String key) {
        PARKHZCMX et = getById(key);
        if(et==null){
            et=new PARKHZCMX();
            et.setParkhzcmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PARKHZCMX getDraft(PARKHZCMX et) {
        fillParentData(et);
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
    public boolean checkKey(PARKHZCMX et) {
        return (!ObjectUtils.isEmpty(et.getParkhzcmxid()))&&(!Objects.isNull(this.getById(et.getParkhzcmxid())));
    }

    @Override
    @Transactional
    public boolean update(PARKHZCMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parkhzcmxid",et.getParkhzcmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParkhzcmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARKHZCMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<PARKHZCMX> selectByParjxkhjcszid(String parjxkhjcszid) {
        return baseMapper.selectByParjxkhjcszid(parjxkhjcszid);
    }

    @Override
    public void removeByParjxkhjcszid(String parjxkhjcszid) {
        this.remove(new QueryWrapper<PARKHZCMX>().eq("parjxkhjcszid",parjxkhjcszid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARKHZCMX> searchDefault(PARKHZCMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARKHZCMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARKHZCMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARKHZCMX et){
        //实体关系[DER1N_PARKHZCMX_PARJXKHJCSZ_PARJXKHJCSZID]
        if(!ObjectUtils.isEmpty(et.getParjxkhjcszid())){
            cn.ibizlab.ehr.core.par.domain.PARJXKHJCSZ parjxkhjcsz=et.getParjxkhjcsz();
            if(ObjectUtils.isEmpty(parjxkhjcsz)){
                cn.ibizlab.ehr.core.par.domain.PARJXKHJCSZ majorEntity=parjxkhjcszService.get(et.getParjxkhjcszid());
                et.setParjxkhjcsz(majorEntity);
                parjxkhjcsz=majorEntity;
            }
            et.setKhdx(parjxkhjcsz.getKhlx());
            et.setParjxkhjcszname(parjxkhjcsz.getParjxkhjcszname());
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
    public List<PARKHZCMX> getParkhzcmxByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PARKHZCMX> getParkhzcmxByEntities(List<PARKHZCMX> entities) {
        List ids =new ArrayList();
        for(PARKHZCMX entity : entities){
            Serializable id=entity.getParkhzcmxid();
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


