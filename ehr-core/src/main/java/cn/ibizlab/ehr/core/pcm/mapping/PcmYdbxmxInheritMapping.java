

package cn.ibizlab.ehr.core.pcm.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdbxmx;
import cn.ibizlab.ehr.core.pcm.domain.PcmYdmx;
import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PcmYdbxmxInheritMapping {

    @Mappings({
        @Mapping(source ="pcmydbxmxid",target = "pcmydmxid"),
        @Mapping(source ="pcmydbxmxname",target = "pcmydmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdmx toPcmydmx(PcmYdbxmx pcmydbxmx);

    @Mappings({
        @Mapping(source ="pcmydmxid" ,target = "pcmydbxmxid"),
        @Mapping(source ="pcmydmxname" ,target = "pcmydbxmxname"),
        @Mapping(target ="focusNull",ignore = true),
    })
    PcmYdbxmx toPcmydbxmx(PcmYdmx pcmydmx);

    List<PcmYdmx> toPcmydmx(List<PcmYdbxmx> pcmydbxmx);

    List<PcmYdbxmx> toPcmydbxmx(List<PcmYdmx> pcmydmx);

}


