package cn.ibizlab.ehr.core.r7rt_dyna.service.impl;

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
import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaChart;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaChartSearchContext;
import cn.ibizlab.ehr.core.r7rt_dyna.service.IDynaChartService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import cn.ibizlab.ehr.core.r7rt_dyna.client.DynaChartFeignClient;

/**
 * 实体[动态图表] 服务对象接口实现
 */
@Slf4j
@Service
public class DynaChartServiceImpl implements IDynaChartService {

    @Autowired
    DynaChartFeignClient dynaChartFeignClient;


    @Override
    public DynaChart get(String dynachartid) {
		DynaChart et=dynaChartFeignClient.get(dynachartid);
        if(et==null){
            et=new DynaChart();
            et.setDynachartid(dynachartid);
        }
        else{
        }
        return  et;
    }

    @Override
    public DynaChart getDraft(DynaChart et) {
        et=dynaChartFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(DynaChart et) {
        return dynaChartFeignClient.checkKey(et);
    }
    @Override
    public boolean update(DynaChart et) {
        DynaChart rt = dynaChartFeignClient.update(et.getDynachartid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<DynaChart> list){
        dynaChartFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String dynachartid) {
        boolean result=dynaChartFeignClient.remove(dynachartid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        dynaChartFeignClient.removeBatch(idList);
    }

    @Override
    public boolean create(DynaChart et) {
        DynaChart rt = dynaChartFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<DynaChart> list){
        dynaChartFeignClient.createBatch(list) ;
    }

    @Override
    @Transactional
    public boolean save(DynaChart et) {
        if(et.getDynachartid()==null) et.setDynachartid((String)et.getDefaultKey(true));
        if(!dynaChartFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<DynaChart> list) {
        dynaChartFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<DynaChart> searchDefault(DynaChartSearchContext context) {
        Page<DynaChart> dynaCharts=dynaChartFeignClient.searchDefault(context);
        return dynaCharts;
    }


}



