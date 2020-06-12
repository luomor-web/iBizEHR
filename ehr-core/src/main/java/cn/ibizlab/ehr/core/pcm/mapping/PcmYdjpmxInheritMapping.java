

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjpmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdjpmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydjpmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydjpmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdjpmx pcmydjpmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydjpmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydjpmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdjpmx toPcmydjpmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdjpmx> pcmydjpmx);

    List<PcmYdjpmx> toPcmydjpmx(List<PcmYdmx> pcmydmx);

}


