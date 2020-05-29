<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMCERTOFREGZCZS_WSSWBJGridViewBase from './pcmcertofregzczs-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-certofreg/ck-grid/ck-grid.vue';

/**
 * 注册证书
 *
 * @export
 * @class PCMCERTOFREGZCZS_WSSWBJGridView
 * @extends {PCMCERTOFREGZCZS_WSSWBJGridViewBase}
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
export default class PCMCERTOFREGZCZS_WSSWBJGridView extends PCMCERTOFREGZCZS_WSSWBJGridViewBase { }
</script>