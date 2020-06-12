<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTRedirectViewBase from './pimcontractredirect-view-base.vue';


/**
 * 合同信息数据重定向视图
 *
 * @export
 * @class PIMCONTRACTRedirectView
 * @extends {PIMCONTRACTRedirectViewBase}
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
export default class PIMCONTRACTRedirectView extends PIMCONTRACTRedirectViewBase { }
</script>