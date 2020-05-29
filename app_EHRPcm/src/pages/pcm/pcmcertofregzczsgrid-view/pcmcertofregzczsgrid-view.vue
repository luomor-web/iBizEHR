<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMCERTOFREGZCZSGridViewBase from './pcmcertofregzczsgrid-view-base.vue';

import view_grid from '@widgets/pcm-certofreg/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-certofreg/default-searchform/default-searchform.vue';

/**
 * 注册证书（要求：带*必填）
 *
 * @export
 * @class PCMCERTOFREGZCZSGridView
 * @extends {PCMCERTOFREGZCZSGridViewBase}
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
export default class PCMCERTOFREGZCZSGridView extends PCMCERTOFREGZCZSGridViewBase { }
</script>