<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmDutyPickupViewBase from './orm-duty-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-duty/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职务库
 *
 * @export
 * @class OrmDutyPickupView
 * @extends {OrmDutyPickupViewBase}
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
export default class OrmDutyPickupView extends OrmDutyPickupViewBase { }
</script>