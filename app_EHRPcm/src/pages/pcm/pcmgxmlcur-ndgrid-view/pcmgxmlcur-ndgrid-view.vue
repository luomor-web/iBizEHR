<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMGXMLCurNDGridViewBase from './pcmgxmlcur-ndgrid-view-base.vue';

import view_grid from '@widgets/pcmgxml/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcmgxml/default-searchform/default-searchform.vue';

/**
 * 高校名录表格视图
 *
 * @export
 * @class PCMGXMLCurNDGridView
 * @extends {PCMGXMLCurNDGridViewBase}
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
export default class PCMGXMLCurNDGridView extends PCMGXMLCurNDGridViewBase { }
</script>