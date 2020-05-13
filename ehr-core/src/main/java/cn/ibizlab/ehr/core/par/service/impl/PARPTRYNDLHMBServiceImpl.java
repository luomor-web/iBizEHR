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
import cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMB;
import cn.ibizlab.ehr.core.par.filter.PARPTRYNDLHMBSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARPTRYNDLHMBService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARPTRYNDLHMBMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[年度量化目标（部门副职及以下人员）] 服务对象接口实现
 */
@Slf4j
@Service("PARPTRYNDLHMBServiceImpl")
public class PARPTRYNDLHMBServiceImpl extends ServiceImpl<PARPTRYNDLHMBMapper, PARPTRYNDLHMB> implements IPARPTRYNDLHMBService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.par.service.IPARPTRYNDLHMBMXService parptryndlhmbmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PARPTRYNDLHMB get(String key) {
        PARPTRYNDLHMB et = getById(key);
        if(et==null){
            et=new PARPTRYNDLHMB();
            et.setParptryndlhmbid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARPTRYNDLHMB et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParptryndlhmbid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARPTRYNDLHMB> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
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
    public boolean update(PARPTRYNDLHMB et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parptryndlhmbid",et.getParptryndlhmbid())))
            return false;
        CachedBeanCopier.copy(get(et.getParptryndlhmbid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARPTRYNDLHMB> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARPTRYNDLHMB et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARPTRYNDLHMB et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARPTRYNDLHMB> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PARPTRYNDLHMB getDraft(PARPTRYNDLHMB et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PARPTRYNDLHMB et) {
        return (!ObjectUtils.isEmpty(et.getParptryndlhmbid()))&&(!Objects.isNull(this.getById(et.getParptryndlhmbid())));
    }


	@Override
    public List<PARPTRYNDLHMB> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PARPTRYNDLHMB>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARPTRYNDLHMB> searchDefault(PARPTRYNDLHMBSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARPTRYNDLHMB> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARPTRYNDLHMB>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARPTRYNDLHMB et){
        //实体关系[DER1N_PARPTRYNDLHMB_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
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

}


