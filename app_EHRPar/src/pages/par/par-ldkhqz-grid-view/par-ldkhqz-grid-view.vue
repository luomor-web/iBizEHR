<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdkhqzGridViewBase from './par-ldkhqz-grid-view-base.vue';

import view_grid from '@widgets/par-ldkhqz/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-ldkhqz/default-searchform/default-searchform.vue';

/**
 * 评分权重分配表格视图
 *
 * @export
 * @class ParLdkhqzGridView
 * @extends {ParLdkhqzGridViewBase}
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
export default class ParLdkhqzGridView extends ParLdkhqzGridViewBase { }
</script>