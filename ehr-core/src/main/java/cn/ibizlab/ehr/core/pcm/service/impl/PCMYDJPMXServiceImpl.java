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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDJPMX;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJPMXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDJPMXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMYDJPMXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[异动解聘明细] 服务对象接口实现
 */
@Slf4j
@Service("PCMYDJPMXServiceImpl")
public class PCMYDJPMXServiceImpl extends ServiceImpl<PCMYDJPMXMapper, PCMYDJPMX> implements IPCMYDJPMXService {


    private int batchSize = 500;

    @Override
    @Transactional
    public PCMYDJPMX fillPersonInfo(PCMYDJPMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PCMYDJPMX et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmydjpmxid",et.getPcmydjpmxid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjpmxid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMYDJPMX> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public PCMYDJPMX getDraft(PCMYDJPMX et) {
        return et;
    }

    @Override
    public boolean checkKey(PCMYDJPMX et) {
        return (!ObjectUtils.isEmpty(et.getPcmydjpmxid()))&&(!Objects.isNull(this.getById(et.getPcmydjpmxid())));
    }

    @Override
    @Transactional
    public boolean save(PCMYDJPMX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMYDJPMX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMYDJPMX> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMYDJPMX get(String key) {
        PCMYDJPMX et = getById(key);
        if(et==null){
            et=new PCMYDJPMX();
            et.setPcmydjpmxid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public PCMYDJPMX jPWC(PCMYDJPMX et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(PCMYDJPMX et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmydjpmxid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMYDJPMX> list) {
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



    /**
     * 查询集合 记录查询
     */
    @Override
    public Page<PCMYDJPMX> searchJLDS(PCMYDJPMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJPMX> pages=baseMapper.searchJLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJPMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMYDJPMX> searchDefault(PCMYDJPMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJPMX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJPMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 管理查询
     */
    @Override
    public Page<PCMYDJPMX> searchGLDS(PCMYDJPMXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMYDJPMX> pages=baseMapper.searchGLDS(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMYDJPMX>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


