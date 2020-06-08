

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdgzmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdgzmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydgzmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydgzmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdgzmx pcmydgzmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydgzmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydgzmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdgzmx toPcmydgzmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdgzmx> pcmydgzmx);

    List<PcmYdgzmx> toPcmydgzmx(List<PcmYdmx> pcmydmx);

}


