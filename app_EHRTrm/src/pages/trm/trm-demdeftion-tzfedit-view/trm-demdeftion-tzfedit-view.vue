<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDemdeftionTZFEditViewBase from './trm-demdeftion-tzfedit-view-base.vue';

import view_form from '@widgets/trm-demdeftion/main-3-form/main-3-form.vue';

/**
 * 需求汇总
 *
 * @export
 * @class TrmDemdeftionTZFEditView
 * @extends {TrmDemdeftionTZFEditViewBase}
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
export default class TrmDemdeftionTZFEditView extends TrmDemdeftionTZFEditViewBase { }
</script>