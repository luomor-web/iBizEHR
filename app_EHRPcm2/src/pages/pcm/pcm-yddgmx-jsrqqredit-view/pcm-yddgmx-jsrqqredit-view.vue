<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxJSRQQREditViewBase from './pcm-yddgmx-jsrqqredit-view-base.vue';

import view_form from '@widgets/pcm-yddgmx/jsrqqr-form/jsrqqr-form.vue';

/**
 * 请确认/修改待岗结束日期
 *
 * @export
 * @class PcmYddgmxJSRQQREditView
 * @extends {PcmYddgmxJSRQQREditViewBase}
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
export default class PcmYddgmxJSRQQREditView extends PcmYddgmxJSRQQREditViewBase { }
</script>