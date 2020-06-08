

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjdmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdjdmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydjdmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydjdmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdjdmx pcmydjdmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydjdmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydjdmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdjdmx toPcmydjdmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdjdmx> pcmydjdmx);

    List<PcmYdjdmx> toPcmydjdmx(List<PcmYdmx> pcmydmx);

}


