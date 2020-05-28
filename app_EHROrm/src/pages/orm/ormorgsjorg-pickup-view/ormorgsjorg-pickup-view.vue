<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSJOrgPickupViewBase from './ormorgsjorg-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/sjorg-pickup-viewpickupviewpanel-pickupviewpanel/sjorg-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 上级组织选择视图
 *
 * @export
 * @class ORMORGSJOrgPickupView
 * @extends {ORMORGSJOrgPickupViewBase}
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
export default class ORMORGSJOrgPickupView extends ORMORGSJOrgPickupViewBase { }
</script>