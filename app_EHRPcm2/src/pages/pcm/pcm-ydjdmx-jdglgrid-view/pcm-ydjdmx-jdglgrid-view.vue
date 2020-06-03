<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxJDGLGridViewBase from './pcm-ydjdmx-jdglgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydjdmx/jdgl2-grid/jdgl2-grid.vue';
import view_searchform from '@widgets/pcm-ydjdmx/default-searchform/default-searchform.vue';

/**
 * 借调管理
 *
 * @export
 * @class PcmYdjdmxJDGLGridView
 * @extends {PcmYdjdmxJDGLGridViewBase}
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
export default class PcmYdjdmxJDGLGridView extends PcmYdjdmxJDGLGridViewBase { }
</script>