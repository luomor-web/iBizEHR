<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdkhqzNewGridViewBase from './par-ldkhqz-new-grid-view-base.vue';

import view_grid from '@widgets/par-ldkhqz/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-ldkhqz/default-searchform/default-searchform.vue';

/**
 * 评分权重分配表格视图
 *
 * @export
 * @class ParLdkhqzNewGridView
 * @extends {ParLdkhqzNewGridViewBase}
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
export default class ParLdkhqzNewGridView extends ParLdkhqzNewGridViewBase { }
</script>