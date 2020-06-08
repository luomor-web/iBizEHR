<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVESCENTERPickupViewBase from './archivescenterpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-archives-center/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 档案室管理数据选择视图
 *
 * @export
 * @class ARCHIVESCENTERPickupView
 * @extends {ARCHIVESCENTERPickupViewBase}
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
export default class ARCHIVESCENTERPickupView extends ARCHIVESCENTERPickupViewBase { }
</script>