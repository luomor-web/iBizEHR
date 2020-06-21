<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainBuapplyEditViewBase from './trm-train-buapply-edit-view-base.vue';

import view_form from '@widgets/trm-train-buapply/main-form/main-form.vue';

/**
 * 培训费用登记
 *
 * @export
 * @class TrmTrainBuapplyEditView
 * @extends {TrmTrainBuapplyEditViewBase}
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
export default class TrmTrainBuapplyEditView extends TrmTrainBuapplyEditViewBase { }
</script>