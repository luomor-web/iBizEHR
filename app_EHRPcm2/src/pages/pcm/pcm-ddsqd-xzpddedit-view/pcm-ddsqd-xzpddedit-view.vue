<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdXZPDDEditViewBase from './pcm-ddsqd-xzpddedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqd/pldd-form/pldd-form.vue';

/**
 * 新增批调动
 *
 * @export
 * @class PcmDdsqdXZPDDEditView
 * @extends {PcmDdsqdXZPDDEditViewBase}
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
export default class PcmDdsqdXZPDDEditView extends PcmDdsqdXZPDDEditViewBase { }
</script>