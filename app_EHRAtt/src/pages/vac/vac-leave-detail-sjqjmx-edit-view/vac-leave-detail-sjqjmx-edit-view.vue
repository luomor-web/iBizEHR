<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveDetailSJQJMX_EditViewBase from './vac-leave-detail-sjqjmx-edit-view-base.vue';

import view_form from '@widgets/vac-leave-detail/sjqjmx-form/sjqjmx-form.vue';

/**
 * 请假明细
 *
 * @export
 * @class VacLeaveDetailSJQJMX_EditView
 * @extends {VacLeaveDetailSJQJMX_EditViewBase}
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
export default class VacLeaveDetailSJQJMX_EditView extends VacLeaveDetailSJQJMX_EditViewBase { }
</script>