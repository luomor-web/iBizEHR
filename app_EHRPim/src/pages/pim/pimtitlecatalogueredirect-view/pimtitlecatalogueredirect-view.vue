<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLECATALOGUERedirectViewBase from './pimtitlecatalogueredirect-view-base.vue';


/**
 * 职称目录管理数据重定向视图
 *
 * @export
 * @class PIMTITLECATALOGUERedirectView
 * @extends {PIMTITLECATALOGUERedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMTITLECATALOGUERedirectView extends PIMTITLECATALOGUERedirectViewBase { }
</script>