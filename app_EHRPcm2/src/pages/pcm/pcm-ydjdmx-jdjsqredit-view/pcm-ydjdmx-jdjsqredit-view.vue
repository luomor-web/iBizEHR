<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxJDJSQREditViewBase from './pcm-ydjdmx-jdjsqredit-view-base.vue';

import view_form from '@widgets/pcm-ydjdmx/jdjsqr-form/jdjsqr-form.vue';

/**
 * 请确认/修改借调结束时间
 *
 * @export
 * @class PcmYdjdmxJDJSQREditView
 * @extends {PcmYdjdmxJDJSQREditViewBase}
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
export default class PcmYdjdmxJDJSQREditView extends PcmYdjdmxJDJSQREditViewBase { }
</script>