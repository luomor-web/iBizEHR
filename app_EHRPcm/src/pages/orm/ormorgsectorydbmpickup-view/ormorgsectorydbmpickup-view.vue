<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORYDBMPickupViewBase from './ormorgsectorydbmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-orgsector/ydbmpickup-viewpickupviewpanel-pickupviewpanel/ydbmpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门选择
 *
 * @export
 * @class ORMORGSECTORYDBMPickupView
 * @extends {ORMORGSECTORYDBMPickupViewBase}
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
export default class ORMORGSECTORYDBMPickupView extends ORMORGSECTORYDBMPickupViewBase { }
</script>