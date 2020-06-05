<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxEditView9Base from './pcm-ydbxmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-ydbxmx/jledit-form-form/jledit-form-form.vue';

/**
 * 病休明细信息
 *
 * @export
 * @class PcmYdbxmxEditView9
 * @extends {PcmYdbxmxEditView9Base}
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
export default class PcmYdbxmxEditView9 extends PcmYdbxmxEditView9Base { }
</script>