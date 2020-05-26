<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMSCHOOLOFFICEZXZWGridViewBase from './pcmschoolofficezxzwgrid-view-base.vue';

import view_grid from '@widgets/pcmschooloffice/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcmschooloffice/default-searchform/default-searchform.vue';

/**
 * 在校职务（要求：带*必填）
 *
 * @export
 * @class PCMSCHOOLOFFICEZXZWGridView
 * @extends {PCMSCHOOLOFFICEZXZWGridViewBase}
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
export default class PCMSCHOOLOFFICEZXZWGridView extends PCMSCHOOLOFFICEZXZWGridViewBase { }
</script>