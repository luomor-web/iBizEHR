<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxJSRQQREditViewBase from './pcm-ydgzmx-jsrqqredit-view-base.vue';

import view_form from '@widgets/pcm-ydgzmx/gzjsrqqr-form/gzjsrqqr-form.vue';

/**
 * 请确认/修改挂职结束时间
 *
 * @export
 * @class PcmYdgzmxJSRQQREditView
 * @extends {PcmYdgzmxJSRQQREditViewBase}
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
export default class PcmYdgzmxJSRQQREditView extends PcmYdgzmxJSRQQREditViewBase { }
</script>