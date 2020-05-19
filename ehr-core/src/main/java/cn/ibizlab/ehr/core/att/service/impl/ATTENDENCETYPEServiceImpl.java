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
import cn.ibizlab.ehr.core.att.domain.ATTENDENCETYPE;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCETYPESearchContext;
import cn.ibizlab.ehr.core.att.service.IATTENDENCETYPEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.ATTENDENCETYPEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤类型] 服务对象接口实现
 */
@Slf4j
@Service("ATTENDENCETYPEServiceImpl")
public class ATTENDENCETYPEServiceImpl extends ServiceImpl<ATTENDENCETYPEMapper, ATTENDENCETYPE> implements IATTENDENCETYPEService {


    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(ATTENDENCETYPE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ATTENDENCETYPE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<ATTENDENCETYPE> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(ATTENDENCETYPE et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendencetypeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ATTENDENCETYPE> list) {
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(ATTENDENCETYPE et) {
        return (!ObjectUtils.isEmpty(et.getAttendencetypeid()))&&(!Objects.isNull(this.getById(et.getAttendencetypeid())));
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
    public ATTENDENCETYPE get(String key) {
        ATTENDENCETYPE et = getById(key);
        if(et==null){
            et=new ATTENDENCETYPE();
            et.setAttendencetypeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public ATTENDENCETYPE getDraft(ATTENDENCETYPE et) {
        return et;
    }

    @Override
    @Transactional
    public boolean update(ATTENDENCETYPE et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendencetypeid",et.getAttendencetypeid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendencetypeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ATTENDENCETYPE> list) {
        updateBatchById(list,batchSize);
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ATTENDENCETYPE> searchDefault(ATTENDENCETYPESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDENCETYPE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDENCETYPE>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


