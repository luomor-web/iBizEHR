<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPRACTICEEXPERIENCESXJYGridViewBase from './pcmpracticeexperiencesxjygrid-view-base.vue';

import view_grid from '@widgets/pcm-practice-experience/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-practice-experience/default-searchform/default-searchform.vue';

/**
 * 实习信息（要求：带*必填）
 *
 * @export
 * @class PCMPRACTICEEXPERIENCESXJYGridView
 * @extends {PCMPRACTICEEXPERIENCESXJYGridViewBase}
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
export default class PCMPRACTICEEXPERIENCESXJYGridView extends PCMPRACTICEEXPERIENCESXJYGridViewBase { }
</script>