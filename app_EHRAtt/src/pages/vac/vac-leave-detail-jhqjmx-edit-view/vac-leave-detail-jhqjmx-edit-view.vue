<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveDetailJHQJMX_EditViewBase from './vac-leave-detail-jhqjmx-edit-view-base.vue';

import view_form from '@widgets/vac-leave-detail/jhqjmx-form/jhqjmx-form.vue';

/**
 * 请假明细
 *
 * @export
 * @class VacLeaveDetailJHQJMX_EditView
 * @extends {VacLeaveDetailJHQJMX_EditViewBase}
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
export default class VacLeaveDetailJHQJMX_EditView extends VacLeaveDetailJHQJMX_EditViewBase { }
</script>