<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmPostORGIDPickupViewBase from './orm-post-orgidpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-post/orgidpickup-viewpickupviewpanel-pickupviewpanel/orgidpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 岗位管理数据选择视图
 *
 * @export
 * @class OrmPostORGIDPickupView
 * @extends {OrmPostORGIDPickupViewBase}
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
export default class OrmPostORGIDPickupView extends OrmPostORGIDPickupViewBase { }
</script>