<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxNTJSRQQREditViewBase from './pcm-ydntmx-ntjsrqqredit-view-base.vue';

import view_form from '@widgets/pcm-ydntmx/ntjsrqqr-form/ntjsrqqr-form.vue';

/**
 * 请确认/修改内退结束日期
 *
 * @export
 * @class PcmYdntmxNTJSRQQREditView
 * @extends {PcmYdntmxNTJSRQQREditViewBase}
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
export default class PcmYdntmxNTJSRQQREditView extends PcmYdntmxNTJSRQQREditViewBase { }
</script>