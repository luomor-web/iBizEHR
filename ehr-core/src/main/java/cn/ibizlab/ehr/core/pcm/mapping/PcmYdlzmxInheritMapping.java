

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdlzmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdlzmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydlzmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydlzmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdlzmx pcmydlzmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydlzmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydlzmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdlzmx toPcmydlzmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdlzmx> pcmydlzmx);

    List<PcmYdlzmx> toPcmydlzmx(List<PcmYdmx> pcmydmx);

}


