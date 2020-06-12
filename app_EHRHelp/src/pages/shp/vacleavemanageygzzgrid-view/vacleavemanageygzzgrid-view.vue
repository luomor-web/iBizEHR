<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGEYGZZGridViewBase from './vacleavemanageygzzgrid-view-base.vue';

import view_grid from '@widgets/vac-leave-manage/main-grid/main-grid.vue';
import view_searchform from '@widgets/vac-leave-manage/default-searchform/default-searchform.vue';

/**
 * 休假申请
 *
 * @export
 * @class VACLEAVEMANAGEYGZZGridView
 * @extends {VACLEAVEMANAGEYGZZGridViewBase}
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
export default class VACLEAVEMANAGEYGZZGridView extends VACLEAVEMANAGEYGZZGridViewBase { }
</script>