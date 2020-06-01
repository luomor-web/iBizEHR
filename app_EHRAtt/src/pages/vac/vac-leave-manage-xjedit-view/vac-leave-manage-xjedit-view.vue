<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveManageXJEditViewBase from './vac-leave-manage-xjedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/xj-form/xj-form.vue';

/**
 * 销假
 *
 * @export
 * @class VacLeaveManageXJEditView
 * @extends {VacLeaveManageXJEditViewBase}
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
export default class VacLeaveManageXJEditView extends VacLeaveManageXJEditViewBase { }
</script>