

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdntmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdntmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydntmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydntmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdntmx pcmydntmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydntmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydntmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdntmx toPcmydntmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdntmx> pcmydntmx);

    List<PcmYdntmx> toPcmydntmx(List<PcmYdmx> pcmydmx);

}


