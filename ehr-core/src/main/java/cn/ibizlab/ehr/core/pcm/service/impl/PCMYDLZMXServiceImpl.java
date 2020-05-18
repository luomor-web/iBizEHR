package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDLZMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDLZMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDLZMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDLZMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动离职明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDLZMXServiceImpl")
public class PCMYDLZMXServiceImpl extends ServiceImpl<PCMYDLZMXMapper, PCMYDLZMX> implements IPCMYDLZMXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PCMYDLZMX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydlzmxid",et.getPcmydlzmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydlzmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDLZMX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PCMYDLZMX fillPersonInfo(PCMYDLZMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PCMYDLZMX get(String key) {
        PCMYDLZMX et = getById(key);
        if(et==null){
            et=new PCMYDLZMX();
            et.setPcmydlzmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMYDLZMX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydlzmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDLZMX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMYDLZMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmydlzmxid()))&&(!Objects.isNull(this.getById(et.getPcmydlzmxid())));
    }

    @Override
    @Transactional
    public PCMYDLZMX finishLZ(PCMYDLZMX et) {
        //自定义代码
        return et;
    }

    @Override
    public PCMYDLZMX getDraft(PCMYDLZMX et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMYDLZMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDLZMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMYDLZMX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
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
    public List<PCMYDLZMX> selectByLzmtrid(String pimpersonid) {
        return baseMapper.selectByLzmtrid(pimpersonid);
    }

    @Override
    public void removeByLzmtrid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMYDLZMX>().eq("lzmtrid",pimpersonid));
    }


    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PCMYDLZMX> searchGLDQ(PCMYDLZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDLZMX> pages=baseMapper.searchGLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDLZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 记录查询
     */
    @Override
    public Page<PCMYDLZMX> searchJLDQ(PCMYDLZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDLZMX> pages=baseMapper.searchJLDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDLZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDLZMX> searchDefault(PCMYDLZMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDLZMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDLZMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMYDLZMX et){
        //实体关系[DER1N_PCMYDLZMX_PIMPERSON_LZMTRID]
        if(!ObjectUtils.isEmpty(et.getLzmtrid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON lzmtr=et.getLzmtr();
            if(ObjectUtils.isEmpty(lzmtr)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getLzmtrid());
                et.setLzmtr(majorEntity);
                lzmtr=majorEntity;
            }
            et.setLzmtrname(lzmtr.getPimpersonname());
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


