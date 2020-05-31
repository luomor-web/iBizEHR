<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEDUCATIONZDXLGridViewBase from './pimeducationzdxlgrid-view-base.vue';

import view_grid from '@widgets/pim-education/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-education/default-searchform/default-searchform.vue';

/**
 * 教育背景
 *
 * @export
 * @class PIMEDUCATIONZDXLGridView
 * @extends {PIMEDUCATIONZDXLGridViewBase}
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
export default class PIMEDUCATIONZDXLGridView extends PIMEDUCATIONZDXLGridViewBase { }
</script>