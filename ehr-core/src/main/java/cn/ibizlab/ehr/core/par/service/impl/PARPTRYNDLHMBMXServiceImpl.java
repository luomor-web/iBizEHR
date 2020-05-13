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
import cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMBMX;
import cn.ibizlab.ehr.core.par.filter.PARPTRYNDLHMBMXSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARPTRYNDLHMBMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARPTRYNDLHMBMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标明细（部门副职及以下人员）] 服务对象接口实现
 */
@Slf4j
@Service("PARPTRYNDLHMBMXServiceImpl")
public class PARPTRYNDLHMBMXServiceImpl extends ServiceImpl<PARPTRYNDLHMBMXMapper, PARPTRYNDLHMBMX> implements IPARPTRYNDLHMBMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARPTRYNDLHMBService parptryndlhmbService;

    private int batchSize = 500;

    @Override
    public PARPTRYNDLHMBMX getDraft(PARPTRYNDLHMBMX et) {
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
    public boolean checkKey(PARPTRYNDLHMBMX et) {
        return (!ObjectUtils.isEmpty(et.getParptryndlhmbmxid()))&&(!Objects.isNull(this.getById(et.getParptryndlhmbmxid())));
    }

    @Override
    @Transactional
    public PARPTRYNDLHMBMX get(String key) {
        PARPTRYNDLHMBMX et = getById(key);
        if(et==null){
            et=new PARPTRYNDLHMBMX();
            et.setParptryndlhmbmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PARPTRYNDLHMBMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARPTRYNDLHMBMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARPTRYNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PARPTRYNDLHMBMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parptryndlhmbmxid",et.getParptryndlhmbmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getParptryndlhmbmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARPTRYNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PARPTRYNDLHMBMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParptryndlhmbmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARPTRYNDLHMBMX> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }


	@Override
    public List<PARPTRYNDLHMBMX> selectByParptryndlhmbid(String parptryndlhmbid) {
        return baseMapper.selectByParptryndlhmbid(parptryndlhmbid);
    }

    @Override
    public void removeByParptryndlhmbid(String parptryndlhmbid) {
        this.remove(new QueryWrapper<PARPTRYNDLHMBMX>().eq("parptryndlhmbid",parptryndlhmbid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARPTRYNDLHMBMX> searchDefault(PARPTRYNDLHMBMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARPTRYNDLHMBMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARPTRYNDLHMBMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARPTRYNDLHMBMX et){
        //实体关系[DER1N_PARPTRYNDLHMBMX_PARPTRYNDLHMB_PARPTRYNDLHMBID]
        if(!ObjectUtils.isEmpty(et.getParptryndlhmbid())){
            cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMB parptryndlhmb=et.getParptryndlhmb();
            if(ObjectUtils.isEmpty(parptryndlhmb)){
                cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMB majorEntity=parptryndlhmbService.get(et.getParptryndlhmbid());
                et.setParptryndlhmb(majorEntity);
                parptryndlhmb=majorEntity;
            }
            et.setParptryndlhmbname(parptryndlhmb.getParptryndlhmbname());
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


