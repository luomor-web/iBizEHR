<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainActmentEditViewBase from './trm-train-actment-edit-view-base.vue';

import view_form from '@widgets/trm-train-actment/main-form/main-form.vue';

/**
 * 培训后评估
 *
 * @export
 * @class TrmTrainActmentEditView
 * @extends {TrmTrainActmentEditViewBase}
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
export default class TrmTrainActmentEditView extends TrmTrainActmentEditViewBase { }
</script>