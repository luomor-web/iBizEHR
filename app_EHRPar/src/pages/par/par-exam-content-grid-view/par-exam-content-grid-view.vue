<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamContentGridViewBase from './par-exam-content-grid-view-base.vue';

import view_grid from '@widgets/par-exam-content/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-exam-content/default-searchform/default-searchform.vue';

/**
 * 考核内容
 *
 * @export
 * @class ParExamContentGridView
 * @extends {ParExamContentGridViewBase}
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
export default class ParExamContentGridView extends ParExamContentGridViewBase { }
</script>