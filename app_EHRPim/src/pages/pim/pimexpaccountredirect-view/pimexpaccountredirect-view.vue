<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXPACCOUNTRedirectViewBase from './pimexpaccountredirect-view-base.vue';


/**
 * 费用台账数据重定向视图
 *
 * @export
 * @class PIMEXPACCOUNTRedirectView
 * @extends {PIMEXPACCOUNTRedirectViewBase}
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
export default class PIMEXPACCOUNTRedirectView extends PIMEXPACCOUNTRedirectViewBase { }
</script>