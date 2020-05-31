<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMDETAILGridViewBase from './pcmdetailgrid-view-base.vue';

import view_grid from '@widgets/pcm-detail/main-grid/main-grid.vue';

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
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMDETAILGridView extends PCMDETAILGridViewBase { }
</script>