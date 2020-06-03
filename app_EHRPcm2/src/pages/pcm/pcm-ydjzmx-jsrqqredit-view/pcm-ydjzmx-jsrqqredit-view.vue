<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxJSRQQREditViewBase from './pcm-ydjzmx-jsrqqredit-view-base.vue';

import view_form from '@widgets/pcm-ydjzmx/jzjsqr-form/jzjsqr-form.vue';

/**
 * 请确认/修改兼职结束时间
 *
 * @export
 * @class PcmYdjzmxJSRQQREditView
 * @extends {PcmYdjzmxJSRQQREditViewBase}
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
export default class PcmYdjzmxJSRQQREditView extends PcmYdjzmxJSRQQREditViewBase { }
</script>