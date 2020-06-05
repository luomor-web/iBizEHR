<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzjlmxXZEditViewBase from './pcm-jxsygzzjlmx-xzedit-view-base.vue';

import view_form from '@widgets/pcm-jxsygzzjlmx/new-data-form-form/new-data-form-form.vue';

/**
 * 见习期员工转正申请
 *
 * @export
 * @class PcmJxsygzzjlmxXZEditView
 * @extends {PcmJxsygzzjlmxXZEditViewBase}
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
export default class PcmJxsygzzjlmxXZEditView extends PcmJxsygzzjlmxXZEditViewBase { }
</script>