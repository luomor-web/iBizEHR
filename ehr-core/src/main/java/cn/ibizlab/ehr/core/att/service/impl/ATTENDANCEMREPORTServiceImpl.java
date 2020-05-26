package cn.ibizlab.ehr.core.att.service.impl;

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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORT;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCEMREPORTSearchContext;
import cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.att.mapper.ATTENDANCEMREPORTMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[考勤月报] 服务对象接口实现
 */
@Slf4j
@Service("ATTENDANCEMREPORTServiceImpl")
public class ATTENDANCEMREPORTServiceImpl extends ServiceImpl<ATTENDANCEMREPORTMapper, ATTENDANCEMREPORT> implements IATTENDANCEMREPORTService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTMXService attendancemreportmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.IATTENDENCESETUPService attendencesetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public ATTENDANCEMREPORT getAttendencemanOfKQSZ(ATTENDANCEMREPORT et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean save(ATTENDANCEMREPORT et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(ATTENDANCEMREPORT et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<ATTENDANCEMREPORT> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<ATTENDANCEMREPORT> list) {
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
    public ATTENDANCEMREPORT exportKQYB(ATTENDANCEMREPORT et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean create(ATTENDANCEMREPORT et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancemreportid()),et);
        return true;
    }

    @Override
    public void createBatch(List<ATTENDANCEMREPORT> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public ATTENDANCEMREPORT sCKQYB(ATTENDANCEMREPORT et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public ATTENDANCEMREPORT get(String key) {
        ATTENDANCEMREPORT et = getById(key);
        if(et==null){
            et=new ATTENDANCEMREPORT();
            et.setAttendancemreportid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(ATTENDANCEMREPORT et) {
        return (!ObjectUtils.isEmpty(et.getAttendancemreportid()))&&(!Objects.isNull(this.getById(et.getAttendancemreportid())));
    }

    @Override
    @Transactional
    public ATTENDANCEMREPORT qR(ATTENDANCEMREPORT et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(ATTENDANCEMREPORT et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("attendancemreportid",et.getAttendancemreportid())))
            return false;
        CachedBeanCopier.copy(get(et.getAttendancemreportid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<ATTENDANCEMREPORT> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public ATTENDANCEMREPORT getDraft(ATTENDANCEMREPORT et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public ATTENDANCEMREPORT printKQYB(ATTENDANCEMREPORT et) {
        //自定义代码
        return et;
    }


	@Override
    public List<ATTENDANCEMREPORT> selectByAttendencesetupid(String attendencesetupid) {
        return baseMapper.selectByAttendencesetupid(attendencesetupid);
    }

    @Override
    public void removeByAttendencesetupid(String attendencesetupid) {
        this.remove(new QueryWrapper<ATTENDANCEMREPORT>().eq("attendencesetupid",attendencesetupid));
    }

	@Override
    public List<ATTENDANCEMREPORT> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<ATTENDANCEMREPORT>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 考勤月报打印
     */
    @Override
    public Page<ATTENDANCEMREPORT> searchKQYBDY(ATTENDANCEMREPORTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORT> pages=baseMapper.searchKQYBDY(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORT>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<ATTENDANCEMREPORT> searchDefault(ATTENDANCEMREPORTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORT> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORT>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤员操作考勤月报
     */
    @Override
    public Page<ATTENDANCEMREPORT> searchKQYCZKQYB(ATTENDANCEMREPORTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORT> pages=baseMapper.searchKQYCZKQYB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORT>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织考勤月报
     */
    @Override
    public Page<ATTENDANCEMREPORT> searchCurORMORGKQYB(ATTENDANCEMREPORTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORT> pages=baseMapper.searchCurORMORGKQYB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORT>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前组织下部门考勤月报
     */
    @Override
    public Page<ATTENDANCEMREPORT> searchCurORMORGSECTORKQYB(ATTENDANCEMREPORTSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<ATTENDANCEMREPORT> pages=baseMapper.searchCurORMORGSECTORKQYB(context.getPages(),context,context.getSelectCond());
        return new PageImpl<ATTENDANCEMREPORT>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(ATTENDANCEMREPORT et){
        //实体关系[DER1N_ATTENDANCEMREPORT_ATTENDENCESETUP_ATTENDENCESETUPID]
        if(!ObjectUtils.isEmpty(et.getAttendencesetupid())){
            cn.ibizlab.ehr.core.att.domain.ATTENDENCESETUP attendencesetup=et.getAttendencesetup();
            if(ObjectUtils.isEmpty(attendencesetup)){
                cn.ibizlab.ehr.core.att.domain.ATTENDENCESETUP majorEntity=attendencesetupService.get(et.getAttendencesetupid());
                et.setAttendencesetup(majorEntity);
                attendencesetup=majorEntity;
            }
            et.setPimpersonname(attendencesetup.getPimpersonname());
            et.setPimpersonid(attendencesetup.getPimpersonid());
            et.setAttendencesetupname(attendencesetup.getAttendencesetupname());
        }
        //实体关系[DER1N_ATTENDANCEMREPORT_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getZzdzs());
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


