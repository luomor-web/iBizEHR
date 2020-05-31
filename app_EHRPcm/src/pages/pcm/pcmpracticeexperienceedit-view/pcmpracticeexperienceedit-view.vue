<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPRACTICEEXPERIENCEEditViewBase from './pcmpracticeexperienceedit-view-base.vue';

import view_form from '@widgets/pcm-practice-experience/main-form/main-form.vue';

/**
 * 实习经验
 *
 * @export
 * @class PCMPRACTICEEXPERIENCEEditView
 * @extends {PCMPRACTICEEXPERIENCEEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMPRACTICEEXPERIENCEEditView extends PCMPRACTICEEXPERIENCEEditViewBase { }
</script>