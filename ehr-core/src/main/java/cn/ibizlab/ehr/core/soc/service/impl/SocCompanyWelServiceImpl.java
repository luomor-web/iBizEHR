package cn.ibizlab.ehr.core.soc.service.impl;

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
import cn.ibizlab.ehr.core.soc.domain.SocCompanyWel;
import cn.ibizlab.ehr.core.soc.filter.SocCompanyWelSearchContext;
import cn.ibizlab.ehr.core.soc.service.ISocCompanyWelService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.soc.mapper.SocCompanyWelMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[单位社保账户] 服务对象接口实现
 */
@Slf4j
@Service("SocCompanyWelServiceImpl")
public class SocCompanyWelServiceImpl extends ServiceImpl<SocCompanyWelMapper, SocCompanyWel> implements ISocCompanyWelService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocSelfarebasemxService socselfarebasemxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocWelfareInfoService socwelfareinfoService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IOrmOrgService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.soc.service.ISocSelfareBaseService socselfarebaseService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(SocCompanyWel et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getSoccompanywelid()),et);
        return true;
    }

    @Override
    public void createBatch(List<SocCompanyWel> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(SocCompanyWel et) {
        return (!ObjectUtils.isEmpty(et.getSoccompanywelid()))&&(!Objects.isNull(this.getById(et.getSoccompanywelid())));
    }
    @Override
    @Transactional
    public boolean save(SocCompanyWel et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(SocCompanyWel et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<SocCompanyWel> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<SocCompanyWel> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(SocCompanyWel et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("soccompanywelid",et.getSoccompanywelid())))
            return false;
        CachedBeanCopier.copy(get(et.getSoccompanywelid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<SocCompanyWel> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public SocCompanyWel get(String key) {
        SocCompanyWel et = getById(key);
        if(et==null){
            et=new SocCompanyWel();
            et.setSoccompanywelid(key);
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
    public SocCompanyWel getDraft(SocCompanyWel et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<SocCompanyWel> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<SocCompanyWel>().eq("ormorgid",orgid));
    }

	@Override
    public List<SocCompanyWel> selectBySocselfarebaseid(String socselfarebaseid) {
        return baseMapper.selectBySocselfarebaseid(socselfarebaseid);
    }

    @Override
    public void removeBySocselfarebaseid(String socselfarebaseid) {
        this.remove(new QueryWrapper<SocCompanyWel>().eq("socselfarebaseid",socselfarebaseid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SocCompanyWel> searchDefault(SocCompanyWelSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SocCompanyWel> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<SocCompanyWel>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(SocCompanyWel et){
        //实体关系[DER1N_SOCCOMPANYWEL_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.OrmOrg majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_SOCCOMPANYWEL_SOCSELFAREBASE_SOCSELFAREBASEID]
        if(!ObjectUtils.isEmpty(et.getSocselfarebaseid())){
            cn.ibizlab.ehr.core.soc.domain.SocSelfareBase socselfarebase=et.getSocselfarebase();
            if(ObjectUtils.isEmpty(socselfarebase)){
                cn.ibizlab.ehr.core.soc.domain.SocSelfareBase majorEntity=socselfarebaseService.get(et.getSocselfarebaseid());
                et.setSocselfarebase(majorEntity);
                socselfarebase=majorEntity;
            }
            et.setSocselfarebasename(socselfarebase.getSocselfarebasename());
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

    @Override
    public List<SocCompanyWel> getSoccompanywelByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<SocCompanyWel> getSoccompanywelByEntities(List<SocCompanyWel> entities) {
        List ids =new ArrayList();
        for(SocCompanyWel entity : entities){
            Serializable id=entity.getSoccompanywelid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



