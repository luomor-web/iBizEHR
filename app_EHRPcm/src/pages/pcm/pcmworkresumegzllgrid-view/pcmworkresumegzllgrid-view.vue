<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMWORKRESUMEGZLLGridViewBase from './pcmworkresumegzllgrid-view-base.vue';

import view_grid from '@widgets/pcm-work-resume/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-work-resume/default-searchform/default-searchform.vue';

/**
 * 工作履历（要求：带*必填）
 *
 * @export
 * @class PCMWORKRESUMEGZLLGridView
 * @extends {PCMWORKRESUMEGZLLGridViewBase}
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
export default class PCMWORKRESUMEGZLLGridView extends PCMWORKRESUMEGZLLGridViewBase { }
</script>