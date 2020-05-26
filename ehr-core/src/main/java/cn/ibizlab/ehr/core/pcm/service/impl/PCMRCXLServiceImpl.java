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
import cn.ibizlab.ehr.core.pcm.domain.PCMRCXL;
import cn.ibizlab.ehr.core.pcm.filter.PCMRCXLSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMRCXLService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMRCXLMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人才序列] 服务对象接口实现
 */
@Slf4j
@Service("PCMRCXLServiceImpl")
public class PCMRCXLServiceImpl extends ServiceImpl<PCMRCXLMapper, PCMRCXL> implements IPCMRCXLService {


    private cn.ibizlab.ehr.core.pcm.service.IPCMRCXLService pcmrcxlService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PCMRCXL et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmrcxlid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMRCXL> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PCMRCXL getDraft(PCMRCXL et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PCMRCXL get(String key) {
        PCMRCXL et = getById(key);
        if(et==null){
            et=new PCMRCXL();
            et.setPcmrcxlid(key);
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
    @Transactional
    public boolean update(PCMRCXL et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmrcxlid",et.getPcmrcxlid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmrcxlid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMRCXL> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMRCXL et) {
        return (!ObjectUtils.isEmpty(et.getPcmrcxlid()))&&(!Objects.isNull(this.getById(et.getPcmrcxlid())));
    }

    @Override
    @Transactional
    public boolean save(PCMRCXL et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMRCXL et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMRCXL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMRCXL> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PCMRCXL> selectByPcmrcxlid2(String pcmrcxlid) {
        return baseMapper.selectByPcmrcxlid2(pcmrcxlid);
    }

    @Override
    public void removeByPcmrcxlid2(String pcmrcxlid) {
        this.remove(new QueryWrapper<PCMRCXL>().eq("pcmrcxlid2",pcmrcxlid));
    }


    /**
     * 查询集合 查询当前人才序列下的序列
     */
    @Override
    public Page<PCMRCXL> searchCurrent(PCMRCXLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRCXL> pages=baseMapper.searchCurrent(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRCXL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人才序列匹配人才序列类型
     */
    @Override
    public Page<PCMRCXL> searchRCXLPPXLLX(PCMRCXLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRCXL> pages=baseMapper.searchRCXLPPXLLX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRCXL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子查询
     */
    @Override
    public Page<PCMRCXL> searchZiDQ(PCMRCXLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRCXL> pages=baseMapper.searchZiDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRCXL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMRCXL> searchDefault(PCMRCXLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRCXL> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRCXL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根查询
     */
    @Override
    public Page<PCMRCXL> searchGenDQ(PCMRCXLSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMRCXL> pages=baseMapper.searchGenDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMRCXL>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMRCXL et){
        //实体关系[DER1N_PCMRCXL_PCMRCXL_PCMRCXLID2]
        if(!ObjectUtils.isEmpty(et.getPcmrcxlid2())){
            cn.ibizlab.ehr.core.pcm.domain.PCMRCXL pcmrcxl2=et.getPcmrcxl2();
            if(ObjectUtils.isEmpty(pcmrcxl2)){
                cn.ibizlab.ehr.core.pcm.domain.PCMRCXL majorEntity=pcmrcxlService.get(et.getPcmrcxlid2());
                et.setPcmrcxl2(majorEntity);
                pcmrcxl2=majorEntity;
            }
            et.setPcmrcxlname2(pcmrcxl2.getPcmrcxlname());
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


