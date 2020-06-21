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
import cn.ibizlab.ehr.core.common.domain.CodeItem;
import cn.ibizlab.ehr.core.common.filter.CodeItemSearchContext;
import cn.ibizlab.ehr.core.common.service.ICodeItemService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.CodeItemMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[代码项] 服务对象接口实现
 */
@Slf4j
@Service("CodeItemServiceImpl")
public class CodeItemServiceImpl extends ServiceImpl<CodeItemMapper, CodeItem> implements ICodeItemService {


    private cn.ibizlab.ehr.core.common.service.ICodeItemService codeitemService = this;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ICodeList1Service codelist1Service;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(CodeItem et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(CodeItem et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<CodeItem> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<CodeItem> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(CodeItem et) {
        return (!ObjectUtils.isEmpty(et.getCodeitemid()))&&(!Objects.isNull(this.getById(et.getCodeitemid())));
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
    public boolean update(CodeItem et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("codeitemid",et.getCodeitemid())))
            return false;
        CachedBeanCopier.copy(get(et.getCodeitemid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<CodeItem> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(CodeItem et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getCodeitemid()),et);
        return true;
    }

    @Override
    public void createBatch(List<CodeItem> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public CodeItem getDraft(CodeItem et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public CodeItem get(String key) {
        CodeItem et = getById(key);
        if(et==null){
            et=new CodeItem();
            et.setCodeitemid(key);
        }
        else{
        }
        return et;
    }


	@Override
    public List<CodeItem> selectByPcodeitemid(String codeitemid) {
        return baseMapper.selectByPcodeitemid(codeitemid);
    }

    @Override
    public void removeByPcodeitemid(String codeitemid) {
        this.remove(new QueryWrapper<CodeItem>().eq("pcodeitemid",codeitemid));
    }

	@Override
    public List<CodeItem> selectByCodelistid(String codelistid) {
        return baseMapper.selectByCodelistid(codelistid);
    }

    @Override
    public void removeByCodelistid(String codelistid) {
        this.remove(new QueryWrapper<CodeItem>().eq("codelistid",codelistid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<CodeItem> searchDefault(CodeItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<CodeItem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<CodeItem>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 当前代码表
     */
    @Override
    public Page<CodeItem> searchCurCL(CodeItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<CodeItem> pages=baseMapper.searchCurCL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<CodeItem>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(CodeItem et){
        //实体关系[DER1N_CODEITEM_CODEITEM_PCODEITEMID]
        if(!ObjectUtils.isEmpty(et.getPcodeitemid())){
            cn.ibizlab.ehr.core.common.domain.CodeItem pcodeitem=et.getPcodeitem();
            if(ObjectUtils.isEmpty(pcodeitem)){
                cn.ibizlab.ehr.core.common.domain.CodeItem majorEntity=codeitemService.get(et.getPcodeitemid());
                et.setPcodeitem(majorEntity);
                pcodeitem=majorEntity;
            }
            et.setPcodeitemname(pcodeitem.getCodeitemname());
        }
        //实体关系[DER1N_CODEITEM_CODELIST_CODELISTID]
        if(!ObjectUtils.isEmpty(et.getCodelistid())){
            cn.ibizlab.ehr.core.common.domain.CodeList1 codelist=et.getCodelist();
            if(ObjectUtils.isEmpty(codelist)){
                cn.ibizlab.ehr.core.common.domain.CodeList1 majorEntity=codelist1Service.get(et.getCodelistid());
                et.setCodelist(majorEntity);
                codelist=majorEntity;
            }
            et.setCodelistname(codelist.getCodelistname());
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
    public List<CodeItem> getCodeitemByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<CodeItem> getCodeitemByEntities(List<CodeItem> entities) {
        List ids =new ArrayList();
        for(CodeItem entity : entities){
            Serializable id=entity.getCodeitemid();
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



