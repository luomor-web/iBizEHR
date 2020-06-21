<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainTeacherPickupViewBase from './trm-train-teacher-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-teacher/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训教师数据选择视图
 *
 * @export
 * @class TrmTrainTeacherPickupView
 * @extends {TrmTrainTeacherPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TrmTrainTeacherPickupView extends TrmTrainTeacherPickupViewBase { }
</script>