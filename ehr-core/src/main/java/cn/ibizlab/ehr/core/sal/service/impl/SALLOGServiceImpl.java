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
import cn.ibizlab.ehr.core.sal.domain.SALLOG;
import cn.ibizlab.ehr.core.sal.filter.SALLOGSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALLOGService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALLOGMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬调整日志] 服务对象接口实现
 */
@Slf4j
@Service("SALLOGServiceImpl")
public class SALLOGServiceImpl extends ServiceImpl<SALLOGMapper, SALLOG> implements ISALLOGService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYDETAILService salsalarydetailService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;

    private int batchSize = 500;

    @Override
    @Transactional
    public SALLOG get(String key) {
        SALLOG et = getById(key);
        if(et==null){
            et=new SALLOG();
            et.setSallogid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(SALLOG et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("sallogid",et.getSallogid())))
            return false;
        CachedBeanCopier.copy(get(et.getSallogid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALLOG> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    public boolean create(SALLOG et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSallogid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALLOG> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(SALLOG et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALLOG et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<SALLOG> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public SALLOG getDraft(SALLOG et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(SALLOG et) {
        return (!ObjectUtils.isEmpty(et.getSallogid()))&&(!Objects.isNull(this.getById(et.getSallogid())));
    }


	@Override
    public List<SALLOG> selectBySalsalarydetailid(String salsalarydetailid) {
        return baseMapper.selectBySalsalarydetailid(salsalarydetailid);
    }

    @Override
    public void removeBySalsalarydetailid(String salsalarydetailid) {
        this.remove(new QueryWrapper<SALLOG>().eq("salsalarydetailid",salsalarydetailid));
    }

	@Override
    public List<SALLOG> selectBySalsalaryid(String salsalaryid) {
        return baseMapper.selectBySalsalaryid(salsalaryid);
    }

    @Override
    public void removeBySalsalaryid(String salsalaryid) {
        this.remove(new QueryWrapper<SALLOG>().eq("salsalaryid",salsalaryid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALLOG> searchDefault(SALLOGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALLOG> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALLOG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALLOG et){
        //实体关系[DER1N_SALLOG_SALSALARYDETAIL_SALSALARYDETAILID]
        if(!ObjectUtils.isEmpty(et.getSalsalarydetailid())){
            cn.ibizlab.ehr.core.sal.domain.SALSALARYDETAIL salsalarydetail=et.getSalsalarydetail();
            if(ObjectUtils.isEmpty(salsalarydetail)){
                cn.ibizlab.ehr.core.sal.domain.SALSALARYDETAIL majorEntity=salsalarydetailService.get(et.getSalsalarydetailid());
                et.setSalsalarydetail(majorEntity);
                salsalarydetail=majorEntity;
            }
            et.setSalsalarydetailname(salsalarydetail.getSalsalarydetailname());
        }
        //实体关系[DER1N_SALLOG_SALSALARY_SALSALARYID]
        if(!ObjectUtils.isEmpty(et.getSalsalaryid())){
            cn.ibizlab.ehr.core.sal.domain.SALSALARY salsalary=et.getSalsalary();
            if(ObjectUtils.isEmpty(salsalary)){
                cn.ibizlab.ehr.core.sal.domain.SALSALARY majorEntity=salsalaryService.get(et.getSalsalaryid());
                et.setSalsalary(majorEntity);
                salsalary=majorEntity;
            }
            et.setSalsalaryname(salsalary.getSalsalaryname());
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


