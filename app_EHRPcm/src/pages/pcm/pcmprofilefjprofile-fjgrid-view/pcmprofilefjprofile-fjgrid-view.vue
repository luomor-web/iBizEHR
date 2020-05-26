<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEFJProfileFJGridViewBase from './pcmprofilefjprofile-fjgrid-view-base.vue';

import view_grid from '@widgets/pcmprofilefj/main-grid/main-grid.vue';

/**
 * 应聘者附件
 *
 * @export
 * @class PCMPROFILEFJProfileFJGridView
 * @extends {PCMPROFILEFJProfileFJGridViewBase}
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
export default class PCMPROFILEFJProfileFJGridView extends PCMPROFILEFJProfileFJGridViewBase { }
</script>