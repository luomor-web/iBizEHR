<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVALCATALOGUERedirectViewBase from './archivalcatalogueredirect-view-base.vue';


/**
 * 档案目录数据重定向视图
 *
 * @export
 * @class ARCHIVALCATALOGUERedirectView
 * @extends {ARCHIVALCATALOGUERedirectViewBase}
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
export default class ARCHIVALCATALOGUERedirectView extends ARCHIVALCATALOGUERedirectViewBase { }
</script>