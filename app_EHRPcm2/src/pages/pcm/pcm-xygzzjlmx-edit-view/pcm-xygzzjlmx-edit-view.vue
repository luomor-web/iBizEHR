<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzjlmxEditViewBase from './pcm-xygzzjlmx-edit-view-base.vue';

import view_form from '@widgets/pcm-xygzzjlmx/main-form/main-form.vue';

/**
 * 试用期员工转正申请
 *
 * @export
 * @class PcmXygzzjlmxEditView
 * @extends {PcmXygzzjlmxEditViewBase}
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
export default class PcmXygzzjlmxEditView extends PcmXygzzjlmxEditViewBase { }
</script>