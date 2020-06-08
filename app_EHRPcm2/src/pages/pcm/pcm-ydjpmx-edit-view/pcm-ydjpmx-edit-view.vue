<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxEditViewBase from './pcm-ydjpmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydjpmx/main-form/main-form.vue';

/**
 * 异动解聘明细
 *
 * @export
 * @class PcmYdjpmxEditView
 * @extends {PcmYdjpmxEditViewBase}
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
export default class PcmYdjpmxEditView extends PcmYdjpmxEditViewBase { }
</script>