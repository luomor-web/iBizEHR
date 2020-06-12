<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzjlmxEditViewBase from './pcm-jxsygzzjlmx-edit-view-base.vue';

import view_form from '@widgets/pcm-jxsygzzjlmx/main-form/main-form.vue';

/**
 * 见习生员工转正记录引用明细编辑视图
 *
 * @export
 * @class PcmJxsygzzjlmxEditView
 * @extends {PcmJxsygzzjlmxEditViewBase}
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
export default class PcmJxsygzzjlmxEditView extends PcmJxsygzzjlmxEditViewBase { }
</script>