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
import cn.ibizlab.ehr.core.par.domain.PARJXNDKHJG;
import cn.ibizlab.ehr.core.par.filter.PARJXNDKHJGSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARJXNDKHJGService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARJXNDKHJGMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[绩效年度考核结果] 服务对象接口实现
 */
@Slf4j
@Service("PARJXNDKHJGServiceImpl")
public class PARJXNDKHJGServiceImpl extends ServiceImpl<PARJXNDKHJGMapper, PARJXNDKHJG> implements IPARJXNDKHJGService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PARJXNDKHJG et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARJXNDKHJG et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARJXNDKHJG> list) {
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
    public PARJXNDKHJG getDraft(PARJXNDKHJG et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean create(PARJXNDKHJG et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjxndkhjgid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARJXNDKHJG> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PARJXNDKHJG et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjxndkhjgid",et.getParjxndkhjgid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjxndkhjgid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARJXNDKHJG> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PARJXNDKHJG get(String key) {
        PARJXNDKHJG et = getById(key);
        if(et==null){
            et=new PARJXNDKHJG();
            et.setParjxndkhjgid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PARJXNDKHJG et) {
        return (!ObjectUtils.isEmpty(et.getParjxndkhjgid()))&&(!Objects.isNull(this.getById(et.getParjxndkhjgid())));
    }


	@Override
    public List<PARJXNDKHJG> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PARJXNDKHJG>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARJXNDKHJG> searchDefault(PARJXNDKHJGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJXNDKHJG> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJXNDKHJG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 最近2年下半年考核成绩
     */
    @Override
    public Page<PARJXNDKHJG> searchLastTwoYear(PARJXNDKHJGSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJXNDKHJG> pages=baseMapper.searchLastTwoYear(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJXNDKHJG>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARJXNDKHJG et){
        //实体关系[DER1N_PARJXNDKHJG_PIMPERSON_PIMPERSONID]
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


