<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMSCHOOLOFFICEEditViewBase from './pcmschoolofficeedit-view-base.vue';

import view_form from '@widgets/pcm-school-office/main-form/main-form.vue';

/**
 * 在校职务
 *
 * @export
 * @class PCMSCHOOLOFFICEEditView
 * @extends {PCMSCHOOLOFFICEEditViewBase}
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
export default class PCMSCHOOLOFFICEEditView extends PCMSCHOOLOFFICEEditViewBase { }
</script>