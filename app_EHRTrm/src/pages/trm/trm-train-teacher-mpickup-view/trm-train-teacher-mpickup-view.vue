<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainTeacherMPickupViewBase from './trm-train-teacher-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-teacher/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训教师数据多项选择视图
 *
 * @export
 * @class TrmTrainTeacherMPickupView
 * @extends {TrmTrainTeacherMPickupViewBase}
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
export default class TrmTrainTeacherMPickupView extends TrmTrainTeacherMPickupViewBase { }
</script>