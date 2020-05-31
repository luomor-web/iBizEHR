<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMDISTIRBUTIONMaturityDueEditViewBase from './pimdistirbutionmaturity-due-edit-view-base.vue';

import view_form from '@widgets/pim-distirbution/maturity-due-edit-form-form/maturity-due-edit-form-form.vue';

/**
 * 借调到期编辑视图
 *
 * @export
 * @class PIMDISTIRBUTIONMaturityDueEditView
 * @extends {PIMDISTIRBUTIONMaturityDueEditViewBase}
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
export default class PIMDISTIRBUTIONMaturityDueEditView extends PIMDISTIRBUTIONMaturityDueEditViewBase { }
</script>