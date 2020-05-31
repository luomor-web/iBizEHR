<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONHMDGridViewBase from './pimpersonhmdgrid-view-base.vue';

import view_grid from '@widgets/pim-person/hmdinfo-grid-grid/hmdinfo-grid-grid.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 黑名单表格视图
 *
 * @export
 * @class PIMPERSONHMDGridView
 * @extends {PIMPERSONHMDGridViewBase}
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
export default class PIMPERSONHMDGridView extends PIMPERSONHMDGridViewBase { }
</script>