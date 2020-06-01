<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceMreportEditViewBase from './att-endance-mreport-edit-view-base.vue';

import view_form from '@widgets/att-endance-mreport/main-form/main-form.vue';

/**
 * 考勤月报
 *
 * @export
 * @class AttEndanceMreportEditView
 * @extends {AttEndanceMreportEditViewBase}
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
export default class AttEndanceMreportEditView extends AttEndanceMreportEditViewBase { }
</script>