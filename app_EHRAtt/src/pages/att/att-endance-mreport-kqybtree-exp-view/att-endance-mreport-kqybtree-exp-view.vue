<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceMreportKQYBTreeExpViewBase from './att-endance-mreport-kqybtree-exp-view-base.vue';

import view_treeexpbar from '@widgets/att-endance-mreport/kqybtree-exp-viewtreeexpbar-treeexpbar/kqybtree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 考勤月报树导航视图
 *
 * @export
 * @class AttEndanceMreportKQYBTreeExpView
 * @extends {AttEndanceMreportKQYBTreeExpViewBase}
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
export default class AttEndanceMreportKQYBTreeExpView extends AttEndanceMreportKQYBTreeExpViewBase { }
</script>