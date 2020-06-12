<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMSTAFFTYPERedirectViewBase from './pimstafftyperedirect-view-base.vue';


/**
 * 员工类型管理数据重定向视图
 *
 * @export
 * @class PIMSTAFFTYPERedirectView
 * @extends {PIMSTAFFTYPERedirectViewBase}
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
export default class PIMSTAFFTYPERedirectView extends PIMSTAFFTYPERedirectViewBase { }
</script>