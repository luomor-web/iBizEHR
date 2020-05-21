<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESCHANGEGridViewBase from './pimarchiveschangegrid-view-base.vue';

import view_grid from '@widgets/pimarchiveschange/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimarchiveschange/default-searchform/default-searchform.vue';

/**
 * 调档记录表格视图
 *
 * @export
 * @class PIMARCHIVESCHANGEGridView
 * @extends {PIMARCHIVESCHANGEGridViewBase}
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
export default class PIMARCHIVESCHANGEGridView extends PIMARCHIVESCHANGEGridViewBase { }
</script>