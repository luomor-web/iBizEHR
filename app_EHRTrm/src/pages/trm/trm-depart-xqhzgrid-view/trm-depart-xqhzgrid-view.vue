<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDepartXQHZGridViewBase from './trm-depart-xqhzgrid-view-base.vue';

import view_grid from '@widgets/trm-depart/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-depart/default-searchform/default-searchform.vue';

/**
 * 需求填报明细
 *
 * @export
 * @class TrmDepartXQHZGridView
 * @extends {TrmDepartXQHZGridViewBase}
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
export default class TrmDepartXQHZGridView extends TrmDepartXQHZGridViewBase { }
</script>