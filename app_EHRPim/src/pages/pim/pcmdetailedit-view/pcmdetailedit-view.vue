<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMDETAILEditViewBase from './pcmdetailedit-view-base.vue';

import view_form from '@widgets/pcm-detail/main-form/main-form.vue';

/**
 * 人员明细表编辑视图
 *
 * @export
 * @class PCMDETAILEditView
 * @extends {PCMDETAILEditViewBase}
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
export default class PCMDETAILEditView extends PCMDETAILEditViewBase { }
</script>