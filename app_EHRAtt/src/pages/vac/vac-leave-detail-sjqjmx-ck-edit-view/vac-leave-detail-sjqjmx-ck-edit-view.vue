<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveDetailSJQJMX_CK_EditViewBase from './vac-leave-detail-sjqjmx-ck-edit-view-base.vue';

import view_form from '@widgets/vac-leave-detail/sjqjmx-ck-form/sjqjmx-ck-form.vue';

/**
 * 请假明细
 *
 * @export
 * @class VacLeaveDetailSJQJMX_CK_EditView
 * @extends {VacLeaveDetailSJQJMX_CK_EditViewBase}
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
export default class VacLeaveDetailSJQJMX_CK_EditView extends VacLeaveDetailSJQJMX_CK_EditViewBase { }
</script>