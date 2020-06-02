<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxSQJDSHEditViewBase from './pcm-ddsqdmx-sqjdshedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/zzsqjdform-form/zzsqjdform-form.vue';

/**
 * 借调明细编辑视图
 *
 * @export
 * @class PcmDdsqdmxSQJDSHEditView
 * @extends {PcmDdsqdmxSQJDSHEditViewBase}
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
export default class PcmDdsqdmxSQJDSHEditView extends PcmDdsqdmxSQJDSHEditViewBase { }
</script>