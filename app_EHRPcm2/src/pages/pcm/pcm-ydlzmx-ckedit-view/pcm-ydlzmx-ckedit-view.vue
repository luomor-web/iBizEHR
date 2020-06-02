<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxCKEditViewBase from './pcm-ydlzmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-ydlzmx/main-form/main-form.vue';

/**
 * 异动离职明细查看
 *
 * @export
 * @class PcmYdlzmxCKEditView
 * @extends {PcmYdlzmxCKEditViewBase}
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
export default class PcmYdlzmxCKEditView extends PcmYdlzmxCKEditViewBase { }
</script>