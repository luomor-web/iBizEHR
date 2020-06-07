<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzjlmxEditView9Base from './pcm-xygzzjlmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-xygzzjlmx/main2-form/main2-form.vue';

/**
 * 试用期员工转正
 *
 * @export
 * @class PcmXygzzjlmxEditView9
 * @extends {PcmXygzzjlmxEditView9Base}
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
export default class PcmXygzzjlmxEditView9 extends PcmXygzzjlmxEditView9Base { }
</script>