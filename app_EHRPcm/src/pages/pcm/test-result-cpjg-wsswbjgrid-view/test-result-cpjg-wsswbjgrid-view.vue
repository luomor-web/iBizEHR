<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TestResultCPJG_WSSWBJGridViewBase from './test-result-cpjg-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-test-result/main-grid/main-grid.vue';

/**
 * 测评结果摘要信息
 *
 * @export
 * @class TestResultCPJG_WSSWBJGridView
 * @extends {TestResultCPJG_WSSWBJGridViewBase}
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
export default class TestResultCPJG_WSSWBJGridView extends TestResultCPJG_WSSWBJGridViewBase { }
</script>