<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveManageNGEditViewBase from './vac-leave-manage-ngedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/ng-form/ng-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VacLeaveManageNGEditView
 * @extends {VacLeaveManageNGEditViewBase}
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
export default class VacLeaveManageNGEditView extends VacLeaveManageNGEditViewBase { }
</script>