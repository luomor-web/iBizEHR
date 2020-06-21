<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainFillinEditViewBase from './trm-train-fillin-edit-view-base.vue';

import view_form from '@widgets/trm-train-fillin/main-form/main-form.vue';

/**
 * 培训需求填报
 *
 * @export
 * @class TrmTrainFillinEditView
 * @extends {TrmTrainFillinEditViewBase}
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
export default class TrmTrainFillinEditView extends TrmTrainFillinEditViewBase { }
</script>