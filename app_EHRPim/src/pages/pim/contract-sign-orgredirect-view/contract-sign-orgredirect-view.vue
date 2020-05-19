<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ContractSignORGRedirectViewBase from './contract-sign-orgredirect-view-base.vue';


/**
 * 签约主体单位数据重定向视图
 *
 * @export
 * @class ContractSignORGRedirectView
 * @extends {ContractSignORGRedirectViewBase}
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
export default class ContractSignORGRedirectView extends ContractSignORGRedirectViewBase { }
</script>