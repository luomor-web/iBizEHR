<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMAWARDSWONSHJQKGridViewBase from './pcmawardswonshjqkgrid-view-base.vue';

import view_grid from '@widgets/pcmawardswons/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcmawardswons/default-searchform/default-searchform.vue';

/**
 * 获奖情况（要求：带*必填）
 *
 * @export
 * @class PCMAWARDSWONSHJQKGridView
 * @extends {PCMAWARDSWONSHJQKGridViewBase}
 */
@Component({
    components: {
        view_grid, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMAWARDSWONSHJQKGridView extends PCMAWARDSWONSHJQKGridViewBase { }
</script>