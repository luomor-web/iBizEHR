<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGHTGLDWPickupViewBase from './ormorghtgldwpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/htgldwpickup-viewpickupviewpanel-pickupviewpanel/htgldwpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织选择
 *
 * @export
 * @class ORMORGHTGLDWPickupView
 * @extends {ORMORGHTGLDWPickupViewBase}
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
export default class ORMORGHTGLDWPickupView extends ORMORGHTGLDWPickupViewBase { }
</script>