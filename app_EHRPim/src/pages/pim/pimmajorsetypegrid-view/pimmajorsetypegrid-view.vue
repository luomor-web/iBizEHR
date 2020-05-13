<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMMAJORSETYPEGridViewBase from './pimmajorsetypegrid-view-base.vue';

import view_grid from '@widgets/pimmajorsetype/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimmajorsetype/default-searchform/default-searchform.vue';

/**
 * 专业序列类型表格视图
 *
 * @export
 * @class PIMMAJORSETYPEGridView
 * @extends {PIMMAJORSETYPEGridViewBase}
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
export default class PIMMAJORSETYPEGridView extends PIMMAJORSETYPEGridViewBase { }
</script>