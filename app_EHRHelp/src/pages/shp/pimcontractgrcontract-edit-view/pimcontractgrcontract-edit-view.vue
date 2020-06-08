<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTGRContractEditViewBase from './pimcontractgrcontract-edit-view-base.vue';

import view_form from '@widgets/pim-contract/grcontract-edit-grid-form/grcontract-edit-grid-form.vue';

/**
 * 合同信息编辑视图
 *
 * @export
 * @class PIMCONTRACTGRContractEditView
 * @extends {PIMCONTRACTGRContractEditViewBase}
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
export default class PIMCONTRACTGRContractEditView extends PIMCONTRACTGRContractEditViewBase { }
</script>