<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLERedirectViewBase from './pimtitleredirect-view-base.vue';


/**
 * 职称信息数据重定向视图
 *
 * @export
 * @class PIMTITLERedirectView
 * @extends {PIMTITLERedirectViewBase}
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
export default class PIMTITLERedirectView extends PIMTITLERedirectViewBase { }
</script>