<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TestResultCPJGGridViewBase from './test-result-cpjggrid-view-base.vue';

import view_grid from '@widgets/pcm-test-result/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-test-result/default-searchform/default-searchform.vue';

/**
 * 测评结果摘要信息（要求：带*必填）
 *
 * @export
 * @class TestResultCPJGGridView
 * @extends {TestResultCPJGGridViewBase}
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
export default class TestResultCPJGGridView extends TestResultCPJGGridViewBase { }
</script>