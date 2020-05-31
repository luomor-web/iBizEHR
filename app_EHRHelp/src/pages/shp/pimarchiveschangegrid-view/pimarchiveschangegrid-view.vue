<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESCHANGEGridViewBase from './pimarchiveschangegrid-view-base.vue';

import view_grid from '@widgets/pim-archives-change/main-grid/main-grid.vue';

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
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMARCHIVESCHANGEGridView extends PIMARCHIVESCHANGEGridViewBase { }
</script>