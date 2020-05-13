package cn.ibizlab.ehr.core.common.service.impl;

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
import cn.ibizlab.ehr.core.common.domain.PVPart;
import cn.ibizlab.ehr.core.common.filter.PVPartSearchContext;
import cn.ibizlab.ehr.core.common.service.IPVPartService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.PVPartMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[门户视图部件] 服务对象接口实现
 */
@Slf4j
@Service("PVPartServiceImpl")
public class PVPartServiceImpl extends ServiceImpl<PVPartMapper, PVPart> implements IPVPartService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IPPModelService ppmodelService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IPortalPageService portalpageService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(PVPart et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pvpartid",et.getPvpartid())))
            return false;
        CachedBeanCopier.copy(get(et.getPvpartid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PVPart> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PVPart get(String key) {
        PVPart et = getById(key);
        if(et==null){
            et=new PVPart();
            et.setPvpartid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public boolean checkKey(PVPart et) {
        return (!ObjectUtils.isEmpty(et.getPvpartid()))&&(!Objects.isNull(this.getById(et.getPvpartid())));
    }

    @Override
    public PVPart getDraft(PVPart et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public boolean save(PVPart et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PVPart et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PVPart> list) {
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
    public boolean create(PVPart et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPvpartid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PVPart> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }


	@Override
    public List<PVPart> selectByPortalpageid(String portalpageid) {
        return baseMapper.selectByPortalpageid(portalpageid);
    }

    @Override
    public void removeByPortalpageid(String portalpageid) {
        this.remove(new QueryWrapper<PVPart>().eq("portalpageid",portalpageid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PVPart> searchDefault(PVPartSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PVPart> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PVPart>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前门户视图
     */
    @Override
    public Page<PVPart> searchCurPV(PVPartSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PVPart> pages=baseMapper.searchCurPV(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PVPart>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PVPart et){
        //实体关系[DER1N_PVPART_PORTALPAGE_PORTALPAGEID]
        if(!ObjectUtils.isEmpty(et.getPortalpageid())){
            cn.ibizlab.ehr.core.common.domain.PortalPage portalpage=et.getPortalpage();
            if(ObjectUtils.isEmpty(portalpage)){
                cn.ibizlab.ehr.core.common.domain.PortalPage majorEntity=portalpageService.get(et.getPortalpageid());
                et.setPortalpage(majorEntity);
                portalpage=majorEntity;
            }
            et.setPortalpagename(portalpage.getPortalpagename());
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


