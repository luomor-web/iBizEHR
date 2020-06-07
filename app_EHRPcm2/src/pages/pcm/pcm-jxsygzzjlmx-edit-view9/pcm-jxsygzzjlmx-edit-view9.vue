<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzjlmxEditView9Base from './pcm-jxsygzzjlmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-jxsygzzjlmx/main-form/main-form.vue';

/**
 * 见习期员工转正
 *
 * @export
 * @class PcmJxsygzzjlmxEditView9
 * @extends {PcmJxsygzzjlmxEditView9Base}
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
export default class PcmJxsygzzjlmxEditView9 extends PcmJxsygzzjlmxEditView9Base { }
</script>