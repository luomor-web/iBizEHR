<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxYDMXEditViewBase from './pcm-ydjdmx-ydmxedit-view-base.vue';

import view_form from '@widgets/pcm-ydjdmx/xzjdedit-form-form/xzjdedit-form-form.vue';

/**
 * 新增借调
 *
 * @export
 * @class PcmYdjdmxYDMXEditView
 * @extends {PcmYdjdmxYDMXEditViewBase}
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
export default class PcmYdjdmxYDMXEditView extends PcmYdjdmxYDMXEditViewBase { }
</script>