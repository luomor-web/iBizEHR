<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCHANGERedirectViewBase from './pimpersonchangeredirect-view-base.vue';


/**
 * 人员信息变更审核数据重定向视图
 *
 * @export
 * @class PIMPERSONCHANGERedirectView
 * @extends {PIMPERSONCHANGERedirectViewBase}
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
export default class PIMPERSONCHANGERedirectView extends PIMPERSONCHANGERedirectViewBase { }
</script>