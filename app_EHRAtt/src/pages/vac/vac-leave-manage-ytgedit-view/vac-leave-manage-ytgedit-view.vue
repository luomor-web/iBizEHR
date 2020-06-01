<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveManageYTGEditViewBase from './vac-leave-manage-ytgedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/ytg-form/ytg-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VacLeaveManageYTGEditView
 * @extends {VacLeaveManageYTGEditViewBase}
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
export default class VacLeaveManageYTGEditView extends VacLeaveManageYTGEditViewBase { }
</script>