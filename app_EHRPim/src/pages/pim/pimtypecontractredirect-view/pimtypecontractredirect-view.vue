<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTYPECONTRACTRedirectViewBase from './pimtypecontractredirect-view-base.vue';


/**
 * 合同类型数据重定向视图
 *
 * @export
 * @class PIMTYPECONTRACTRedirectView
 * @extends {PIMTYPECONTRACTRedirectViewBase}
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
export default class PIMTYPECONTRACTRedirectView extends PIMTYPECONTRACTRedirectViewBase { }
</script>