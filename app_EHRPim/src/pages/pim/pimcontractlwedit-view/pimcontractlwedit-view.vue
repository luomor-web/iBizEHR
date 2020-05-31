<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTLWEditViewBase from './pimcontractlwedit-view-base.vue';

import view_form from '@widgets/pim-contract/lab-services-edit-grid-form/lab-services-edit-grid-form.vue';

/**
 * 合同信息编辑视图
 *
 * @export
 * @class PIMCONTRACTLWEditView
 * @extends {PIMCONTRACTLWEditViewBase}
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
export default class PIMCONTRACTLWEditView extends PIMCONTRACTLWEditViewBase { }
</script>