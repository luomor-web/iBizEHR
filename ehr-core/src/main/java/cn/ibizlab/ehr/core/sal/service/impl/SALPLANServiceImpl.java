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
import cn.ibizlab.ehr.core.sal.domain.SALPLAN;
import cn.ibizlab.ehr.core.sal.filter.SALPLANSearchContext;
import cn.ibizlab.ehr.core.sal.service.ISALPLANService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.sal.mapper.SALPLANMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[薪酬计算计划] 服务对象接口实现
 */
@Slf4j
@Service("SALPLANServiceImpl")
public class SALPLANServiceImpl extends ServiceImpl<SALPLANMapper, SALPLAN> implements ISALPLANService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSALARYService salsalaryService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.sal.service.ISALSCHEMEService salschemeService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SALPLAN et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSalplanid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SALPLAN> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    public boolean checkKey(SALPLAN et) {
        return (!ObjectUtils.isEmpty(et.getSalplanid()))&&(!Objects.isNull(this.getById(et.getSalplanid())));
    }

    @Override
    @Transactional
    public boolean save(SALPLAN et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SALPLAN et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<SALPLAN> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public SALPLAN getDraft(SALPLAN et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(SALPLAN et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("salplanid",et.getSalplanid())))
            return false;
        CachedBeanCopier.copy(get(et.getSalplanid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SALPLAN> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public SALPLAN get(String key) {
        SALPLAN et = getById(key);
        if(et==null){
            et=new SALPLAN();
            et.setSalplanid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<SALPLAN> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<SALPLAN>().eq("ormorgid",orgid));
    }

	@Override
    public List<SALPLAN> selectBySalschemeid(String salschemeid) {
        return baseMapper.selectBySalschemeid(salschemeid);
    }

    @Override
    public void removeBySalschemeid(String salschemeid) {
        this.remove(new QueryWrapper<SALPLAN>().eq("salschemeid",salschemeid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SALPLAN> searchDefault(SALPLANSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SALPLAN> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SALPLAN>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SALPLAN et){
        //实体关系[DER1N_SALPLAN_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_SALPLAN_SALSCHEME_SALSCHEMEID]
        if(!ObjectUtils.isEmpty(et.getSalschemeid())){
            cn.ibizlab.ehr.core.sal.domain.SALSCHEME salscheme=et.getSalscheme();
            if(ObjectUtils.isEmpty(salscheme)){
                cn.ibizlab.ehr.core.sal.domain.SALSCHEME majorEntity=salschemeService.get(et.getSalschemeid());
                et.setSalscheme(majorEntity);
                salscheme=majorEntity;
            }
            et.setSalschemename(salscheme.getSalschemename());
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


