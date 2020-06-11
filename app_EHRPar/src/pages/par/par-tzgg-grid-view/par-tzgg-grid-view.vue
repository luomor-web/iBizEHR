<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParTzggGridViewBase from './par-tzgg-grid-view-base.vue';

import view_grid from '@widgets/par-tzgg/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-tzgg/default-searchform/default-searchform.vue';

/**
 * 通知发布
 *
 * @export
 * @class ParTzggGridView
 * @extends {ParTzggGridViewBase}
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
export default class ParTzggGridView extends ParTzggGridViewBase { }
</script>