<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmRecruitmentPickupGridViewBase from './pcm-recruitment-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-recruitment/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-recruitment/default-searchform/default-searchform.vue';

/**
 * 内部招聘信息选择表格视图
 *
 * @export
 * @class PcmRecruitmentPickupGridView
 * @extends {PcmRecruitmentPickupGridViewBase}
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
export default class PcmRecruitmentPickupGridView extends PcmRecruitmentPickupGridViewBase { }
</script>