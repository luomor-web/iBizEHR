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
import cn.ibizlab.ehr.core.trm.domain.TRMCOUARRANGE;
import cn.ibizlab.ehr.core.trm.filter.TRMCOUARRANGESearchContext;
import cn.ibizlab.ehr.core.trm.service.ITRMCOUARRANGEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.trm.mapper.TRMCOUARRANGEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[培训记录] 服务对象接口实现
 */
@Slf4j
@Service("TRMCOUARRANGEServiceImpl")
public class TRMCOUARRANGEServiceImpl extends ServiceImpl<TRMCOUARRANGEMapper, TRMCOUARRANGE> implements ITRMCOUARRANGEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMEMPLOYRETIONService trmemployretionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMAGENCYRECORDService trmagencyrecordService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMCOURSESYSTEMService trmcoursesystemService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINACTAPPLYService trmtrainactapplyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINADDRESSService trmtrainaddressService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService trmtrainagencyService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService trmtraincourseService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINFACIESService trmtrainfaciesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService trmtrainplantermService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService trmtrainteacherService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.trm.service.ITRMTRIANPERSONService trmtrianpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(TRMCOUARRANGE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTrmcouarrangeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TRMCOUARRANGE> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TRMCOUARRANGE get(String key) {
        TRMCOUARRANGE et = getById(key);
        if(et==null){
            et=new TRMCOUARRANGE();
            et.setTrmcouarrangeid(key);
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
    public TRMCOUARRANGE getDraft(TRMCOUARRANGE et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TRMCOUARRANGE et) {
        return (!ObjectUtils.isEmpty(et.getTrmcouarrangeid()))&&(!Objects.isNull(this.getById(et.getTrmcouarrangeid())));
    }

    @Override
    @Transactional
    public boolean save(TRMCOUARRANGE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TRMCOUARRANGE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TRMCOUARRANGE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TRMCOUARRANGE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(TRMCOUARRANGE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("trmcouarrangeid",et.getTrmcouarrangeid())))
            return false;
        CachedBeanCopier.copy(get(et.getTrmcouarrangeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TRMCOUARRANGE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<TRMCOUARRANGE> selectByTrmagencyrecordid(String trmagencyrecordid) {
        return baseMapper.selectByTrmagencyrecordid(trmagencyrecordid);
    }

    @Override
    public void removeByTrmagencyrecordid(String trmagencyrecordid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmagencyrecordid",trmagencyrecordid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmcoursesystemid(String trmcoursesystemid) {
        return baseMapper.selectByTrmcoursesystemid(trmcoursesystemid);
    }

    @Override
    public void removeByTrmcoursesystemid(String trmcoursesystemid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmcoursesystemid",trmcoursesystemid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtrainactapplyid(String trmtrainactapplyid) {
        return baseMapper.selectByTrmtrainactapplyid(trmtrainactapplyid);
    }

    @Override
    public void removeByTrmtrainactapplyid(String trmtrainactapplyid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtrainactapplyid",trmtrainactapplyid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtrainaddressid(String trmtrainaddressid) {
        return baseMapper.selectByTrmtrainaddressid(trmtrainaddressid);
    }

    @Override
    public void removeByTrmtrainaddressid(String trmtrainaddressid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtrainaddressid",trmtrainaddressid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtrainagencyid(String trmtrainagencyid) {
        return baseMapper.selectByTrmtrainagencyid(trmtrainagencyid);
    }

    @Override
    public void removeByTrmtrainagencyid(String trmtrainagencyid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtrainagencyid",trmtrainagencyid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtraincourseid(String trmtraincourseid) {
        return baseMapper.selectByTrmtraincourseid(trmtraincourseid);
    }

    @Override
    public void removeByTrmtraincourseid(String trmtraincourseid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtraincourseid",trmtraincourseid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtrainfaciesid(String trmtrainfaciesid) {
        return baseMapper.selectByTrmtrainfaciesid(trmtrainfaciesid);
    }

    @Override
    public void removeByTrmtrainfaciesid(String trmtrainfaciesid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtrainfaciesid",trmtrainfaciesid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtrainplantermid(String trmtrainplantermid) {
        return baseMapper.selectByTrmtrainplantermid(trmtrainplantermid);
    }

    @Override
    public void removeByTrmtrainplantermid(String trmtrainplantermid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtrainplantermid",trmtrainplantermid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtrainteacherid(String trmtrainteacherid) {
        return baseMapper.selectByTrmtrainteacherid(trmtrainteacherid);
    }

    @Override
    public void removeByTrmtrainteacherid(String trmtrainteacherid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtrainteacherid",trmtrainteacherid));
    }

	@Override
    public List<TRMCOUARRANGE> selectByTrmtrianpersonid(String trmtrianpersonid) {
        return baseMapper.selectByTrmtrianpersonid(trmtrianpersonid);
    }

    @Override
    public void removeByTrmtrianpersonid(String trmtrianpersonid) {
        this.remove(new QueryWrapper<TRMCOUARRANGE>().eq("trmtrianpersonid",trmtrianpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TRMCOUARRANGE> searchDefault(TRMCOUARRANGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TRMCOUARRANGE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TRMCOUARRANGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TRMCOUARRANGE et){
        //实体关系[DER1N_TRMCOUARRANGE_TRMAGENCYRECORD_TRMAGENCYRECORDID]
        if(!ObjectUtils.isEmpty(et.getTrmagencyrecordid())){
            cn.ibizlab.ehr.core.trm.domain.TRMAGENCYRECORD trmagencyrecord=et.getTrmagencyrecord();
            if(ObjectUtils.isEmpty(trmagencyrecord)){
                cn.ibizlab.ehr.core.trm.domain.TRMAGENCYRECORD majorEntity=trmagencyrecordService.get(et.getTrmagencyrecordid());
                et.setTrmagencyrecord(majorEntity);
                trmagencyrecord=majorEntity;
            }
            et.setTrmagencyrecordname(trmagencyrecord.getTrmagencyrecordname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMCOURSESYSTEM_TRMCOURSESYSTEMID]
        if(!ObjectUtils.isEmpty(et.getTrmcoursesystemid())){
            cn.ibizlab.ehr.core.trm.domain.TRMCOURSESYSTEM trmcoursesystem=et.getTrmcoursesystem();
            if(ObjectUtils.isEmpty(trmcoursesystem)){
                cn.ibizlab.ehr.core.trm.domain.TRMCOURSESYSTEM majorEntity=trmcoursesystemService.get(et.getTrmcoursesystemid());
                et.setTrmcoursesystem(majorEntity);
                trmcoursesystem=majorEntity;
            }
            et.setTrmcoursesystemname(trmcoursesystem.getTrmcoursesystemname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINACTAPPLY_TRMTRAINACTAPPLYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainactapplyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTAPPLY trmtrainactapply=et.getTrmtrainactapply();
            if(ObjectUtils.isEmpty(trmtrainactapply)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTAPPLY majorEntity=trmtrainactapplyService.get(et.getTrmtrainactapplyid());
                et.setTrmtrainactapply(majorEntity);
                trmtrainactapply=majorEntity;
            }
            et.setTrmtrainactapplyname(trmtrainactapply.getTrmtrainactapplyname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINADDRESS_TRMTRAINADDRESSID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainaddressid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINADDRESS trmtrainaddress=et.getTrmtrainaddress();
            if(ObjectUtils.isEmpty(trmtrainaddress)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINADDRESS majorEntity=trmtrainaddressService.get(et.getTrmtrainaddressid());
                et.setTrmtrainaddress(majorEntity);
                trmtrainaddress=majorEntity;
            }
            et.setTrmtrainaddressname(trmtrainaddress.getTrmtrainaddressname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINAGENCY_TRMTRAINAGENCYID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainagencyid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY trmtrainagency=et.getTrmtrainagency();
            if(ObjectUtils.isEmpty(trmtrainagency)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY majorEntity=trmtrainagencyService.get(et.getTrmtrainagencyid());
                et.setTrmtrainagency(majorEntity);
                trmtrainagency=majorEntity;
            }
            et.setTrmtrainagencyname(trmtrainagency.getTrmtrainagencyname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINCOURSE_TRMTRAINCOURSEID]
        if(!ObjectUtils.isEmpty(et.getTrmtraincourseid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE trmtraincourse=et.getTrmtraincourse();
            if(ObjectUtils.isEmpty(trmtraincourse)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE majorEntity=trmtraincourseService.get(et.getTrmtraincourseid());
                et.setTrmtraincourse(majorEntity);
                trmtraincourse=majorEntity;
            }
            et.setTrmtraincoursename(trmtraincourse.getTrmtraincoursename());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINFACIES_TRMTRAINFACIESID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainfaciesid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINFACIES trmtrainfacies=et.getTrmtrainfacies();
            if(ObjectUtils.isEmpty(trmtrainfacies)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINFACIES majorEntity=trmtrainfaciesService.get(et.getTrmtrainfaciesid());
                et.setTrmtrainfacies(majorEntity);
                trmtrainfacies=majorEntity;
            }
            et.setTrmtrainfaciesname(trmtrainfacies.getTrmtrainfaciesname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINPLANTERM_TRMTRAINPLANTERMID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainplantermid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM trmtrainplanterm=et.getTrmtrainplanterm();
            if(ObjectUtils.isEmpty(trmtrainplanterm)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM majorEntity=trmtrainplantermService.get(et.getTrmtrainplantermid());
                et.setTrmtrainplanterm(majorEntity);
                trmtrainplanterm=majorEntity;
            }
            et.setTrmtrainplantermname(trmtrainplanterm.getTrmtrainplantermname());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRAINTEACHER_TRMTRAINTEACHERID]
        if(!ObjectUtils.isEmpty(et.getTrmtrainteacherid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER trmtrainteacher=et.getTrmtrainteacher();
            if(ObjectUtils.isEmpty(trmtrainteacher)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER majorEntity=trmtrainteacherService.get(et.getTrmtrainteacherid());
                et.setTrmtrainteacher(majorEntity);
                trmtrainteacher=majorEntity;
            }
            et.setTrmtrainteachername(trmtrainteacher.getTrmtrainteachername());
        }
        //实体关系[DER1N_TRMCOUARRANGE_TRMTRIANPERSON_TRMTRIANPERSONID]
        if(!ObjectUtils.isEmpty(et.getTrmtrianpersonid())){
            cn.ibizlab.ehr.core.trm.domain.TRMTRIANPERSON trmtrianperson=et.getTrmtrianperson();
            if(ObjectUtils.isEmpty(trmtrianperson)){
                cn.ibizlab.ehr.core.trm.domain.TRMTRIANPERSON majorEntity=trmtrianpersonService.get(et.getTrmtrianpersonid());
                et.setTrmtrianperson(majorEntity);
                trmtrianperson=majorEntity;
            }
            et.setTrmtrianpersonname(trmtrianperson.getTrmtrianpersonname());
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
    public List<TRMCOUARRANGE> getTrmcouarrangeByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TRMCOUARRANGE> getTrmcouarrangeByEntities(List<TRMCOUARRANGE> entities) {
        List ids =new ArrayList();
        for(TRMCOUARRANGE entity : entities){
            Serializable id=entity.getTrmcouarrangeid();
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


