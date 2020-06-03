<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveTipsEditViewBase from './vac-leave-tips-edit-view-base.vue';

import view_form from '@widgets/vac-leave-tips/main-form/main-form.vue';

/**
 * 请假提示
 *
 * @export
 * @class VacLeaveTipsEditView
 * @extends {VacLeaveTipsEditViewBase}
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
export default class VacLeaveTipsEditView extends VacLeaveTipsEditViewBase { }
</script>