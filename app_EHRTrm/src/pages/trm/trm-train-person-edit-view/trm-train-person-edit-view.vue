<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPersonEditViewBase from './trm-train-person-edit-view-base.vue';

import view_form from '@widgets/trm-train-person/main-form/main-form.vue';

/**
 * 培训人员编辑视图
 *
 * @export
 * @class TrmTrainPersonEditView
 * @extends {TrmTrainPersonEditViewBase}
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
export default class TrmTrainPersonEditView extends TrmTrainPersonEditViewBase { }
</script>