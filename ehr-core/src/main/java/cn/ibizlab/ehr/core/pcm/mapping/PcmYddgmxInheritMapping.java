

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYddgmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYddgmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmyddgmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmyddgmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYddgmx pcmyddgmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmyddgmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmyddgmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYddgmx toPcmyddgmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYddgmx> pcmyddgmx);

    List<PcmYddgmx> toPcmyddgmx(List<PcmYdmx> pcmydmx);

}


