<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESCHANGEDADCJLGridViewBase from './pimarchiveschangedadcjlgrid-view-base.vue';

import view_grid from '@widgets/pimarchiveschange/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pimarchiveschange/default-searchform/default-searchform.vue';

/**
 * 档案调出记录
 *
 * @export
 * @class PIMARCHIVESCHANGEDADCJLGridView
 * @extends {PIMARCHIVESCHANGEDADCJLGridViewBase}
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
export default class PIMARCHIVESCHANGEDADCJLGridView extends PIMARCHIVESCHANGEDADCJLGridViewBase { }
</script>