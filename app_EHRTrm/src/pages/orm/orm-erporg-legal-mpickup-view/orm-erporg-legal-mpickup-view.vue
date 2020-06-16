<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmErporgLegalMPickupViewBase from './orm-erporg-legal-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-erporg/legal-mpickup-viewpickupviewpanel-pickupviewpanel/legal-mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 管理单位
 *
 * @export
 * @class OrmErporgLegalMPickupView
 * @extends {OrmErporgLegalMPickupViewBase}
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
export default class OrmErporgLegalMPickupView extends OrmErporgLegalMPickupViewBase { }
</script>