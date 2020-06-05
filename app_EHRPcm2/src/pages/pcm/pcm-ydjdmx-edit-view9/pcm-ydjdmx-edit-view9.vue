<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxEditView9Base from './pcm-ydjdmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-ydjdmx/main-form/main-form.vue';

/**
 * 借调信息
 *
 * @export
 * @class PcmYdjdmxEditView9
 * @extends {PcmYdjdmxEditView9Base}
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
export default class PcmYdjdmxEditView9 extends PcmYdjdmxEditView9Base { }
</script>