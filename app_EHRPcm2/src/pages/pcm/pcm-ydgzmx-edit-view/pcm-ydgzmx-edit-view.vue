<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxEditViewBase from './pcm-ydgzmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydgzmx/main-form/main-form.vue';

/**
 * 异动挂职明细编辑视图
 *
 * @export
 * @class PcmYdgzmxEditView
 * @extends {PcmYdgzmxEditViewBase}
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
export default class PcmYdgzmxEditView extends PcmYdgzmxEditViewBase { }
</script>