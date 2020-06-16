<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCourseSystemMPickupViewBase from './trm-course-system-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-course-system/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 课程体系数据多项选择视图
 *
 * @export
 * @class TrmCourseSystemMPickupView
 * @extends {TrmCourseSystemMPickupViewBase}
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
export default class TrmCourseSystemMPickupView extends TrmCourseSystemMPickupViewBase { }
</script>