<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TRMTRIANPERSONEditViewBase from './trmtrianpersonedit-view-base.vue';

import view_form from '@widgets/trm-train-person/main-form/main-form.vue';

/**
 * 培训人员编辑视图
 *
 * @export
 * @class TRMTRIANPERSONEditView
 * @extends {TRMTRIANPERSONEditViewBase}
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
export default class TRMTRIANPERSONEditView extends TRMTRIANPERSONEditViewBase { }
</script>