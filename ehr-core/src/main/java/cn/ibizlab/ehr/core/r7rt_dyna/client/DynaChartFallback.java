package cn.ibizlab.ehr.core.r7rt_dyna.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaChart;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaChartSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[DynaChart] 服务对象接口
 */
@Component
public class DynaChartFallback implements DynaChartFeignClient{

    public Page<DynaChart> select(){
            return null;
     }

    public DynaChart get(String dynachartid){
            return null;
     }


    public DynaChart getDraft(){
            return null;
    }



    public Boolean checkKey(DynaChart dynachart){
            return false;
     }


    public DynaChart update(String dynachartid, DynaChart dynachart){
            return null;
     }
    public Boolean updateBatch(List<DynaChart> dynacharts){
            return false;
     }


    public Boolean remove(String dynachartid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public DynaChart create(DynaChart dynachart){
            return null;
     }
    public Boolean createBatch(List<DynaChart> dynacharts){
            return false;
     }

    public Boolean save(DynaChart dynachart){
            return false;
     }
    public Boolean saveBatch(List<DynaChart> dynacharts){
            return false;
     }

    public Page<DynaChart> searchDefault(DynaChartSearchContext context){
            return null;
     }


}
