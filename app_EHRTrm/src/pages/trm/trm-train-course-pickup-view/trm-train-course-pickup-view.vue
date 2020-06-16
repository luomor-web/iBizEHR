<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainCoursePickupViewBase from './trm-train-course-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-course/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训课程数据选择视图
 *
 * @export
 * @class TrmTrainCoursePickupView
 * @extends {TrmTrainCoursePickupViewBase}
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
export default class TrmTrainCoursePickupView extends TrmTrainCoursePickupViewBase { }
</script>