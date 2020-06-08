<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import QUESTIONSCurrentQuestionsGridViewBase from './questionscurrent-questions-grid-view-base.vue';

import view_grid from '@widgets/pim-questions/current-questions-grid/current-questions-grid.vue';
import view_searchform from '@widgets/pim-questions/default-searchform/default-searchform.vue';

/**
 * 本页问题表格
 *
 * @export
 * @class QUESTIONSCurrentQuestionsGridView
 * @extends {QUESTIONSCurrentQuestionsGridViewBase}
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
export default class QUESTIONSCurrentQuestionsGridView extends QUESTIONSCurrentQuestionsGridViewBase { }
</script>