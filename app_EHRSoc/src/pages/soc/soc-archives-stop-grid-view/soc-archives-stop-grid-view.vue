<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesStopGridViewBase from './soc-archives-stop-grid-view-base.vue';

import view_grid from '@widgets/soc-archives/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-archives/default-searchform/default-searchform.vue';

/**
 * 非员工终止社保
 *
 * @export
 * @class SocArchivesStopGridView
 * @extends {SocArchivesStopGridViewBase}
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
export default class SocArchivesStopGridView extends SocArchivesStopGridViewBase { }
</script>