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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINPLANTERMSearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMTRAINPLANTERMMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训立项] 服务对象接口实现
 */
@Slf4j
@Service("TRMTRAINPLANTERMServiceImpl")
public class TRMTRAINPLANTERMServiceImpl extends ServiceImpl<TRMTRAINPLANTERMMapper, TRMTRAINPLANTERM> implements ITRMTRAINPLANTERMService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDService attendancerecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService trmcouarrangeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTEACHERCHARGEService trmteacherchargeService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTEACHERTRAINService trmteachertrainService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINBUAPPLYService trmtrainbuapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRIANPERSONService trmtrianpersonService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANService trmtrainplanService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService trmtrainteacherService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITRMTRAINPLANTERMKBLogic kbLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITRMTRAINPLANTERMQXLogic qxLogic;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.logic.ITRMTRAINPLANTERMLXLogic lxLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public TRMTRAINPLANTERM get(String key) {
        TRMTRAINPLANTERM et = getById(key);
        if(et==null){
            et=new TRMTRAINPLANTERM();
            et.setTrmtrainplantermid(key);
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
    public boolean checkKey(TRMTRAINPLANTERM et) {
        return (!ObjectUtils.isEmpty(et.getTrmtrainplantermid()))&&(!Objects.isNull(this.getById(et.getTrmtrainplantermid())));
    }

    @Override
    @Transactional
    public boolean update(TRMTRAINPLANTERM et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmtrainplantermid",et.getTrmtrainplantermid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainplantermid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMTRAINPLANTERM> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TRMTRAINPLANTERM et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMTRAINPLANTERM et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<TRMTRAINPLANTERM> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public TRMTRAINPLANTERM getDraft(TRMTRAINPLANTERM et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public TRMTRAINPLANTERM kB(TRMTRAINPLANTERM et) {
        kbLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public boolean create(TRMTRAINPLANTERM et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmtrainplantermid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMTRAINPLANTERM> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMTRAINPLANTERM qX(TRMTRAINPLANTERM et) {
        qxLogic.execute(et);
         return et ;
    }

    @Override
    @Transactional
    public TRMTRAINPLANTERM lX(TRMTRAINPLANTERM et) {
        lxLogic.execute(et);
         return et ;
    }


	@Override
    public List<TRMTRAINPLANTERM> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMTRAINPLANTERM>().eq("trmtrainagencyid",trmtrainagencyid));
    }

	@Override
    public List<TRMTRAINPLANTERM> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TRMTRAINPLANTERM>().eq("trmtraincourseid",trmtraincourseid));
    }

	@Override
    public List<TRMTRAINPLANTERM> selectByTrmtrainplanid(String trmtrainplanid) {
        return baseMapper.selectByTrmtrainplanid(trmtrainplanid);
    }

    @Override
    public void removeByTrmtrainplanid(String trmtrainplanid) {
        this.remove(new QueryWrapper<TRMTRAINPLANTERM>().eq("trmtrainplanid",trmtrainplanid));
    }

	@Override
    public List<TRMTRAINPLANTERM> selectByTrmtrainteacherid(String trmtrainteacherid) {
        return baseMapper.selectByTrmtrainteacherid(trmtrainteacherid);
    }

    @Override
    public void removeByTrmtrainteacherid(String trmtrainteacherid) {
        this.remove(new QueryWrapper<TRMTRAINPLANTERM>().eq("trmtrainteacherid",trmtrainteacherid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMTRAINPLANTERM> searchDefault(TRMTRAINPLANTERMSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMTRAINPLANTERM> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMTRAINPLANTERM>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMTRAINPLANTERM et){
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
        }
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
        }
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINPLAN_TRMTRAINPLANID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplanid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLAN trmtrainplan=et.getTrmtrainplan();
            if(ObjectUtils.isEmpty(trmtrainplan)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLAN majorEntity=trmtrainplanService.get(et.getTrmtrainplanid());
                et.setTrmtrainplan(majorEntity);
                trmtrainplan=majorEntity;
            }
            et.setTrmdemdeftionname(trmtrainplan.getTrmdemdeftionname());
            et.setNd(trmtrainplan.getJhnd());
            et.setPxdd(trmtrainplan.getPxdd());
            et.setPxkssj(trmtrainplan.getPxkssj());
            et.setPxjssj(trmtrainplan.getPxjssj());
            et.setTrmtrainplanname(trmtrainplan.getTrmtrainplanname());
        }
        //实体关系[DER1N_TRMTRAINPLANTERM_TRMTRAINTEACHER_TRMTRAINTEACHERID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainteacherid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER trmtrainteacher=et.getTrmtrainteacher();
            if(ObjectUtils.isEmpty(trmtrainteacher)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER majorEntity=trmtrainteacherService.get(et.getTrmtrainteacherid());
                et.setTrmtrainteacher(majorEntity);
                trmtrainteacher=majorEntity;
            }
            et.setTrmtrainteachername(trmtrainteacher.getTrmtrainteachername());
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


