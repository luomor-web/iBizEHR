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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESLOANANDRETURN;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESLOANANDRETURNSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESLOANANDRETURNService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMARCHIVESLOANANDRETURNMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案借阅及归还记录] 服务对象接口实现
 */
@Slf4j
@Service("PIMARCHIVESLOANANDRETURNServiceImpl")
public class PIMARCHIVESLOANANDRETURNServiceImpl extends ServiceImpl<PIMARCHIVESLOANANDRETURNMapper, PIMARCHIVESLOANANDRETURN> implements IPIMARCHIVESLOANANDRETURNService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPIMARCHIVESLOANANDRETURNUpdateArchiveStateLogic updatearchivestateLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPIMARCHIVESLOANANDRETURNUpdateStateLogic updatestateLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PIMARCHIVESLOANANDRETURN get(String key) {
        PIMARCHIVESLOANANDRETURN et = getById(key);
        if(et==null){
            et=new PIMARCHIVESLOANANDRETURN();
            et.setPimarchivesloanandreturnid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PIMARCHIVESLOANANDRETURN et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarchivesloanandreturnid",et.getPimarchivesloanandreturnid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesloanandreturnid()),et);
        updatearchivestateLogic.execute(et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMARCHIVESLOANANDRETURN> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PIMARCHIVESLOANANDRETURN et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesloanandreturnid()),et);
        updatearchivestateLogic.execute(et);
        return true;
    }

    @Override
    public void createBatch(List<PIMARCHIVESLOANANDRETURN> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PIMARCHIVESLOANANDRETURN getDraft(PIMARCHIVESLOANANDRETURN et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PIMARCHIVESLOANANDRETURN et) {
        return (!ObjectUtils.isEmpty(et.getPimarchivesloanandreturnid()))&&(!Objects.isNull(this.getById(et.getPimarchivesloanandreturnid())));
    }

    @Override
    @Transactional
    public PIMARCHIVESLOANANDRETURN updateState(PIMARCHIVESLOANANDRETURN et) {
        updatestateLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean save(PIMARCHIVESLOANANDRETURN et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMARCHIVESLOANANDRETURN et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PIMARCHIVESLOANANDRETURN> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PIMARCHIVESLOANANDRETURN> list) {
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
    @Transactional
    public PIMARCHIVESLOANANDRETURN updateArchiveState(PIMARCHIVESLOANANDRETURN et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PIMARCHIVESLOANANDRETURN> selectByPimarchivesid(String pimarchivesid) {
        return baseMapper.selectByPimarchivesid(pimarchivesid);
    }

    @Override
    public void removeByPimarchivesid(String pimarchivesid) {
        this.remove(new QueryWrapper<PIMARCHIVESLOANANDRETURN>().eq("pimarchivesid",pimarchivesid));
    }

	@Override
    public List<PIMARCHIVESLOANANDRETURN> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMARCHIVESLOANANDRETURN>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<PIMARCHIVESLOANANDRETURN> selectByPimpersonid2(String pimpersonid) {
        return baseMapper.selectByPimpersonid2(pimpersonid);
    }

    @Override
    public void removeByPimpersonid2(String pimpersonid) {
        this.remove(new QueryWrapper<PIMARCHIVESLOANANDRETURN>().eq("pimpersonid2",pimpersonid));
    }

	@Override
    public List<PIMARCHIVESLOANANDRETURN> selectByPimpersonid3(String pimpersonid) {
        return baseMapper.selectByPimpersonid3(pimpersonid);
    }

    @Override
    public void removeByPimpersonid3(String pimpersonid) {
        this.remove(new QueryWrapper<PIMARCHIVESLOANANDRETURN>().eq("pimpersonid3",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMARCHIVESLOANANDRETURN> searchDefault(PIMARCHIVESLOANANDRETURNSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMARCHIVESLOANANDRETURN> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMARCHIVESLOANANDRETURN>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMARCHIVESLOANANDRETURN et){
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMARCHIVES_PIMARCHIVESID]
        if(!ObjectUtils.isEmpty(et.getPimarchivesid())){
            cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES pimarchives=et.getPimarchives();
            if(ObjectUtils.isEmpty(pimarchives)){
                cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES majorEntity=pimarchivesService.get(et.getPimarchivesid());
                et.setPimarchives(majorEntity);
                pimarchives=majorEntity;
            }
            et.setPimarchivesname(pimarchives.getPimarchivesname());
        }
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMPERSON_PIMPERSONID2]
        if(!ObjectUtils.isEmpty(et.getPimpersonid2())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson2=et.getPimperson2();
            if(ObjectUtils.isEmpty(pimperson2)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid2());
                et.setPimperson2(majorEntity);
                pimperson2=majorEntity;
            }
            et.setPimpersonname2(pimperson2.getPimpersonname());
        }
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMPERSON_PIMPERSONID3]
        if(!ObjectUtils.isEmpty(et.getPimpersonid3())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson3=et.getPimperson3();
            if(ObjectUtils.isEmpty(pimperson3)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid3());
                et.setPimperson3(majorEntity);
                pimperson3=majorEntity;
            }
            et.setPimpersonname3(pimperson3.getPimpersonname());
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


