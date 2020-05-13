package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TRMTEACHERCHARGE;
import cn.ibizlab.ehr.core.trm.filter.TRMTEACHERCHARGESearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTEACHERCHARGEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTEACHERCHARGEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[讲师收费记录] 服务对象接口实现
 */
@Slf4j
@Service("TRMTEACHERCHARGEServiceImpl")
public class TRMTEACHERCHARGEServiceImpl extends ServiceImpl<TRMTEACHERCHARGEMapper, TRMTEACHERCHARGE> implements ITRMTEACHERCHARGEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService trmtrainteacherService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TRMTEACHERCHARGE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTEACHERCHARGE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMTEACHERCHARGE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMTEACHERCHARGE get(String key) {
        TRMTEACHERCHARGE et = getById(key);
        if(et==null){
            et=new TRMTEACHERCHARGE();
            et.setTrmteacherchargeid(key);
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
    public boolean update(TRMTEACHERCHARGE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmteacherchargeid",et.getTrmteacherchargeid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmteacherchargeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTEACHERCHARGE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(TRMTEACHERCHARGE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmteacherchargeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTEACHERCHARGE> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public TRMTEACHERCHARGE getDraft(TRMTEACHERCHARGE et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TRMTEACHERCHARGE et) {
        return (!ObjectUtils.isEmpty(et.getTrmteacherchargeid()))&&(!Objects.isNull(this.getById(et.getTrmteacherchargeid())));
    }


	@Override
    public List<TRMTEACHERCHARGE> selectByTrmtrainplantermid(String trmtrainplantermid) {
        return baseMapper.selectByTrmtrainplantermid(trmtrainplantermid);
    }

    @Override
    public void removeByTrmtrainplantermid(String trmtrainplantermid) {
        this.remove(new QueryWrapper<TRMTEACHERCHARGE>().eq("trmtrainplantermid",trmtrainplantermid));
    }

	@Override
    public List<TRMTEACHERCHARGE> selectByTrmtrainteacherid(String trmtrainteacherid) {
        return baseMapper.selectByTrmtrainteacherid(trmtrainteacherid);
    }

    @Override
    public void removeByTrmtrainteacherid(String trmtrainteacherid) {
        this.remove(new QueryWrapper<TRMTEACHERCHARGE>().eq("trmtrainteacherid",trmtrainteacherid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTEACHERCHARGE> searchDefault(TRMTEACHERCHARGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTEACHERCHARGE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTEACHERCHARGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTEACHERCHARGE et){
        //实体关系[DER1N_TRMTEACHERCHARGE_TRMTRAINPLANTERM_TRMTRAINPLANTERMID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplantermid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM trmtrainplanterm=et.getTrmtrainplanterm();
            if(ObjectUtils.isEmpty(trmtrainplanterm)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM majorEntity=trmtrainplantermService.get(et.getTrmtrainplantermid());
                et.setTrmtrainplanterm(majorEntity);
                trmtrainplanterm=majorEntity;
            }
            et.setTrmtrainplantermname(trmtrainplanterm.getTrmtrainplantermname());
        }
        //实体关系[DER1N_TRMTEACHERCHARGE_TRMTRAINTEACHER_TRMTRAINTEACHERID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainteacherid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER trmtrainteacher=et.getTrmtrainteacher();
            if(ObjectUtils.isEmpty(trmtrainteacher)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER majorEntity=trmtrainteacherService.get(et.getTrmtrainteacherid());
                et.setTrmtrainteacher(majorEntity);
                trmtrainteacher=majorEntity;
            }
            et.setTrmtrainteachername(trmtrainteacher.getTrmtrainteachername());
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


