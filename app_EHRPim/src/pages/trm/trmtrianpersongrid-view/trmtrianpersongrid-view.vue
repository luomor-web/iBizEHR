<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TRMTRIANPERSONGridViewBase from './trmtrianpersongrid-view-base.vue';

import view_grid from '@widgets/trmtrianperson/main-grid/main-grid.vue';
import view_searchform from '@widgets/trmtrianperson/default-searchform/default-searchform.vue';

/**
 * 培训记录表格视图
 *
 * @export
 * @class TRMTRIANPERSONGridView
 * @extends {TRMTRIANPERSONGridViewBase}
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
export default class TRMTRIANPERSONGridView extends TRMTRIANPERSONGridViewBase { }
</script>