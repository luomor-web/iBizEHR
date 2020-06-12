<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParJxkhxhzYGKHXGridViewBase from './par-jxkhxhz-ygkhxgrid-view-base.vue';

import view_grid from '@widgets/par-jxkhxhz/ygkhx-grid/ygkhx-grid.vue';
import view_searchform from '@widgets/par-jxkhxhz/default-searchform/default-searchform.vue';

/**
 * 员工考核内容及评分汇总
 *
 * @export
 * @class ParJxkhxhzYGKHXGridView
 * @extends {ParJxkhxhzYGKHXGridViewBase}
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
export default class ParJxkhxhzYGKHXGridView extends ParJxkhxhzYGKHXGridViewBase { }
</script>