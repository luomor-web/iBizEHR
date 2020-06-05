<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxCKEditViewBase from './pcm-ydbxmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-ydbxmx/jledit-form-form/jledit-form-form.vue';

/**
 * 异动病休明细
 *
 * @export
 * @class PcmYdbxmxCKEditView
 * @extends {PcmYdbxmxCKEditViewBase}
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
export default class PcmYdbxmxCKEditView extends PcmYdbxmxCKEditViewBase { }
</script>