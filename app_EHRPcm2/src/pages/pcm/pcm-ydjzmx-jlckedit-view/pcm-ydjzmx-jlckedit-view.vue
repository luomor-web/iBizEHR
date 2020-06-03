<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxJLCKEditViewBase from './pcm-ydjzmx-jlckedit-view-base.vue';

import view_form from '@widgets/pcm-ydjzmx/main-form/main-form.vue';

/**
 * 异动兼职明细
 *
 * @export
 * @class PcmYdjzmxJLCKEditView
 * @extends {PcmYdjzmxJLCKEditViewBase}
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
export default class PcmYdjzmxJLCKEditView extends PcmYdjzmxJLCKEditViewBase { }
</script>