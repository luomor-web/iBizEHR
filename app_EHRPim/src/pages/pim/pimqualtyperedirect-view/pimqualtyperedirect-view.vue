<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALTYPERedirectViewBase from './pimqualtyperedirect-view-base.vue';


/**
 * 执业资格类别数据重定向视图
 *
 * @export
 * @class PIMQUALTYPERedirectView
 * @extends {PIMQUALTYPERedirectViewBase}
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
export default class PIMQUALTYPERedirectView extends PIMQUALTYPERedirectViewBase { }
</script>