package cn.ibizlab.ehr.core.trm.service.impl;

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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMANDSUM;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDEMANDSUMSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINDEMANDSUMService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINDEMANDSUMMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训需求汇总明细] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINDEMANDSUMServiceImpl")
public class TRMTRAINDEMANDSUMServiceImpl extends ServiceImpl<TRMTRAINDEMANDSUMMapper, TRMTRAINDEMANDSUM> implements ITRMTRAINDEMANDSUMService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINDEMANDService trmtraindemandService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(TRMTRAINDEMANDSUM et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINDEMANDSUM et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMTRAINDEMANDSUM> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMTRAINDEMANDSUM get(String key) {
        TRMTRAINDEMANDSUM et = getById(key);
        if(et==null){
            et=new TRMTRAINDEMANDSUM();
            et.setTrmtraindemandsumid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINDEMANDSUM et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraindemandsumid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINDEMANDSUM> list) {
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
    public TRMTRAINDEMANDSUM getDraft(TRMTRAINDEMANDSUM et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean update(TRMTRAINDEMANDSUM et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtraindemandsumid",et.getTrmtraindemandsumid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtraindemandsumid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINDEMANDSUM> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(TRMTRAINDEMANDSUM et) {
        return (!ObjectUtils.isEmpty(et.getTrmtraindemandsumid()))&&(!Objects.isNull(this.getById(et.getTrmtraindemandsumid())));
    }


	@Override
    public List<TRMTRAINDEMANDSUM> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<TRMTRAINDEMANDSUM>().eq("ormorgid",orgid));
    }

	@Override
    public List<TRMTRAINDEMANDSUM> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TRMTRAINDEMANDSUM>().eq("trmtraincourseid",trmtraincourseid));
    }

	@Override
    public List<TRMTRAINDEMANDSUM> selectByTrmtraindemandid(String trmtraindemandid) {
        return baseMapper.selectByTrmtraindemandid(trmtraindemandid);
    }

    @Override
    public void removeByTrmtraindemandid(String trmtraindemandid) {
        this.remove(new QueryWrapper<TRMTRAINDEMANDSUM>().eq("trmtraindemandid",trmtraindemandid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINDEMANDSUM> searchDefault(TRMTRAINDEMANDSUMSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINDEMANDSUM> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINDEMANDSUM>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINDEMANDSUM et){
        //实体关系[DER1N_TRMTRAINDEMANDSUM_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
        }
        //实体关系[DER1N_TRMTRAINDEMANDSUM_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setKcbm(trmtraincourse.getKcbm());
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
        }
        //实体关系[DER1N_TRMTRAINDEMANDSUM_TRMTRAINDEMAND_TRMTRAINDEMANDID]
        if(!ObjectUtils.isEmpty(et.getTrmtraindemandid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMAND trmtraindemand=et.getTrmtraindemand();
            if(ObjectUtils.isEmpty(trmtraindemand)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMAND majorEntity=trmtraindemandService.get(et.getTrmtraindemandid());
                et.setTrmtraindemand(majorEntity);
                trmtraindemand=majorEntity;
            }
            et.setTrmtraindemandname(trmtraindemand.getTrmtraindemandname());
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

