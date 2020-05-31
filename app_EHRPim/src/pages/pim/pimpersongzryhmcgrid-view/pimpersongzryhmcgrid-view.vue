<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONGZRYHMCGridViewBase from './pimpersongzryhmcgrid-view-base.vue';

import view_grid from '@widgets/pim-person/gzdq-grid/gzdq-grid.vue';
import view_searchform from '@widgets/pim-person/default-searchform/default-searchform.vue';

/**
 * 挂职人员花名册
 *
 * @export
 * @class PIMPERSONGZRYHMCGridView
 * @extends {PIMPERSONGZRYHMCGridViewBase}
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
export default class PIMPERSONGZRYHMCGridView extends PIMPERSONGZRYHMCGridViewBase { }
</script>