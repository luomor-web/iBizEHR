<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMEducationExperienceJYBJ_WSSWBJGridViewBase from './pcmeducation-experience-jybj-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-education-experience/ck-grid/ck-grid.vue';

/**
 * 教育信息
 *
 * @export
 * @class PCMEducationExperienceJYBJ_WSSWBJGridView
 * @extends {PCMEducationExperienceJYBJ_WSSWBJGridViewBase}
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
export default class PCMEducationExperienceJYBJ_WSSWBJGridView extends PCMEducationExperienceJYBJ_WSSWBJGridViewBase { }
</script>