<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveDetailEditViewBase from './vac-leave-detail-edit-view-base.vue';

import view_form from '@widgets/vac-leave-detail/main-form/main-form.vue';

/**
 * 请销假明细编辑视图
 *
 * @export
 * @class VacLeaveDetailEditView
 * @extends {VacLeaveDetailEditViewBase}
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
export default class VacLeaveDetailEditView extends VacLeaveDetailEditViewBase { }
</script>