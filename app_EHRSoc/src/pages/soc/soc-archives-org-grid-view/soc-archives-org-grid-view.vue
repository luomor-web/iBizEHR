<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesOrgGridViewBase from './soc-archives-org-grid-view-base.vue';

import view_grid from '@widgets/soc-archives/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-archives/default-searchform/default-searchform.vue';

/**
 * 社保档案表格视图
 *
 * @export
 * @class SocArchivesOrgGridView
 * @extends {SocArchivesOrgGridViewBase}
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
export default class SocArchivesOrgGridView extends SocArchivesOrgGridViewBase { }
</script>