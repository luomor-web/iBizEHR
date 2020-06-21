<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDemdeftionTBFEditViewBase from './trm-demdeftion-tbfedit-view-base.vue';

import view_form from '@widgets/trm-demdeftion/main-2-form/main-2-form.vue';

/**
 * 培训需求填报明细
 *
 * @export
 * @class TrmDemdeftionTBFEditView
 * @extends {TrmDemdeftionTBFEditViewBase}
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
export default class TrmDemdeftionTBFEditView extends TrmDemdeftionTBFEditViewBase { }
</script>