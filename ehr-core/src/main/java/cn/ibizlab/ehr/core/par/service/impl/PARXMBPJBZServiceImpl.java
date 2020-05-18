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
import cn.ibizlab.ehr.core.par.domain.PARXMBPJBZ;
import cn.ibizlab.ehr.core.par.filter.PARXMBPJBZSearchContext;
import cn.ibizlab.ehr.core.par.service.IPARXMBPJBZService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.par.mapper.PARXMBPJBZMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[项目部评级标准] 服务对象接口实现
 */
@Slf4j
@Service("PARXMBPJBZServiceImpl")
public class PARXMBPJBZServiceImpl extends ServiceImpl<PARXMBPJBZMapper, PARXMBPJBZ> implements IPARXMBPJBZService {


    private cn.ibizlab.ehr.core.par.service.IPARXMBPJBZService parxmbpjbzService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PARXMBPJBZ get(String key) {
        PARXMBPJBZ et = getById(key);
        if(et==null){
            et=new PARXMBPJBZ();
            et.setParxmbpjbzid(key);
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
    public boolean checkKey(PARXMBPJBZ et) {
        return (!ObjectUtils.isEmpty(et.getParxmbpjbzid()))&&(!Objects.isNull(this.getById(et.getParxmbpjbzid())));
    }

    @Override
    @Transactional
    public boolean update(PARXMBPJBZ et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("parxmbpjbzid",et.getParxmbpjbzid())))
            return false;
        CachedBeanCopier.copy(get(et.getParxmbpjbzid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PARXMBPJBZ> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PARXMBPJBZ et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getParxmbpjbzid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PARXMBPJBZ> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PARXMBPJBZ et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PARXMBPJBZ et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PARXMBPJBZ> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public PARXMBPJBZ getDraft(PARXMBPJBZ et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PARXMBPJBZ> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PARXMBPJBZ>().eq("ormorgid",orgid));
    }

	@Override
    public List<PARXMBPJBZ> selectByXmbpjbzid(String parxmbpjbzid) {
        return baseMapper.selectByXmbpjbzid(parxmbpjbzid);
    }

    @Override
    public void removeByXmbpjbzid(String parxmbpjbzid) {
        this.remove(new QueryWrapper<PARXMBPJBZ>().eq("xmbpjbzid",parxmbpjbzid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PARXMBPJBZ> searchDefault(PARXMBPJBZSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PARXMBPJBZ> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PARXMBPJBZ>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PARXMBPJBZ et){
        //实体关系[DER1N_PARXMBPJBZ_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_PARXMBPJBZ_PARXMBPJBZ_XMBPJBZID]
        if(!ObjectUtils.isEmpty(et.getXmbpjbzid())){
            cn.ibizlab.ehr.core.par.domain.PARXMBPJBZ parxmbpjbz=et.getParxmbpjbz();
            if(ObjectUtils.isEmpty(parxmbpjbz)){
                cn.ibizlab.ehr.core.par.domain.PARXMBPJBZ majorEntity=parxmbpjbzService.get(et.getXmbpjbzid());
                et.setParxmbpjbz(majorEntity);
                parxmbpjbz=majorEntity;
            }
            et.setXmbpjbzmc(parxmbpjbz.getParxmbpjbzname());
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


