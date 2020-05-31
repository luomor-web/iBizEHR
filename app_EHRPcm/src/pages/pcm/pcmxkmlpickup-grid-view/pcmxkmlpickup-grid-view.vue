<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMXKMLPickupGridViewBase from './pcmxkmlpickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-xkml/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-xkml/default-searchform/default-searchform.vue';

/**
 * 学科目录选择表格视图
 *
 * @export
 * @class PCMXKMLPickupGridView
 * @extends {PCMXKMLPickupGridViewBase}
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
export default class PCMXKMLPickupGridView extends PCMXKMLPickupGridViewBase { }
</script>