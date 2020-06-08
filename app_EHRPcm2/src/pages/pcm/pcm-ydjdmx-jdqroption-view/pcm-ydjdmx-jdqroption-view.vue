<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxJDQROptionViewBase from './pcm-ydjdmx-jdqroption-view-base.vue';

import view_form from '@widgets/pcm-ydjdmx/jdjsqr-form/jdjsqr-form.vue';

/**
 * 请确认/修改借调结束时间
 *
 * @export
 * @class PcmYdjdmxJDQROptionView
 * @extends {PcmYdjdmxJDQROptionViewBase}
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
export default class PcmYdjdmxJDQROptionView extends PcmYdjdmxJDQROptionViewBase { }
</script>