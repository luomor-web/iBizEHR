<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlantermEditViewBase from './trm-train-planterm-edit-view-base.vue';

import view_form from '@widgets/trm-train-planterm/main-form/main-form.vue';

/**
 * 立项信息
 *
 * @export
 * @class TrmTrainPlantermEditView
 * @extends {TrmTrainPlantermEditViewBase}
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
export default class TrmTrainPlantermEditView extends TrmTrainPlantermEditViewBase { }
</script>