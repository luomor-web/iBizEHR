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
import cn.ibizlab.ehr.core.par.domain.PARJGBMPJBZ;
import cn.ibizlab.ehr.core.par.filter.PARJGBMPJBZSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARJGBMPJBZService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARJGBMPJBZMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[部门评级标准] 服务对象接口实现
 */
@Slf4j
@Service("PARJGBMPJBZServiceImpl")
public class PARJGBMPJBZServiceImpl extends ServiceImpl<PARJGBMPJBZMapper, PARJGBMPJBZ> implements IPARJGBMPJBZService {


    private cn.ibizlab.ehr.core.par.service.IPARJGBMPJBZService parjgbmpjbzService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(PARJGBMPJBZ et) {
        return (!ObjectUtils.isEmpty(et.getParjgbmpjbzid()))&&(!Objects.isNull(this.getById(et.getParjgbmpjbzid())));
    }

    @Override
    @Transactional
    public PARJGBMPJBZ get(String key) {
        PARJGBMPJBZ et = getById(key);
        if(et==null){
            et=new PARJGBMPJBZ();
            et.setParjgbmpjbzid(key);
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
    public boolean create(PARJGBMPJBZ et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParjgbmpjbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARJGBMPJBZ> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PARJGBMPJBZ et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parjgbmpjbzid",et.getParjgbmpjbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getParjgbmpjbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARJGBMPJBZ> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARJGBMPJBZ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARJGBMPJBZ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARJGBMPJBZ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PARJGBMPJBZ getDraft(PARJGBMPJBZ et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PARJGBMPJBZ> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PARJGBMPJBZ>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PARJGBMPJBZ> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PARJGBMPJBZ>().eq("ormorgid",orgid));
    }

	@Override
    public List<PARJGBMPJBZ> selectByPjbzid(String parjgbmpjbzid) {
        return baseMapper.selectByPjbzid(parjgbmpjbzid);
    }

    @Override
    public void removeByPjbzid(String parjgbmpjbzid) {
        this.remove(new QueryWrapper<PARJGBMPJBZ>().eq("pjbzid",parjgbmpjbzid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARJGBMPJBZ> searchDefault(PARJGBMPJBZSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARJGBMPJBZ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARJGBMPJBZ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARJGBMPJBZ et){
        //实体关系[DER1N_PARJGBMPJBZ_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PARJGBMPJBZ_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PARJGBMPJBZ_PARJGBMPJBZ_PJBZID]
        if(!ObjectUtils.isEmpty(et.getPjbzid())){
            cn.ibizlab.ehr.core.par.domain.PARJGBMPJBZ pjbz=et.getPjbz();
            if(ObjectUtils.isEmpty(pjbz)){
                cn.ibizlab.ehr.core.par.domain.PARJGBMPJBZ majorEntity=parjgbmpjbzService.get(et.getPjbzid());
                et.setPjbz(majorEntity);
                pjbz=majorEntity;
            }
            et.setPjbzmc(pjbz.getParjgbmpjbzname());
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


