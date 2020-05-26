<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTGWBZXZMPickupViewBase from './ormpostgwbzxzmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormpost/gwbzxzmpickup-viewpickupviewpanel-pickupviewpanel/gwbzxzmpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 岗位库
 *
 * @export
 * @class ORMPOSTGWBZXZMPickupView
 * @extends {ORMPOSTGWBZXZMPickupViewBase}
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
export default class ORMPOSTGWBZXZMPickupView extends ORMPOSTGWBZXZMPickupViewBase { }
</script>