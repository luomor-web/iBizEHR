<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TDZWXXTDZW_WSSWBJGridViewBase from './tdzwxxtdzw-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-tdzwxx/main-grid/main-grid.vue';

/**
 * 投递职位摘要信息
 *
 * @export
 * @class TDZWXXTDZW_WSSWBJGridView
 * @extends {TDZWXXTDZW_WSSWBJGridViewBase}
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
export default class TDZWXXTDZW_WSSWBJGridView extends TDZWXXTDZW_WSSWBJGridViewBase { }
</script>