<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ContractSignORGEditViewBase from './contract-sign-orgedit-view-base.vue';

import view_form from '@widgets/pim-contract-sign-org/main-form/main-form.vue';

/**
 * 法人主体设置编辑视图
 *
 * @export
 * @class ContractSignORGEditView
 * @extends {ContractSignORGEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ContractSignORGEditView extends ContractSignORGEditViewBase { }
</script>