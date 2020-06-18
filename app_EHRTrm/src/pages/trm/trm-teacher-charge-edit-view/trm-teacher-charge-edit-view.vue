<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTeacherChargeEditViewBase from './trm-teacher-charge-edit-view-base.vue';

import view_form from '@widgets/trm-teacher-charge/main-form/main-form.vue';

/**
 * 讲师费用台账
 *
 * @export
 * @class TrmTeacherChargeEditView
 * @extends {TrmTeacherChargeEditViewBase}
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
export default class TrmTeacherChargeEditView extends TrmTeacherChargeEditViewBase { }
</script>