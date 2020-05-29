package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.TestResult;
import cn.ibizlab.ehr.core.pcm.filter.TestResultSearchContext;
import cn.ibizlab.ehr.core.pcm.service.ITestResultService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.TestResultMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[测评结果摘要信息] 服务对象接口实现
 */
@Slf4j
@Service("TestResultServiceImpl")
public class TestResultServiceImpl extends ServiceImpl<TestResultMapper, TestResult> implements ITestResultService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEService pcmprofileService;

    private int batchSize = 500;

    @Override
    public TestResult getDraft(TestResult et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(TestResult et) {
        return (!ObjectUtils.isEmpty(et.getTestresultid()))&&(!Objects.isNull(this.getById(et.getTestresultid())));
    }

    @Override
    @Transactional
    public boolean create(TestResult et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getTestresultid()),et);
        return true;
    }

    @Override
    public void createBatch(List<TestResult> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(TestResult et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(TestResult et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<TestResult> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<TestResult> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public TestResult get(String key) {
        TestResult et = getById(key);
        if(et==null){
            et=new TestResult();
            et.setTestresultid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean update(TestResult et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("testresultid",et.getTestresultid())))
            return false;
        CachedBeanCopier.copy(get(et.getTestresultid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<TestResult> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
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
    public List<TestResult> selectByPcmprofileid(String pcmprofileid) {
        return baseMapper.selectByPcmprofileid(pcmprofileid);
    }

    @Override
    public void removeByPcmprofileid(String pcmprofileid) {
        this.remove(new QueryWrapper<TestResult>().eq("pcmprofileid",pcmprofileid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<TestResult> searchDefault(TestResultSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TestResult> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<TestResult>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(TestResult et){
        //实体关系[DER1N_TESTRESULT_PCMPROFILE_PCMPROFILEID]
        if(!ObjectUtils.isEmpty(et.getPcmprofileid())){
            cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE pcmprofile=et.getPcmprofile();
            if(ObjectUtils.isEmpty(pcmprofile)){
                cn.ibizlab.ehr.core.pcm.domain.PCMPROFILE majorEntity=pcmprofileService.get(et.getPcmprofileid());
                et.setPcmprofile(majorEntity);
                pcmprofile=majorEntity;
            }
            et.setPcmprofilename(pcmprofile.getPcmprofilename());
            et.setCertificatenumber(pcmprofile.getCertificatenumber());
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
    public List<TestResult> getTestresultByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<TestResult> getTestresultByEntities(List<TestResult> entities) {
        List ids =new ArrayList();
        for(TestResult entity : entities){
            Serializable id=entity.getTestresultid();
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


