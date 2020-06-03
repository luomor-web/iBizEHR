<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEnsummaryKQHZTreeExpViewBase from './att-ensummary-kqhztree-exp-view-base.vue';

import view_treeexpbar from '@widgets/att-ensummary/kqhztree-exp-viewtreeexpbar-treeexpbar/kqhztree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 考勤汇总树导航视图
 *
 * @export
 * @class AttEnsummaryKQHZTreeExpView
 * @extends {AttEnsummaryKQHZTreeExpViewBase}
 */
@Component({
    components: {
        view_treeexpbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class AttEnsummaryKQHZTreeExpView extends AttEnsummaryKQHZTreeExpViewBase { }
</script>