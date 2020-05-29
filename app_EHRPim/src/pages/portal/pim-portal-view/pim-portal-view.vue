<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPortalViewBase from './pim-portal-view-base.vue';

import view_dashboard from '@widgets/app/pim-portal-view-db-dashboard/pim-portal-view-db-dashboard.vue';

/**
 * Pim门户首页
 *
 * @export
 * @class PimPortalView
 * @extends {PimPortalViewBase}
 */
@Component({
    components: {
        view_dashboard, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PimPortalView extends PimPortalViewBase { }
</script>