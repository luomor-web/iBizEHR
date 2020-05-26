<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMGLPickupViewBase from './ormxmglpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormxmgl/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * ERP项目库
 *
 * @export
 * @class ORMXMGLPickupView
 * @extends {ORMXMGLPickupViewBase}
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
export default class ORMXMGLPickupView extends ORMXMGLPickupViewBase { }
</script>