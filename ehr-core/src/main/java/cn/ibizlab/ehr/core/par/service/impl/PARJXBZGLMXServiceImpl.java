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
import cn.ibizlab.ehr.core.par.domain.PARJXBZGLMX;
import cn.ibizlab.ehr.core.par.filter.PARJXBZGLMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARJXBZGLMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARJXBZGLMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效标准管理明细] 服务对象接口实现
 */
@Slf4j
@Service("PARJXBZGLMXServiceImpl")
public class PARJXBZGLMXServiceImpl extends ServiceImpl<PARJXBZGLMXMapper, PARJXBZGLMX> implements IPARJXBZGLMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARJXBZGLService parjxbzglService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PARJXBZGLMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxbzglmxid",et.getParjxbzglmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxbzglmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARJXBZGLMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARJXBZGLMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARJXBZGLMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARJXBZGLMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PARJXBZGLMX get(String key) {
        PARJXBZGLMX et = getById(key);
        if(et==null){
            et=new PARJXBZGLMX();
            et.setParjxbzglmxid(key);
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
    public boolean create(PARJXBZGLMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxbzglmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARJXBZGLMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public PARJXBZGLMX getDraft(PARJXBZGLMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PARJXBZGLMX et) {
        return (!ObjectUtils.isEmpty(et.getParjxbzglmxid()))&&(!Objects.isNull(this.getById(et.getParjxbzglmxid())));
    }


	@Override
    public List<PARJXBZGLMX> selectByParjxbzglid(String parjxbzglid) {
        return baseMapper.selectByParjxbzglid(parjxbzglid);
    }

    @Override
    public void removeByParjxbzglid(String parjxbzglid) {
        this.remove(new QueryWrapper<PARJXBZGLMX>().eq("parjxbzglid",parjxbzglid));
    }

	@Override
    public List<PARJXBZGLMX> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PARJXBZGLMX>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARJXBZGLMX> searchDefault(PARJXBZGLMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJXBZGLMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJXBZGLMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARJXBZGLMX et){
        //实体关系[DER1N_PARJXBZGLMX_PARJXBZGL_PARJXBZGLID]
        if(!ObjectUtils.isEmpty(et.getParjxbzglid())){
            cn.ibizlab.ehr.core.par.domain.PARJXBZGL parjxbzgl=et.getParjxbzgl();
            if(ObjectUtils.isEmpty(parjxbzgl)){
                cn.ibizlab.ehr.core.par.domain.PARJXBZGL majorEntity=parjxbzglService.get(et.getParjxbzglid());
                et.setParjxbzgl(majorEntity);
                parjxbzgl=majorEntity;
            }
            et.setParjxbzglname(parjxbzgl.getParjxbzglname());
        }
        //实体关系[DER1N_PARJXBZGLMX_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setBm(pimperson.getOrmorgsectorname());
            et.setZz(pimperson.getOrmorgname());
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


