<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TDZWXXTDZWGridViewBase from './tdzwxxtdzwgrid-view-base.vue';

import view_grid from '@widgets/pcm-tdzwxx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-tdzwxx/default-searchform/default-searchform.vue';

/**
 * 投递职位摘要信息（要求：带*必填）
 *
 * @export
 * @class TDZWXXTDZWGridView
 * @extends {TDZWXXTDZWGridViewBase}
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
export default class TDZWXXTDZWGridView extends TDZWXXTDZWGridViewBase { }
</script>