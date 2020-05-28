<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVESMANAGERedirectViewBase from './archivesmanageredirect-view-base.vue';


/**
 * 档案管理数据重定向视图
 *
 * @export
 * @class ARCHIVESMANAGERedirectView
 * @extends {ARCHIVESMANAGERedirectViewBase}
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
export default class ARCHIVESMANAGERedirectView extends ARCHIVESMANAGERedirectViewBase { }
</script>