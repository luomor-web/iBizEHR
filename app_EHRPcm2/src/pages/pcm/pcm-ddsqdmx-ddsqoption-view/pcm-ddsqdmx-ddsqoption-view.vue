<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxDDSQOptionViewBase from './pcm-ddsqdmx-ddsqoption-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/main-form/main-form.vue';

/**
 * 调动
 *
 * @export
 * @class PcmDdsqdmxDDSQOptionView
 * @extends {PcmDdsqdmxDDSQOptionViewBase}
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
export default class PcmDdsqdmxDDSQOptionView extends PcmDdsqdmxDDSQOptionViewBase { }
</script>