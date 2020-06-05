<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxCKEditViewBase from './pcm-ydjpmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-ydjpmx/main2-form/main2-form.vue';

/**
 * 异动解聘明细
 *
 * @export
 * @class PcmYdjpmxCKEditView
 * @extends {PcmYdjpmxCKEditViewBase}
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
export default class PcmYdjpmxCKEditView extends PcmYdjpmxCKEditViewBase { }
</script>