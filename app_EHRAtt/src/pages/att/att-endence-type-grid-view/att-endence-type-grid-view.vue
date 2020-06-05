<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceTypeGridViewBase from './att-endence-type-grid-view-base.vue';

import view_grid from '@widgets/att-endence-type/main-grid/main-grid.vue';

/**
 * 考勤类型表格视图
 *
 * @export
 * @class AttEndenceTypeGridView
 * @extends {AttEndenceTypeGridViewBase}
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
export default class AttEndenceTypeGridView extends AttEndenceTypeGridViewBase { }
</script>