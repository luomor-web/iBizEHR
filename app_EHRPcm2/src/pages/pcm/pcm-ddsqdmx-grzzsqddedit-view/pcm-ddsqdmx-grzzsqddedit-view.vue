<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxGRZZSQDDEditViewBase from './pcm-ddsqdmx-grzzsqddedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/zzsqddform-form/zzsqddform-form.vue';

/**
 * 调动申请编辑视图
 *
 * @export
 * @class PcmDdsqdmxGRZZSQDDEditView
 * @extends {PcmDdsqdmxGRZZSQDDEditViewBase}
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
export default class PcmDdsqdmxGRZZSQDDEditView extends PcmDdsqdmxGRZZSQDDEditViewBase { }
</script>