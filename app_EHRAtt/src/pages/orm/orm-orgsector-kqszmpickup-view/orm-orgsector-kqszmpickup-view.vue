<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgsectorKQSZMPickupViewBase from './orm-orgsector-kqszmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-orgsector/kqszmpickup-viewpickupviewpanel-pickupviewpanel/kqszmpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门管理数据多项选择视图
 *
 * @export
 * @class OrmOrgsectorKQSZMPickupView
 * @extends {OrmOrgsectorKQSZMPickupViewBase}
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
export default class OrmOrgsectorKQSZMPickupView extends OrmOrgsectorKQSZMPickupViewBase { }
</script>