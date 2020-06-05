

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjzmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdjzmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydjzmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydjzmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdjzmx pcmydjzmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydjzmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydjzmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdjzmx toPcmydjzmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdjzmx> pcmydjzmx);

    List<PcmYdjzmx> toPcmydjzmx(List<PcmYdmx> pcmydmx);

}


