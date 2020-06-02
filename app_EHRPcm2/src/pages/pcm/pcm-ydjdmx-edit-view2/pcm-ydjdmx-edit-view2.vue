<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxEditView2Base from './pcm-ydjdmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydjdmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydjdmx/default-drbar/default-drbar.vue';

/**
 * 异动借调明细编辑视图
 *
 * @export
 * @class PcmYdjdmxEditView2
 * @extends {PcmYdjdmxEditView2Base}
 */
@Component({
    components: {
        view_form, 
        view_drbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PcmYdjdmxEditView2 extends PcmYdjdmxEditView2Base { }
</script>