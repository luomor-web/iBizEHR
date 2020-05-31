<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMDISTIRBUTIONGRDividerEditViewBase from './pimdistirbutiongrdivider-edit-view-base.vue';

import view_form from '@widgets/pim-distirbution/grdivider-edit-grid-form/grdivider-edit-grid-form.vue';

/**
 * 分配信息编辑视图
 *
 * @export
 * @class PIMDISTIRBUTIONGRDividerEditView
 * @extends {PIMDISTIRBUTIONGRDividerEditViewBase}
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
export default class PIMDISTIRBUTIONGRDividerEditView extends PIMDISTIRBUTIONGRDividerEditViewBase { }
</script>