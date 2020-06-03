<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostLibPickupViewBase from './ormpost-lib-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-post-lib/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 标准岗位
 *
 * @export
 * @class ORMPostLibPickupView
 * @extends {ORMPostLibPickupViewBase}
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
export default class ORMPostLibPickupView extends ORMPostLibPickupViewBase { }
</script>