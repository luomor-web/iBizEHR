<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmPostPickupViewBase from './orm-post-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-post/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 岗位管理数据选择视图
 *
 * @export
 * @class OrmPostPickupView
 * @extends {OrmPostPickupViewBase}
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
export default class OrmPostPickupView extends OrmPostPickupViewBase { }
</script>