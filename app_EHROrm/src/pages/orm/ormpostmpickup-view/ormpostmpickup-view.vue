<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTMPickupViewBase from './ormpostmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormpost/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 岗位管理数据多项选择视图
 *
 * @export
 * @class ORMPOSTMPickupView
 * @extends {ORMPOSTMPickupViewBase}
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
export default class ORMPOSTMPickupView extends ORMPOSTMPickupViewBase { }
</script>