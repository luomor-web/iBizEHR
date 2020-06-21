<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesDetailGridViewBase from './soc-archives-detail-grid-view-base.vue';

import view_grid from '@widgets/soc-archives-detail/main-grid/main-grid.vue';

/**
 * 社保档案明细表格视图
 *
 * @export
 * @class SocArchivesDetailGridView
 * @extends {SocArchivesDetailGridViewBase}
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
export default class SocArchivesDetailGridView extends SocArchivesDetailGridViewBase { }
</script>