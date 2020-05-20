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
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[DynaChart] 服务对象接口
 */
@FeignClient(value = "r7rt-dyna", contextId = "DynaChart", fallback = DynaChartFallback.class)
public interface DynaChartFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/dynacharts/select")
    Page<DynaChart> select();


    @RequestMapping(method = RequestMethod.GET, value = "/dynacharts/{dynachartid}")
    DynaChart get(@PathVariable("dynachartid") String dynachartid);


    @RequestMapping(method = RequestMethod.GET, value = "/dynacharts/getdraft")
    DynaChart getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/dynacharts/checkkey")
    Boolean checkKey(@RequestBody DynaChart dynachart);


    @RequestMapping(method = RequestMethod.PUT, value = "/dynacharts/{dynachartid}")
    DynaChart update(@PathVariable("dynachartid") String dynachartid,@RequestBody DynaChart dynachart);

    @RequestMapping(method = RequestMethod.PUT, value = "/dynacharts/batch")
    Boolean updateBatch(@RequestBody List<DynaChart> dynacharts);


    @RequestMapping(method = RequestMethod.DELETE, value = "/dynacharts/{dynachartid}")
    Boolean remove(@PathVariable("dynachartid") String dynachartid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/dynacharts/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.POST, value = "/dynacharts")
    DynaChart create(@RequestBody DynaChart dynachart);

    @RequestMapping(method = RequestMethod.POST, value = "/dynacharts/batch")
    Boolean createBatch(@RequestBody List<DynaChart> dynacharts);


    @RequestMapping(method = RequestMethod.POST, value = "/dynacharts/save")
    Boolean save(@RequestBody DynaChart dynachart);

    @RequestMapping(method = RequestMethod.POST, value = "/dynacharts/save")
    Boolean saveBatch(@RequestBody List<DynaChart> dynacharts);



    @RequestMapping(method = RequestMethod.POST, value = "/dynacharts/searchdefault")
    Page<DynaChart> searchDefault(@RequestBody DynaChartSearchContext context);


}
