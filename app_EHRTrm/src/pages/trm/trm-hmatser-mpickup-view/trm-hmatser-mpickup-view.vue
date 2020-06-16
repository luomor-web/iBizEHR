<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmHmatserMPickupViewBase from './trm-hmatser-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-hmatser/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 班主任数据多项选择视图
 *
 * @export
 * @class TrmHmatserMPickupView
 * @extends {TrmHmatserMPickupViewBase}
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
export default class TrmHmatserMPickupView extends TrmHmatserMPickupViewBase { }
</script>