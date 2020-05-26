<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBQMPickupViewBase from './ormxmbqmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormxmbq/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 项目标签数据多项选择视图
 *
 * @export
 * @class ORMXMBQMPickupView
 * @extends {ORMXMBQMPickupViewBase}
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
export default class ORMXMBQMPickupView extends ORMXMBQMPickupViewBase { }
</script>