<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxBXJSRQQREditViewBase from './pcm-ydbxmx-bxjsrqqredit-view-base.vue';

import view_form from '@widgets/pcm-ydbxmx/bxjsrqqr-form/bxjsrqqr-form.vue';

/**
 * 请确认/修改病休结束日期
 *
 * @export
 * @class PcmYdbxmxBXJSRQQREditView
 * @extends {PcmYdbxmxBXJSRQQREditViewBase}
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
export default class PcmYdbxmxBXJSRQQREditView extends PcmYdbxmxBXJSRQQREditViewBase { }
</script>