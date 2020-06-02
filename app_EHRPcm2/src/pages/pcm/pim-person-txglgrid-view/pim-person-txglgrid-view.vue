<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonTXGLGridViewBase from './pim-person-txglgrid-view-base.vue';

import view_grid from '@widgets/pim-person/ktxyg-grid/ktxyg-grid.vue';
import view_searchform from '@widgets/pim-person/ydryinfo-search-form-searchform/ydryinfo-search-form-searchform.vue';

/**
 * 退休管理
 *
 * @export
 * @class PimPersonTXGLGridView
 * @extends {PimPersonTXGLGridViewBase}
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
export default class PimPersonTXGLGridView extends PimPersonTXGLGridViewBase { }
</script>