<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTRenewEditViewBase from './pimcontractrenew-edit-view-base.vue';

import view_form from '@widgets/pim-contract/main-form/main-form.vue';

/**
 * 合同信息编辑视图（新签/续签）
 *
 * @export
 * @class PIMCONTRACTRenewEditView
 * @extends {PIMCONTRACTRenewEditViewBase}
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
export default class PIMCONTRACTRenewEditView extends PIMCONTRACTRenewEditViewBase { }
</script>