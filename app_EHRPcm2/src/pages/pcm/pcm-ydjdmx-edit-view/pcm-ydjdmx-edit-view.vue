<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxEditViewBase from './pcm-ydjdmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydjdmx/main-form/main-form.vue';

/**
 * 异动借调明细编辑视图
 *
 * @export
 * @class PcmYdjdmxEditView
 * @extends {PcmYdjdmxEditViewBase}
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
export default class PcmYdjdmxEditView extends PcmYdjdmxEditViewBase { }
</script>