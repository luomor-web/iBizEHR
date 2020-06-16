<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCourseSystemPickupViewBase from './trm-course-system-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-course-system/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 课程体系数据选择视图
 *
 * @export
 * @class TrmCourseSystemPickupView
 * @extends {TrmCourseSystemPickupViewBase}
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
export default class TrmCourseSystemPickupView extends TrmCourseSystemPickupViewBase { }
</script>