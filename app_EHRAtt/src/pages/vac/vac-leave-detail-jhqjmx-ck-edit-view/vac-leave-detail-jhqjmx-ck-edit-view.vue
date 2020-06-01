<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveDetailJHQJMX_CK_EditViewBase from './vac-leave-detail-jhqjmx-ck-edit-view-base.vue';

import view_form from '@widgets/vac-leave-detail/jhqjmx-ck-form/jhqjmx-ck-form.vue';

/**
 * 请假明细
 *
 * @export
 * @class VacLeaveDetailJHQJMX_CK_EditView
 * @extends {VacLeaveDetailJHQJMX_CK_EditViewBase}
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
export default class VacLeaveDetailJHQJMX_CK_EditView extends VacLeaveDetailJHQJMX_CK_EditViewBase { }
</script>