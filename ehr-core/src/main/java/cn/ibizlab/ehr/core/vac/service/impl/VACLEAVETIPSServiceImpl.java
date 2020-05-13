package cn.ibizlab.ehr.core.vac.service.impl;

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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVETIPS;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVETIPSSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVETIPSService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VACLEAVETIPSMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假提示] 服务对象接口实现
 */
@Slf4j
@Service("VACLEAVETIPSServiceImpl")
public class VACLEAVETIPSServiceImpl extends ServiceImpl<VACLEAVETIPSMapper, VACLEAVETIPS> implements IVACLEAVETIPSService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYRULESService vacholidayrulesService;

    private int batchSize = 500;

    @Override
    @Transactional
    public VACLEAVETIPS checkQJZL(VACLEAVETIPS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(VACLEAVETIPS et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavetipsid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VACLEAVETIPS> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    public VACLEAVETIPS getDraft(VACLEAVETIPS et) {
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
    public boolean checkKey(VACLEAVETIPS et) {
        return (!ObjectUtils.isEmpty(et.getVacleavetipsid()))&&(!Objects.isNull(this.getById(et.getVacleavetipsid())));
    }

    @Override
    @Transactional
    public VACLEAVETIPS checkRepeat(VACLEAVETIPS et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public VACLEAVETIPS get(String key) {
        VACLEAVETIPS et = getById(key);
        if(et==null){
            et=new VACLEAVETIPS();
            et.setVacleavetipsid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(VACLEAVETIPS et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavetipsid",et.getVacleavetipsid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavetipsid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VACLEAVETIPS> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(VACLEAVETIPS et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VACLEAVETIPS et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<VACLEAVETIPS> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<VACLEAVETIPS> selectByVacholidayrulesid(String vacholidayrulesid) {
        return baseMapper.selectByVacholidayrulesid(vacholidayrulesid);
    }

    @Override
    public void removeByVacholidayrulesid(String vacholidayrulesid) {
        this.remove(new QueryWrapper<VACLEAVETIPS>().eq("vacholidayrulesid",vacholidayrulesid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VACLEAVETIPS> searchDefault(VACLEAVETIPSSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VACLEAVETIPS> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VACLEAVETIPS>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VACLEAVETIPS et){
        //实体关系[DER1N_VACLEAVETIPS_VACHOLIDAYRULES_VACHOLIDAYRULESID]
        if(!ObjectUtils.isEmpty(et.getVacholidayrulesid())){
            cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES vacholidayrules=et.getVacholidayrules();
            if(ObjectUtils.isEmpty(vacholidayrules)){
                cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES majorEntity=vacholidayrulesService.get(et.getVacholidayrulesid());
                et.setVacholidayrules(majorEntity);
                vacholidayrules=majorEntity;
            }
            et.setVacholidayrulesname(vacholidayrules.getVacholidayrulesname());
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

