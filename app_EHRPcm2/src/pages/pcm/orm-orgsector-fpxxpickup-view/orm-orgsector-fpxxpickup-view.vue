<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgsectorFPXXPickupViewBase from './orm-orgsector-fpxxpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-orgsector/fpxxpickup-viewpickupviewpanel-pickupviewpanel/fpxxpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门选择
 *
 * @export
 * @class OrmOrgsectorFPXXPickupView
 * @extends {OrmOrgsectorFPXXPickupViewBase}
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
export default class OrmOrgsectorFPXXPickupView extends OrmOrgsectorFPXXPickupViewBase { }
</script>