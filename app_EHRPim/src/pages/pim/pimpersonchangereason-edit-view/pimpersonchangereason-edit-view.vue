<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCHANGEReasonEditViewBase from './pimpersonchangereason-edit-view-base.vue';

import view_form from '@widgets/pim-person-change/reason-edit-form/reason-edit-form.vue';

/**
 * 驳回原因
 *
 * @export
 * @class PIMPERSONCHANGEReasonEditView
 * @extends {PIMPERSONCHANGEReasonEditViewBase}
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
export default class PIMPERSONCHANGEReasonEditView extends PIMPERSONCHANGEReasonEditViewBase { }
</script>