<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacHolidayEditViewBase from './vac-holiday-edit-view-base.vue';

import view_form from '@widgets/vac-holiday/main-form/main-form.vue';

/**
 * 节假日/调休上班
 *
 * @export
 * @class VacHolidayEditView
 * @extends {VacHolidayEditViewBase}
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
export default class VacHolidayEditView extends VacHolidayEditViewBase { }
</script>