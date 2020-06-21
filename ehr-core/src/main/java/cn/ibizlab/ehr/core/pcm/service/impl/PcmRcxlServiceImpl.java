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
import cn.ibizlab.ehr.core.pcm.domain.PcmRcxl;
import cn.ibizlab.ehr.core.pcm.filter.PcmRcxlSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPcmRcxlService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PcmRcxlMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人才序列] 服务对象接口实现
 */
@Slf4j
@Service("PcmRcxlServiceImpl")
public class PcmRcxlServiceImpl extends ServiceImpl<PcmRcxlMapper, PcmRcxl> implements IPcmRcxlService {


    private cn.ibizlab.ehr.core.pcm.service.IPcmRcxlService pcmrcxlService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PcmRcxl et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmrcxlid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PcmRcxl> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public PcmRcxl getDraft(PcmRcxl et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public PcmRcxl get(String key) {
        PcmRcxl et = getById(key);
        if(et==null){
            et=new PcmRcxl();
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
    public boolean update(PcmRcxl et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmrcxlid",et.getPcmrcxlid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmrcxlid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PcmRcxl> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(PcmRcxl et) {
        return (!ObjectUtils.isEmpty(et.getPcmrcxlid()))&&(!Objects.isNull(this.getById(et.getPcmrcxlid())));
    }
    @Override
    @Transactional
    public boolean save(PcmRcxl et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PcmRcxl et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PcmRcxl> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PcmRcxl> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }


	@Override
    public List<PcmRcxl> selectByPcmrcxlid2(String pcmrcxlid) {
        return baseMapper.selectByPcmrcxlid2(pcmrcxlid);
    }

    @Override
    public void removeByPcmrcxlid2(String pcmrcxlid) {
        this.remove(new QueryWrapper<PcmRcxl>().eq("pcmrcxlid2",pcmrcxlid));
    }


    /**
     * 查询集合 查询当前人才序列下的序列
     */
    @Override
    public Page<PcmRcxl> searchCurrent(PcmRcxlSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmRcxl> pages=baseMapper.searchCurrent(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmRcxl>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人才序列匹配人才序列类型
     */
    @Override
    public Page<PcmRcxl> searchRCXLPPXLLX(PcmRcxlSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmRcxl> pages=baseMapper.searchRCXLPPXLLX(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmRcxl>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 子查询
     */
    @Override
    public Page<PcmRcxl> searchZiDQ(PcmRcxlSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmRcxl> pages=baseMapper.searchZiDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmRcxl>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PcmRcxl> searchDefault(PcmRcxlSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmRcxl> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmRcxl>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 根查询
     */
    @Override
    public Page<PcmRcxl> searchGenDQ(PcmRcxlSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PcmRcxl> pages=baseMapper.searchGenDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PcmRcxl>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PcmRcxl et){
        //实体关系[DER1N_PCMRCXL_PCMRCXL_PCMRCXLID2]
        if(!ObjectUtils.isEmpty(et.getPcmrcxlid2())){
            cn.ibizlab.ehr.core.pcm.domain.PcmRcxl pcmrcxl2=et.getPcmrcxl2();
            if(ObjectUtils.isEmpty(pcmrcxl2)){
                cn.ibizlab.ehr.core.pcm.domain.PcmRcxl majorEntity=pcmrcxlService.get(et.getPcmrcxlid2());
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

    @Override
    public List<PcmRcxl> getPcmrcxlByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<PcmRcxl> getPcmrcxlByEntities(List<PcmRcxl> entities) {
        List ids =new ArrayList();
        for(PcmRcxl entity : entities){
            Serializable id=entity.getPcmrcxlid();
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



