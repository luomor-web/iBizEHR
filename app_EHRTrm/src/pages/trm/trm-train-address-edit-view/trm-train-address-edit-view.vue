<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAddressEditViewBase from './trm-train-address-edit-view-base.vue';

import view_form from '@widgets/trm-train-address/main-form/main-form.vue';

/**
 * 培训场地
 *
 * @export
 * @class TrmTrainAddressEditView
 * @extends {TrmTrainAddressEditViewBase}
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
export default class TrmTrainAddressEditView extends TrmTrainAddressEditViewBase { }
</script>