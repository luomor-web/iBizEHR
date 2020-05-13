<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMDETAILGridViewBase from './pcmdetailgrid-view-base.vue';

import view_grid from '@widgets/pcmdetail/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcmdetail/default-searchform/default-searchform.vue';

/**
 * 人员花名册
 *
 * @export
 * @class PCMDETAILGridView
 * @extends {PCMDETAILGridViewBase}
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
export default class PCMDETAILGridView extends PCMDETAILGridViewBase { }
</script>