<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzjlmxCKEditViewBase from './pcm-jxsygzzjlmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-jxsygzzjlmx/main-form/main-form.vue';

/**
 * 见习生员工转正明细
 *
 * @export
 * @class PcmJxsygzzjlmxCKEditView
 * @extends {PcmJxsygzzjlmxCKEditViewBase}
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
export default class PcmJxsygzzjlmxCKEditView extends PcmJxsygzzjlmxCKEditViewBase { }
</script>