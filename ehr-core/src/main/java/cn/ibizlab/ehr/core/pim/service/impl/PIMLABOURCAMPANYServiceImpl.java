package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PIMLABOURCAMPANY;
import cn.ibizlab.ehr.core.pim.filter.PIMLABOURCAMPANYSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMLABOURCAMPANYService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMLABOURCAMPANYMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[劳务派遣公司管理] 服务对象接口实现
 */
@Slf4j
@Service("PIMLABOURCAMPANYServiceImpl")
public class PIMLABOURCAMPANYServiceImpl extends ServiceImpl<PIMLABOURCAMPANYMapper, PIMLABOURCAMPANY> implements IPIMLABOURCAMPANYService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTService pimcontractService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PIMLABOURCAMPANY et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMLABOURCAMPANY et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMLABOURCAMPANY> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PIMLABOURCAMPANY et) {
        return (!ObjectUtils.isEmpty(et.getPimlabourcampanyid()))&&(!Objects.isNull(this.getById(et.getPimlabourcampanyid())));
    }

    @Override
    @Transactional
    public boolean update(PIMLABOURCAMPANY et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimlabourcampanyid",et.getPimlabourcampanyid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimlabourcampanyid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMLABOURCAMPANY> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMLABOURCAMPANY et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimlabourcampanyid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMLABOURCAMPANY> list) {
        list.forEach(item->fillParentData(item));
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

    @Override
    @Transactional
    public PIMLABOURCAMPANY get(String key) {
        PIMLABOURCAMPANY et = getById(key);
        if(et==null){
            et=new PIMLABOURCAMPANY();
            et.setPimlabourcampanyid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PIMLABOURCAMPANY getDraft(PIMLABOURCAMPANY et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PIMLABOURCAMPANY> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PIMLABOURCAMPANY>().eq("ormorgid",orgid));
    }

	@Override
    public List<PIMLABOURCAMPANY> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMLABOURCAMPANY>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 AuthLab
     */
    @Override
    public Page<PIMLABOURCAMPANY> searchAuthLab(PIMLABOURCAMPANYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMLABOURCAMPANY> pages=baseMapper.searchAuthLab(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMLABOURCAMPANY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMLABOURCAMPANY> searchDefault(PIMLABOURCAMPANYSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMLABOURCAMPANY> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMLABOURCAMPANY>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMLABOURCAMPANY et){
        //实体关系[DER1N_PIMLABOURCAMPANY_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PIMLABOURCAMPANY_PIMPERSON_PIMPERSONID]
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


