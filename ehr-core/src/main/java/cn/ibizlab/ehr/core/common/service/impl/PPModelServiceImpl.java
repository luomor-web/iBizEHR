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
import cn.ibizlab.ehr.core.common.domain.PPModel;
import cn.ibizlab.ehr.core.common.filter.PPModelSearchContext;
import cn.ibizlab.ehr.core.common.service.IPPModelService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.PPModelMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[门户页面模型] 服务对象接口实现
 */
@Slf4j
@Service("PPModelServiceImpl")
public class PPModelServiceImpl extends ServiceImpl<PPModelMapper, PPModel> implements IPPModelService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IPortalPageService portalpageService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IPVPartService pvpartService;

    private int batchSize = 500;

    @Override
    public PPModel getDraft(PPModel et) {
        fillParentData(et);
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
    public boolean checkKey(PPModel et) {
        return (!ObjectUtils.isEmpty(et.getPpmodelid()))&&(!Objects.isNull(this.getById(et.getPpmodelid())));
    }

    @Override
    @Transactional
    public boolean save(PPModel et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PPModel et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PPModel> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PPModel get(String key) {
        PPModel et = getById(key);
        if(et==null){
            et=new PPModel();
            et.setPpmodelid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PPModel et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPpmodelid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PPModel> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PPModel et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("ppmodelid",et.getPpmodelid())))
            return false;
        CachedBeanCopier.copy(get(et.getPpmodelid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PPModel> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<PPModel> selectByPortalpageid(String portalpageid) {
        return baseMapper.selectByPortalpageid(portalpageid);
    }

    @Override
    public void removeByPortalpageid(String portalpageid) {
        this.remove(new QueryWrapper<PPModel>().eq("portalpageid",portalpageid));
    }

	@Override
    public List<PPModel> selectByC1pvpartid(String pvpartid) {
        return baseMapper.selectByC1pvpartid(pvpartid);
    }

    @Override
    public void removeByC1pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("c1pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByC2pvpartid(String pvpartid) {
        return baseMapper.selectByC2pvpartid(pvpartid);
    }

    @Override
    public void removeByC2pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("c2pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByC3pvpartid(String pvpartid) {
        return baseMapper.selectByC3pvpartid(pvpartid);
    }

    @Override
    public void removeByC3pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("c3pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByC4pvpartid(String pvpartid) {
        return baseMapper.selectByC4pvpartid(pvpartid);
    }

    @Override
    public void removeByC4pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("c4pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByL1pvpartid(String pvpartid) {
        return baseMapper.selectByL1pvpartid(pvpartid);
    }

    @Override
    public void removeByL1pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("l1pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByL2pvpartid(String pvpartid) {
        return baseMapper.selectByL2pvpartid(pvpartid);
    }

    @Override
    public void removeByL2pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("l2pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByL3pvpartid(String pvpartid) {
        return baseMapper.selectByL3pvpartid(pvpartid);
    }

    @Override
    public void removeByL3pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("l3pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByL4pvpartid(String pvpartid) {
        return baseMapper.selectByL4pvpartid(pvpartid);
    }

    @Override
    public void removeByL4pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("l4pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByR1pvpartid(String pvpartid) {
        return baseMapper.selectByR1pvpartid(pvpartid);
    }

    @Override
    public void removeByR1pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("r1pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByR2pvpartid(String pvpartid) {
        return baseMapper.selectByR2pvpartid(pvpartid);
    }

    @Override
    public void removeByR2pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("r2pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByR3pvpartid(String pvpartid) {
        return baseMapper.selectByR3pvpartid(pvpartid);
    }

    @Override
    public void removeByR3pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("r3pvpartid",pvpartid));
    }

	@Override
    public List<PPModel> selectByR4pvpartid(String pvpartid) {
        return baseMapper.selectByR4pvpartid(pvpartid);
    }

    @Override
    public void removeByR4pvpartid(String pvpartid) {
        this.remove(new QueryWrapper<PPModel>().eq("r4pvpartid",pvpartid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PPModel> searchDefault(PPModelSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PPModel> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PPModel>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PPModel et){
        //实体关系[DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID]
        if(!ObjectUtils.isEmpty(et.getPortalpageid())){
            cn.ibizlab.ehr.core.common.domain.PortalPage portalpage=et.getPortalpage();
            if(ObjectUtils.isEmpty(portalpage)){
                cn.ibizlab.ehr.core.common.domain.PortalPage majorEntity=portalpageService.get(et.getPortalpageid());
                et.setPortalpage(majorEntity);
                portalpage=majorEntity;
            }
            et.setPortalpagename(portalpage.getPortalpagename());
        }
        //实体关系[DER1N_PPMODEL_PVPART_C1PVPARTID]
        if(!ObjectUtils.isEmpty(et.getC1pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart c1pvpart=et.getC1pvpart();
            if(ObjectUtils.isEmpty(c1pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getC1pvpartid());
                et.setC1pvpart(majorEntity);
                c1pvpart=majorEntity;
            }
            et.setC1pvpartname(c1pvpart.getPvpartname());
            et.setC1pvpartctrlid(c1pvpart.getCtrlid());
        }
        //实体关系[DER1N_PPMODEL_PVPART_C2PVPARTID]
        if(!ObjectUtils.isEmpty(et.getC2pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart c2pvpart=et.getC2pvpart();
            if(ObjectUtils.isEmpty(c2pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getC2pvpartid());
                et.setC2pvpart(majorEntity);
                c2pvpart=majorEntity;
            }
            et.setC2pvpartctrlid(c2pvpart.getCtrlid());
            et.setC2pvpartname(c2pvpart.getPvpartname());
        }
        //实体关系[DER1N_PPMODEL_PVPART_C3PVPARTID]
        if(!ObjectUtils.isEmpty(et.getC3pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart c3pvpart=et.getC3pvpart();
            if(ObjectUtils.isEmpty(c3pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getC3pvpartid());
                et.setC3pvpart(majorEntity);
                c3pvpart=majorEntity;
            }
            et.setC3pvpartname(c3pvpart.getPvpartname());
            et.setC3pvpartctrlid(c3pvpart.getCtrlid());
        }
        //实体关系[DER1N_PPMODEL_PVPART_C4PVPARTID]
        if(!ObjectUtils.isEmpty(et.getC4pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart c4pvpart=et.getC4pvpart();
            if(ObjectUtils.isEmpty(c4pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getC4pvpartid());
                et.setC4pvpart(majorEntity);
                c4pvpart=majorEntity;
            }
            et.setC4pvpartctrlid(c4pvpart.getCtrlid());
            et.setC4pvpartname(c4pvpart.getPvpartname());
        }
        //实体关系[DER1N_PPMODEL_PVPART_L1PVPARTID]
        if(!ObjectUtils.isEmpty(et.getL1pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart l1pvpart=et.getL1pvpart();
            if(ObjectUtils.isEmpty(l1pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getL1pvpartid());
                et.setL1pvpart(majorEntity);
                l1pvpart=majorEntity;
            }
            et.setL1pvpartctrlid(l1pvpart.getCtrlid());
            et.setL1pvpartname(l1pvpart.getPvpartname());
        }
        //实体关系[DER1N_PPMODEL_PVPART_L2PVPARTID]
        if(!ObjectUtils.isEmpty(et.getL2pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart l2pvpart=et.getL2pvpart();
            if(ObjectUtils.isEmpty(l2pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getL2pvpartid());
                et.setL2pvpart(majorEntity);
                l2pvpart=majorEntity;
            }
            et.setL2pvpartname(l2pvpart.getPvpartname());
            et.setL2pvpartctrlid(l2pvpart.getCtrlid());
        }
        //实体关系[DER1N_PPMODEL_PVPART_L3PVPARTID]
        if(!ObjectUtils.isEmpty(et.getL3pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart l3pvpart=et.getL3pvpart();
            if(ObjectUtils.isEmpty(l3pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getL3pvpartid());
                et.setL3pvpart(majorEntity);
                l3pvpart=majorEntity;
            }
            et.setL3pvpartname(l3pvpart.getPvpartname());
            et.setL3pvpartctrlid(l3pvpart.getCtrlid());
        }
        //实体关系[DER1N_PPMODEL_PVPART_L4PVPARTID]
        if(!ObjectUtils.isEmpty(et.getL4pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart l4pvpart=et.getL4pvpart();
            if(ObjectUtils.isEmpty(l4pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getL4pvpartid());
                et.setL4pvpart(majorEntity);
                l4pvpart=majorEntity;
            }
            et.setL4pvpartctrlid(l4pvpart.getCtrlid());
            et.setL4pvpartname(l4pvpart.getPvpartname());
        }
        //实体关系[DER1N_PPMODEL_PVPART_R1PVPARTID]
        if(!ObjectUtils.isEmpty(et.getR1pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart r1pvpart=et.getR1pvpart();
            if(ObjectUtils.isEmpty(r1pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getR1pvpartid());
                et.setR1pvpart(majorEntity);
                r1pvpart=majorEntity;
            }
            et.setR1pvpartname(r1pvpart.getPvpartname());
            et.setR1pvpartctrlid(r1pvpart.getCtrlid());
        }
        //实体关系[DER1N_PPMODEL_PVPART_R2PVPARTID]
        if(!ObjectUtils.isEmpty(et.getR2pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart r2pvpart=et.getR2pvpart();
            if(ObjectUtils.isEmpty(r2pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getR2pvpartid());
                et.setR2pvpart(majorEntity);
                r2pvpart=majorEntity;
            }
            et.setR2pvpartctrlid(r2pvpart.getCtrlid());
            et.setR2pvpartname(r2pvpart.getPvpartname());
        }
        //实体关系[DER1N_PPMODEL_PVPART_R3PVPARTID]
        if(!ObjectUtils.isEmpty(et.getR3pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart r3pvpart=et.getR3pvpart();
            if(ObjectUtils.isEmpty(r3pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getR3pvpartid());
                et.setR3pvpart(majorEntity);
                r3pvpart=majorEntity;
            }
            et.setR3pvpartctrlid(r3pvpart.getCtrlid());
            et.setR3pvpartname(r3pvpart.getPvpartname());
        }
        //实体关系[DER1N_PPMODEL_PVPART_R4PVPARTID]
        if(!ObjectUtils.isEmpty(et.getR4pvpartid())){
            cn.ibizlab.ehr.core.common.domain.PVPart r4pvpart=et.getR4pvpart();
            if(ObjectUtils.isEmpty(r4pvpart)){
                cn.ibizlab.ehr.core.common.domain.PVPart majorEntity=pvpartService.get(et.getR4pvpartid());
                et.setR4pvpart(majorEntity);
                r4pvpart=majorEntity;
            }
            et.setR4pvpartname(r4pvpart.getPvpartname());
            et.setR4pvpartctrlid(r4pvpart.getCtrlid());
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


