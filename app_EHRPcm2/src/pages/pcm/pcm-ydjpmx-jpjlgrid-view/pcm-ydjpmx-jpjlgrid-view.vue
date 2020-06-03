<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxJPJLGridViewBase from './pcm-ydjpmx-jpjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydjpmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjpmx/default-searchform/default-searchform.vue';

/**
 * 解聘记录
 *
 * @export
 * @class PcmYdjpmxJPJLGridView
 * @extends {PcmYdjpmxJPJLGridViewBase}
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
export default class PcmYdjpmxJPJLGridView extends PcmYdjpmxJPJLGridViewBase { }
</script>