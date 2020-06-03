<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESCHANGERedirectViewBase from './pimarchiveschangeredirect-view-base.vue';


/**
 * 档案归档地变更记录数据重定向视图
 *
 * @export
 * @class PIMARCHIVESCHANGERedirectView
 * @extends {PIMARCHIVESCHANGERedirectViewBase}
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
export default class PIMARCHIVESCHANGERedirectView extends PIMARCHIVESCHANGERedirectViewBase { }
</script>