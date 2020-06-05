

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdtxmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdtxmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydtxmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydtxmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdtxmx pcmydtxmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydtxmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydtxmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdtxmx toPcmydtxmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdtxmx> pcmydtxmx);

    List<PcmYdtxmx> toPcmydtxmx(List<PcmYdmx> pcmydmx);

}


