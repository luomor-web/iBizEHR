<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxEditViewBase from './pcm-ydjzmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydjzmx/main-form/main-form.vue';

/**
 * 异动兼职明细编辑视图
 *
 * @export
 * @class PcmYdjzmxEditView
 * @extends {PcmYdjzmxEditViewBase}
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
export default class PcmYdjzmxEditView extends PcmYdjzmxEditViewBase { }
</script>