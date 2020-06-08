<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzjlmxCKEditViewBase from './pcm-xygzzjlmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-xygzzjlmx/main-form/main-form.vue';

/**
 * 试用期员工转正明细
 *
 * @export
 * @class PcmXygzzjlmxCKEditView
 * @extends {PcmXygzzjlmxCKEditViewBase}
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
export default class PcmXygzzjlmxCKEditView extends PcmXygzzjlmxCKEditViewBase { }
</script>