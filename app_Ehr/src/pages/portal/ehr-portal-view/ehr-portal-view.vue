<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import EhrPortalViewBase from './ehr-portal-view-base.vue';

import view_dashboard from '@widgets/app/ehr-portal-view-db-dashboard/ehr-portal-view-db-dashboard.vue';

/**
 * Ehr门户首页
 *
 * @export
 * @class EhrPortalView
 * @extends {EhrPortalViewBase}
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
export default class EhrPortalView extends EhrPortalViewBase { }
</script>