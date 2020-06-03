<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTTYPERedirectViewBase from './pimcontracttyperedirect-view-base.vue';


/**
 * 合同/协议类型管理数据重定向视图
 *
 * @export
 * @class PIMCONTRACTTYPERedirectView
 * @extends {PIMCONTRACTTYPERedirectViewBase}
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
export default class PIMCONTRACTTYPERedirectView extends PIMCONTRACTTYPERedirectViewBase { }
</script>