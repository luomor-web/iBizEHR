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
import cn.ibizlab.ehr.core.pim.domain.PimArchiveSloanandreturn;
import cn.ibizlab.ehr.core.pim.filter.PimArchiveSloanandreturnSearchContext;
import cn.ibizlab.ehr.core.pim.service.IPimArchiveSloanandreturnService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PimArchiveSloanandreturnMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[档案借阅及归还记录] 服务对象接口实现
 */
@Slf4j
@Service("PimArchiveSloanandreturnServiceImpl")
public class PimArchiveSloanandreturnServiceImpl extends ServiceImpl<PimArchiveSloanandreturnMapper, PimArchiveSloanandreturn> implements IPimArchiveSloanandreturnService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimArchivesService pimarchivesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPimArchiveSloanandreturnUpdateArchiveStateLogic updatearchivestateLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.logic.IPimArchiveSloanandreturnUpdateStateLogic updatestateLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public PimArchiveSloanandreturn get(String key) {
        PimArchiveSloanandreturn et = getById(key);
        if(et==null){
            et=new PimArchiveSloanandreturn();
            et.setPimarchivesloanandreturnid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(PimArchiveSloanandreturn et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimarchivesloanandreturnid",et.getPimarchivesloanandreturnid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesloanandreturnid()),et);
        updatearchivestateLogic.execute(et);
        return true;
    }

    @Override
    public void updateBatch(List<PimArchiveSloanandreturn> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PimArchiveSloanandreturn et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimarchivesloanandreturnid()),et);
        updatearchivestateLogic.execute(et);
        return true;
    }

    @Override
    public void createBatch(List<PimArchiveSloanandreturn> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PimArchiveSloanandreturn getDraft(PimArchiveSloanandreturn et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PimArchiveSloanandreturn et) {
        return (!ObjectUtils.isEmpty(et.getPimarchivesloanandreturnid()))&&(!Objects.isNull(this.getById(et.getPimarchivesloanandreturnid())));
    }
    @Override
    @Transactional
    public PimArchiveSloanandreturn updateState(PimArchiveSloanandreturn et) {
        updatestateLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean save(PimArchiveSloanandreturn et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PimArchiveSloanandreturn et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PimArchiveSloanandreturn> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PimArchiveSloanandreturn> list) {
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
    public PimArchiveSloanandreturn updateArchiveState(PimArchiveSloanandreturn et) {
        //自定义代码
        return et;
    }


	@Override
    public List<PimArchiveSloanandreturn> selectByPimarchivesid(String pimarchivesid) {
        return baseMapper.selectByPimarchivesid(pimarchivesid);
    }

    @Override
    public void removeByPimarchivesid(String pimarchivesid) {
        this.remove(new QueryWrapper<PimArchiveSloanandreturn>().eq("pimarchivesid",pimarchivesid));
    }

	@Override
    public List<PimArchiveSloanandreturn> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PimArchiveSloanandreturn>().eq("pimpersonid",pimpersonid));
    }

	@Override
    public List<PimArchiveSloanandreturn> selectByPimpersonid2(String pimpersonid) {
        return baseMapper.selectByPimpersonid2(pimpersonid);
    }

    @Override
    public void removeByPimpersonid2(String pimpersonid) {
        this.remove(new QueryWrapper<PimArchiveSloanandreturn>().eq("pimpersonid2",pimpersonid));
    }

	@Override
    public List<PimArchiveSloanandreturn> selectByPimpersonid3(String pimpersonid) {
        return baseMapper.selectByPimpersonid3(pimpersonid);
    }

    @Override
    public void removeByPimpersonid3(String pimpersonid) {
        this.remove(new QueryWrapper<PimArchiveSloanandreturn>().eq("pimpersonid3",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PimArchiveSloanandreturn> searchDefault(PimArchiveSloanandreturnSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PimArchiveSloanandreturn> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PimArchiveSloanandreturn>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PimArchiveSloanandreturn et){
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMARCHIVES_PIMARCHIVESID]
        if(!ObjectUtils.isEmpty(et.getPimarchivesid())){
            cn.ibizlab.ehr.core.pim.domain.PimArchives pimarchives=et.getPimarchives();
            if(ObjectUtils.isEmpty(pimarchives)){
                cn.ibizlab.ehr.core.pim.domain.PimArchives majorEntity=pimarchivesService.get(et.getPimarchivesid());
                et.setPimarchives(majorEntity);
                pimarchives=majorEntity;
            }
            et.setPimarchivesname(pimarchives.getPimarchivesname());
        }
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
        }
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMPERSON_PIMPERSONID2]
        if(!ObjectUtils.isEmpty(et.getPimpersonid2())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson2=et.getPimperson2();
            if(ObjectUtils.isEmpty(pimperson2)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid2());
                et.setPimperson2(majorEntity);
                pimperson2=majorEntity;
            }
            et.setPimpersonname2(pimperson2.getPimpersonname());
        }
        //实体关系[DER1N_PIMARCHIVESLOANANDRETURN_PIMPERSON_PIMPERSONID3]
        if(!ObjectUtils.isEmpty(et.getPimpersonid3())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson3=et.getPimperson3();
            if(ObjectUtils.isEmpty(pimperson3)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid3());
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

    @Override
    public List<PimArchiveSloanandreturn> getPimarchivesloanandreturnByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PimArchiveSloanandreturn> getPimarchivesloanandreturnByEntities(List<PimArchiveSloanandreturn> entities) {
        List ids =new ArrayList();
        for(PimArchiveSloanandreturn entity : entities){
            Serializable id=entity.getPimarchivesloanandreturnid();
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



