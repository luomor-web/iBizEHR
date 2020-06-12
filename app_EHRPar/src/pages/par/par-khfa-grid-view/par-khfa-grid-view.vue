<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParKhfaGridViewBase from './par-khfa-grid-view-base.vue';

import view_grid from '@widgets/par-khfa/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-khfa/default-searchform/default-searchform.vue';

/**
 * 考核对象
 *
 * @export
 * @class ParKhfaGridView
 * @extends {ParKhfaGridViewBase}
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
export default class ParKhfaGridView extends ParKhfaGridViewBase { }
</script>