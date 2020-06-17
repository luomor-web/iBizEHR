<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainFaciesEditViewBase from './trm-train-facies-edit-view-base.vue';

import view_form from '@widgets/trm-train-facies/main-form/main-form.vue';

/**
 * 培训设施
 *
 * @export
 * @class TrmTrainFaciesEditView
 * @extends {TrmTrainFaciesEditViewBase}
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
export default class TrmTrainFaciesEditView extends TrmTrainFaciesEditViewBase { }
</script>