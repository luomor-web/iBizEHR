<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxGRZZSQJDEditViewBase from './pcm-ddsqdmx-grzzsqjdedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/zzsqjdform-form/zzsqjdform-form.vue';

/**
 * 借调申请编辑视图
 *
 * @export
 * @class PcmDdsqdmxGRZZSQJDEditView
 * @extends {PcmDdsqdmxGRZZSQJDEditViewBase}
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
export default class PcmDdsqdmxGRZZSQJDEditView extends PcmDdsqdmxGRZZSQJDEditViewBase { }
</script>