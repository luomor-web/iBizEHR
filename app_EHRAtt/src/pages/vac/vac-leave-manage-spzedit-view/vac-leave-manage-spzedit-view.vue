<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveManageSPZEditViewBase from './vac-leave-manage-spzedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/spz-form/spz-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VacLeaveManageSPZEditView
 * @extends {VacLeaveManageSPZEditViewBase}
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
export default class VacLeaveManageSPZEditView extends VacLeaveManageSPZEditViewBase { }
</script>