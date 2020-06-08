<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgsectorPickupViewBase from './orm-orgsector-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-orgsector/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门管理数据选择视图
 *
 * @export
 * @class OrmOrgsectorPickupView
 * @extends {OrmOrgsectorPickupViewBase}
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
export default class OrmOrgsectorPickupView extends OrmOrgsectorPickupViewBase { }
</script>