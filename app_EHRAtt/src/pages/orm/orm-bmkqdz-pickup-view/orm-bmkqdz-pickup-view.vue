<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmBmkqdzPickupViewBase from './orm-bmkqdz-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-bmkqdz/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门地址维护数据选择视图
 *
 * @export
 * @class OrmBmkqdzPickupView
 * @extends {OrmBmkqdzPickupViewBase}
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
export default class OrmBmkqdzPickupView extends OrmBmkqdzPickupViewBase { }
</script>