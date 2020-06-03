<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxEditViewBase from './pcm-ydlzmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydlzmx/main-form/main-form.vue';

/**
 * 异动离职明细编辑视图
 *
 * @export
 * @class PcmYdlzmxEditView
 * @extends {PcmYdlzmxEditViewBase}
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
export default class PcmYdlzmxEditView extends PcmYdlzmxEditViewBase { }
</script>