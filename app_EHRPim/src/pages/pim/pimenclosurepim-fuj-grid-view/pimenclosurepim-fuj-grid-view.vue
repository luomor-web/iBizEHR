<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMENCLOSUREPimFujGridViewBase from './pimenclosurepim-fuj-grid-view-base.vue';

import view_grid from '@widgets/pimenclosure/main-grid/main-grid.vue';

/**
 * 附件信息表格视图
 *
 * @export
 * @class PIMENCLOSUREPimFujGridView
 * @extends {PIMENCLOSUREPimFujGridViewBase}
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
export default class PIMENCLOSUREPimFujGridView extends PIMENCLOSUREPimFujGridViewBase { }
</script>