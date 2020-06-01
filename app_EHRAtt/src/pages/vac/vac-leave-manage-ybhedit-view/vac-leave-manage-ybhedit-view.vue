<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveManageYBHEditViewBase from './vac-leave-manage-ybhedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/ybh-form/ybh-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VacLeaveManageYBHEditView
 * @extends {VacLeaveManageYBHEditViewBase}
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
export default class VacLeaveManageYBHEditView extends VacLeaveManageYBHEditViewBase { }
</script>