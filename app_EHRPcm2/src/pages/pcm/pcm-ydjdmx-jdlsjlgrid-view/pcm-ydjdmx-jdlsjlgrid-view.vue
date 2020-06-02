<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxJDLSJLGridViewBase from './pcm-ydjdmx-jdlsjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydjdmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjdmx/default-searchform/default-searchform.vue';

/**
 * 借调记录
 *
 * @export
 * @class PcmYdjdmxJDLSJLGridView
 * @extends {PcmYdjdmxJDLSJLGridViewBase}
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
export default class PcmYdjdmxJDLSJLGridView extends PcmYdjdmxJDLSJLGridViewBase { }
</script>