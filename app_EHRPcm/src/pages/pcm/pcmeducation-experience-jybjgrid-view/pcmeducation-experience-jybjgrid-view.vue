<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMEducationExperienceJYBJGridViewBase from './pcmeducation-experience-jybjgrid-view-base.vue';

import view_grid from '@widgets/pcm-education-experience/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-education-experience/default-searchform/default-searchform.vue';

/**
 * 教育信息（要求：1.高中以上，2.带*必填，3.大专学位证用毕业证代替）
 *
 * @export
 * @class PCMEducationExperienceJYBJGridView
 * @extends {PCMEducationExperienceJYBJGridViewBase}
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
export default class PCMEducationExperienceJYBJGridView extends PCMEducationExperienceJYBJGridViewBase { }
</script>